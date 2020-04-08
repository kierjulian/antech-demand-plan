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
import ph.edu.up.antech.domain.master.config.NetsuiteGeneralInformation;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.NetsuiteGeneralInformationService;
import ph.edu.up.antech.service.impl.NetsuiteGeneralInformationServiceImpl;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Run this if you want to repopulate NetsuiteGeneralInformation table")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        NetsuiteGeneralInformationServiceImpl.class
})
public class NetsuiteGeneralInformationSetup {

    @Autowired
    private NetsuiteGeneralInformationService netsuiteGeneralInformationService;

    @Test
    public void convertCsvToNetsuiteGeneralInformation_andPersistToDatabase() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/NetsuiteGeneralInformation.csv"),
                StandardCharsets.ISO_8859_1)) {
            CsvToBean<NetsuiteGeneralInformation> csvToBean = new CsvToBeanBuilder(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .withType(NetsuiteGeneralInformation.class)
                    .build();
            List<NetsuiteGeneralInformation> netsuiteGeneralInformationList = csvToBean.parse();
            netsuiteGeneralInformationList.forEach(netsuiteGeneralInformation -> {
                System.out.println("Customer / Job: " + netsuiteGeneralInformation.getCustomerJob());
                System.out.println("Account: " + netsuiteGeneralInformation.getAccount());
                System.out.println("Name: " + netsuiteGeneralInformation.getName());
                System.out.println("NA Number: " + netsuiteGeneralInformation.getNaNumber());
                System.out.println("Kam Reference Name: " + netsuiteGeneralInformation.getKamReferenceName());
                System.out.println("Location: " + netsuiteGeneralInformation.getLocation());
                System.out.println();
                //netsuiteGeneralInformationService.saveNetsuiteGeneralInformation(netsuiteGeneralInformation);
            });
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
