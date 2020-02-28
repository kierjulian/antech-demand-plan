package ph.edu.up.antech.domain.sales.raw;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.Customer;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.CustomerService;
import ph.edu.up.antech.service.ZolPerDoorsGeneralInformationService;
import ph.edu.up.antech.service.ZolPerDoorsPerAcctService;
import ph.edu.up.antech.service.impl.CustomerServiceImpl;
import ph.edu.up.antech.service.impl.ZolPerDoorsGeneralInformationServiceImpl;
import ph.edu.up.antech.service.impl.ZolPerDoorsPerAcctServiceImpl;
import ph.edu.up.antech.service.impl.ZolPerDoorsServiceImpl;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {ZolPerDoorsGeneralInformationServiceImpl.class,
        ZolPerDoorsPerAcctServiceImpl.class, ZolPerDoorsServiceImpl.class, CustomerServiceImpl.class})
public class CustomerItemSalesPerPeriodToZolPerDoorsTest {

    @Autowired
    private ZolPerDoorsGeneralInformationService zolPerDoorsGeneralInformationService;

    @Autowired
    private ZolPerDoorsPerAcctService zolPerDoorsPerAcctService;

    @Autowired
    private CustomerService customerService;

    @Test
    public void readCustomerItemSalesPerPeriod_andConvertToZolPerDoors_shouldBeSuccesful() {
        try (Reader reader = Files.newBufferedReader(
                Paths.get("src/test/resources/Actual_CustomerItemSalesPerPeriod.csv"),
                StandardCharsets.ISO_8859_1)) {
            CsvToBean<CustomerItemSalesPerPeriod> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CustomerItemSalesPerPeriod.class)
                    .withSkipLines(0)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<CustomerItemSalesPerPeriod> customerItemSalesPerPeriodList =
                    csvToBean.parse();

            List<ZolPerDoorsGeneralInformation> zolPerDoorsGeneralInformationList = zolPerDoorsGeneralInformationService
                    .findAllZolPerDoorsGeneralInformation();
            List<ZolPerDoorsPerAcct> zolPerDoorsPerAcctList = zolPerDoorsPerAcctService.findAllZolPerDoorsPerAcct();
            List<Customer> customerList = customerService.findAllCustomers();

            customerItemSalesPerPeriodList.forEach(customerItemSalesPerPeriod -> {
                customerItemSalesPerPeriod.setDate(LocalDate.now());
                customerItemSalesPerPeriod.convertAllStringValuesToProperType();

                Customer customer = customerList.stream()
                        .filter(cust -> cust.getCustomerCode().equals(customerItemSalesPerPeriod.getCustomerCode()))
                        .findFirst()
                        .orElse(null);
                customerItemSalesPerPeriod.updateValuesBasedOnCustomer(customer);

                Customer otherCustomer = customerList.stream()
                        .filter(cust -> cust.getZolMaterialCode().equals(customerItemSalesPerPeriod.getMaterialCode()))
                        .findFirst()
                        .orElse(null);
                customerItemSalesPerPeriod.updateMaterialCodeBasedOnCustomer(otherCustomer);

                ZolPerDoors zolPerDoors = new ZolPerDoors(customerItemSalesPerPeriod);

                ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation =
                        zolPerDoorsGeneralInformationList.stream()
                                .filter(generalInformation -> generalInformation.getZpcItemCode().equals(zolPerDoors.getItemCode()))
                                .findFirst()
                                .orElse(null);
                zolPerDoors.generateValuesBasedOnZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);

                ZolPerDoorsPerAcct zolPerDoorsPerAcct =
                        zolPerDoorsPerAcctList.stream()
                                .filter(perAcct -> perAcct.getZol().equals(zolPerDoors.getCustomerCode()))
                                .findFirst()
                                .orElse(null);
                zolPerDoors.generateValuesBasedOnZolPerDoorsPerAcct(zolPerDoorsPerAcct);

                System.out.println("Date: " + zolPerDoors.getDate());
                System.out.println("Customer Code: " + zolPerDoors.getCustomerCode());
                System.out.println("Customer Name: " + zolPerDoors.getCustomerName());
                System.out.println("Item Code: " + zolPerDoors.getItemCode());
                System.out.println("Item Name: " + zolPerDoors.getItemName());
                System.out.println("Sales Unit: " + zolPerDoors.getSalesUnit());
                System.out.println("Sales Value: " + zolPerDoors.getSalesValue());
                System.out.println("Antech Product Description: " + zolPerDoors.getAntechProductDescription());
                System.out.println("Antech Price: " + zolPerDoors.getAntechPrice());
                System.out.println("Amount: " + zolPerDoors.getAmount());
                System.out.println("Account: " + zolPerDoors.getAccount());
                System.out.println("KAM: " + zolPerDoors.getKam());
                System.out.println("KAM REFERENCE NAME: " + zolPerDoors.getKamReferenceName());
                System.out.println("Stage: " + zolPerDoors.getStage());
                System.out.println("Amount Converted: " + zolPerDoors.getAmountConverted());
                System.out.println("Type: " + zolPerDoors.getType());
                System.out.println("Location: " + zolPerDoors.getLocation());
                System.out.println("CM: " + zolPerDoors.getCm());
                System.out.println("Less than 0.00375 Percent: " + zolPerDoors.getLess00375Percent());
                System.out.println("V1: " + zolPerDoors.getV1());
                System.out.println("Less than 0.0835 Percent: " + zolPerDoors.getLess0853Percent());
                System.out.println("V2: " + zolPerDoors.getV2());
                System.out.println("Final Amount: " + zolPerDoors.getFinalAmount());
                System.out.println("Amount Times 1000: " + zolPerDoors.getAmountTimesOneThousand());
                System.out.println("A: " + zolPerDoors.getA());
                System.out.println();
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
