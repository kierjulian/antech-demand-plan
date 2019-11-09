package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ProductSalesDAO;
import ph.edu.up.antech.domain.ProductSales;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductSalesDAOImpl implements ProductSalesDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ProductSales> findAllProductSales() {
		TypedQuery<ProductSales> query = entityManager.createQuery("SELECT o FROM ProductSales o",
				ProductSales.class);
		return query.getResultList();
	}

}
