package ph.edu.up.antech.domain.raw;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ZolDailySalesPerBranchTest {

    @Test
    public void readZolDailySalesPerBranch_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/Actual_ZolDailySalesPerBranch.csv"),
                StandardCharsets.ISO_8859_1)) {
            CsvToBean<ZolDailySalesPerBranch> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ZolDailySalesPerBranch.class)
                    .withSkipLines(0)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<ZolDailySalesPerBranch> zolDailySalesPerBranchList = csvToBean.parse();
            zolDailySalesPerBranchList.forEach(zolDailySalesPerBranch -> {
                zolDailySalesPerBranch.convertStringValuesToCorrectTypes();
                System.out.println(zolDailySalesPerBranch.getCono());
                System.out.println(zolDailySalesPerBranch.getRec());
                System.out.println(zolDailySalesPerBranch.getBran());
                System.out.println(zolDailySalesPerBranch.getSatbrn());
                System.out.println(zolDailySalesPerBranch.getCusno());
                System.out.println(zolDailySalesPerBranch.getShpcn());
                System.out.println(zolDailySalesPerBranch.getCustnm());
                System.out.println(zolDailySalesPerBranch.getCadd1());
                System.out.println(zolDailySalesPerBranch.getCadd2());
                System.out.println(zolDailySalesPerBranch.getClazz());
                System.out.println(zolDailySalesPerBranch.getZipcd());
                System.out.println(zolDailySalesPerBranch.getSman());
                System.out.println(zolDailySalesPerBranch.getPrin());
                System.out.println(zolDailySalesPerBranch.getSubpr());
                System.out.println(zolDailySalesPerBranch.getRefcd());
                System.out.println(zolDailySalesPerBranch.getTag());
                System.out.println(zolDailySalesPerBranch.getNetValueInString());
                System.out.println(zolDailySalesPerBranch.getFinalNetVatInString());
                System.out.println(zolDailySalesPerBranch.getUnits());
                System.out.println(zolDailySalesPerBranch.getRefdt());
                System.out.println(zolDailySalesPerBranch.getRefno());
                System.out.println(zolDailySalesPerBranch.getXrefno());
                System.out.println(zolDailySalesPerBranch.getReasn());
                System.out.println(zolDailySalesPerBranch.getProdcd());
                System.out.println(zolDailySalesPerBranch.getZapCode());
                System.out.println(zolDailySalesPerBranch.getItemDescription());
                System.out.println(zolDailySalesPerBranch.getQtyor());
                System.out.println(zolDailySalesPerBranch.getQtysh());
                System.out.println(zolDailySalesPerBranch.getUm());
                System.out.println(zolDailySalesPerBranch.getVlamt());
                System.out.println(zolDailySalesPerBranch.getSellPr());
                System.out.println(zolDailySalesPerBranch.getPds());
                System.out.println(zolDailySalesPerBranch.getExpdte());
                System.out.println(zolDailySalesPerBranch.getLotno());
                System.out.println(zolDailySalesPerBranch.getBarcode());
                System.out.println(zolDailySalesPerBranch.getPdcode());
                System.out.println(zolDailySalesPerBranch.getDman());
                System.out.println(zolDailySalesPerBranch.getFindsc());
                System.out.println(zolDailySalesPerBranch.getFrtamt());
                System.out.println(zolDailySalesPerBranch.getSlsyr());
                System.out.println(zolDailySalesPerBranch.getSlsmo());
                System.out.println(zolDailySalesPerBranch.getSlswk());
                System.out.println(zolDailySalesPerBranch.getAppnum());
                System.out.println(zolDailySalesPerBranch.getPonum());
                System.out.println(zolDailySalesPerBranch.getGuartran());
                System.out.println(zolDailySalesPerBranch.getNetsales());
                System.out.println(zolDailySalesPerBranch.getDebtorCode());
                System.out.println();
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
