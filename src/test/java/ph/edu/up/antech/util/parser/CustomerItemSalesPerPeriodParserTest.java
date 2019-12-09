package ph.edu.up.antech.util.parser;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import ph.edu.up.antech.domain.sales.raw.CustomerItemSalesPerPeriod;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CustomerItemSalesPerPeriodParserTest {

    @Test
    public void printContents_fromCustomerItemSalesPerPeriodCSVFile_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/CustomerItemSalesPerPeriod.csv"));
             CSVReader csvReader = new CSVReader(reader)) {
            Object[] record;
            while ((record = csvReader.readNext()) != null) {
                System.out.println((String) record[0]);
                System.out.println(record[1]);
                System.out.println(record[2]);
                System.out.println(record[3]);

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void convertCSVToCustomerItemSalesPerPeriodObject_andPrintContents_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/CustomerItemSalesPerPeriod.csv"))) {
            CsvToBean<CustomerItemSalesPerPeriod> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CustomerItemSalesPerPeriod.class).withSkipLines(3).build();
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
