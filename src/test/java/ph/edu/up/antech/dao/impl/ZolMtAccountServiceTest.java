package ph.edu.up.antech.dao.impl;

import org.junit.Assert;
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
        List<ZolMtAccount> zolMtAccountList = zolMtAccountService.findAllZolMtAccount();
        Assert.assertNotNull(zolMtAccountList);
    }

}
