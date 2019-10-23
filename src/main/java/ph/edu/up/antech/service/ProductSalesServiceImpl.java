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
		productSalesList.add(ProductSalesHelper.initializeProductSalesForS1400Jan2019());
		productSalesList.add(ProductSalesHelper.initializeProductSalesForS1400Feb2019());
		productSalesList.add(ProductSalesHelper.initializeProductSalesForS1400March2019());
		productSalesList.add(ProductSalesHelper.initializeProductSalesFors1400April2019());
		productSalesList.add(ProductSalesHelper.initializeProductSalesForS1400May2019());
		productSalesList.add(ProductSalesHelper.initializeProductSalesForS1400June2019());
		productSalesList.add(ProductSalesHelper.initializeProductSalesForS1400July2019());
		return productSalesList;
	}

	@Override
	public ProductSales createProductSale(ProductSalesGeneration productSalesGeneration) {
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
