package ph.edu.up.antech.domain.sales.raw;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtRaw;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtSheet;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.MdcPerBranchSalesNaConfigurationService;
import ph.edu.up.antech.service.ZolMtAccountService;
import ph.edu.up.antech.service.ZolMtPerBranchService;
import ph.edu.up.antech.service.ZolPerDoorsGeneralInformationService;
import ph.edu.up.antech.service.impl.MdcPerBranchSalesNaConfigurationServiceImpl;
import ph.edu.up.antech.service.impl.ZolMtAccountServiceImpl;
import ph.edu.up.antech.service.impl.ZolMtPerBranchServiceImpl;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        ZolMtAccountServiceImpl.class, ZolPerDoorsGeneralInformationService.class,
        ZolMtPerBranchServiceImpl.class, MdcPerBranchSalesNaConfigurationServiceImpl.class
})
public class ZolDailySalesPerBranchToZolMtTest {

    @Autowired
    private ZolMtAccountService zolMtAccountService;

    @Autowired
    private ZolPerDoorsGeneralInformationService zolPerDoorsGeneralInformationService;

    @Autowired
    private MdcPerBranchSalesNaConfigurationService mdcPerBranchSalesNaConfigurationService;

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

            List<ZolMtRaw> zolMtRawList = new ArrayList<>();
            List<ZolMtSheet> zolMdcSheetList = new ArrayList<>();

            List<ZolMtAccount> zolMtAccountList = zolMtAccountService.findAllZolMtAccount();

            zolDailySalesPerBranchList.forEach(zolDailySalesPerBranch -> {
                zolDailySalesPerBranch.convertStringValuesToCorrectTypes();
                ZolMtRaw zolMtRaw = new ZolMtRaw(zolDailySalesPerBranch);

                ZolMtAccount zolMtAccount = zolMtAccountList.stream()
                        .filter(zol -> zol.getShpcn().equals(zolDailySalesPerBranch.getShpcn()))
                        .findFirst()
                        .orElse(null);
                if (zolMtAccount != null) {
                    zolMtRaw.setAccountName(zolMtAccount.getBranchName());
                }

                zolMtRawList.add(zolMtRaw);
            });

            zolMtRawList.forEach(zolMtRaw -> {
                ZolMtSheet zolMtSheet = new ZolMtSheet(zolMtRaw);
                zolMdcSheetList.add(zolMtSheet);
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
