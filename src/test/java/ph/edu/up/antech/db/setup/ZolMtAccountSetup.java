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
import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.ZolMtAccountService;
import ph.edu.up.antech.service.impl.ZolMtAccountServiceImpl;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Unignore me if you want to repopulate zol_mt_account table.")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@ContextConfiguration(classes = {
        ZolMtAccountServiceImpl.class
})
public class ZolMtAccountSetup {

    @Autowired
    private ZolMtAccountService zolMtAccountService;

    @Test
    public void readZolMtAccountsFromCsvFile_andPersistToDatabase_shouldBeSuccesful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/ZolMtAccount.csv"),
                StandardCharsets.ISO_8859_1)) {
            CsvToBean<ZolMtAccount> csvToBean = new CsvToBeanBuilder(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .withType(ZolMtAccount.class)
                    .build();
            List<ZolMtAccount> zolMtAccountList = csvToBean.parse();
            zolMtAccountList.forEach(zolMtAccount -> {
                //zolMtAccountService.createZolMtAccount(zolMtAccount);
                System.out.println(zolMtAccount.getShpcn());
                System.out.println(zolMtAccount.getCustomerName());
                System.out.println(zolMtAccount.getBranchName());
                System.out.println(zolMtAccount.getCadd1());
                System.out.println(zolMtAccount.getCadd2());
                System.out.println(zolMtAccount.getNa());
                System.out.println();
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
