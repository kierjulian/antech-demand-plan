package ph.edu.up.antech.util.converter;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.domain.sales.master.converter.*;
import ph.edu.up.antech.domain.sales.raw.CustomerSalesByItem;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.*;
import ph.edu.up.antech.service.impl.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        NetsuiteProductListSourceServiceImpl.class, NetsuiteProductListDeServiceImpl.class,
        NetsuiteGeneralInformationServiceImpl.class, NetsuiteOtherInformationServiceImpl.class,
        MdcPerBranchSalesNaConfigurationServiceImpl.class, NetsuiteBbjTaggingServiceImpl.class
})
public class ConvertCustomerSalesByItemToNetsuiteTest {

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

    @Test
    public void convertCustomerSalesByItemToNetsuite_andPrintContentsOfNetsuite_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/CustomerSalesByItem.csv"))) {
            CsvToBean<CustomerSalesByItem> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CustomerSalesByItem.class)
                    .withSkipLines(6)
                    .build();
            List<CustomerSalesByItem> customerSalesByItemList = csvToBean.parse();

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

            for (CustomerSalesByItem customerSalesByItem : customerSalesByItemList) {
                customerSalesByItem.convertAllStringFieldsToProperType();
                customerSalesByItem.setItemDate(LocalDate.now());

                Netsuite netsuite = new Netsuite(customerSalesByItem);
                System.out.println("Item Date: " + netsuite.getItemDate());
                System.out.println("Type: " + netsuite.getType());
                System.out.println("Customer: " + netsuite.getCustomer());
                System.out.println("Category: " + netsuite.getCategory());
                System.out.println("Date: " + netsuite.getDate());
                System.out.println("NUM: " + netsuite.getNum());
                System.out.println("Created From: " + netsuite.getCreatedFrom());
                System.out.println("Description: " + netsuite.getDescription());
                System.out.println("Quantity: " + netsuite.getQuantity());
                System.out.println("Sales Price: " + netsuite.getSalesPrice());
                System.out.println("Revenue: " + netsuite.getRevenue());
                System.out.println("Price Level: " + netsuite.getPriceLevel());
                System.out.println("Credited To Territorial Manager: " + netsuite.getCreditedToTerritorialManager());
                System.out.println("Sales Rep: " + netsuite.getSalesRep());
                System.out.println("Revenue Converted: " + netsuite.getRevenueConverted());
                System.out.println("Na Left: " + netsuite.getNaLeft());
                System.out.println("Trim: " + netsuite.getTrim());
                System.out.println("Customer Since: " + netsuite.getCustomerSince());
                System.out.println("Zone: " + netsuite.getZone());
                System.out.println("Customer Job Zone: " + netsuite.getCustomerJobZone());
                System.out.println("Pick Up: " + netsuite.getPickup());
                System.out.println("Address 1: " + netsuite.getBillingAddressLine1());
                System.out.println("Address 2: " + netsuite.getBillingAddressLine2());

                NetsuiteGeneralInformation netsuiteGeneralInformation =
                        netsuiteGeneralInformationList.stream()
                                .filter(info -> info.getCustomerJob().equals(netsuite.getCustomer()))
                                .findFirst()
                                .orElse(null);
                netsuite.generateValuesFromNetsuiteGeneralInformation(netsuiteGeneralInformation);
                System.out.println("KAM REF NAME: " + netsuite.getKamRefName1());

                MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration =
                        mdcPerBranchSalesNaConfigurationList.stream()
                                .filter(config -> config.getNaName().equals(netsuite.getKamRefName1()))
                                .findFirst()
                                .orElse(null);
                netsuite.generateValuesFromMdcPerBranchSalesNaConfiguration(mdcPerBranchSalesNaConfiguration);
                System.out.println("REGION: " + netsuite.getRegion());
                System.out.println("ASM: " + netsuite.getAsm());

                NetsuiteProductListSource netsuiteProductListSource =
                        netsuiteProductListSourceList.stream()
                                .filter(source -> source.getOrigin().equals(netsuite.getDescription()))
                                .findFirst()
                                .orElse(null);
                netsuite.generateValuesFromNetsuiteProductListSource(netsuiteProductListSource);
                System.out.println(netsuite.getFormula());

                NetsuiteProductListDe netsuiteProductListDe =
                        netsuiteProductListDeList.stream()
                                .filter(de -> de.getDescription().equals(netsuite.getFormula()))
                                .findFirst()
                                .orElse(null);
                netsuite.generateValuesFromNetsuiteProductListDe(netsuiteProductListDe);
                System.out.println(netsuite.getBrand());
                System.out.println(netsuite.getStage());
                System.out.println();

                NetsuiteOtherInformation netsuiteOtherInformation =
                        netsuiteOtherInformationList.stream()
                                .filter(info -> info.getType().equals(netsuite.getCategory()))
                                .findFirst()
                                .orElse(null);
                netsuite.generateValuesFromNetsuiteOtherInformation(netsuiteOtherInformation);
                System.out.println("MGNT: " + netsuite.getMgmt());

                NetsuiteBbjTagging netsuiteBbjTagging =
                        netsuiteBbjTaggingList.stream()
                                .filter(tagging -> tagging.getCustomerName().equals(netsuite.getCustomer()))
                                .findFirst()
                                .orElse(null);
                netsuite.generateValuesFromNetsuiteBjjTagging(netsuiteBbjTagging);
                System.out.println("CSR TAGGING: " + netsuite.getCsrTagging());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
