package ph.edu.up.antech.controller.view.general;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import ph.edu.up.antech.domain.raw.CustomerItemSalesPerPeriod;
import ph.edu.up.antech.domain.raw.CustomerSalesByItem;
import ph.edu.up.antech.domain.raw.DispensingDistributor;
import ph.edu.up.antech.domain.raw.ZolDailySalesPerBranch;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvToObjectConverter {

    private CsvToObjectConverter() {
    }

    public static List<CustomerItemSalesPerPeriod> convertCsvToListOfCustomerItemSalesPerPeriod(
            InputStream inputStream) throws IOException {
        try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1)) {
            CsvToBean<CustomerItemSalesPerPeriod> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CustomerItemSalesPerPeriod.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            return csvToBean.parse();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while uploading file for Customer Item Sales Per Period", e);
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
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while uploading file for Dispensing Distributor", e);
        }
    }

    public static List<CustomerSalesByItem> convertCsvToListOfCustomerSalesByItem(InputStream inputStream)
            throws IOException {
        try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1)) {
            CsvToBean<CustomerSalesByItem> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CustomerSalesByItem.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(6)
                    .build();
            return csvToBean.parse();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while uploading file for Customer Sales By Item", e);
        }
    }

    public static List<ZolDailySalesPerBranch> convertCsvToListOfZolDailySalesPerBranch(InputStream inputStream)
            throws IOException {
        try (Reader reader = new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1)) {
            CsvToBean<ZolDailySalesPerBranch> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ZolDailySalesPerBranch.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            return csvToBean.parse();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while uploading file for ZOL Daily Sales Per Branch", e);
        }
    }

}
