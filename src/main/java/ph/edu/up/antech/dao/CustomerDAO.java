package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.Customer;

import java.util.List;

public interface CustomerDAO {

    public Customer saveCustomer(Customer customer);

    public Customer findCustomerByCustomerCodeAndMaterialCode(String customerCode, String materialCode);

    public Customer findCustomerByCustomerCode(String customerCode);

    public String findCustomerZolMaterialCodeByMaterialCode(String materialCode);

    public List<Customer> findAllCustomers();

    public List<Customer> findAllCustomerByCustomerCode(String customerCode);

    public Customer findCustomerById(Integer id);

    public Customer updateCustomer(Customer customer);

    public void removeCustomer(Integer id);

}
