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
import ph.edu.up.antech.domain.sales.master.MdcPerBranchSales;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtRaw;
import ph.edu.up.antech.domain.sales.raw.ZolDailySalesPerBranch;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.ZolMtAccountService;
import ph.edu.up.antech.service.impl.ZolMtAccountServiceImpl;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        ZolMtAccountServiceImpl.class
})
public class ConvertZolDailySalesPerBranchToMdcPerBranchSalesTest {

    @Autowired
    private ZolMtAccountService zolMtAccountService;

    @Test
    public void convertZolDailySalesPerBranch_toMdcPerBranchSales_andPrintContents_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/ZolDailySalesPerBranchTest.csv"))) {
            CsvToBean<ZolDailySalesPerBranch> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ZolDailySalesPerBranch.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            List<ZolDailySalesPerBranch> zolDailySalesPerBranchList = csvToBean.parse();

            List<ZolMtRaw> zolMtRawList = new ArrayList<>();
            List<ZolMtAccount> zolMtAccountList = zolMtAccountService.findAllZolMtAccount();

            zolDailySalesPerBranchList.forEach(zolDailySalesPerBranch -> {
                zolDailySalesPerBranch.convertStringValuesToCorrectTypes();

                ZolMtAccount zolMtAccount = zolMtAccountList.stream()
                        .filter(zol -> zol.getShpcn().equals(zolDailySalesPerBranch.getShpcn()))
                        .findFirst()
                        .orElse(null);

                ZolMtRaw zolMtRaw = new ZolMtRaw(zolDailySalesPerBranch);
                if (zolMtAccount != null) {
                    zolMtRaw.setAccountName(zolMtAccount.getBranchName());
                }

                zolMtRawList.add(zolMtRaw);
            });

            List<ZolMtRaw> zolMtRawFilteredList = zolMtRawList.stream()
                    .filter(zolMtRaw -> zolMtRaw.getAccountName() != null)
                    .collect(Collectors.toList());
            zolMtRawFilteredList.forEach(zolMtRaw -> {
                MdcPerBranchSales mdcPerBranchSales = new MdcPerBranchSales(zolMtRaw);
                System.out.println(mdcPerBranchSales.getCono());
                System.out.println(mdcPerBranchSales.getRec());
                System.out.println(mdcPerBranchSales.getBran());
                System.out.println(mdcPerBranchSales.getSatbrn());
                System.out.println(mdcPerBranchSales.getCustomerNo());
                System.out.println(mdcPerBranchSales.getShpcn());
                System.out.println(mdcPerBranchSales.getCustomerName());
                System.out.println(mdcPerBranchSales.getCadd1());
                System.out.println(mdcPerBranchSales.getCadd2());
                System.out.println(mdcPerBranchSales.getClazz());
                System.out.println(mdcPerBranchSales.getZipcd());
                System.out.println(mdcPerBranchSales.getSman());
                System.out.println(mdcPerBranchSales.getPrin());
                System.out.println(mdcPerBranchSales.getSubpr());
                System.out.println(mdcPerBranchSales.getReferenceNo());
                System.out.println(mdcPerBranchSales.getXreferenceNo());
                System.out.println(mdcPerBranchSales.getReasn());
                System.out.println(mdcPerBranchSales.getProdcd());
                System.out.println(mdcPerBranchSales.getQuantityQr());
                System.out.println(mdcPerBranchSales.getQuantitySh());
                System.out.println(mdcPerBranchSales.getUm());
                System.out.println(mdcPerBranchSales.getVlamt());
                System.out.println(mdcPerBranchSales.getSellpr());
                System.out.println(mdcPerBranchSales.getPds());
                System.out.println(mdcPerBranchSales.getLotNo());
                System.out.println(mdcPerBranchSales.getBarcode());
                System.out.println(mdcPerBranchSales.getPdcode());
                System.out.println(mdcPerBranchSales.getDman());
                System.out.println(mdcPerBranchSales.getFindsc());
                System.out.println(mdcPerBranchSales.getFramt());
                System.out.println(mdcPerBranchSales.getAppNum());
                System.out.println(mdcPerBranchSales.getPoNum());
                System.out.println(mdcPerBranchSales.getGuartran());
                System.out.println(mdcPerBranchSales.getNetSales());
                System.out.println(mdcPerBranchSales.getDebtorCode());
                System.out.println();
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
