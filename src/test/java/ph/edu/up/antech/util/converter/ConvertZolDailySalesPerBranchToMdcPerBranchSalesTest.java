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
import ph.edu.up.antech.domain.master.MdcPerBranchSales;
import ph.edu.up.antech.domain.master.config.*;
import ph.edu.up.antech.domain.raw.ZolDailySalesPerBranch;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.*;
import ph.edu.up.antech.service.impl.*;

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
        MdcPerBranchSalesInformationServiceImpl.class,
        MdcPerBranchSalesAccountServiceImpl.class, MdcPerBranchSalesBrnServiceImpl.class,
        MdcPerBranchSalesCoverageServiceImpl.class, ZolMdcAccountServiceImpl.class,
        MdcPerBranchSalesNaConfigurationServiceImpl.class, MdcPerBranchSalesCodeService.class,
        MdcPerBranchSalesServiceImpl.class
})
public class ConvertZolDailySalesPerBranchToMdcPerBranchSalesTest {

    @Autowired
    private ZolMdcAccountService zolMdcAccountService;

    @Autowired
    private MdcPerBranchSalesInformationService mdcPerBranchSalesInformationService;

    @Autowired
    private MdcPerBranchSalesAccountService mdcPerBranchSalesAccountService;

    @Autowired
    private MdcPerBranchSalesBrnService mdcPerBranchSalesBrnService;

    @Autowired
    private MdcPerBranchSalesCoverageService mdcPerBranchSalesCoverageService;

    @Autowired
    private MdcPerBranchSalesNaConfigurationService mdcPerBranchSalesNaConfigurationService;

    @Autowired
    private MdcPerBranchSalesCodeService mdcPerBranchSalesCodeService;

    @Autowired
    private MdcPerBranchSalesService mdcPerBranchSalesService;

    @Test
    public void convertZolDailySalesPerBranch_toMdcPerBranchSales_andPrintContents_shouldBeSuccessful() {
        try (Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/ZolDailySalesPerBranchTest.csv"))) {
            CsvToBean<ZolDailySalesPerBranch> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(ZolDailySalesPerBranch.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(0)
                    .build();
            List<ZolDailySalesPerBranch> zolDailySalesPerBranchList = csvToBean.parse();

            List<ZolMdcRaw> zolMdcRawList = new ArrayList<>();

            List<ZolMdcAccount> zolMdcAccountList = zolMdcAccountService.findAllZolMdcAccount();

            zolDailySalesPerBranchList.forEach(zolDailySalesPerBranch -> {
                zolDailySalesPerBranch.convertStringValuesToCorrectTypes();

                ZolMdcAccount zolMdcAccount = zolMdcAccountList.stream()
                        .filter(zol -> zol.getShpcn().equals(zolDailySalesPerBranch.getShpcn()))
                        .findFirst()
                        .orElse(null);

                ZolMdcRaw zolMdcRaw = new ZolMdcRaw(zolDailySalesPerBranch);
                if (zolMdcAccount != null) {
                    zolMdcRaw.setAccountName(zolMdcAccount.getBranchName());
                }

                zolMdcRawList.add(zolMdcRaw);
            });

            List<MdcPerBranchSalesInformation> mdcPerBranchSalesInformationList =
                    mdcPerBranchSalesInformationService.findAllMdcPerBranchSalesInformation();

            List<MdcPerBranchSalesAccount> mdcPerBranchSalesAccountList =
                    mdcPerBranchSalesAccountService.findAllMdcPerBranchSalesAccount();

            List<MdcPerBranchSalesBrn> mdcPerBranchSalesBrnList =
                    mdcPerBranchSalesBrnService.findAllMdcPerBranchSalesBrn();

            List<MdcPerBranchSalesCoverage> mdcPerBranchSalesCoverageList =
                    mdcPerBranchSalesCoverageService.findAllMdcPerBranchSalesCoverage();

            List<MdcPerBranchSalesNaConfiguration> mdcPerBranchSalesNaConfigurationList =
                    mdcPerBranchSalesNaConfigurationService.findAllMdcPerBranchSalesNaConfiguration();

            List<MdcPerBranchSalesCode> mdcPerBranchSalesCodeList =
                    mdcPerBranchSalesCodeService.findAllMdcPerBranchSalesCode();

            List<ZolMdcRaw> zolMdcRawFilteredList = zolMdcRawList.stream()
                    .filter(zolMdcRaw -> zolMdcRaw.getAccountName() != null)
                    .collect(Collectors.toList());

            List<MdcPerBranchSales> mdcPerBranchSalesList = new ArrayList<>();

            zolMdcRawFilteredList.forEach(zolMdcRaw -> {
                MdcPerBranchSales mdcPerBranchSales = new MdcPerBranchSales(zolMdcRaw);
                mdcPerBranchSales.setOtherDetails();

                MdcPerBranchSalesInformation mdcPerBranchSalesInformation =
                        mdcPerBranchSalesInformationList.stream()
                                .filter(information -> information.getItemNumber().equals(mdcPerBranchSales.getProdcd()))
                                .findFirst()
                                .orElse(null);
                mdcPerBranchSales.generateValuesBasedOnMdcPerBranchSalesInformation(mdcPerBranchSalesInformation);

                MdcPerBranchSalesAccount mdcPerBranchSalesAccount =
                        mdcPerBranchSalesAccountList.stream()
                                .filter(account -> account.getShpcn().equals(mdcPerBranchSales.getShpcn()))
                                .findFirst()
                                .orElse(null);
                mdcPerBranchSales.generateValuesBasedOnMdcPerBranchSalesAccount(mdcPerBranchSalesAccount);

                MdcPerBranchSalesBrn mdcPerBranchSalesBrn =
                        mdcPerBranchSalesBrnList.stream()
                                .filter(brn -> brn.getShpcn().equals(mdcPerBranchSales.getShpcn()))
                                .findFirst()
                                .orElse(null);
                mdcPerBranchSales.generateValuesBasedOnMdcPerBranchSalesBrn(mdcPerBranchSalesBrn);

                MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage =
                        mdcPerBranchSalesCoverageList.stream()
                                .filter(coverage -> coverage.getBranchCode().equals(mdcPerBranchSales.getStrCode()))
                                .findFirst()
                                .orElse(null);
                mdcPerBranchSales.generateValuesBasedOnMdcPerBranchSalesCoverage(mdcPerBranchSalesCoverage);

                MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration =
                        mdcPerBranchSalesNaConfigurationList.stream()
                                .filter(configuration -> configuration.getNaName().equals(mdcPerBranchSales.getNaName()))
                                .findFirst()
                                .orElse(null);
                mdcPerBranchSales.generateValuesBasedOnMdcPerBranchSalesNaConfiguration(mdcPerBranchSalesNaConfiguration);

                MdcPerBranchSalesCode mdcPerBranchSalesCode = mdcPerBranchSalesCodeList.stream()
                        .filter(salesCode -> salesCode.getCode().equals(mdcPerBranchSales.getReasn()))
                        .findFirst()
                        .orElse(null);
                mdcPerBranchSales.generateValuesBasedOnMdcPerBranchSalesCode(mdcPerBranchSalesCode);
                mdcPerBranchSales.setDate(LocalDate.now());

                System.out.println(mdcPerBranchSales.getCono());
                System.out.println(mdcPerBranchSales.getRec());
                System.out.println(mdcPerBranchSales.getBran());
                System.out.println(mdcPerBranchSales.getSatbrn());
                System.out.println(mdcPerBranchSales.getCustomerNo());
                System.out.println("SHPCN: " + mdcPerBranchSales.getShpcn());
                System.out.println(mdcPerBranchSales.getCustomerName());
                System.out.println(mdcPerBranchSales.getCadd1());
                System.out.println(mdcPerBranchSales.getCadd2());
                System.out.println(mdcPerBranchSales.getClazz());
                System.out.println(mdcPerBranchSales.getZipcd());
                System.out.println(mdcPerBranchSales.getSman());
                System.out.println(mdcPerBranchSales.getPrin());
                System.out.println(mdcPerBranchSales.getSubpr());
                System.out.println("REFCD: " + mdcPerBranchSales.getRefcd());
                System.out.println("REFCD1: " + mdcPerBranchSales.getRefcd1());
                System.out.println("NETQTY: " + mdcPerBranchSales.getNetQuantity());
                System.out.println("NETVALUE: " + mdcPerBranchSales.getNetValue());
                System.out.println("NETVALUE1: " + mdcPerBranchSales.getNetValue2());
                System.out.println("GROSS VALUE: " + mdcPerBranchSales.getGrossValue());
                System.out.println("SKU: " + mdcPerBranchSales.getSku());
                System.out.println("CATEGORY: " + mdcPerBranchSales.getCategory());
                System.out.println("REFERENCEDATE: " + mdcPerBranchSales.getReferenceDate());
                System.out.println(mdcPerBranchSales.getReferenceNo());
                System.out.println(mdcPerBranchSales.getXreferenceNo());
                System.out.println(mdcPerBranchSales.getReasn());
                System.out.println(mdcPerBranchSales.getProdcd());
                System.out.println(mdcPerBranchSales.getQuantityOr());
                System.out.println(mdcPerBranchSales.getQuantitySh());
                System.out.println(mdcPerBranchSales.getUm());
                System.out.println(mdcPerBranchSales.getVlamt());
                System.out.println(mdcPerBranchSales.getSellpr());
                System.out.println(mdcPerBranchSales.getPds());
                System.out.println("EXPDTE: " + mdcPerBranchSales.getExpirationDate());
                System.out.println(mdcPerBranchSales.getLotNo());
                System.out.println(mdcPerBranchSales.getBarcode());
                System.out.println(mdcPerBranchSales.getPdcode());
                System.out.println(mdcPerBranchSales.getDman());
                System.out.println(mdcPerBranchSales.getFindsc());
                System.out.println(mdcPerBranchSales.getFramt());
                System.out.println("SLSYEAR: " + mdcPerBranchSales.getSlsyr());
                System.out.println("SLSMO: " + mdcPerBranchSales.getSlsmo());
                System.out.println("SLSWK: " + mdcPerBranchSales.getSlswk());
                System.out.println(mdcPerBranchSales.getAppNum());
                System.out.println(mdcPerBranchSales.getPoNum());
                System.out.println(mdcPerBranchSales.getGuartran());
                System.out.println(mdcPerBranchSales.getNetSales());
                System.out.println(mdcPerBranchSales.getDebtorCode());
                System.out.println("STRCODE: " + mdcPerBranchSales.getStrCode());
                System.out.println("COVERAGE: " + mdcPerBranchSales.getCoverage());
                System.out.println("REASON: " + mdcPerBranchSales.getReason());
                System.out.println("BRANCHNAME: " + mdcPerBranchSales.getBranchName());
                System.out.println("NA NAME: " + mdcPerBranchSales.getNaName());
                System.out.println("DSM NAME: " + mdcPerBranchSales.getDsmName());
                System.out.println("COORDINATOR: " + mdcPerBranchSales.getCoordinator());
                System.out.println("REGION: " + mdcPerBranchSales.getRegion());
                System.out.println();

                mdcPerBranchSalesList.add(mdcPerBranchSales);
            });

            //mdcPerBranchSalesService.saveMdcPerBranchSalesByBatch(mdcPerBranchSalesList);
            //mdcPerBranchSalesService.removeMdcPerBranchSalesByDate(LocalDate.now());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

}
