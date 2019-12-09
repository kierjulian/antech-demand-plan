package ph.edu.up.antech.util.parser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import ph.edu.up.antech.domain.sales.raw.CustomerSalesByItem;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CustomerSalesByItemParserTest {

    @Test
    public void convertCustomerSalesByItemToObject_andPrintContents_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/CustomerSalesByItem.csv"))) {
            CsvToBean<CustomerSalesByItem> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CustomerSalesByItem.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(6)
                    .build();

            List<CustomerSalesByItem> customerSalesByItemList = csvToBean.parse();
            for (CustomerSalesByItem customerSalesByItem : customerSalesByItemList) {
                customerSalesByItem.convertAllStringFieldsToProperType();

                System.out.println("Item: " + customerSalesByItem.getItem());
                System.out.println("Type: " + customerSalesByItem.getType());
                System.out.println("Customer Name: " + customerSalesByItem.getCustomerName());
                System.out.println("Category: " + customerSalesByItem.getCategory());
                System.out.println("Date: " + customerSalesByItem.getDate());
                System.out.println("Num: " + customerSalesByItem.getNum());
                System.out.println("Sales Invoice: " + customerSalesByItem.getSalesInvoice());
                System.out.println("Description: " + customerSalesByItem.getDescription());
                System.out.println("Qty Sold: " + customerSalesByItem.getQuantitySold());
                System.out.println("Sales Price: " + customerSalesByItem.getSalesPrice());
                System.out.println("Net Amount: " + customerSalesByItem.getNetAmount());
                System.out.println("Price Level: " + customerSalesByItem.getPriceLevel());
                System.out.println("Territorial Manager: " + customerSalesByItem.getCreditedToTerritorialManager());
                System.out.println("Sales Rep Name: " + customerSalesByItem.getSalesRepName());
                System.out.println("Acquisition CSR: " + customerSalesByItem.getCustomerJobAcquisitionCsrCreditedTo());
                System.out.println("Retention CSR: " + customerSalesByItem.getCustomerJobRetentionCsrCreditedTo());
                System.out.println("Order Taken By: " + customerSalesByItem.getOrderTakenBy());
                System.out.println("ZIP Code: " + customerSalesByItem.getAddressZipCode());
                System.out.println("Sales Role Name: " + customerSalesByItem.getSalesRoleName());
                System.out.println("Shipping Address: " + customerSalesByItem.getAddressShippingAddressCity());
                System.out.println("Billing Address 1: " + customerSalesByItem.getAddressBillingAddress1());
                System.out.println("Billing Address 2: " + customerSalesByItem.getAddressBillingAddress2());
                System.out.println("Hospital 1: " + customerSalesByItem.getCustomerJobHospital1());
                System.out.println("Doctor 1: " + customerSalesByItem.getCustomerJobDoctor1());
                System.out.println("Referred By: " + customerSalesByItem.getCustomerJobReferredBy());
                System.out.println("PO Number: " + customerSalesByItem.getPoNumber());
                System.out.println("Mobile Number: " + customerSalesByItem.getMobileNo());

                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
