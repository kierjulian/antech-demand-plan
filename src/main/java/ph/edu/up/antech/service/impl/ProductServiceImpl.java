package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ProductDAO;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<Product> findAllProducts() {
		return productDAO.findAllProducts();
	}

	@Override
	public Product findProductById(Integer id) {
		return productDAO.findProductById(id);
	}

	@Override
	public void createProduct(Product product) {
		productDAO.createProduct(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return productDAO.updateProduct(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		productDAO.deleteProduct(id);
	}


}
