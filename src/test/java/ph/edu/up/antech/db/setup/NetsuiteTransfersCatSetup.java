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
import ph.edu.up.antech.domain.master.config.NetsuiteTransfersCat;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.NetsuiteTransfersCatService;
import ph.edu.up.antech.service.impl.NetsuiteTransfersCatServiceImpl;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Run this if you want to repopulate NetsuiteTransfersCat table")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        NetsuiteTransfersCatServiceImpl.class
})
public class NetsuiteTransfersCatSetup {

    @Autowired
    private NetsuiteTransfersCatService netsuiteTransfersCatService;

    @Test
    public void readNetsuiteTransfersCatCsv_andPersistToDb_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/NetsuiteTransfersCat.csv"),
                StandardCharsets.ISO_8859_1)) {
            CsvToBean<NetsuiteTransfersCat> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(NetsuiteTransfersCat.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            List<NetsuiteTransfersCat> netsuiteTransfersCatList = csvToBean.parse();
            netsuiteTransfersCatList.forEach(netsuiteTransferCat -> {
                System.out.println(netsuiteTransferCat.getName());
                System.out.println(netsuiteTransferCat.getCode());
                System.out.println(netsuiteTransferCat.getRecode());
                System.out.println();
                netsuiteTransfersCatService.saveNetsuiteTransfersCat(netsuiteTransferCat);
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
