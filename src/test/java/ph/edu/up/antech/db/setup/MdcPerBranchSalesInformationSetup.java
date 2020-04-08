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
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesInformation;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.MdcPerBranchSalesInformationService;
import ph.edu.up.antech.service.impl.MdcPerBranchSalesInformationServiceImpl;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Run this if you want to repopulate MdcPerBranchSalesInformation table")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        MdcPerBranchSalesInformationServiceImpl.class
})
public class MdcPerBranchSalesInformationSetup {

    @Autowired
    private MdcPerBranchSalesInformationService mdcPerBranchSalesInformationService;

    @Test
    public void readAndSaveToDb_mdcPerBranchSalesInformationCsvFile_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/MdcPerBranchSalesInformation.csv"))) {
            CsvToBean<MdcPerBranchSalesInformation> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(MdcPerBranchSalesInformation.class)
                    .withSkipLines(0)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<MdcPerBranchSalesInformation> mdcPerBranchSalesInformationList =
                    csvToBean.parse();
            mdcPerBranchSalesInformationList.forEach(mdcPerBranchSalesInformation -> {
                mdcPerBranchSalesInformation.convertStringTypesToCorrectTypes();
                System.out.println(mdcPerBranchSalesInformation.getItemNumber());
                System.out.println(mdcPerBranchSalesInformation.getItemDescription());
                System.out.println(mdcPerBranchSalesInformation.getItemShortDescription());
                System.out.println(mdcPerBranchSalesInformation.getQuantity());
                System.out.println(mdcPerBranchSalesInformation.getPrice());
                System.out.println(mdcPerBranchSalesInformation.getTotal());
                System.out.println(mdcPerBranchSalesInformation.getItemCode());
                System.out.println(mdcPerBranchSalesInformation.getStage());
                System.out.println(mdcPerBranchSalesInformation.getItemType());
                System.out.println();

                mdcPerBranchSalesInformationService.saveMdcPerBranchSalesInformation(mdcPerBranchSalesInformation);
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
