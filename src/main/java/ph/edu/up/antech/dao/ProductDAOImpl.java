package ph.edu.up.antech.dao;

import org.springframework.stereotype.Repository;
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
	public List<Product> findAll() {
		TypedQuery<Product> query = entityManager.createQuery("SELECT o FROM Product o",
				Product.class);
		return query.getResultList();
	}

}
