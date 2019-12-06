package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.CustomerDAO;
import ph.edu.up.antech.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
    public Customer findByCustomerCodeAndMaterialCode(String customerCode, String materialCode) {
        TypedQuery<Customer> query = entityManager.createNamedQuery("findCustomerByCustomerCodeAndMaterialCode",
                Customer.class);
        query.setParameter("customerCode", customerCode);
        query.setParameter("materialCode", materialCode);

        List<Customer> customerList = query.getResultList();
        if (customerList != null && !customerList.isEmpty()) {
            return customerList.get(0);
        }

        return null;
    }

    @Override
    public Customer findCustomerByCustomerCode(String customerCode) {
        TypedQuery<Customer> query = entityManager.createNamedQuery("findCustomerByCustomerCode",
                Customer.class);
        query.setParameter("customerCode", customerCode);

        List<Customer> customerList = query.getResultList();
        if (customerList != null && !customerList.isEmpty()) {
            return customerList.get(0);
        }

        return null;
    }

    @Override
    public String findZolMaterialCodeByMaterialCode(String materialCode) {
        TypedQuery<String> query = entityManager.createNamedQuery("findZolMaterialCodeByMaterialCode",
                String.class);
        query.setParameter("materialCode", materialCode);

        List<String> materialCodeList = query.getResultList();
        if (materialCodeList != null && !materialCodeList.isEmpty()) {
            return materialCodeList.get(0);
        }

        return null;
    }

}
