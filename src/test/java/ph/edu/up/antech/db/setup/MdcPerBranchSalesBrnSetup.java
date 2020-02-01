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
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesBrn;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.MdcPerBranchSalesBrnService;
import ph.edu.up.antech.service.impl.MdcPerBranchSalesBrnServiceImpl;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Run this if you want to repopulate MdcPerBranchSalesBrn table")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        MdcPerBranchSalesBrnServiceImpl.class
})
public class MdcPerBranchSalesBrnSetup {

    @Autowired
    private MdcPerBranchSalesBrnService mdcPerBranchSalesBrnService;

    @Test
    public void readMdcPerBranchSalesBrnCsv_andSaveToDb_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/MdcPerBranchSalesBrn.csv"),
                StandardCharsets.ISO_8859_1)) {
            CsvToBean<MdcPerBranchSalesBrn> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(MdcPerBranchSalesBrn.class)
                    .withSkipLines(0)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<MdcPerBranchSalesBrn> mdcPerBranchSalesBrnList = csvToBean.parse();
            mdcPerBranchSalesBrnList.forEach(mdcPerBranchSalesBrn -> {
                System.out.println(mdcPerBranchSalesBrn.getShpcn());
                System.out.println(mdcPerBranchSalesBrn.getCustomerName());
                System.out.println(mdcPerBranchSalesBrn.getBranchName());
                System.out.println(mdcPerBranchSalesBrn.getCadd1());
                System.out.println(mdcPerBranchSalesBrn.getCadd2());
                System.out.println(mdcPerBranchSalesBrn.getNa());
                System.out.println();
                mdcPerBranchSalesBrnService.saveMdcPerBranchSalesBrn(mdcPerBranchSalesBrn);
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
