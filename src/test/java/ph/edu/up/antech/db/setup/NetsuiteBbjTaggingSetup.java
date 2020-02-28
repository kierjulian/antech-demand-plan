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
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBbjTagging;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.NetsuiteBbjTaggingService;
import ph.edu.up.antech.service.impl.NetsuiteBbjTaggingServiceImpl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Ignore("Unignore me if you want to repopulate netsuite_bjj_tagging table.")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@ContextConfiguration(classes = {
        NetsuiteBbjTaggingServiceImpl.class
})
public class NetsuiteBbjTaggingSetup {

    @Autowired
    private NetsuiteBbjTaggingService netsuiteBbjTaggingService;

    @Test
    public void readNetsuiteBjjTaggingFromCsvAndPersistToDatabase() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/NetsuiteBJJTagging.csv"))) {
            CsvToBean<NetsuiteBbjTagging> csvToBean = new CsvToBeanBuilder(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .withType(NetsuiteBbjTagging.class)
                    .build();
            List<NetsuiteBbjTagging> netsuiteBbjTaggingList = csvToBean.parse();
            netsuiteBbjTaggingList.forEach(netsuiteBjjTagging -> {
                System.out.println("Customer Name: " + netsuiteBjjTagging.getCustomerName());
                System.out.println("Zone: " + netsuiteBjjTagging.getZone());
                System.out.println("Address: " + netsuiteBjjTagging.getAddress());
                System.out.println("NEW CSR: " + netsuiteBjjTagging.getNewCsr());
                System.out.println("New Tagging of CSR: " + netsuiteBjjTagging.getNewTaggingOfCsr());
                System.out.println();

                netsuiteBbjTaggingService.saveNetsuiteBbjTagging(netsuiteBjjTagging);
            });
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
