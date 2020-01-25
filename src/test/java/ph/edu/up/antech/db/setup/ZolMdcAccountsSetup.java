package ph.edu.up.antech.db.setup;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.sales.master.converter.ZolMdcAccount;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.ZolMdcAccountService;
import ph.edu.up.antech.service.impl.ZolMdcAccountServiceImpl;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Unignore me if you want to repopulate zol_mdc_account table.")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@ContextConfiguration(classes = {
        ZolMdcAccountServiceImpl.class
})
public class ZolMdcAccountsSetup {

    @Autowired
    private ZolMdcAccountService zolMdcAccountService;

    @Test
    public void populateZolMdcAccountViaCsvFile() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/ZolMdcAccount.csv"),
                StandardCharsets.ISO_8859_1)) {
            CsvToBean<ZolMdcAccount> csvToBean = new CsvToBeanBuilder(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .withType(ZolMdcAccount.class)
                    .build();
            List<ZolMdcAccount> zolMdcAccountList = csvToBean.parse();
            zolMdcAccountList.forEach(zolMdcAccount -> {
                zolMdcAccountService.createZolMdcAccount(zolMdcAccount);
                System.out.println(zolMdcAccount.getShpcn());
                System.out.println(zolMdcAccount.getCustomerName());
                System.out.println(zolMdcAccount.getBranchName());
                System.out.println(zolMdcAccount.getCadd1());
                System.out.println(zolMdcAccount.getCadd2());
                System.out.println(zolMdcAccount.getNa());
                System.out.println();
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
