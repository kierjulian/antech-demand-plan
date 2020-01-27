package ph.edu.up.antech.dao.impl;

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

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        ZolMtAccountServiceImpl.class
})
public class ZolMtAccountServiceTest {

    @Autowired
    private ZolMtAccountService zolMtAccountService;

    @Test
    public void findAllZolMtAccount_shouldBeSuccessful() {
        List<ZolMtAccount> ZolMtAccountList = zolMtAccountService.findAllZolMtAccount();
        ZolMtAccountList.forEach(zolMtAccount -> {
            System.out.println(zolMtAccount.getId());
            System.out.println(zolMtAccount.getShpcn());
            System.out.println(zolMtAccount.getBranchName());
            System.out.println(zolMtAccount.getCustomerName());
            System.out.println(zolMtAccount.getCadd1());
            System.out.println(zolMtAccount.getCadd2());
            System.out.println(zolMtAccount.getNa());
            System.out.println();
        });
    }

}
