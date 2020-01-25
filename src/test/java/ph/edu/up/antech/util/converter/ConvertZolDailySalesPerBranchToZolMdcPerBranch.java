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
import ph.edu.up.antech.domain.sales.master.converter.ZolMdcAccount;
import ph.edu.up.antech.domain.sales.master.converter.ZolMdcRaw;
import ph.edu.up.antech.domain.sales.master.converter.ZolMdcSheet;
import ph.edu.up.antech.domain.sales.raw.ZolDailySalesPerBranch;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.ZolMdcAccountService;
import ph.edu.up.antech.service.impl.ZolMdcAccountServiceImpl;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        ZolMdcAccountServiceImpl.class
})
public class ConvertZolDailySalesPerBranchToZolMdcPerBranch {

    @Autowired
    private ZolMdcAccountService zolMdcAccountService;

    @Test
    public void convertZolDailySalesPerBranch_toZolMdcPerBranch_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/ZolDailySalesPerBranchTest.csv"))) {
            CsvToBean<ZolDailySalesPerBranch> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ZolDailySalesPerBranch.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            List<ZolDailySalesPerBranch> zolDailySalesPerBranchList = csvToBean.parse();
            List<ZolMdcRaw> zolMdcRawList = new ArrayList<>();

            zolDailySalesPerBranchList.forEach(zolDailySalesPerBranch -> {
                zolDailySalesPerBranch.convertStringValuesToCorrectTypes();
                ZolMdcAccount zolMdcAccount = zolMdcAccountService
                        .findZolMdcAccountByShpcn(zolDailySalesPerBranch.getShpcn());

                ZolMdcRaw zolMdcRaw = new ZolMdcRaw(zolDailySalesPerBranch);

                if (zolMdcAccount != null) {
                    zolMdcRaw.setAccountName(zolMdcAccount.getBranchName());
                }

                zolMdcRawList.add(zolMdcRaw);
            });


            List<ZolMdcRaw> zolMdcRawFilteredList = zolMdcRawList.stream()
                    .filter(zolMdcRaw -> zolMdcRaw.getAccountName() != null)
                    .collect(Collectors.toList());

            List<ZolMdcSheet> zolMdcSheetList = new ArrayList<>();
            zolMdcRawFilteredList.forEach(zolMdcRaw -> {
                System.out.println(zolMdcRaw.getCono());
                System.out.println(zolMdcRaw.getRec());
                System.out.println(zolMdcRaw.getBran());
                System.out.println(zolMdcRaw.getSatbrn());
                System.out.println(zolMdcRaw.getCusno());
                System.out.println(zolMdcRaw.getShpcn());
                System.out.println(zolMdcRaw.getCustnm());
                System.out.println(zolMdcRaw.getAccountName());
                System.out.println(zolMdcRaw.getCadd1());
                System.out.println(zolMdcRaw.getCadd2());
                System.out.println(zolMdcRaw.getClazz());
                System.out.println(zolMdcRaw.getZipcd());
                System.out.println(zolMdcRaw.getSman());
                System.out.println(zolMdcRaw.getPrin());
                System.out.println(zolMdcRaw.getSubpr());
                System.out.println(zolMdcRaw.getRefcd());
                System.out.println(zolMdcRaw.getTag());
                System.out.println(zolMdcRaw.getNetValueInString());
                System.out.println(zolMdcRaw.getFinalNetVat());
                System.out.println(zolMdcRaw.getUnits());
                System.out.println(zolMdcRaw.getRefdt());
                System.out.println(zolMdcRaw.getRefno());
                System.out.println(zolMdcRaw.getXrefno());
                System.out.println(zolMdcRaw.getReasn());
                System.out.println(zolMdcRaw.getProdcd());
                System.out.println(zolMdcRaw.getZapCode());
                System.out.println(zolMdcRaw.getItemDescription());
                System.out.println(zolMdcRaw.getQtyor());
                System.out.println(zolMdcRaw.getQtysh());
                System.out.println(zolMdcRaw.getUm());
                System.out.println(zolMdcRaw.getVlamt());
                System.out.println(zolMdcRaw.getSellPr());
                System.out.println(zolMdcRaw.getPds());
                System.out.println(zolMdcRaw.getExpdte());
                System.out.println(zolMdcRaw.getLotno());
                System.out.println(zolMdcRaw.getBarcode());
                System.out.println(zolMdcRaw.getPdcode());
                System.out.println(zolMdcRaw.getDman());
                System.out.println(zolMdcRaw.getFindsc());
                System.out.println(zolMdcRaw.getFrtamt());
                System.out.println(zolMdcRaw.getSlsyr());
                System.out.println(zolMdcRaw.getSlsmo());
                System.out.println(zolMdcRaw.getSlswk());
                System.out.println(zolMdcRaw.getAppnum());
                System.out.println(zolMdcRaw.getPonum());
                System.out.println(zolMdcRaw.getGuartran());
                System.out.println(zolMdcRaw.getNetsales());
                System.out.println(zolMdcRaw.getDebtorCode());
                System.out.println();
                ZolMdcSheet zolMdcSheet = new ZolMdcSheet(zolMdcRaw);
                zolMdcSheetList.add(zolMdcSheet);
            });

            zolMdcSheetList.forEach(zolMdcSheet -> {
                System.out.println(zolMdcSheet.getAccountName());
                System.out.println(zolMdcSheet.getZapCode());
                System.out.println(zolMdcSheet.getItemDescription());
                System.out.println(zolMdcSheet.getSumOfUnits());
                System.out.println(zolMdcSheet.getSumOfFinalNetValue());
                System.out.println();
            });

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
