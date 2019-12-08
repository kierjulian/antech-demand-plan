package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.Customer;

import java.util.List;

public interface CustomerService {

    public Customer create(Customer customer);

    public Customer findByCustomerCodeAndMaterialCode(String customerCode, String materialCode);

    public Customer findCustomerByCustomerCode(String customerCode);

    public String findZolMaterialCodeByMaterialCode(String materialCode);

    public List<Customer> findAllCustomers();

    public List<Customer> findAllCustomersByCustomerCode(String customerCode);

    public Customer findCustomerById(Integer id);

    public Customer updateCustomer(Customer customer);

    public void deleteCustomer(Integer id);

}
