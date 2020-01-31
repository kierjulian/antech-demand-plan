package ph.edu.up.antech.controller.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.Customer;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.domain.sales.master.ZolMdcPerBranch;
import ph.edu.up.antech.domain.sales.master.ZolMtPerBranch;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.domain.sales.master.converter.*;
import ph.edu.up.antech.domain.sales.raw.CustomerItemSalesPerPeriod;
import ph.edu.up.antech.domain.sales.raw.CustomerSalesByItem;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;
import ph.edu.up.antech.domain.sales.raw.ZolDailySalesPerBranch;
import ph.edu.up.antech.service.*;
import ph.edu.up.antech.util.CsvToObjectConverter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/reports")
public class StatusReportController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusReportController.class);

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

    @GetMapping("")
    public String loadStatusReportHomePage() {
        return "status-report";
    }

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

            handleZolPerDoors(customerItemSalesPerPeriodList, localDate);
            handleDispensingDistributor(dispensingDistributorList, localDate);
            handleCustomerSalesByItem(customerSalesByItemList, localDate);
            handleZolDailySalesPerBranchToZolMdcPerBranch(zolDailySalesPerBranchList, localDate);
            handleZolDailySalesPerBranchToZolMtPerBranch(zolDailySalesPerBranchList, localDate);

            initializeSuccessMessage(redirectAttributes);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/reports";
    }

    private void handleZolPerDoors(List<CustomerItemSalesPerPeriod> customerItemSalesPerPeriodList, LocalDate localDate) {
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
        List<ZolPerDoorsPerAcct> zolPerDoorsPerAcctList = zolPerDoorsPerAcctService.findAllZolPerDoors();
        List<Customer> customerList = customerService.findAllCustomers();

        for (CustomerItemSalesPerPeriod customerItemSalesPerPeriod : customerItemSalesPerPeriodList) {
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
                            .filter(generalInformation -> generalInformation.getItemCode().equals(zolPerDoors.getItemCode()))
                            .findFirst()
                            .orElse(null);
            zolPerDoors.generateValuesBasedOnZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);

            ZolPerDoorsPerAcct zolPerDoorsPerAcct =
                    zolPerDoorsPerAcctList.stream()
                            .filter(perAcct -> perAcct.getZol().equals(zolPerDoors.getCustomerCode()))
                            .findFirst()
                            .orElse(null);
            zolPerDoors.generateValuesBasedOnZolPerDoorsPerAcct(zolPerDoorsPerAcct);

            zolPerDoorsService.createZolPerDoors(zolPerDoors);
        }
    }

    private void handleDispensingDistributor(List<DispensingDistributor> dispensingDistributorList,
                                             LocalDate localDate) {
        removeDispensingDistributorByDate(localDate);
        createDispensingDistributorBasedOnCsvFile(dispensingDistributorList, localDate);
    }

    private void removeDispensingDistributorByDate(LocalDate date) {
        dispensingDistributorService.removeDispensingDistributorByLocalDate(date);
    }

    private void createDispensingDistributorBasedOnCsvFile(List<DispensingDistributor> dispensingDistributorList,
                                                           LocalDate localDate) {
        for (DispensingDistributor dispensingDistributor : dispensingDistributorList) {
            dispensingDistributor.convertAllStringTypeToProperType();
            dispensingDistributor.setDate(localDate);
        }

        dispensingDistributorService.saveDispensingDistributorByBatch(dispensingDistributorList);
    }

    private void handleCustomerSalesByItem(List<CustomerSalesByItem> customerSalesByItemList, LocalDate localDate) {
        removeNetsuiteByDate(localDate);
        createNetsuiteByCustomerSalesByItemList(customerSalesByItemList, localDate);
    }

    private void removeNetsuiteByDate(LocalDate localDate) {
        netsuiteService.removeNetsuiteByDate(localDate);
    }

    private void createNetsuiteByCustomerSalesByItemList(List<CustomerSalesByItem> customerSalesByItemList, LocalDate localDate) {
        List<Netsuite> netsuiteList = new ArrayList<>();
        customerSalesByItemList.forEach(customerSalesByItem -> {
            customerSalesByItem.setItemDate(localDate);
            customerSalesByItem.convertAllStringFieldsToProperType();
            Netsuite netsuite = new Netsuite(customerSalesByItem);
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

            zolMdcPerBranch.setDate(localDate);
        });

        zolMdcPerBranchService.saveZolMdcPerBranchByBatch(zolMdcPerBranchList);
    }

    private void handleZolDailySalesPerBranchToZolMtPerBranch(List<ZolDailySalesPerBranch> zolDailySalesPerBranchList, LocalDate localDate) {
        zolMtPerBranchService.removeZolMtPerBranchByLocalDate(localDate);

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
            zolMtPerBranch.setDate(localDate);

            zolMtPerBranchService.createZolMtPerBranch(zolMtPerBranch);
        });
    }


    private void initializeSuccessMessage(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMessage",
                "The uploaded files were successfully converted to master files. You can view them in the master files area.");
    }

}
