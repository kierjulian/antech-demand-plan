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
import ph.edu.up.antech.dao.impl.ZolPerDoorsGeneralInformationDAOImpl;
import ph.edu.up.antech.domain.master.config.ZolPerDoorsGeneralInformation;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.ZolPerDoorsGeneralInformationService;
import ph.edu.up.antech.service.impl.ZolPerDoorsGeneralInformationServiceImpl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Unignore this if you want to repopulate ZolPerDoorsGeneralInformation")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {ZolPerDoorsGeneralInformationServiceImpl.class,
        ZolPerDoorsGeneralInformationDAOImpl.class})
public class ZolPerDoorsGeneralInformationSetup {

    @Autowired
    private ZolPerDoorsGeneralInformationService zolPerDoorsGeneralInformationService;

    @Test
    public void convertZolPerDoorsGeneralInformationFromCsvToObject_andPersistToDb_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(
                Paths.get("src/test/resources/ZolPerDoorsGeneralInformation.csv"))) {
            CsvToBean<ZolPerDoorsGeneralInformation> csvToBean = new CsvToBeanBuilder(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withType(ZolPerDoorsGeneralInformation.class)
                    .build();
            List<ZolPerDoorsGeneralInformation> zolPerDoorsGeneralInformationList = csvToBean.parse();
            for (ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation : zolPerDoorsGeneralInformationList) {
                zolPerDoorsGeneralInformation.removeBlankSpacesInStrings();
                zolPerDoorsGeneralInformation.convertStringsToCorrectType();

                System.out.println(zolPerDoorsGeneralInformation.getZpcItemCode());
                System.out.println(zolPerDoorsGeneralInformation.getItemCode());
                System.out.println(zolPerDoorsGeneralInformation.getItemName());
                System.out.println(zolPerDoorsGeneralInformation.getAntechProductDescription());
                System.out.println(zolPerDoorsGeneralInformation.getPcsCs());
                System.out.println(zolPerDoorsGeneralInformation.getPcAmount());
                System.out.println(zolPerDoorsGeneralInformation.getPerCase());
                System.out.println(zolPerDoorsGeneralInformation.getBrand());
                System.out.println(zolPerDoorsGeneralInformation.getStage());
                System.out.println(zolPerDoorsGeneralInformation.getOldPrice());
                System.out.println(zolPerDoorsGeneralInformation.getNewPrice());

                System.out.println();

                zolPerDoorsGeneralInformationService.saveZolPerDoorsGeneralInformation(
                        zolPerDoorsGeneralInformation);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
