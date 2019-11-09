package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.ProductSales;
import ph.edu.up.antech.domain.ProductSalesGeneration;

import java.util.List;

public interface ProductSalesService {

	public List<ProductSales> findAllProductSales();
	public ProductSales createProductSale(ProductSalesGeneration productSalesGeneration);

}
