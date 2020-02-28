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
import ph.edu.up.antech.dao.impl.ZolPerDoorsPerAcctDAOImpl;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.ZolPerDoorsPerAcctService;
import ph.edu.up.antech.service.impl.ZolPerDoorsPerAcctServiceImpl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Unignore this class if you want to repopulate ZolPerDoorsAcctSetup")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {ZolPerDoorsPerAcctServiceImpl.class, ZolPerDoorsPerAcctDAOImpl.class})
public class ZolPerDoorsPerAcctSetup {

    @Autowired
    private ZolPerDoorsPerAcctService zolPerDoorsPerAcctService;

    @Test
    public void convertZolPerDoorsPerAcctAndPersistToDb_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/ZolPerDoorsPerAcct.csv"))) {
            CsvToBean<ZolPerDoorsPerAcct> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ZolPerDoorsPerAcct.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<ZolPerDoorsPerAcct> zolPerDoorsPerAcctList = csvToBean.parse();
            for (ZolPerDoorsPerAcct zolPerDoorsPerAcct : zolPerDoorsPerAcctList) {
                System.out.println(zolPerDoorsPerAcct.getLocation());
                System.out.println(zolPerDoorsPerAcct.getId());
                System.out.println(zolPerDoorsPerAcct.getSap());
                System.out.println(zolPerDoorsPerAcct.getZol());
                System.out.println(zolPerDoorsPerAcct.getBranch());
                System.out.println(zolPerDoorsPerAcct.getAccount());
                System.out.println(zolPerDoorsPerAcct.getKam());
                System.out.println(zolPerDoorsPerAcct.getTm());
                System.out.println(zolPerDoorsPerAcct.getShare());
                System.out.println(zolPerDoorsPerAcct.getKamReferenceName());
                System.out.println(zolPerDoorsPerAcct.getLocation2());
                System.out.println(zolPerDoorsPerAcct.getNaName());
                System.out.println();
                zolPerDoorsPerAcctService.saveZolPerDoorsPerAcct(zolPerDoorsPerAcct);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
