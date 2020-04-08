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
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesAccount;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.MdcPerBranchSalesAccountService;
import ph.edu.up.antech.service.impl.MdcPerBranchSalesAccountServiceImpl;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Run this if you want to repopulate MdcPerBranchSalesAccount table")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        MdcPerBranchSalesAccountServiceImpl.class
})
public class MdcPerBranchSalesAccountSetup {

    @Autowired
    private MdcPerBranchSalesAccountService mdcPerBranchSalesAccountService;

    @Test
    public void convertMdcPerBranchSalesAccount_fromCsvToObject_andPersist() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/MdcPerBranchSalesAccount.csv"),
                StandardCharsets.ISO_8859_1)) {
            CsvToBean<MdcPerBranchSalesAccount> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(MdcPerBranchSalesAccount.class)
                    .withSkipLines(0)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<MdcPerBranchSalesAccount> mdcPerBranchSalesAccountList = csvToBean.parse();
            mdcPerBranchSalesAccountList.forEach(mdcPerBranchSalesAccount -> {
                System.out.println(mdcPerBranchSalesAccount.getShpcn());
                System.out.println(mdcPerBranchSalesAccount.getCustomerName());
                System.out.println(mdcPerBranchSalesAccount.getBranchName());
                System.out.println(mdcPerBranchSalesAccount.getCadd1());
                System.out.println(mdcPerBranchSalesAccount.getCadd2());
                System.out.println(mdcPerBranchSalesAccount.getNa());
                System.out.println();
                mdcPerBranchSalesAccountService.saveMdcPerBranchSalesAccount(mdcPerBranchSalesAccount);
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
