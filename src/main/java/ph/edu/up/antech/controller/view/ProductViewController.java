package ph.edu.up.antech.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.controller.rest.client.ProductRestClient;
import ph.edu.up.antech.domain.Product;

import java.util.ArrayList;
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
		model.addAttribute("product", product);
		return "product-view";
	}

	@GetMapping("/add")
	public String createProduct(Model model) {
		return "product-add";
	}

	@GetMapping("/save")
	public String saveProduct() {
		Product product = new Product();
		//productRestClient.createProduct(product);
		return "redirect:/products/view/" + 1;
	}

}
