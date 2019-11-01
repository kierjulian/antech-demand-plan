package ph.edu.up.antech.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(path = "${api.v1}/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("")
	public List<Product> findAll() {
		return productService.findAll();
	}

}
