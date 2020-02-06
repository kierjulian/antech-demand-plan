package ph.edu.up.antech.db.setup;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListSource;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NetsuiteProductListSourceDbSetup {

    @Test
    public void convertNetsuiteProductListToObject_andSaveToDb_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/NetsuiteProductListSource.csv"))) {
            CsvToBean<NetsuiteProductListSource> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(NetsuiteProductListSource.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            List<NetsuiteProductListSource> netsuiteProductListSourceList = csvToBean.parse();
            netsuiteProductListSourceList.forEach(netsuiteProductListSource -> {
                System.out.println(netsuiteProductListSource.getSource());
                System.out.println(netsuiteProductListSource.getFrom());
                System.out.println(netsuiteProductListSource.getTo());
                System.out.println(netsuiteProductListSource.getDescription());
                System.out.println(netsuiteProductListSource.getInPcs());
                System.out.println(netsuiteProductListSource.getProduct());
                System.out.println();
            });
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
