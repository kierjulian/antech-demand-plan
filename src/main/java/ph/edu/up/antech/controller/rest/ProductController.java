package ph.edu.up.antech.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.service.ProductService;

import java.util.List;

@RestController
@RequestMapping(path = "${api.v1}/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("")
	public List<Product> findAll(@RequestParam(required = false) String code) {
		if (code != null) {
			return productService.findProductsByCode(code);
		}
		return productService.findAllProducts();
	}

	@GetMapping("/{id}")
	public Product findProductById(@PathVariable("id") Integer id) {
		return productService.findProductById(id);
	}

	@PostMapping("")
	public void createProduct(@RequestBody Product product) {
		productService.createProduct(product);
	}

	@PutMapping("")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Integer id) {
		productService.deleteProduct(id);
	}

}
