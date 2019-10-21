package ph.edu.up.antech.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ph.edu.up.antech.domain.*;
import ph.edu.up.antech.helper.ProductSalesHelper;
import ph.edu.up.antech.service.ProductSalesService;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;
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

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ProductSales createProductSales() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1400)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();
		ProductSalesDetails productSalesDetails = ProductSalesDetails.Builder.buildProductSalesDetails()
				.plan(895)
				.inMarketSales(2000)
				.production(5660)
				.loading(0)
				.shipmentReceived(3812)
				.actualSales(2000)
				.build();

		ProductSalesGeneration productSalesGeneration = ProductSalesGeneration.Builder.buildProductSalesGeneration()
				.product(product)
				.year(Year.now())
				.month(Month.AUGUST)
				.productSalesOneMonthBefore(ProductSalesHelper.initializeProductSalesFors1400OnJuly2019())
				.productSalesTwoMonthBefore(ProductSalesHelper.initializeProductSalesFors1400OnJune2019())
				.productSalesThreeMonthBefore(ProductSalesHelper.initializeProductSalesFors1400OnMay2019())
				.productSalesDetails(productSalesDetails)
				.build();
		return productSalesService.createProductSale(productSalesGeneration);
	}

}
