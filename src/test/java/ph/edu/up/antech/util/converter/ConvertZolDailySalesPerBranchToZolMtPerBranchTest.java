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
import ph.edu.up.antech.domain.sales.master.converter.*;
import ph.edu.up.antech.domain.sales.raw.ZolDailySalesPerBranch;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.MdcPerBranchSalesNaConfigurationService;
import ph.edu.up.antech.service.ZolMtAccountService;
import ph.edu.up.antech.service.ZolMtPerBranchService;
import ph.edu.up.antech.service.ZolPerDoorsGeneralInformationService;
import ph.edu.up.antech.service.impl.MdcPerBranchSalesNaConfigurationServiceImpl;
import ph.edu.up.antech.service.impl.ZolMtAccountServiceImpl;
import ph.edu.up.antech.service.impl.ZolMtPerBranchServiceImpl;

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
        ZolMtPerBranchServiceImpl.class, MdcPerBranchSalesNaConfigurationServiceImpl.class
})
public class ConvertZolDailySalesPerBranchToZolMtPerBranchTest {

    @Autowired
    private ZolMtAccountService zolMtAccountService;

    @Autowired
    private ZolPerDoorsGeneralInformationService zolPerDoorsGeneralInformationService;

    @Autowired
    private ZolMtPerBranchService zolMtPerBranchService;

    @Autowired
    private MdcPerBranchSalesNaConfigurationService mdcPerBranchSalesNaConfigurationService;

    @Test
    public void convertZolDailySalesPerBranch_toZolMtPerBranch_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(
                Paths.get("src/test/resources/ZolDailySalesPerBranch.csv"))) {
            Long startTime = System.nanoTime();
            CsvToBean<ZolDailySalesPerBranch> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ZolDailySalesPerBranch.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            List<ZolDailySalesPerBranch> zolDailySalesPerBranchList = csvToBean.parse();
            List<ZolMtRaw> zolMtRawList = new ArrayList<>();

            List<ZolMtAccount> zolMtAccountList = zolMtAccountService.findAllZolMtAccount();

            zolDailySalesPerBranchList.forEach(zolDailySalesPerBranch -> {
                zolDailySalesPerBranch.convertStringValuesToCorrectTypes();

                ZolMtAccount zolMtAccount = zolMtAccountList.stream()
                        .filter(zol -> zol.getShpcn().equals(zolDailySalesPerBranch.getShpcn()))
                        .findFirst()
                        .orElse(null);

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

            List<ZolPerDoorsGeneralInformation> zolPerDoorsGeneralInformationList = zolPerDoorsGeneralInformationService
                    .findAllZolPerDoorsGeneralInformation();
            List<MdcPerBranchSalesNaConfiguration> mdcPerBranchSalesNaConfigurationList =
                    mdcPerBranchSalesNaConfigurationService.findAllMdcPerBranchSalesNaConfiguration();

            zolMtPerBranchList.forEach(zolMtPerBranch -> {
                ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = zolPerDoorsGeneralInformationList.stream()
                        .filter(generalInfo -> generalInfo.getZpcItemCode().equals(zolMtPerBranch.getItemCode()))
                        .findFirst()
                        .orElse(null);
                zolMtPerBranch.setValuesFromZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);

                ZolMtAccount zolMtAccount = zolMtAccountList.stream()
                        .filter(zol -> zol.getBranchName().equals(zolMtPerBranch.getCustomerName()))
                        .findFirst()
                        .orElse(null);
                zolMtPerBranch.setValuesFromZolMtAccount(zolMtAccount);

                MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration = mdcPerBranchSalesNaConfigurationList.stream()
                        .filter(naConfig -> naConfig.getNaName().equals(zolMtPerBranch.getKamRefName()))
                        .findFirst()
                        .orElse(null);
                zolMtPerBranch.generateValuesFromZolMdcPerBranchNaConfiguration(mdcPerBranchSalesNaConfiguration);

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
                System.out.println(zolMtPerBranch.getDsm());
                System.out.println();

                LocalDate localDate = LocalDate.now();
                zolMtPerBranch.setDate(localDate);
            });

            //zolMtPerBranchService.saveZolMtPerBranchByBatch(zolMtPerBranchList);
            //zolMtPerBranchService.removeZolMtPerBranchByLocalDate(LocalDate.now());

            Long endTime = System.nanoTime();
            System.out.println(endTime - startTime);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
