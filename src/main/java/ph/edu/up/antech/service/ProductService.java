package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.Product;

import java.util.List;

public interface ProductService {

	public List<Product> findAllProducts();

	public Product findProductById(Integer id);

	public Product saveProduct(Product product);

	public Product updateProduct(Product product);

	public void removeProduct(Integer id);

	public List<Product> findProductsByCode(String code);

}
