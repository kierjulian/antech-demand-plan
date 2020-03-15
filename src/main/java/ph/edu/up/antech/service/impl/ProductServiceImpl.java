package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ProductDAO;
import ph.edu.up.antech.dao.pagination.ProductPaginationDAO;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.service.ProductService;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductPaginationDAO productPaginationDAO;

    @Override
    public List<Product> findAllProducts() {
        List<Product> productList = productDAO.findAllProducts();
        Collections.sort(productList);
        return productList;
    }

    @Override
    public Product findProductById(Integer id) {
        return productDAO.findProductById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productDAO.saveProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

    @Override
    public void removeProduct(Integer id) {
        productDAO.removeProduct(id);
    }

    @Override
    public List<Product> findProductsByCode(String code) {
        return productDAO.findProductsByCode(code);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productPaginationDAO.findAll(pageable);
    }

    @Override
    public Page<Product> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return productPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
