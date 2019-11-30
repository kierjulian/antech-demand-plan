package ph.edu.up.antech.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.sales.master.MdcPerBranchSales;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;
import ph.edu.up.antech.domain.sales.raw.CustomerItemSalesPerPeriod;
import ph.edu.up.antech.domain.sales.raw.CustomerSalesByItem;
import ph.edu.up.antech.domain.sales.raw.DailySalesDataDetail;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.ZolPerDoorsGeneralInformationService;
import ph.edu.up.antech.service.ZolPerDoorsPerAcctService;
import ph.edu.up.antech.service.ZolPerDoorsService;
import ph.edu.up.antech.service.impl.ZolPerDoorsGeneralInformationServiceImpl;
import ph.edu.up.antech.service.impl.ZolPerDoorsPerAcctServiceImpl;
import ph.edu.up.antech.service.impl.ZolPerDoorsServiceImpl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {ZolPerDoorsGeneralInformationServiceImpl.class,
        ZolPerDoorsPerAcctServiceImpl.class, ZolPerDoorsServiceImpl.class})
public class ConvertRawDataToMasterDataTest {

    @Autowired
    private ZolPerDoorsGeneralInformationService zolPerDoorsGeneralInformationService;

    @Autowired
    private ZolPerDoorsPerAcctService zolPerDoorsPerAcctService;

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @Test
    public void convertCustomerItemSalesPerPeriodToZolPerDoors_andPrintContentsOfMasterFile_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/CustomerItemSalesPerPeriod.csv"))) {
            CsvToBean<CustomerItemSalesPerPeriod> csvToBean = new CsvToBeanBuilder(reader)
                    .withSkipLines(3).withType(CustomerItemSalesPerPeriod.class).build();
            List<CustomerItemSalesPerPeriod> customerItemSalesPerPeriodList = csvToBean.parse();
            for (CustomerItemSalesPerPeriod customerItemSalesPerPeriod : customerItemSalesPerPeriodList) {
                customerItemSalesPerPeriod.convertAllStringValuesToProperType();
                customerItemSalesPerPeriod.setDate(LocalDate.now());

                ZolPerDoors zolPerDoors = new ZolPerDoors(customerItemSalesPerPeriod);
                // Find ZolPerDoorsGeneralInformation where itemCode = itemCode
                // Populate ZolPerDoors
                ZolPerDoorsGeneralInformation generalInformation =
                        zolPerDoorsGeneralInformationService.findByItemCode(zolPerDoors.getItemCode());
                zolPerDoors.generateValuesBasedOnZolPerDoorsGeneralInformation(generalInformation);

                // Find ZolPerDoorsPerAcct where zol == customerCode
                // Populate ZolPerDoors
                ZolPerDoorsPerAcct perAcct = zolPerDoorsPerAcctService.findByZol(zolPerDoors.getCustomerCode());
                zolPerDoors.generateValuesBasedOnZolPerDoorsPerAcct(perAcct);

                if (zolPerDoors == null || perAcct == null) {
                    continue;
                }

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

                // Save to database
                //zolPerDoorsService.create(zolPerDoors);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

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

    @Test
    public void convertDailySalesDataDetailToMdcPerBranchSales_andPrintContents_shouldBeSuccessul() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/DailySalesDataDetail.csv"))) {
            CsvToBean<DailySalesDataDetail> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(DailySalesDataDetail.class)
                    .build();
            List<DailySalesDataDetail> dailySalesDataDetailList = csvToBean.parse();
            for (DailySalesDataDetail dailySalesDataDetail : dailySalesDataDetailList) {
                dailySalesDataDetail.convertAllStringFieldsToProperType();

                MdcPerBranchSales mdcPerBranchSales = new MdcPerBranchSales(dailySalesDataDetail);
                System.out.println("CONO: " + mdcPerBranchSales.getCono());
                System.out.println("REC: " + mdcPerBranchSales.getRec());
                System.out.println("BRAN: " + mdcPerBranchSales.getBran());
                System.out.println("SATBRN: " + mdcPerBranchSales.getSatbrn());
                System.out.println("CUSNO: " + mdcPerBranchSales.getCustomerNo());
                System.out.println("SHPCN: " + mdcPerBranchSales.getShpcn());
                System.out.println("CUSTNM: " + mdcPerBranchSales.getCustomerNo());
                System.out.println("CADD1: " + mdcPerBranchSales.getCadd1());
                System.out.println("CADD2: " + mdcPerBranchSales.getCadd2());
                System.out.println("CLASS: " + mdcPerBranchSales.getClazz());
                System.out.println("ZIPCD: " + mdcPerBranchSales.getZipcd());
                System.out.println("SMAN: " + mdcPerBranchSales.getSman());
                System.out.println("PRIN: " + mdcPerBranchSales.getPrin());
                System.out.println("SUBPR: " + mdcPerBranchSales.getSubpr());
                System.out.println("REFCD: " + mdcPerBranchSales.getRefcd());
                System.out.println("REFDT: " + mdcPerBranchSales.getReferenceDate());
                System.out.println("REFNO: " + mdcPerBranchSales.getReferenceNo());
                System.out.println("XREFNO: " + mdcPerBranchSales.getXreferenceNo());
                System.out.println("REASN: " + mdcPerBranchSales.getReasn());
                System.out.println("PRODCD: " + mdcPerBranchSales.getProdcd());
                System.out.println("QTYQR: " + mdcPerBranchSales.getQuantityQr());
                System.out.println("QTYSH: " + mdcPerBranchSales.getQuantitySh());
                System.out.println("UM: " + mdcPerBranchSales.getUm());
                System.out.println("VLAMT: " + mdcPerBranchSales.getVlamt());
                System.out.println("SELLPR: " + mdcPerBranchSales.getSellpr());
                System.out.println("PDS: " + mdcPerBranchSales.getPds());
                System.out.println("EXRDTE: " + mdcPerBranchSales.getExpirationDate());
                System.out.println("LOTNO: " + mdcPerBranchSales.getLotNo());
                System.out.println("BARCODE: " + mdcPerBranchSales.getBarcode());
                System.out.println("PDCODE: " + mdcPerBranchSales.getPdcode());
                System.out.println("DMAN: " + mdcPerBranchSales.getDman());
                System.out.println("FINDSC: " + mdcPerBranchSales.getFindsc());
                System.out.println("SLSYR: " + mdcPerBranchSales.getSlsyr());
                System.out.println("SLSMO: " + mdcPerBranchSales.getSlsmo());
                System.out.println("SLSWK: " + mdcPerBranchSales.getSlswk());
                System.out.println("APPNUM: " + mdcPerBranchSales.getAppNum());
                System.out.println("PONUM: " + mdcPerBranchSales.getPoNum());
                System.out.println("GUARTRAN: " + mdcPerBranchSales.getGuartran());
                System.out.println("NETSALES: " + mdcPerBranchSales.getNetSales());

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
