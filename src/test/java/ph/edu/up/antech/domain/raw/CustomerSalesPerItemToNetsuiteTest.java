package ph.edu.up.antech.domain.raw;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.master.Netsuite;
import ph.edu.up.antech.domain.master.config.*;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.*;
import ph.edu.up.antech.service.impl.*;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        NetsuiteProductListSourceServiceImpl.class, NetsuiteProductListDeServiceImpl.class,
        NetsuiteGeneralInformationServiceImpl.class, NetsuiteOtherInformationServiceImpl.class,
        MdcPerBranchSalesNaConfigurationServiceImpl.class, NetsuiteBbjTaggingServiceImpl.class,
        NetsuiteTransfersCatServiceImpl.class
})
public class CustomerSalesPerItemToNetsuiteTest {

    @Autowired
    private NetsuiteProductListSourceService netsuiteProductListSourceService;

    @Autowired
    private NetsuiteProductListDeService netsuiteProductListDeService;

    @Autowired
    private NetsuiteGeneralInformationService netsuiteGeneralInformationService;

    @Autowired
    private NetsuiteOtherInformationService netsuiteOtherInformationService;

    @Autowired
    private MdcPerBranchSalesNaConfigurationService mdcPerBranchSalesNaConfigurationService;

    @Autowired
    private NetsuiteBbjTaggingService netsuiteBbjTaggingService;

    @Autowired
    private NetsuiteTransfersCatService netsuiteTransfersCatService;

    @Test
    public void readCustomerSalesPerItem_andConvertToNetsuite_shouldBeSuccesful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/Actual_CustomerSalesPerItem.csv"),
                StandardCharsets.ISO_8859_1)) {
            CsvToBean<CustomerSalesByItem> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CustomerSalesByItem.class)
                    .withSkipLines(6)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<CustomerSalesByItem> customerSalesByItemList = csvToBean.parse();
            customerSalesByItemList.forEach(customerSalesByItem -> {
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
            });

            List<NetsuiteProductListSource> netsuiteProductListSourceList =
                    netsuiteProductListSourceService.findAllNetsuiteProductListSource();
            List<NetsuiteProductListDe> netsuiteProductListDeList =
                    netsuiteProductListDeService.findAllNetsuiteProductListDe();
            List<NetsuiteGeneralInformation> netsuiteGeneralInformationList =
                    netsuiteGeneralInformationService.findAllNetsuiteGeneralInformation();
            List<NetsuiteOtherInformation> netsuiteOtherInformationList =
                    netsuiteOtherInformationService.findAllNetsuiteOtherInformation();
            List<MdcPerBranchSalesNaConfiguration> mdcPerBranchSalesNaConfigurationList =
                    mdcPerBranchSalesNaConfigurationService.findAllMdcPerBranchSalesNaConfiguration();
            List<NetsuiteBbjTagging> netsuiteBbjTaggingList =
                    netsuiteBbjTaggingService.findAllNetsuiteBbjTagging();
            List<NetsuiteTransfersCat> netsuiteTransfersCatList =
                    netsuiteTransfersCatService.findAllNetsuiteTransfersCat();

            customerSalesByItemList.forEach(customerSalesByItem -> {
                customerSalesByItem.setItemDate(LocalDate.now());
                Netsuite netsuite = new Netsuite(customerSalesByItem);

                NetsuiteGeneralInformation netsuiteGeneralInformation =
                        netsuiteGeneralInformationList.stream()
                                .filter(info -> info.getCustomerJob().equals(netsuite.getCustomer()))
                                .findFirst()
                                .orElse(null);
                netsuite.generateValuesFromNetsuiteGeneralInformation(netsuiteGeneralInformation);

                MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration =
                        mdcPerBranchSalesNaConfigurationList.stream()
                                .filter(config -> config.getNaName().equals(netsuite.getKamRefName1()))
                                .findFirst()
                                .orElse(null);
                netsuite.generateValuesFromMdcPerBranchSalesNaConfiguration(mdcPerBranchSalesNaConfiguration);

                NetsuiteProductListSource netsuiteProductListSource =
                        netsuiteProductListSourceList.stream()
                                .filter(source -> source.getOrigin().equals(netsuite.getDescription()))
                                .findFirst()
                                .orElse(null);
                netsuite.generateValuesFromNetsuiteProductListSource(netsuiteProductListSource);

                NetsuiteProductListDe netsuiteProductListDe =
                        netsuiteProductListDeList.stream()
                                .filter(de -> de.getDescription().equals(netsuite.getFormula()))
                                .findFirst()
                                .orElse(null);
                netsuite.generateValuesFromNetsuiteProductListDe(netsuiteProductListDe);

                NetsuiteOtherInformation netsuiteOtherInformation =
                        netsuiteOtherInformationList.stream()
                                .filter(info -> info.getType().equals(netsuite.getCategory()))
                                .findFirst()
                                .orElse(null);
                netsuite.generateValuesFromNetsuiteOtherInformation(netsuiteOtherInformation);

                NetsuiteBbjTagging netsuiteBbjTagging =
                        netsuiteBbjTaggingList.stream()
                                .filter(tagging -> tagging.getCustomerName().equals(netsuite.getCustomer()))
                                .findFirst()
                                .orElse(null);
                netsuite.generateValuesFromNetsuiteBjjTagging(netsuiteBbjTagging);

                NetsuiteTransfersCat netsuiteTransfersCat =
                        netsuiteTransfersCatList.stream()
                                .filter(transferCat -> transferCat.getName().equals(netsuite.getCategory()))
                                .findFirst()
                                .orElse(null);
                netsuite.generateValuesFromNetsuiteTransfersCat(netsuiteTransfersCat);
                netsuite.generateValuesWhenOtherValuesArePopulated();

                System.out.println("Item Date: " + netsuite.getItemDate());
                System.out.println("Type: " + netsuite.getType());
                System.out.println("Customer: " + netsuite.getCustomer());
                System.out.println("Category: " + netsuite.getCategory());
                System.out.println("Date: " + netsuite.getDate());
                System.out.println("Num: " + netsuite.getNum());
                System.out.println("Created From: " + netsuite.getCreatedFrom());
                System.out.println("Description: " + netsuite.getDescription());
                System.out.println("Quantity: " + netsuite.getQuantity());
                System.out.println("Sales Price: " + netsuite.getSalesPrice());
                System.out.println("Revenue: " + netsuite.getRevenue());
                System.out.println("Price Level: " + netsuite.getPriceLevel());
                System.out.println("Credited To Territorial Manager: " + netsuite.getCreditedToTerritorialManager());
                System.out.println("Sales Rep: " + netsuite.getSalesRep());
                System.out.println("CSR Acquisitions: " + netsuite.getAcquisitionCsrCreditedTo());
                System.out.println("CSR Retention: " + netsuite.getRetentionCsrCreditedTo());
                System.out.println("Order Taken By: " + netsuite.getOrderTakenBy());
                System.out.println("Awareness: " + netsuite.getAwareness());
                System.out.println("Customer Since: " + netsuite.getCustomerSince());
                System.out.println("Zone: " + netsuite.getZone());
                System.out.println("Customer Job Zone: " + netsuite.getCustomerJobZone());
                System.out.println("Pick Up: " + netsuite.getPickup());
                System.out.println("Address 1: " + netsuite.getBillingAddressLine1());
                System.out.println("Address 2: " + netsuite.getBillingAddressLine2());
                System.out.println("Customer Job Hospital: " + netsuite.getCustomerJobHospital1());
                System.out.println("X: " + netsuite.getX());
                System.out.println("Mobile No: " + netsuite.getA());
                System.out.println("Formula : " + netsuite.getFormula());
                System.out.println("Brand : " + netsuite.getBrand());
                System.out.println("Stage : " + netsuite.getStage());
                System.out.println("Transfer Cat: " + netsuite.getTransfersCat());
                System.out.println("Transfer Cat Recode: " + netsuite.getTransfersCatRecode());
                System.out.println("In PCS: " + netsuite.getInPcs());
                System.out.println("Conv Units: " + netsuite.getConvUnits());
                System.out.println("Desc: " + netsuite.getDesc());
                System.out.println("Kam Ref Name: " + netsuite.getKamRefName1());
                System.out.println("Region: " + netsuite.getRegion());
                System.out.println("Revenue Converted: " + netsuite.getRevenueConverted());
                System.out.println("Na Left: " + netsuite.getNaLeft());
                System.out.println("Trim: " + netsuite.getTrim());
                System.out.println("Mgmt: " + netsuite.getMgmt());
                System.out.println("CSR: " + netsuite.getCsrTagging());
                System.out.println("ASM: " + netsuite.getAsm());
                System.out.println("Product Category: " + netsuite.getProductCategory());
                System.out.println();
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
