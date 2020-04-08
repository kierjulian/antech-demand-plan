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
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesCoverage;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.MdcPerBranchSalesCoverageService;
import ph.edu.up.antech.service.impl.MdcPerBranchSalesCoverageServiceImpl;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Run this if you want to repopulate MdcPerBranchSalesCoverage table")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        MdcPerBranchSalesCoverageServiceImpl.class
})
public class MdcPerBranchSalesCoverageSetup {

    @Autowired
    private MdcPerBranchSalesCoverageService mdcPerBranchSalesCoverageService;

    @Test
    public void readMdcPerBranchSalesCoverageFromCsvFile_andStoreToDatabase_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/MdcPerBranchSalesCoverage.csv"),
                StandardCharsets.ISO_8859_1)) {
            CsvToBean<MdcPerBranchSalesCoverage> csvToBean = new CsvToBeanBuilder(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .withType(MdcPerBranchSalesCoverage.class)
                    .build();
            List<MdcPerBranchSalesCoverage> mdcPerBranchSalesCoverageList = csvToBean.parse();
            mdcPerBranchSalesCoverageList.forEach(mdcPerBranchSalesCoverage -> {
                System.out.println(mdcPerBranchSalesCoverage.getBranchCode());
                System.out.println(mdcPerBranchSalesCoverage.getBranchName());
                System.out.println(mdcPerBranchSalesCoverage.getNewCoverage());
                System.out.println(mdcPerBranchSalesCoverage.getOldCoverage());
                System.out.println(mdcPerBranchSalesCoverage.getCoordinator());
                System.out.println(mdcPerBranchSalesCoverage.getRegion());
                System.out.println();
                //mdcPerBranchSalesCoverageService.saveMdcPerBranchSalesCoverage(mdcPerBranchSalesCoverage);
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
