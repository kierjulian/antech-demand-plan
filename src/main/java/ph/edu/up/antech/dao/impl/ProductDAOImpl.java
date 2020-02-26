package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ProductDAO;
import ph.edu.up.antech.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Product> findAllProducts() {
		TypedQuery<Product> query = em.createNamedQuery("findAllProducts",
				Product.class);
		return query.getResultList();
	}

	@Override
	public Product findProductById(Integer id) {
		TypedQuery<Product> query = em.createNamedQuery("findProductById",
				Product.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public Product createProduct(Product product) {
		em.persist(product);
		em.flush();
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		return em.merge(product);
	}

	@Override
	public void deleteProduct(Integer id) {
		Product product = em.find(Product.class, id);
		em.remove(product);
	}

	@Override
	public List<Product> findProductsByCode(String code) {
		TypedQuery<Product> query = em.createNamedQuery("findProductByCode",
				Product.class);
		query.setParameter("code", code);
		return query.getResultList();
	}

}
