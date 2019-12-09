package ph.edu.up.antech.util.parser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import ph.edu.up.antech.domain.sales.raw.DailySalesDataDetail;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DailySalesDataDetailParserTest {

    @Test
    public void convertCSVToDailySalesDataDetail_andPrintContents_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/DailySalesDataDetail.csv"))) {
            CsvToBean<DailySalesDataDetail> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(DailySalesDataDetail.class).build();
            List<DailySalesDataDetail> dailySalesDataDetailList = csvToBean.parse();
            for (DailySalesDataDetail dailySalesDataDetail : dailySalesDataDetailList) {
                dailySalesDataDetail.convertAllStringFieldsToProperType();

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
                System.out.println("Reference Date: " + dailySalesDataDetail.getReferenceDate());
                System.out.println("REFNO: " + dailySalesDataDetail.getRefno());
                System.out.println("XREFNO: " + dailySalesDataDetail.getXrefno());
                System.out.println("REASN: " + dailySalesDataDetail.getReasn());
                System.out.println("PRODCD: " + dailySalesDataDetail.getProdcd());
                System.out.println("QTYSH: " + dailySalesDataDetail.getQuantitySh());
                System.out.println("QTYQR: " + dailySalesDataDetail.getQuantityOr());
                System.out.println("UM: " + dailySalesDataDetail.getUm());
                System.out.println("VLAMT: " + dailySalesDataDetail.getVlamt());
                System.out.println("SELLPR: " + dailySalesDataDetail.getSellpr());
                System.out.println("PDS: " + dailySalesDataDetail.getPds());
                System.out.println("Expiry Date: " + dailySalesDataDetail.getExpiryDate());
                System.out.println("LOTNO: " + dailySalesDataDetail.getLotNo());
                System.out.println("BARCODE: " + dailySalesDataDetail.getBarcode());
                System.out.println("PDCODE: " + dailySalesDataDetail.getPdcode());
                System.out.println("DMAN: " + dailySalesDataDetail.getDman());
                System.out.println("FILLER3: " + dailySalesDataDetail.getFiller3());
                System.out.println("FINDSC: " + dailySalesDataDetail.getFindsc());
                System.out.println("FRTAMT: " + dailySalesDataDetail.getFrtamt());
                System.out.println("SLSYR: " + dailySalesDataDetail.getSlsyr());
                System.out.println("SLSMO: " + dailySalesDataDetail.getSlsmo());
                System.out.println("SLSWK: " + dailySalesDataDetail.getSlswk());
                System.out.println("APPNUM: " + dailySalesDataDetail.getAppnum());
                System.out.println("PONUM: " + dailySalesDataDetail.getPonum());
                System.out.println("GUARTRAN: " + dailySalesDataDetail.getGuartran());
                System.out.println("FILLER4: " + dailySalesDataDetail.getFiller4());
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

}
