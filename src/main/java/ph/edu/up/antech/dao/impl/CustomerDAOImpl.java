package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.CustomerDAO;
import ph.edu.up.antech.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Customer createCustomer(Customer customer) {
        em.persist(customer);
        em.flush();
        return customer;
    }

    @Override
    public Customer findCustomerByCustomerCodeAndMaterialCode(String customerCode, String materialCode) {
        TypedQuery<Customer> query = em.createNamedQuery("findCustomerByCustomerCodeAndMaterialCode",
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
        TypedQuery<Customer> query = em.createNamedQuery("findCustomerByCustomerCode",
                Customer.class);
        query.setParameter("customerCode", customerCode);

        List<Customer> customerList = query.getResultList();
        if (customerList != null && !customerList.isEmpty()) {
            return customerList.get(0);
        }

        return null;
    }

    @Override
    public String findCustomerZolMaterialCodeByMaterialCode(String materialCode) {
        TypedQuery<String> query = em.createNamedQuery("findZolMaterialCodeByMaterialCode",
                String.class);
        query.setParameter("materialCode", materialCode);

        List<String> materialCodeList = query.getResultList();
        if (materialCodeList != null && !materialCodeList.isEmpty()) {
            return materialCodeList.get(0);
        }

        return null;
    }

    @Override
    public List<Customer> findAllCustomers() {
        TypedQuery<Customer> query = em.createNamedQuery("findAllCustomers", Customer.class);
        return query.getResultList();
    }

    @Override
    public List<Customer> findAllCustomerByCustomerCode(String customerCode) {
        TypedQuery<Customer> query = em.createNamedQuery("findAllCustomersByCustomerCode", Customer.class);
        query.setParameter("customerCode", customerCode);
        return query.getResultList();
    }

    @Override
    public Customer findCustomerById(Integer id) {
        TypedQuery<Customer> query = em.createNamedQuery("findCustomerById", Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return em.merge(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        Customer customer = em.find(Customer.class, id);
        em.remove(customer);
    }

}
