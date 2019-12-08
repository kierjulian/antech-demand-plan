package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ProductSalesDAO;
import ph.edu.up.antech.domain.ProductSales;
import ph.edu.up.antech.domain.ProductSalesGeneration;
import ph.edu.up.antech.service.ProductSalesService;

import java.util.List;

@Service
public class ProductSalesServiceImpl implements ProductSalesService {

	@Autowired
	private ProductSalesDAO productSalesDAO;

	@Override
	public List<ProductSales> findAllProductSales() {
		return productSalesDAO.findAllProductSales();
	}

	@Override
	public ProductSales createProductSales(ProductSalesGeneration productSalesGeneration) {
		ProductSales productSales = new ProductSales(productSalesGeneration.getProduct(),
				productSalesGeneration.getProductSalesOneMonthBefore(),
				productSalesGeneration.getProductSalesTwoMonthBefore(),
				productSalesGeneration.getProductSalesThreeMonthBefore(),
				productSalesGeneration.getProductSalesDetails());
		productSales.setMonth(productSalesGeneration.getMonth());
		productSales.setYear(productSalesGeneration.getYear());
		return productSales;
	}

}
