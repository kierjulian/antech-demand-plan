package ph.edu.up.antech.util.parser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DispensingDistrubutorParserTest {

    @Test
    public void convertDispensingDistributorCSVToObject_andPrintContents_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/DispensingDistributor.csv"),
                StandardCharsets.ISO_8859_1)) {
            CsvToBean<DispensingDistributor> csvToBean = new CsvToBeanBuilder(reader)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withType(DispensingDistributor.class).build();
            List<DispensingDistributor> dispensingDistributorList = csvToBean.parse();
            for (DispensingDistributor dispensingDistributor : dispensingDistributorList) {
                dispensingDistributor.convertAllStringTypeToProperType();

                System.out.println("MONTH: " + dispensingDistributor.getMonth());
                System.out.println("ACCOUNTS: " + dispensingDistributor.getAccounts());
                System.out.println("DSMNAME: " + dispensingDistributor.getDsmName());
                System.out.println("DOCTORNAME: " + dispensingDistributor.getDoctorName());
                System.out.println("NAME: " + dispensingDistributor.getNaName());
                System.out.println("ITEM KEY: " + dispensingDistributor.getItemKey());
                System.out.println("REFCD: " + dispensingDistributor.getItemDescription());
                System.out.println("CATEGORY: " + dispensingDistributor.getCategory());
                System.out.println("REFERENCE NO: " + dispensingDistributor.getReferenceNo());
                System.out.println("PRICE: " + dispensingDistributor.getPrice());
                System.out.println("UNITS: " + dispensingDistributor.getUnits());
                System.out.println("TOTAL AMOUNT: " + dispensingDistributor.getTotalAmount());
                System.out.println("Final Amount: " + dispensingDistributor.getFinalAmount());

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
