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
import ph.edu.up.antech.domain.master.config.NetsuiteProductListDe;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.NetsuiteProductListDeService;
import ph.edu.up.antech.service.impl.NetsuiteProductListDeServiceImpl;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Run this if you want to repopulate NetsuiteProductListDe table")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        NetsuiteProductListDeServiceImpl.class
})
public class NetsuiteProductListDeSetup {

    @Autowired
    private NetsuiteProductListDeService netsuiteProductListDeService;

    @Test
    public void readNetsuiteProductListDe_convertAndPersistToDb_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/NetsuiteProductListDe.csv"))) {
            CsvToBean<NetsuiteProductListDe> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(NetsuiteProductListDe.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            List<NetsuiteProductListDe> netsuiteProductListDeList = csvToBean.parse();
            netsuiteProductListDeList.forEach(netsuiteProductListDe -> {
                System.out.println(netsuiteProductListDe.getDescription());
                System.out.println(netsuiteProductListDe.getStage());
                System.out.println(netsuiteProductListDe.getProductCode());
                System.out.println(netsuiteProductListDe.getProductType());
                System.out.println();

                netsuiteProductListDeService.saveNetsuiteProductListDe(netsuiteProductListDe);
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
