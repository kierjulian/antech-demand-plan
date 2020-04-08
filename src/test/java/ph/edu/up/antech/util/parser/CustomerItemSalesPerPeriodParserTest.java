package ph.edu.up.antech.util.parser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import ph.edu.up.antech.domain.raw.CustomerItemSalesPerPeriod;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CustomerItemSalesPerPeriodParserTest {

    @Test
    public void convertCSVToCustomerItemSalesPerPeriodObject_andPrintContents_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/CustomerItemSalesPerPeriod.csv"))) {
            CsvToBean<CustomerItemSalesPerPeriod> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CustomerItemSalesPerPeriod.class)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<CustomerItemSalesPerPeriod> customerItemSalesPerPeriodList = csvToBean.parse();
            for (CustomerItemSalesPerPeriod customerItemSalesPerPeriod : customerItemSalesPerPeriodList) {
                customerItemSalesPerPeriod.convertAllStringValuesToProperType();
                System.out.println("Row: " + customerItemSalesPerPeriod.getRow());
                System.out.println("Customer Code: " + customerItemSalesPerPeriod.getCustomerCode());
                System.out.println("Customer Name: " + customerItemSalesPerPeriod.getCustomerName());
                System.out.println("Material Code: " + customerItemSalesPerPeriod.getMaterialCode());
                System.out.println("Material Description: " + customerItemSalesPerPeriod.getMaterialDescription());
                System.out.println("Quantity: " + customerItemSalesPerPeriod.getQuantity());
                System.out.println("Quantity Bonus: " + customerItemSalesPerPeriod.getQuantityBonus());
                System.out.println("Sales Amount: " + customerItemSalesPerPeriod.getSalesAmount());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void convertCSVToCustomerItemSalesPerPeriodObject_realData_andPrintContents_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/CustomerItemSalesPerPeriod_December19.csv"))) {
            CsvToBean<CustomerItemSalesPerPeriod> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CustomerItemSalesPerPeriod.class)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<CustomerItemSalesPerPeriod> customerItemSalesPerPeriodList = csvToBean.parse();
            for (CustomerItemSalesPerPeriod customerItemSalesPerPeriod : customerItemSalesPerPeriodList) {
                customerItemSalesPerPeriod.convertAllStringValuesToProperType();
                System.out.println("Row: " + customerItemSalesPerPeriod.getRow());
                System.out.println("Customer Code: " + customerItemSalesPerPeriod.getCustomerCode());
                System.out.println("Customer Name: " + customerItemSalesPerPeriod.getCustomerName());
                System.out.println("Material Code: " + customerItemSalesPerPeriod.getMaterialCode());
                System.out.println("Material Description: " + customerItemSalesPerPeriod.getMaterialDescription());
                System.out.println("Quantity: " + customerItemSalesPerPeriod.getQuantity());
                System.out.println("Quantity Bonus: " + customerItemSalesPerPeriod.getQuantityBonus());
                System.out.println("Sales Amount: " + customerItemSalesPerPeriod.getSalesAmount());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
