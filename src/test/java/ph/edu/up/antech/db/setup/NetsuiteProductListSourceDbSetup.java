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
import ph.edu.up.antech.domain.master.config.NetsuiteProductListSource;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.NetsuiteProductListSourceService;
import ph.edu.up.antech.service.impl.NetsuiteProductListSourceServiceImpl;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Run this if you want to repopulate NetsuiteProductListSource table")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        NetsuiteProductListSourceServiceImpl.class
})
public class NetsuiteProductListSourceDbSetup {

    @Autowired
    private NetsuiteProductListSourceService netsuiteProductListSourceService;

    @Test
    public void convertNetsuiteProductListToObject_andSaveToDb_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/NetsuiteProductListSource.csv"))) {
            CsvToBean<NetsuiteProductListSource> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(NetsuiteProductListSource.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            List<NetsuiteProductListSource> netsuiteProductListSourceList = csvToBean.parse();
            netsuiteProductListSourceList.forEach(netsuiteProductListSource -> {
                System.out.println(netsuiteProductListSource.getSource());
                System.out.println(netsuiteProductListSource.getOrigin());
                System.out.println(netsuiteProductListSource.getDestination());
                System.out.println(netsuiteProductListSource.getDescription());
                System.out.println(netsuiteProductListSource.getInPcs());
                System.out.println(netsuiteProductListSource.getProduct());
                System.out.println();

                netsuiteProductListSourceService.saveNetsuiteProductListSource(netsuiteProductListSource);
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
