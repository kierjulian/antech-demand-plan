package ph.edu.up.antech.controller.view.general;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.service.ProductService;
import ph.edu.up.antech.util.StringUtils;

import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("/general/products")
public class ProductController {

    private static final Logger LOGGER = Logger.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String loadProductPage(Model model, @PageableDefault Pageable pageable,
                                  @RequestParam(required = false) String filter) {
        Page<Product> page = StringUtils.isNullOrEmpty(filter)
                ? productService.findAll(pageable)
                : productService.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
        return "product";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable Integer id, Model model) {
        Product product = productService.findProductById(id);
        if (product != null && product.getCertificateFile() != null) {
            model.addAttribute("image", Base64.getEncoder().
                    encodeToString(product.getCertificateFile()));
        }

        model.addAttribute("product", product);
        return "product-view";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "product-edit";
    }

    @PostMapping("/update")
    public String updateProduct(RedirectAttributes redirectAttributes,
                                @ModelAttribute(value = "product") Product product,
                                @RequestParam("certificateImage") MultipartFile image) {
        if (image != null && !image.isEmpty()) {
            try {
                byte[] imageBytes = image.getBytes();
                if (imageBytes != null) {
                    product.setCertificateFile(imageBytes);
                }
            } catch (IOException e) {
                redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while updating product.");
                LOGGER.error(e.getMessage(), e);
            }
        } else {
            Product oldProduct = productService.findProductById(product.getId());
            if (oldProduct.getCertificateFile() != null) {
                product.setCertificateFile(
                        oldProduct.getCertificateFile());
            }
        }

        try {
            productService.updateProduct(product);
            redirectAttributes.addFlashAttribute("successMessage", "Product was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while updating product.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/general/products/view/" + product.getId();
    }

    @GetMapping("/add")
    public String createProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-add";
    }

    @PostMapping("/save")
    public String saveProduct(RedirectAttributes redirectAttributes,
                              @ModelAttribute("product") Product product,
                              @RequestParam("certificateImage") MultipartFile image) {
        try {
            byte[] imageBytes = image.getBytes();
            if (imageBytes != null) {
                product.setCertificateFile(imageBytes);
            }
            product = productService.saveProduct(product);
            redirectAttributes.addFlashAttribute("successMessage", "Product was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while saving the product.");
            LOGGER.error(e.getMessage(), e);
            return "redirect:/general/products";
        }

        return "redirect:/general/products/view/" + product.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            productService.removeProduct(id);
            redirectAttributes.addFlashAttribute("successMessage", "Product was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorDeleteMessage", "An error occurred while deleting product.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/general/products";
    }

}
