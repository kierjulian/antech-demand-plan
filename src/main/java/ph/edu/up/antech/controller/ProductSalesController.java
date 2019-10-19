package ph.edu.up.antech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ph.edu.up.antech.domain.ProductSales;
import ph.edu.up.antech.service.ProductSalesService;

import java.util.List;

@RestController
@RequestMapping("/productSales")
public class ProductSalesController {

	@Autowired
	private ProductSalesService productSalesService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<ProductSales> findAllProductSales() {
		return productSalesService.findAll();
	}

}
