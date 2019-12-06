package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.Customer;

import java.util.List;

public interface CustomerDAO {

    public Customer create(Customer customer);

    public List<Customer> findByCustomerCodeAndMaterialCode(String customerCode, String materialCode);

}
