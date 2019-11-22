package ph.edu.up.antech.util;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import ph.edu.up.antech.domain.monthly.sales.CustomerItemSalesPerPeriod;
import ph.edu.up.antech.domain.monthly.sales.DailySalesDataDetail;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVParserTest {

    @Test
    public void printContentsFromCSVFile_shouldBeSuccessful() {
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
    public void convertCSVToCustomerItemSalesPerPeriodObject_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/CustomerItemSalesPerPeriod.csv"))) {
            CsvToBean<CustomerItemSalesPerPeriod> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CustomerItemSalesPerPeriod.class).withSkipLines(3).build();
            List<CustomerItemSalesPerPeriod> customerItemSalesPerPeriodList = csvToBean.parse();
            for (CustomerItemSalesPerPeriod customerItemSalesPerPeriod : customerItemSalesPerPeriodList) {
                System.out.println(customerItemSalesPerPeriod.getRow());
                System.out.println(customerItemSalesPerPeriod.getCustomerCode());
                System.out.println(customerItemSalesPerPeriod.getCustomerName());
                System.out.println(customerItemSalesPerPeriod.getMaterialCode());
                System.out.println(customerItemSalesPerPeriod.getMaterialDescription());
                System.out.println(customerItemSalesPerPeriod.getQuantity());
                System.out.println(customerItemSalesPerPeriod.getQuantityBonus());
                customerItemSalesPerPeriod.convertSalesAmount();
                System.out.println(customerItemSalesPerPeriod.getSalesAmount());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void convertCSVToDailySalesDataDetail_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/DailySalesDataDetail.csv"))) {
            CsvToBean<DailySalesDataDetail> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(DailySalesDataDetail.class).build();
            List<DailySalesDataDetail> dailySalesDataDetailList = csvToBean.parse();
            for (DailySalesDataDetail dailySalesDataDetail : dailySalesDataDetailList) {
                System.out.println(dailySalesDataDetail.getCono());
				System.out.println(dailySalesDataDetail.getRec());
				System.out.println(dailySalesDataDetail.getBran());
				System.out.println(dailySalesDataDetail.getSatbrn());
				System.out.println(dailySalesDataDetail.getCustomerNo());
				System.out.println(dailySalesDataDetail.getFiller1());
				System.out.println(dailySalesDataDetail.getShpcn());
				System.out.println(dailySalesDataDetail.getCustomerName());
				System.out.println(dailySalesDataDetail.getCadd1());
				System.out.println(dailySalesDataDetail.getCadd2());
				System.out.println(dailySalesDataDetail.getClazz());
				System.out.println(dailySalesDataDetail.getZipcd());
				System.out.println(dailySalesDataDetail.getFiller2());
				System.out.println(dailySalesDataDetail.getPrin());
				System.out.println(dailySalesDataDetail.getSubpr());
				System.out.println(dailySalesDataDetail.getRefcd());
				System.out.println(dailySalesDataDetail.getRefdt());
				System.out.println(dailySalesDataDetail.getRefno());
				System.out.println(dailySalesDataDetail.getXrefno());
				System.out.println(dailySalesDataDetail.getReasn());
				System.out.println(dailySalesDataDetail.getXrefno());
				System.out.println(dailySalesDataDetail.getProdcd());
				System.out.println(dailySalesDataDetail.getQuantitySh());
				System.out.println(dailySalesDataDetail.getQuantityQr());
				System.out.println(dailySalesDataDetail.getUm());
				System.out.println(dailySalesDataDetail.getVlamtInString());
				System.out.println(dailySalesDataDetail.getSellprInString());
				System.out.println(dailySalesDataDetail.getPdsInString());
				System.out.println(dailySalesDataDetail.getExpiryDate());
				System.out.println(dailySalesDataDetail.getLotNo());
				System.out.println(dailySalesDataDetail.getBarcode());
				System.out.println(dailySalesDataDetail.getPdcode());
				System.out.println(dailySalesDataDetail.getXrefno());
				System.out.println(dailySalesDataDetail.getDman());
				System.out.println(dailySalesDataDetail.getFiller3());
				System.out.println(dailySalesDataDetail.getFindscInString());
				System.out.println(dailySalesDataDetail.getFrtamt());
				System.out.println(dailySalesDataDetail.getSlsyr());
				System.out.println(dailySalesDataDetail.getSlsmo());
				System.out.println(dailySalesDataDetail.getSlswk());
				System.out.println(dailySalesDataDetail.getXrefno());
				System.out.println(dailySalesDataDetail.getAppnum());
				System.out.println(dailySalesDataDetail.getPonum());
				System.out.println(dailySalesDataDetail.getGuartran());
				System.out.println(dailySalesDataDetail.getFiller4());
				System.out.println(dailySalesDataDetail.getNetSalesInString());
				System.out.println(dailySalesDataDetail.getFiller5());
				System.out.println(dailySalesDataDetail.getDebtorCode());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
