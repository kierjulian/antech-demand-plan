package ph.edu.up.antech.db.setup;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesCoverage;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MdcPerBranchSalesCoverageSetup {

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
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
