package ph.edu.up.antech.domain.sales.raw;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DispensingDistributorTest {

    @Test
    public void readDispensingDistributor_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/Actual_DispensingDistributor.csv"),
                StandardCharsets.UTF_8)) {
            CsvToBean<DispensingDistributor> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(DispensingDistributor.class)
                    .withSkipLines(0)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<DispensingDistributor> dispensingDistributorList = csvToBean.parse();
            dispensingDistributorList.forEach(dispensingDistributor -> {
                dispensingDistributor.convertAllStringTypeToProperType();
                System.out.println("Month: " + dispensingDistributor.getMonth());
                System.out.println("Accounts: " + dispensingDistributor.getAccounts());
                System.out.println("DSM Name: " + dispensingDistributor.getDsmName());
                System.out.println("Doctor Name: " + dispensingDistributor.getDoctorName());
                System.out.println("NA Name: " + dispensingDistributor.getNaName());
                System.out.println("Item Key: " + dispensingDistributor.getItemKey());
                System.out.println("Category: " + dispensingDistributor.getCategory());
                System.out.println("Reference No: " + dispensingDistributor.getReferenceNo());
                System.out.println("Price: " + dispensingDistributor.getPrice());
                System.out.println("Units: " + dispensingDistributor.getUnits());
                System.out.println("Total Amount: " + dispensingDistributor.getTotalAmount());
                System.out.println("Final Amount: " + dispensingDistributor.getFinalAmount());
                System.out.println();
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
