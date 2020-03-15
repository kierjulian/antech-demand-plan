package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.Customer;

import java.util.List;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public Customer findCustomerByCustomerCodeAndMaterialCode(String customerCode, String materialCode);

    public Customer findCustomerByCustomerCode(String customerCode);

    public String findCustomerZolMaterialCodeByMaterialCode(String materialCode);

    public List<Customer> findAllCustomers();

    public List<Customer> findAllCustomersByCustomerCode(String customerCode);

    public Customer findCustomerById(Integer id);

    public Customer updateCustomer(Customer customer);

    public void removeCustomer(Integer id);

    public Page<Customer> findAll(Pageable pageable);

    public Page<Customer> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
