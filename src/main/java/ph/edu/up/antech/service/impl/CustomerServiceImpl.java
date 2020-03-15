package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.CustomerDAO;
import ph.edu.up.antech.dao.pagination.CustomerPaginationDAO;
import ph.edu.up.antech.domain.Customer;
import ph.edu.up.antech.service.CustomerService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustomerPaginationDAO customerPaginationDAO;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerDAO.saveCustomer(customer);
    }

    @Override
    public Customer findCustomerByCustomerCodeAndMaterialCode(String customerCode, String materialCode) {
        return customerDAO.findCustomerByCustomerCodeAndMaterialCode(customerCode, materialCode);
    }

    @Override
    public Customer findCustomerByCustomerCode(String customerCode) {
        return customerDAO.findCustomerByCustomerCode(customerCode);
    }

    @Override
    public String findCustomerZolMaterialCodeByMaterialCode(String materialCode) {
        return customerDAO.findCustomerZolMaterialCodeByMaterialCode(materialCode);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerDAO.findAllCustomers();
    }

    @Override
    public List<Customer> findAllCustomersByCustomerCode(String customerCode) {
        return customerDAO.findAllCustomerByCustomerCode(customerCode);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerDAO.findCustomerById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }

    @Override
    public void removeCustomer(Integer id) {
        customerDAO.removeCustomer(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerPaginationDAO.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return customerPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
