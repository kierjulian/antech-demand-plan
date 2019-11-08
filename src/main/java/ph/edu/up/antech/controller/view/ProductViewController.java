package ph.edu.up.antech.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ph.edu.up.antech.controller.rest.client.ProductRestClient;
import ph.edu.up.antech.domain.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductViewController {

	@Autowired
	private ProductRestClient productRestClient;

	@GetMapping("")
	public String loadProductPage(Model model, @RequestParam(required = false) String code) {
		List<Product> productList = new ArrayList<>();
		if (code == null || code.isEmpty()) {
			productList = productRestClient.findAllProducts();
		} else {
			productList = productRestClient.findProductsByCode(code);
		}

		model.addAttribute("productList", productList);
		return "product";
	}

	@GetMapping("/view/{id}")
	public String viewProduct(@PathVariable Integer id, Model model) {
		Product product = productRestClient.findProductById(id);
		if (product.getLicenseInformation() != null && product.getLicenseInformation().getCertificateFile() != null) {
			model.addAttribute("image", Base64.getEncoder().
					encodeToString(product.getLicenseInformation().getCertificateFile()));
		}

		model.addAttribute("product", product);
		return "product-view";
	}

	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable Integer id, Model model) {
		Product product = productRestClient.findProductById(id);
		model.addAttribute("product", product);
		return "product-edit";
	}

	@PostMapping("/update")
	public String updateProduct(@ModelAttribute(value = "product") Product product,
								@RequestParam("certificateFile") MultipartFile image) {
		if (image != null && !image.isEmpty()) {
			try {
				byte[] imageBytes = image.getBytes();
				if (imageBytes != null) {
					product.getLicenseInformation().setCertificateFile(imageBytes);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Product oldProduct = productRestClient.findProductById(product.getId());
			if (oldProduct.getLicenseInformation().getCertificateFile() != null) {
				product.getLicenseInformation().setCertificateFile(
						oldProduct.getLicenseInformation().getCertificateFile());
			}
		}

		productRestClient.updateProduct(product);
		return "redirect:/products/view/" + product.getId();
	}

	@GetMapping("/add")
	public String createProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "product-add";
	}

	@PostMapping("/save")
	public String saveProduct(@ModelAttribute(value = "product") Product product,
							  @RequestParam("certificateFile") MultipartFile image) {
		try {
			byte[] imageBytes = image.getBytes();
			if (imageBytes != null) {
				product.getLicenseInformation().setCertificateFile(imageBytes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		product = productRestClient.createProduct(product);
		return "redirect:/products/view/" + product.getId();
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		productRestClient.deleteProduct(id);
		return "redirect:/products";
	}

}
