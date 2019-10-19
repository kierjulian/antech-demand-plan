package ph.edu.up.antech.service;

import org.springframework.stereotype.Service;
import ph.edu.up.antech.domain.ProductSales;
import ph.edu.up.antech.domain.ProductSalesGeneration;
import ph.edu.up.antech.helper.ProductSalesHelper;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSalesServiceImpl implements ProductSalesService {

	@Override
	public List<ProductSales> findAll() {
		List<ProductSales> productSalesList = new ArrayList<>();
		productSalesList.add(ProductSalesHelper.initializeProductSalesFors1400OnMay2019());
		productSalesList.add(ProductSalesHelper.initializeProductSalesFors1400OnJune2019());
		productSalesList.add(ProductSalesHelper.initializeProductSalesFors1400OnJuly2019());
		return productSalesList;
	}

	@Override
	public ProductSales createProductSale(ProductSalesGeneration productSalesGeneration) {
		return new ProductSales(productSalesGeneration.getProduct(),
				productSalesGeneration.getProductSalesOneMonthBefore(),
				productSalesGeneration.getProductSalesTwoMonthBefore(),
				productSalesGeneration.getProductSalesThreeMonthBefore(),
				productSalesGeneration.getProductSalesDetails());
	}

}
