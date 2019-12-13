package ph.edu.up.antech.db.setup;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteGeneralInformation;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NetsuiteGeneralInformationSetup {

    @Test
    public void convertCsvToNetsuiteGeneralInformation_andPersistToDatabase() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/NetsuiteGeneralInformation.csv"),
                StandardCharsets.ISO_8859_1)) {
            CsvToBean<NetsuiteGeneralInformation> csvToBean = new CsvToBeanBuilder(reader)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .withType(NetsuiteGeneralInformation.class)
                    .build();
            List<NetsuiteGeneralInformation> netsuiteGeneralInformationList = csvToBean.parse();
            netsuiteGeneralInformationList.forEach(netsuiteGeneralInformation -> {
                System.out.println("Customer / Job: " + netsuiteGeneralInformation.getCustomerJob());
                System.out.println("Account: " + netsuiteGeneralInformation.getAccount());
                System.out.println("Name: " + netsuiteGeneralInformation.getName());
                System.out.println("NA Number: " + netsuiteGeneralInformation.getNaNumber());
                System.out.println("Kam Reference Name: " + netsuiteGeneralInformation.getKamReferenceName());
                System.out.println("Location: " + netsuiteGeneralInformation.getLocation());
                System.out.println();
            });
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
