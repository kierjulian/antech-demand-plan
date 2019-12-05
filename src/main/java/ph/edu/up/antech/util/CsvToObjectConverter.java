package ph.edu.up.antech.util;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ph.edu.up.antech.domain.sales.raw.CustomerItemSalesPerPeriod;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvToObjectConverter {

    public static List<CustomerItemSalesPerPeriod> convertCsvToListOfCustomerItemSalesPerPeriod(
            InputStream inputStream) throws IOException {
        try (Reader reader = new InputStreamReader(inputStream)) {
            CsvToBean<CustomerItemSalesPerPeriod> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CustomerItemSalesPerPeriod.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(3)
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    public static List<DispensingDistributor> convertCsvToListOfDispensingDistributor(InputStream inputStream)
            throws IOException {
        try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1)) {
            CsvToBean<DispensingDistributor> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(DispensingDistributor.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

}
