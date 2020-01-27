package ph.edu.up.antech.util.converter;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import ph.edu.up.antech.domain.sales.master.MdcPerBranchSales;
import ph.edu.up.antech.domain.sales.raw.DailySalesDataDetail;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ConvertDailySalesDataDetailToMdcPerBranchSalesTest {

    @Test
    public void convertDailySalesDataDetailToMdcPerBranchSales_andPrintContents_shouldBeSuccessful() {
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
                System.out.println("FRAMT:" + mdcPerBranchSales.getFramt());
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
