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
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesNaConfiguration;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.MdcPerBranchSalesNaConfigurationService;
import ph.edu.up.antech.service.impl.MdcPerBranchSalesNaConfigurationServiceImpl;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Run this if you want to repopulate MdcPerBranchSalesNaConfiguration table")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        MdcPerBranchSalesNaConfigurationServiceImpl.class
})
public class MdcPerBranchSalesNaConfigurationSetup {

    @Autowired
    private MdcPerBranchSalesNaConfigurationService mdcPerBranchSalesNaConfigurationService;

    @Test
    public void readMdPerBranchSalesNaConfiguration_andSaveToDb_shouldBeSuccesful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/MdcPerBranchSalesNaConfiguration.csv"))) {
            CsvToBean<MdcPerBranchSalesNaConfiguration> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(MdcPerBranchSalesNaConfiguration.class)
                    .withSkipLines(0)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<MdcPerBranchSalesNaConfiguration> mdcPerBranchSalesNaConfigurationList = csvToBean.parse();
            mdcPerBranchSalesNaConfigurationList.forEach(mdcPerBranchSalesNaConfiguration -> {
                System.out.println(mdcPerBranchSalesNaConfiguration.getNaName());
                System.out.println(mdcPerBranchSalesNaConfiguration.getDsm());
                System.out.println(mdcPerBranchSalesNaConfiguration.getRegion());
                System.out.println();
                mdcPerBranchSalesNaConfigurationService.saveMdcPerBranchSalesNaConfiguration(mdcPerBranchSalesNaConfiguration);
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
