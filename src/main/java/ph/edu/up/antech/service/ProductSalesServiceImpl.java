package ph.edu.up.antech.service;

import org.springframework.stereotype.Service;
import ph.edu.up.antech.domain.ProductSales;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSalesServiceImpl implements ProductSalesService {

	@Override
	public List<ProductSales> findAll() {
		List<ProductSales> productSalesList = new ArrayList<>();
		productSalesList.add(new ProductSales());

		return productSalesList;
	}
}
