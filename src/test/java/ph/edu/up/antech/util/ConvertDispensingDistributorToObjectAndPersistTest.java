package ph.edu.up.antech.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.DispensingDistributorService;
import ph.edu.up.antech.service.impl.DispensingDistributorServiceImpl;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        DispensingDistributorServiceImpl.class
})
public class ConvertDispensingDistributorToObjectAndPersistTest {

    @Autowired
    private DispensingDistributorService dispensingDistributorService;

    @Test
    public void convertDispensingDistributor_fromCsvToObject_shouldPrintCorrectDetails() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/DispensingDistributor.csv"))) {
            CsvToBean<DispensingDistributor> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(DispensingDistributor.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            List<DispensingDistributor> dispensingDistributorList = csvToBean.parse();
            for (DispensingDistributor dispensingDistributor : dispensingDistributorList) {
                dispensingDistributor.setDate(LocalDate.now());
                dispensingDistributor.convertAllStringTypeToProperType();
                System.out.println("MONTH: " + dispensingDistributor.getMonth());
                System.out.println("ACCOUNTS: " + dispensingDistributor.getAccounts());
                System.out.println("DSM NAME: " + dispensingDistributor.getDsmName());
                System.out.println("DOCTOR NAME: " + dispensingDistributor.getDoctorName());
                System.out.println("NA NAME: " + dispensingDistributor.getNaName());
                System.out.println("ITEM KEY: " + dispensingDistributor.getItemKey());
                System.out.println("CATEGORY: " + dispensingDistributor.getCategory());
                System.out.println("REFERENCE NO: " + dispensingDistributor.getReferenceNo());
                System.out.println("PRICE: " + dispensingDistributor.getPrice());
                System.out.println("UNITS: " + dispensingDistributor.getUnits());
                System.out.println("TOTAL AMOUNT: " + dispensingDistributor.getTotalAmount());
                System.out.println("FINAL AMOUNT: " + dispensingDistributor.getFinalAmount());

                // Create new DispensingDistributor
                //dispensingDistributorService.create(dispensingDistributor);

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
