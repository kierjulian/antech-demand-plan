package ph.edu.up.antech.util;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import ph.edu.up.antech.domain.sales.raw.CustomerItemSalesPerPeriod;
import ph.edu.up.antech.domain.sales.raw.DailySalesDataDetail;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVParserTest {

    @Test
    public void printContentsFromSampleCSVFile_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/SampleCSV.csv"));
             CSVReader csvReader = new CSVReader(reader)) {
            Object[] record;
            while ((record = csvReader.readNext()) != null) {
                System.out.println((String) record[0]);
                System.out.println(record[1]);
                System.out.println(record[2]);
                System.out.println(record[3]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

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
                System.out.println("Row: " + customerItemSalesPerPeriod.getRow());
                System.out.println("Customer Code: " + customerItemSalesPerPeriod.getCustomerCode());
                System.out.println("Customer Name: " + customerItemSalesPerPeriod.getCustomerName());
                System.out.println("Material Code: " + customerItemSalesPerPeriod.getMaterialCode());
                System.out.println("Material Description: " + customerItemSalesPerPeriod.getMaterialDescription());
                System.out.println("Quantity: " + customerItemSalesPerPeriod.getQuantity());
                System.out.println("Quantity Bonus: " + customerItemSalesPerPeriod.getQuantityBonus());
                customerItemSalesPerPeriod.convertSalesAmountFromStringToBigDecimal();
                System.out.println("Sales Amount: " + customerItemSalesPerPeriod.getSalesAmount());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void convertCSVToDailySalesDataDetail_andPrintContents_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/DailySalesDataDetail.csv"))) {
            CsvToBean<DailySalesDataDetail> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(DailySalesDataDetail.class).build();
            List<DailySalesDataDetail> dailySalesDataDetailList = csvToBean.parse();
            for (DailySalesDataDetail dailySalesDataDetail : dailySalesDataDetailList) {
                System.out.println("CONO: " + dailySalesDataDetail.getCono());
                System.out.println("REC: " + dailySalesDataDetail.getRec());
                System.out.println("BRAN: " + dailySalesDataDetail.getBran());
                System.out.println("SATBRN: " + dailySalesDataDetail.getSatbrn());
                System.out.println("Customer No: " + dailySalesDataDetail.getCustomerNo());
                System.out.println("Filler1: " + dailySalesDataDetail.getFiller1());
                System.out.println("SHPCN: " + dailySalesDataDetail.getShpcn());
                System.out.println("Customer Name: " + dailySalesDataDetail.getCustomerName());
                System.out.println("Cadd1: " + dailySalesDataDetail.getCadd1());
                System.out.println("Cadd2: " + dailySalesDataDetail.getCadd2());
                System.out.println("Class: " + dailySalesDataDetail.getClazz());
                System.out.println("ZIPCD: " + dailySalesDataDetail.getZipcd());
                System.out.println("Filler2: " + dailySalesDataDetail.getFiller2());
                System.out.println("PRIN: " + dailySalesDataDetail.getPrin());
                System.out.println("SUBPR: " + dailySalesDataDetail.getSubpr());
                System.out.println("REFCD: " + dailySalesDataDetail.getRefcd());

                dailySalesDataDetail.convertRefdtToReferenceDate();
                System.out.println("Reference Date: " + dailySalesDataDetail.getReferenceDate());

                System.out.println("REFNO: " + dailySalesDataDetail.getRefno());
                System.out.println("XREFNO: " + dailySalesDataDetail.getXrefno());
                System.out.println("REASN: " + dailySalesDataDetail.getReasn());
                System.out.println("PRODCD: " + dailySalesDataDetail.getProdcd());
                System.out.println("QTYSH: " + dailySalesDataDetail.getQuantitySh());
                System.out.println("QTYQR: " + dailySalesDataDetail.getQuantityOr());
                System.out.println("UM: " + dailySalesDataDetail.getUm());

                dailySalesDataDetail.convertVlamtFromStringToBigDecimal();
                System.out.println("VLAMT: " + dailySalesDataDetail.getVlamt());

                dailySalesDataDetail.convertSellprFromStringToBigDecimal();
                System.out.println("SELLPR: " + dailySalesDataDetail.getSellpr());

                dailySalesDataDetail.convertPdsFromStringToBigDecimal();
                System.out.println("PDS: " + dailySalesDataDetail.getPds());

                dailySalesDataDetail.convertExpiryDateFromStringToLocalDate();
                System.out.println("Expiry Date: " + dailySalesDataDetail.getExpiryDate());

                System.out.println("LOTNO: " + dailySalesDataDetail.getLotNo());
                System.out.println("BARCODE: " + dailySalesDataDetail.getBarcode());
                System.out.println("PDCODE: " + dailySalesDataDetail.getPdcode());
                System.out.println("DMAN: " + dailySalesDataDetail.getDman());
                System.out.println("FILLER3: " + dailySalesDataDetail.getFiller3());

                dailySalesDataDetail.convertFindscFromStringToBigDecimal();
                System.out.println("FINDSC: " + dailySalesDataDetail.getFindsc());

                System.out.println("FRTAMT: " + dailySalesDataDetail.getFrtamt());
                System.out.println("SLSYR: " + dailySalesDataDetail.getSlsyr());
                System.out.println("SLSMO: " + dailySalesDataDetail.getSlsmo());
                System.out.println("SLSWK: " + dailySalesDataDetail.getSlswk());
                System.out.println("APPNUM: " + dailySalesDataDetail.getAppnum());
                System.out.println("PONUM: " + dailySalesDataDetail.getPonum());
                System.out.println("GUARTRAN: " + dailySalesDataDetail.getGuartran());
                System.out.println("FILLER4: " + dailySalesDataDetail.getFiller4());

                dailySalesDataDetail.convertNetSalesFromStringToBigDecimal();
                System.out.println("Net Sales: " + dailySalesDataDetail.getNetSales());
                System.out.println("Filler5: " + dailySalesDataDetail.getFiller5());
                System.out.println("DEBTORCODE: " + dailySalesDataDetail.getDebtorCode());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void convertDispensingDistributorCSVToObject_andPrintContents_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/DispensingDistributor.csv"),
                StandardCharsets.ISO_8859_1)) {
            CsvToBean<DispensingDistributor> csvToBean = new CsvToBeanBuilder(reader)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withType(DispensingDistributor.class).build();
            List<DispensingDistributor> dispensingDistributorList = csvToBean.parse();
            for (DispensingDistributor dispensingDistributor : dispensingDistributorList) {
                System.out.println("MONTH: " + dispensingDistributor.getMonth());
                System.out.println("ACCOUNTS: " + dispensingDistributor.getAccounts());
                System.out.println("DSMNAME: " + dispensingDistributor.getDsmName());
                System.out.println("DOCTORNAME: " + dispensingDistributor.getDoctorName());
                System.out.println("NAME: " + dispensingDistributor.getNaName());
                System.out.println("ITEM KEY: " + dispensingDistributor.getItemKey());
                System.out.println("REFCD: " + dispensingDistributor.getItemDescription());
                System.out.println("CATEGORY: " + dispensingDistributor.getCategory());
                System.out.println("REFERENCE NO: " + dispensingDistributor.getReferenceNo());
                dispensingDistributor.convertPriceFromStringToBigDecimal();
                System.out.println("PRICE: " + dispensingDistributor.getPrice());
                System.out.println("UNITS: " + dispensingDistributor.getUnits());
                dispensingDistributor.convertTotalAmountFromStringToBigDecimal();
                dispensingDistributor.convertFinalAmountFromStringToBigDecimal();
                System.out.println("TOTAL AMOUNT: " + dispensingDistributor.getTotalAmount());
                System.out.println("Final Amount: " + dispensingDistributor.getFinalAmount());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
