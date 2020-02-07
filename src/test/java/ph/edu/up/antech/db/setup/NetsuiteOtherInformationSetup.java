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
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteOtherInformation;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.NetsuiteOtherInformationService;
import ph.edu.up.antech.service.impl.NetsuiteOtherInformationServiceImpl;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Run this if you want to repopulate NetsuiteOtherInformation table")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        NetsuiteOtherInformationServiceImpl.class
})
public class NetsuiteOtherInformationSetup {

    @Autowired
    private NetsuiteOtherInformationService netsuiteOtherInformationService;

    @Test
    public void convertNetsuitOtherInformationFromCsvToObject_andPersistToDb_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/NetsuiteOtherInformation.csv"))) {
            CsvToBean<NetsuiteOtherInformation> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(NetsuiteOtherInformation.class)
                    .withSkipLines(0)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<NetsuiteOtherInformation> netsuiteOtherInformationList = csvToBean.parse();
            netsuiteOtherInformationList.forEach(netsuiteOtherInformation -> {
                System.out.println(netsuiteOtherInformation.getType());
                System.out.println(netsuiteOtherInformation.getDescription());
                System.out.println(netsuiteOtherInformation.getOtherDescription());
                System.out.println();
                netsuiteOtherInformationService.saveNetsuiteOtherInformation(netsuiteOtherInformation);
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
