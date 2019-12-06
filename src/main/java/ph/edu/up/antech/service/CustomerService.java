package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.Customer;

public interface CustomerService {

    public Customer create(Customer customer);

    public Customer findByCustomerCodeAndMaterialCode(String customerCode, String materialCode);

    public Customer findCustomerByCustomerCode(String customerCode);

    public String findZolMaterialCodeByMaterialCode(String materialCode);

}
