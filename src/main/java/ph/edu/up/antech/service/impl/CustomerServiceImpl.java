package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.CustomerDAO;
import ph.edu.up.antech.domain.Customer;
import ph.edu.up.antech.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Customer create(Customer customer) {
        return customerDAO.create(customer);
    }

    @Override
    public Customer findByCustomerCodeAndMaterialCode(String customerCode, String materialCode) {
        return customerDAO.findByCustomerCodeAndMaterialCode(customerCode, materialCode);
    }

    @Override
    public Customer findCustomerByCustomerCode(String customerCode) {
        return customerDAO.findCustomerByCustomerCode(customerCode);
    }

    @Override
    public String findZolMaterialCodeByMaterialCode(String materialCode) {
        return customerDAO.findZolMaterialCodeByMaterialCode(materialCode);
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
    public void deleteCustomer(Integer id) {
        customerDAO.deleteCustomer(id);
    }

}
