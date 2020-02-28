package ph.edu.up.antech.db.setup;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.dao.CustomerDAO;
import ph.edu.up.antech.dao.impl.CustomerDAOImpl;
import ph.edu.up.antech.domain.Customer;
import ph.edu.up.antech.runner.Application;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Run this if you want to repopulate Customer table")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        CustomerDAOImpl.class
})
public class CustomerSetup {

    @Autowired
    private CustomerDAO customerDAO;

    @Test
    public void populateCustomerViaCsvFile() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/Customers.csv"))) {
            CsvToBean<Customer> csvToBean = new CsvToBeanBuilder(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .withType(Customer.class)
                    .build();
            List<Customer> customersList = csvToBean.parse();
            customersList.forEach(customer -> {
                System.out.println(customer.getCustomerCode());
                System.out.println(customer.getCustomerName());
                System.out.println(customer.getZolCustomerCode());
                System.out.println(customer.getZolCustomerName());
                System.out.println(customer.getMaterialCode());
                System.out.println(customer.getZolMaterialCode());
                System.out.println(customer.getZolMaterialCode());
                System.out.println();

                customerDAO.saveCustomer(customer);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
