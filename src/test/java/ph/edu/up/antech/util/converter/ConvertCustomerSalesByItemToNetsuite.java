package ph.edu.up.antech.util.converter;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.domain.sales.raw.CustomerSalesByItem;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class ConvertCustomerSalesByItemToNetsuite {

    @Test
    public void convertCustomerSalesByItemToNetsuite_andPrintContentsOfNetsuite_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/CustomerSalesByItem.csv"))) {
            CsvToBean<CustomerSalesByItem> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CustomerSalesByItem.class)
                    .withSkipLines(6)
                    .build();
            List<CustomerSalesByItem> customerSalesByItemList = csvToBean.parse();
            for (CustomerSalesByItem customerSalesByItem : customerSalesByItemList) {
                customerSalesByItem.convertAllStringFieldsToProperType();
                customerSalesByItem.setItemDate(LocalDate.now());

                Netsuite netsuite = new Netsuite(customerSalesByItem);
                System.out.println("Item Date: " + netsuite.getItemDate());
                System.out.println("Type: " + netsuite.getType());
                System.out.println("Customer: " + netsuite.getCustomer());
                System.out.println("Category: " + netsuite.getCategory());
                System.out.println("Date: " + netsuite.getDate());
                System.out.println("Created From: " + netsuite.getCreatedFrom());
                System.out.println("Description: " + netsuite.getDescription());
                System.out.println("Quantity: " + netsuite.getQuantity());
                System.out.println("Sales Price: " + netsuite.getSalesPrice());
                System.out.println("Revenue: " + netsuite.getRevenue());
                System.out.println("Price Level: " + netsuite.getPriceLevel());
                System.out.println("Credited To Territorial Manager: " + netsuite.getCreditedToTerritorialManager());
                System.out.println("Sales Rep: " + netsuite.getSalesRep());
                System.out.println("Customer Since: " + netsuite.getCustomerSince());
                System.out.println("Zone: " + netsuite.getZone());
                System.out.println("Customer Job Zone: " + netsuite.getCustomerJobZone());
                System.out.println("Pick Up: " + netsuite.getPickup());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
