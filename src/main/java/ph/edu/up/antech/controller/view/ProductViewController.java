package ph.edu.up.antech.controller.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String loadProductPage(Model model, @RequestParam(required = false) String productCode) {
		List<Product> productList = new ArrayList<>();
		if (productCode == null) {
			productList = productRestClient.findAllProducts();
		} else {

		}

		model.addAttribute("productList", productList);
		return "product";
	}

}
