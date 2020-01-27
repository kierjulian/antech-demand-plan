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
            handleZolDailySalesPerBranch(zolDailySalesPerBranchList, localDate);

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
        List<ZolPerDoors> zolPerDoorsList = zolPerDoorsService.findZolPerDoorsByDate(localDate);
        if (zolPerDoorsList != null) {
            for (ZolPerDoors zolPerDoors : zolPerDoorsList) {
                zolPerDoorsService.removeZolPerDoors(zolPerDoors.getId());
            }
        }
    }

    private void createZolPerDoorsBasedOnCustomerItemSalesPerPeriodCsvFile(
            List<CustomerItemSalesPerPeriod> customerItemSalesPerPeriodList, LocalDate date) {
        for (CustomerItemSalesPerPeriod customerItemSalesPerPeriod : customerItemSalesPerPeriodList) {
            customerItemSalesPerPeriod.convertAllStringValuesToProperType();

            Customer customer = customerService.findCustomerByCustomerCode(customerItemSalesPerPeriod.getCustomerCode());
            customerItemSalesPerPeriod.updateValuesBasedOnCustomer(customer);

            String materialCode = customerService.findCustomerZolMaterialCodeByMaterialCode(customerItemSalesPerPeriod.getMaterialCode());
            customerItemSalesPerPeriod.setMaterialCode(materialCode);

            ZolPerDoors zolPerDoors = new ZolPerDoors(customerItemSalesPerPeriod);
            zolPerDoors.setDate(date);

            ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = zolPerDoorsGeneralInformationService
                    .findZolPerDoorsGeneralInformationByZpcItemCode(zolPerDoors.getItemCode());
            zolPerDoors.generateValuesBasedOnZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);

            ZolPerDoorsPerAcct zolPerDoorsPerAcct = zolPerDoorsPerAcctService.findZolPerDoorsPerAcctByZol(zolPerDoors.getCustomerCode());
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
        List<DispensingDistributor> dispensingDistributorList = dispensingDistributorService.findDispensingDistributorByDate(date);
        if (dispensingDistributorList != null) {
            for (DispensingDistributor dispensingDistributor : dispensingDistributorList) {
                dispensingDistributorService.removeDispensingDistributor(dispensingDistributor.getId());
            }
        }
    }

    private void createDispensingDistributorBasedOnCsvFile(List<DispensingDistributor> dispensingDistributorList,
                                                           LocalDate localDate) {
        for (DispensingDistributor dispensingDistributor : dispensingDistributorList) {
            dispensingDistributor.convertAllStringTypeToProperType();
            dispensingDistributor.setDate(localDate);
            dispensingDistributorService.createDispensingDistributor(dispensingDistributor);
        }
    }

    private void handleCustomerSalesByItem(List<CustomerSalesByItem> customerSalesByItemList, LocalDate localDate) {
        removeNetsuiteByDate(localDate);
        createNetsuiteByCustomerSalesByItemList(customerSalesByItemList, localDate);
    }

    private void removeNetsuiteByDate(LocalDate localDate) {
        List<Netsuite> netsuiteList = netsuiteService.findNetsuiteByItemDate(localDate);
        if (netsuiteList != null) {
            netsuiteList.forEach(netsuite -> {
                netsuiteService.removeNetsuite(netsuite.getId());
            });
        }
    }

    private void createNetsuiteByCustomerSalesByItemList(List<CustomerSalesByItem> customerSalesByItemList, LocalDate localDate) {
        customerSalesByItemList.forEach(customerSalesByItem -> {
            customerSalesByItem.setItemDate(localDate);
            customerSalesByItem.convertAllStringFieldsToProperType();
            Netsuite netsuite = new Netsuite(customerSalesByItem);
            netsuiteService.createNetsuite(netsuite);
        });
    }

    private void handleZolDailySalesPerBranch(List<ZolDailySalesPerBranch> zolDailySalesPerBranchList, LocalDate localDate) {
        removeZolMdcPerBranchByDate(localDate);
        createZolMdcPerBranchByZolDailySalesPerBranch(zolDailySalesPerBranchList, localDate);
    }

    private void removeZolMdcPerBranchByDate(LocalDate localDate) {
        List<ZolMdcPerBranch> zolMdcPerBranchList = zolMdcPerBranchService.findZolMdcPerBranchByLocalDate(localDate);
        if (zolMdcPerBranchList != null) {
            zolMdcPerBranchList.forEach(zolMdcPerBranch -> zolMdcPerBranchService
                    .removeZolMdcPerBranchById(zolMdcPerBranch.getId()));
        }
    }

    private void createZolMdcPerBranchByZolDailySalesPerBranch(List<ZolDailySalesPerBranch> zolDailySalesPerBranchList, LocalDate localDate) {
        List<ZolMdcRaw> zolMdcRawList = new ArrayList<>();
        zolDailySalesPerBranchList.forEach(zolDailySalesPerBranch -> {
            zolDailySalesPerBranch.convertStringValuesToCorrectTypes();
            ZolMdcAccount zolMdcAccount = zolMdcAccountService
                    .findZolMdcAccountByShpcn(zolDailySalesPerBranch.getShpcn());

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

        zolMdcPerBranchList.forEach(zolMdcPerBranch -> {
            ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = zolPerDoorsGeneralInformationService
                    .findZolPerDoorsGeneralInformationByZpcItemCode(zolMdcPerBranch.getItemCode());
            zolMdcPerBranch.setValuesFromZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);

            ZolMdcAccount zolMdcAccount = zolMdcAccountService
                    .findZolMdcAccountByBranchName(zolMdcPerBranch.getCustomerName());
            zolMdcPerBranch.setValuesFromZolMdcAccount(zolMdcAccount);

            zolMdcPerBranch.setDate(localDate);
            zolMdcPerBranchService.createZolMdcPerBranch(zolMdcPerBranch);
        });
    }

    private void handleZolDailySalesPerBranchToZolMtPerBranch(List<ZolDailySalesPerBranch> zolDailySalesPerBranchList, LocalDate localDate) {
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

            zolMtPerBranch.setDate(localDate);
        });
    }


    private void initializeSuccessMessage(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMessage",
                "The uploaded files were successfully converted to master files. You can view them in the master files area.");
    }

}
