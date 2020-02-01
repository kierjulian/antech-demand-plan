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
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesCode;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.MdcPerBranchSalesCodeService;
import ph.edu.up.antech.service.impl.MdcPerBranchSalesCodeServiceImpl;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Run this if you want to repopulate MdcPerBranchSalesCode table")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        MdcPerBranchSalesCodeServiceImpl.class
})
public class MdcPerBranchSalesCodeSetup {

    @Autowired
    private MdcPerBranchSalesCodeService mdcPerBranchSalesCodeService;

    @Test
    public void readAndPersistMdcPerBranchSalesCode_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/MdcPerBranchSalesCode.csv"))) {
            CsvToBean<MdcPerBranchSalesCode> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(MdcPerBranchSalesCode.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            List<MdcPerBranchSalesCode> mdcPerBranchSalesCodeList = csvToBean.parse();
            mdcPerBranchSalesCodeList.forEach(mdcPerBranchSalesCode -> {
                System.out.println(mdcPerBranchSalesCode.getCode());
                System.out.println(mdcPerBranchSalesCode.getDescription());
                System.out.println();
                mdcPerBranchSalesCodeService.saveMdcPerBranchSalesCoverage(mdcPerBranchSalesCode);
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
