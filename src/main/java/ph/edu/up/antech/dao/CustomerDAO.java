package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.Customer;

public interface CustomerDAO {

    public Customer create(Customer customer);

    public Customer findByCustomerCodeAndMaterialCode(String customerCode, String materialCode);

    public Customer findCustomerByCustomerCode(String customerCode);

    public String findZolMaterialCodeByMaterialCode(String materialCode);

}
