package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.CustomerDAO;
import ph.edu.up.antech.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer create(Customer customer) {
        entityManager.persist(customer);
        entityManager.flush();
        return customer;
    }

    @Override
    public List<Customer> findByCustomerCodeAndMaterialCode(String customerCode, String materialCode) {
        return null;
    }

}
