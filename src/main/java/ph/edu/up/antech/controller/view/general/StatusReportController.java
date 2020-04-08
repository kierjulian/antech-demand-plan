package ph.edu.up.antech.controller.view.general;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.Customer;
import ph.edu.up.antech.domain.master.*;
import ph.edu.up.antech.domain.master.config.*;
import ph.edu.up.antech.domain.raw.CustomerItemSalesPerPeriod;
import ph.edu.up.antech.domain.raw.CustomerSalesByItem;
import ph.edu.up.antech.domain.raw.DispensingDistributor;
import ph.edu.up.antech.domain.raw.ZolDailySalesPerBranch;
import ph.edu.up.antech.service.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/general/reports")
public class StatusReportController {

    private static final Logger LOGGER = Logger.getLogger(StatusReportController.class);

    @Autowired
    private ZolPerDoorsGeneralInformationService zolPerDoorsGeneralInformationService;

    @Autowired
    private ZolPerDoorsPerAcctService zolPerDoorsPerAcctService;

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @Autowired
    private DispensingDistributorService dispensingDistributorService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private NetsuiteService netsuiteService;

    @Autowired
    private ZolMdcAccountService zolMdcAccountService;

    @Autowired
    private ZolMdcPerBranchService zolMdcPerBranchService;

    @Autowired
    private ZolMtAccountService zolMtAccountService;

    @Autowired
    private ZolMtPerBranchService zolMtPerBranchService;

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

    @Autowired
    private NetsuiteProductListSourceService netsuiteProductListSourceService;

    @Autowired
    private NetsuiteProductListDeService netsuiteProductListDeService;

    @Autowired
    private NetsuiteGeneralInformationService netsuiteGeneralInformationService;

    @Autowired
    private NetsuiteOtherInformationService netsuiteOtherInformationService;

    @Autowired
    private NetsuiteBbjTaggingService netsuiteBbjTaggingService;

    @Autowired
    private NetsuiteTransfersCatService netsuiteTransfersCatService;

    @GetMapping("")
    public String loadStatusReportHomePage() {
        return "status-report";
    }

    @Transactional(rollbackOn = Exception.class)
    @PostMapping("/upload")
    public String addCsvFiles(RedirectAttributes redirectAttributes,
                              @RequestParam("customerItemSalesPerPeriodFile") MultipartFile customerItemSalesPerPeriodFile,
                              @RequestParam("dispensingDistributorFile") MultipartFile dispensingDistributorFile,
                              @RequestParam("customerSalesByItemFile") MultipartFile customerSalesByItemFile,
                              @RequestParam("zolDailySalesPerBranchFile") MultipartFile zolDailySalesPerBranchFile,
                              @RequestParam("date") String date) {
        try {
            List<CustomerItemSalesPerPeriod> customerItemSalesPerPeriodList = CsvToObjectConverter
                    .convertCsvToListOfCustomerItemSalesPerPeriod(customerItemSalesPerPeriodFile.getInputStream());
            List<DispensingDistributor> dispensingDistributorList = CsvToObjectConverter
                    .convertCsvToListOfDispensingDistributor(dispensingDistributorFile.getInputStream());
            List<CustomerSalesByItem> customerSalesByItemList = CsvToObjectConverter
                    .convertCsvToListOfCustomerSalesByItem(customerSalesByItemFile.getInputStream());
            List<ZolDailySalesPerBranch> zolDailySalesPerBranchList = CsvToObjectConverter
                    .convertCsvToListOfZolDailySalesPerBranch(zolDailySalesPerBranchFile.getInputStream());

            LocalDate localDate = LocalDate.parse(date);

            handleCustomerItemSalesPerPeriodToZolPerDoors(customerItemSalesPerPeriodList, localDate);
            handleDispensingDistributorToDispensingDistributor(dispensingDistributorList, localDate);
            handleCustomerSalesByItemToNetsuite(customerSalesByItemList, localDate);
            handleZolDailySalesPerBranchToZolMdcPerBranch(zolDailySalesPerBranchList, localDate);
            handleZolDailySalesPerBranchToZolMtPerBranch(zolDailySalesPerBranchList, localDate);
            handleZolDailySalesPerBranchToMdcPerBranchSales(zolDailySalesPerBranchList, localDate);

            initializeSuccessMessage(redirectAttributes);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        return "redirect:/general/reports";
    }

    private void handleCustomerItemSalesPerPeriodToZolPerDoors(List<CustomerItemSalesPerPeriod> customerItemSalesPerPeriodList, LocalDate localDate) {
        removeZolPerDoorsByDate(localDate);
        createZolPerDoorsBasedOnCustomerItemSalesPerPeriodCsvFile(customerItemSalesPerPeriodList, localDate);
    }

    private void removeZolPerDoorsByDate(LocalDate localDate) {
        zolPerDoorsService.removeZolPerDoorsByLocalDate(localDate);
    }

    private void createZolPerDoorsBasedOnCustomerItemSalesPerPeriodCsvFile(
            List<CustomerItemSalesPerPeriod> customerItemSalesPerPeriodList, LocalDate date) {
        List<ZolPerDoorsGeneralInformation> zolPerDoorsGeneralInformationList = zolPerDoorsGeneralInformationService
                .findAllZolPerDoorsGeneralInformation();
        List<ZolPerDoorsPerAcct> zolPerDoorsPerAcctList = zolPerDoorsPerAcctService.findAllZolPerDoorsPerAcct();
        List<Customer> customerList = customerService.findAllCustomers();

        List<ZolPerDoors> zolPerDoorsList = new ArrayList<>();

        customerItemSalesPerPeriodList.forEach(customerItemSalesPerPeriod -> {
            customerItemSalesPerPeriod.convertAllStringValuesToProperType();

            Customer customer = customerList.stream()
                    .filter(cust -> cust.getCustomerCode().equals(customerItemSalesPerPeriod.getCustomerCode()))
                    .findFirst()
                    .orElse(null);
            customerItemSalesPerPeriod.updateValuesBasedOnCustomer(customer);

            Customer otherCustomer = customerList.stream()
                    .filter(cust -> cust.getZolMaterialCode().equals(customerItemSalesPerPeriod.getMaterialCode()))
                    .findFirst()
                    .orElse(null);
            if (otherCustomer != null) {
                String materialCode = otherCustomer.getZolMaterialCode();
                customerItemSalesPerPeriod.setMaterialCode(materialCode);
            }

            ZolPerDoors zolPerDoors = new ZolPerDoors(customerItemSalesPerPeriod);
            zolPerDoors.setDate(date);

            ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation =
                    zolPerDoorsGeneralInformationList.stream()
                            .filter(generalInformation -> generalInformation.getZpcItemCode().equals(zolPerDoors.getItemCode()))
                            .findFirst()
                            .orElse(null);
            zolPerDoors.generateValuesBasedOnZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);

            ZolPerDoorsPerAcct zolPerDoorsPerAcct =
                    zolPerDoorsPerAcctList.stream()
                            .filter(perAcct -> perAcct.getZol().equals(zolPerDoors.getCustomerCode()))
                            .findFirst()
                            .orElse(null);
            zolPerDoors.generateValuesBasedOnZolPerDoorsPerAcct(zolPerDoorsPerAcct);

            zolPerDoorsList.add(zolPerDoors);
        });

        zolPerDoorsService.saveZolPerDoorsByBatch(zolPerDoorsList);
    }

    private void handleDispensingDistributorToDispensingDistributor(List<DispensingDistributor> dispensingDistributorList,
                                                                    LocalDate localDate) {
        removeDispensingDistributorByDate(localDate);
        createDispensingDistributorBasedOnCsvFile(dispensingDistributorList, localDate);
    }

    private void removeDispensingDistributorByDate(LocalDate date) {
        dispensingDistributorService.removeDispensingDistributorByLocalDate(date);
    }

    private void createDispensingDistributorBasedOnCsvFile(List<DispensingDistributor> dispensingDistributorList,
                                                           LocalDate localDate) {
        dispensingDistributorList.forEach(dispensingDistributor -> {
            dispensingDistributor.convertAllStringTypeToProperType();
            dispensingDistributor.setDate(localDate);
        });

        dispensingDistributorService.saveDispensingDistributorByBatch(dispensingDistributorList);
    }

    private void handleCustomerSalesByItemToNetsuite(List<CustomerSalesByItem> customerSalesByItemList, LocalDate localDate) {
        removeNetsuiteByDate(localDate);
        createNetsuiteByCustomerSalesByItemList(customerSalesByItemList, localDate);
    }

    private void removeNetsuiteByDate(LocalDate localDate) {
        netsuiteService.removeNetsuiteByDate(localDate);
    }

    private void createNetsuiteByCustomerSalesByItemList(List<CustomerSalesByItem> customerSalesByItemList, LocalDate localDate) {
        List<Netsuite> netsuiteList = new ArrayList<>();

        List<NetsuiteProductListSource> netsuiteProductListSourceList =
                netsuiteProductListSourceService.findAllNetsuiteProductListSource();
        List<NetsuiteProductListDe> netsuiteProductListDeList =
                netsuiteProductListDeService.findAllNetsuiteProductListDe();
        List<NetsuiteGeneralInformation> netsuiteGeneralInformationList =
                netsuiteGeneralInformationService.findAllNetsuiteGeneralInformation();
        List<NetsuiteOtherInformation> netsuiteOtherInformationList =
                netsuiteOtherInformationService.findAllNetsuiteOtherInformation();
        List<MdcPerBranchSalesNaConfiguration> mdcPerBranchSalesNaConfigurationList =
                mdcPerBranchSalesNaConfigurationService.findAllMdcPerBranchSalesNaConfiguration();
        List<NetsuiteBbjTagging> netsuiteBbjTaggingList =
                netsuiteBbjTaggingService.findAllNetsuiteBbjTagging();
        List<NetsuiteTransfersCat> netsuiteTransfersCatList =
                netsuiteTransfersCatService.findAllNetsuiteTransfersCat();

        customerSalesByItemList.forEach(customerSalesByItem -> {
            customerSalesByItem.setItemDate(localDate);
            customerSalesByItem.convertAllStringFieldsToProperType();
            Netsuite netsuite = new Netsuite(customerSalesByItem);

            NetsuiteGeneralInformation netsuiteGeneralInformation =
                    netsuiteGeneralInformationList.stream()
                            .filter(info -> info.getCustomerJob().equals(netsuite.getCustomer()))
                            .findFirst()
                            .orElse(null);
            netsuite.generateValuesFromNetsuiteGeneralInformation(netsuiteGeneralInformation);

            MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration =
                    mdcPerBranchSalesNaConfigurationList.stream()
                            .filter(config -> config.getNaName().equals(netsuite.getKamRefName1()))
                            .findFirst()
                            .orElse(null);
            netsuite.generateValuesFromMdcPerBranchSalesNaConfiguration(mdcPerBranchSalesNaConfiguration);

            NetsuiteProductListSource netsuiteProductListSource =
                    netsuiteProductListSourceList.stream()
                            .filter(source -> source.getOrigin().equals(netsuite.getDescription()))
                            .findFirst()
                            .orElse(null);
            netsuite.generateValuesFromNetsuiteProductListSource(netsuiteProductListSource);

            NetsuiteProductListDe netsuiteProductListDe =
                    netsuiteProductListDeList.stream()
                            .filter(de -> de.getDescription().equals(netsuite.getFormula()))
                            .findFirst()
                            .orElse(null);
            netsuite.generateValuesFromNetsuiteProductListDe(netsuiteProductListDe);

            NetsuiteOtherInformation netsuiteOtherInformation =
                    netsuiteOtherInformationList.stream()
                            .filter(info -> info.getType().equals(netsuite.getCategory()))
                            .findFirst()
                            .orElse(null);
            netsuite.generateValuesFromNetsuiteOtherInformation(netsuiteOtherInformation);

            NetsuiteBbjTagging netsuiteBbjTagging =
                    netsuiteBbjTaggingList.stream()
                            .filter(tagging -> tagging.getCustomerName().equals(netsuite.getCustomer()))
                            .findFirst()
                            .orElse(null);
            netsuite.generateValuesFromNetsuiteBjjTagging(netsuiteBbjTagging);

            NetsuiteTransfersCat netsuiteTransfersCat =
                    netsuiteTransfersCatList.stream()
                            .filter(transferCat -> transferCat.getName().equals(netsuite.getCategory()))
                            .findFirst()
                            .orElse(null);
            netsuite.generateValuesFromNetsuiteTransfersCat(netsuiteTransfersCat);
            netsuite.generateValuesWhenOtherValuesArePopulated();
            netsuiteList.add(netsuite);
        });

        netsuiteService.saveNetsuiteByBatch(netsuiteList);
    }

    private void handleZolDailySalesPerBranchToZolMdcPerBranch(List<ZolDailySalesPerBranch> zolDailySalesPerBranchList, LocalDate localDate) {
        removeZolMdcPerBranchByDate(localDate);
        createZolMdcPerBranchByZolDailySalesPerBranch(zolDailySalesPerBranchList, localDate);
    }

    private void removeZolMdcPerBranchByDate(LocalDate localDate) {
        zolMdcPerBranchService.removeZolMdcPerBranchByLocalDate(localDate);
    }

    private void createZolMdcPerBranchByZolDailySalesPerBranch(List<ZolDailySalesPerBranch> zolDailySalesPerBranchList, LocalDate localDate) {
        List<ZolMdcRaw> zolMdcRawList = new ArrayList<>();

        List<ZolMdcAccount> zolMdcAccountList = zolMdcAccountService.findAllZolMdcAccount();

        zolDailySalesPerBranchList.forEach(zolDailySalesPerBranch -> {
            zolDailySalesPerBranch.convertStringValuesToCorrectTypes();
            ZolMdcAccount zolMdcAccount = zolMdcAccountList.stream()
                    .filter(account -> account.getShpcn().equals(zolDailySalesPerBranch.getShpcn()))
                    .findFirst()
                    .orElse(null);

            ZolMdcRaw zolMdcRaw = new ZolMdcRaw(zolDailySalesPerBranch);
            if (zolMdcAccount != null) {
                zolMdcRaw.setAccountName(zolMdcAccount.getBranchName());
            }

            zolMdcRawList.add(zolMdcRaw);
        });

        List<ZolMdcSheet> zolMdcSheetList = new ArrayList<>();

        List<ZolMdcRaw> zolMdcRawFilteredList = zolMdcRawList.stream()
                .filter(zolMdcRaw -> zolMdcRaw.getAccountName() != null)
                .collect(Collectors.toList());

        zolMdcRawFilteredList.forEach(zolMdcRaw -> {
            ZolMdcSheet zolMdcSheet = new ZolMdcSheet(zolMdcRaw);
            zolMdcSheetList.add(zolMdcSheet);
        });

        List<ZolMdcPerBranch> zolMdcPerBranchList = new ArrayList<>();

        zolMdcSheetList.forEach(zolMdcSheet -> {
            ZolMdcPerBranch zolMdcPerBranch = new ZolMdcPerBranch(zolMdcSheet);
            zolMdcPerBranchList.add(zolMdcPerBranch);
        });

        List<ZolPerDoorsGeneralInformation> zolPerDoorsGeneralInformationList =
                zolPerDoorsGeneralInformationService.findAllZolPerDoorsGeneralInformation();
        List<MdcPerBranchSalesNaConfiguration> mdcPerBranchSalesNaConfigurationList =
                mdcPerBranchSalesNaConfigurationService.findAllMdcPerBranchSalesNaConfiguration();

        zolMdcPerBranchList.forEach(zolMdcPerBranch -> {
            ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = zolPerDoorsGeneralInformationList.stream()
                    .filter(generalInformation -> generalInformation.getZpcItemCode().equals(zolMdcPerBranch.getItemCode()))
                    .findFirst()
                    .orElse(null);
            zolMdcPerBranch.setValuesFromZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);

            ZolMdcAccount zolMdcAccount = zolMdcAccountList.stream()
                    .filter(account -> account.getBranchName().equals(zolMdcPerBranch.getCustomerName()))
                    .findFirst()
                    .orElse(null);
            zolMdcPerBranch.setValuesFromZolMdcAccount(zolMdcAccount);

            MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration = mdcPerBranchSalesNaConfigurationList.stream()
                    .filter(naConfiguration -> naConfiguration.getNaName().equals(zolMdcPerBranch.getKamRefName()))
                    .findFirst()
                    .orElse(null);
            zolMdcPerBranch.setValuesFromMdcPerBranchSalesNaConfiguration(mdcPerBranchSalesNaConfiguration);

            zolMdcPerBranch.setDate(localDate);
        });

        zolMdcPerBranchService.saveZolMdcPerBranchByBatch(zolMdcPerBranchList);
    }

    private void handleZolDailySalesPerBranchToZolMtPerBranch(List<ZolDailySalesPerBranch> zolDailySalesPerBranchList, LocalDate localDate) {
        removeZolMtPerBranchByDate(localDate);
        createZolMtPerBranch(zolDailySalesPerBranchList, localDate);
    }

    private void removeZolMtPerBranchByDate(LocalDate localDate) {
        zolMtPerBranchService.removeZolMtPerBranchByLocalDate(localDate);
    }

    private void createZolMtPerBranch(List<ZolDailySalesPerBranch> zolDailySalesPerBranchList, LocalDate localDate) {
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

            zolMtPerBranch.setDate(localDate);
        });

        zolMtPerBranchService.saveZolMtPerBranchByBatch(zolMtPerBranchList);
    }

    private void handleZolDailySalesPerBranchToMdcPerBranchSales(List<ZolDailySalesPerBranch> zolDailySalesPerBranchList, LocalDate localDate) {
        removeMdcPerBranchSalesByLocalDate(localDate);
        createMdcPerBranchSales(zolDailySalesPerBranchList, localDate);
    }

    private void removeMdcPerBranchSalesByLocalDate(LocalDate localDate) {
        mdcPerBranchSalesService.removeMdcPerBranchSalesByDate(localDate);
    }

    private void createMdcPerBranchSales(List<ZolDailySalesPerBranch> zolDailySalesPerBranchList, LocalDate localDate) {
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
            mdcPerBranchSales.setDate(localDate);
            mdcPerBranchSalesList.add(mdcPerBranchSales);
        });

        mdcPerBranchSalesService.saveMdcPerBranchSalesByBatch(mdcPerBranchSalesList);
    }

    private void initializeSuccessMessage(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMessage",
                "The uploaded files were successfully converted to master files. You can view them in the master files area.");
    }

}
