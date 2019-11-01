package ph.edu.up.antech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ProductDAO;
import ph.edu.up.antech.domain.Product;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<Product> findAll() {
		return productDAO.findAll();
	}

}
