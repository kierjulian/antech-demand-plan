package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ProductDAO;
import ph.edu.up.antech.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Product> findAllProducts() {
		TypedQuery<Product> query = entityManager.createNamedQuery("findAllProducts",
				Product.class);
		return query.getResultList();
	}

	@Override
	public Product findProductById(Integer id) {
		TypedQuery<Product> query = entityManager.createNamedQuery("findProductById",
				Product.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Product createProduct(Product product) {
		entityManager.persist(product);
		entityManager.flush();
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		return entityManager.merge(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		Product product = entityManager.find(Product.class, id);
		entityManager.remove(product);
	}

	@Override
	public List<Product> findProductsByCode(String code) {
		TypedQuery<Product> query = entityManager.createNamedQuery("findProductByCode",
				Product.class);
		query.setParameter("code", code);
		return query.getResultList();
	}

}
