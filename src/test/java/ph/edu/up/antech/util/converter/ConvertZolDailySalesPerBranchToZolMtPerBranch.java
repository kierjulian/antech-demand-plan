package ph.edu.up.antech.util.converter;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.sales.master.ZolMtPerBranch;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtRaw;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtSheet;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;
import ph.edu.up.antech.domain.sales.raw.ZolDailySalesPerBranch;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.ZolMtAccountService;
import ph.edu.up.antech.service.ZolPerDoorsGeneralInformationService;
import ph.edu.up.antech.service.impl.ZolMdcPerBranchServiceImpl;
import ph.edu.up.antech.service.impl.ZolMtAccountServiceImpl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        ZolMtAccountServiceImpl.class, ZolPerDoorsGeneralInformationService.class,
        ZolMdcPerBranchServiceImpl.class
})
public class ConvertZolDailySalesPerBranchToZolMtPerBranch {

    @Autowired
    private ZolMtAccountService zolMtAccountService;

    @Autowired
    private ZolPerDoorsGeneralInformationService zolPerDoorsGeneralInformationService;

    @Test
    public void convertZolDailySalesPerBranch_toZolMtPerBranch_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(
                Paths.get("src/test/resources/ZolDailySalesPerBranch.csv"))) {
            CsvToBean<ZolDailySalesPerBranch> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ZolDailySalesPerBranch.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            List<ZolDailySalesPerBranch> zolDailySalesPerBranchList = csvToBean.parse();
            List<ZolMtRaw> zolMtRawList = new ArrayList<>();

            zolDailySalesPerBranchList.forEach(zolDailySalesPerBranch -> {
                zolDailySalesPerBranch.convertStringValuesToCorrectTypes();

                ZolMtAccount zolMtAccount = zolMtAccountService
                        .findZolMtAccountByShpcn(zolDailySalesPerBranch.getShpcn());

                ZolMtRaw zolMtRaw = new ZolMtRaw(zolDailySalesPerBranch);
                if (zolMtAccount != null) {
                    zolMtRaw.setAccountName(zolMtAccount.getBranchName());
                }

                zolMtRawList.add(zolMtRaw);
            });

            List<ZolMtRaw> zolMtRawFilteredList = zolMtRawList.stream()
                    .filter(zolMtRaw -> zolMtRaw.getAccountName() != null)
                    .collect(Collectors.toList());
            List<ZolMtSheet> zolMdcSheetList = new ArrayList<>();

            zolMtRawFilteredList.forEach(zolMtRaw -> {
                ZolMtSheet zolMtSheet = new ZolMtSheet(zolMtRaw);
                zolMdcSheetList.add(zolMtSheet);
            });

            List<ZolMtPerBranch> zolMtPerBranchList = new ArrayList<>();

            zolMdcSheetList.forEach(zolMtSheet -> {
                ZolMtPerBranch zolMtPerBranch = new ZolMtPerBranch(zolMtSheet);
                zolMtPerBranchList.add(zolMtPerBranch);
            });

            zolMtPerBranchList.forEach(zolMtPerBranch -> {
                ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = zolPerDoorsGeneralInformationService
                        .findZolPerDoorsGeneralInformationByZpcItemCode(zolMtPerBranch.getItemCode());
                zolMtPerBranch.setValuesFromZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);

                ZolMtAccount zolMtAccount = zolMtAccountService
                        .findZolMtAccountByBranchName(zolMtPerBranch.getCustomerName());
                zolMtPerBranch.setValuesFromZolMtAccount(zolMtAccount);

                System.out.println(zolMtPerBranch.getCustomerName());
                System.out.println(zolMtPerBranch.getItemCode());
                System.out.println(zolMtPerBranch.getItemName());
                System.out.println(zolMtPerBranch.getSalesUnit());
                System.out.println(zolMtPerBranch.getSalesValue());
                System.out.println(zolMtPerBranch.getAntechProductDescription());
                System.out.println(zolMtPerBranch.getAccount());
                System.out.println(zolMtPerBranch.getAntechPrice());
                System.out.println(zolMtPerBranch.getAmount());
                System.out.println(zolMtPerBranch.getKamRefName());
                System.out.println(zolMtPerBranch.getStage());
                System.out.println(zolMtPerBranch.getAmountConverted());
                System.out.println(zolMtPerBranch.getType());
                System.out.println(zolMtPerBranch.getLessThan00375());
                System.out.println(zolMtPerBranch.getV1());
                System.out.println(zolMtPerBranch.getLessThan0853());
                System.out.println(zolMtPerBranch.getV2());
                System.out.println(zolMtPerBranch.getFinalAmount());
                System.out.println(zolMtPerBranch.getAmountTimes1000());
                System.out.println(zolMtPerBranch.getA());
                System.out.println();

                LocalDate localDate = LocalDate.now();
                zolMtPerBranch.setDate(localDate);
            });
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
