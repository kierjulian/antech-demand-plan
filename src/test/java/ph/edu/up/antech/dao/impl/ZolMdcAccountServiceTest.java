package ph.edu.up.antech.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.master.config.ZolMdcAccount;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.ZolMdcAccountService;
import ph.edu.up.antech.service.impl.ZolMdcAccountServiceImpl;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        ZolMdcAccountServiceImpl.class
})
public class ZolMdcAccountServiceTest {

    @Autowired
    private ZolMdcAccountService zolMdcAccountService;

    @Test
    public void queryAllZolMdcAccount_shouldBeSuccessful() {
        List<ZolMdcAccount> zolMdcAccountList = zolMdcAccountService.findAllZolMdcAccount();
        Assert.assertNotNull(zolMdcAccountList);
    }

}
