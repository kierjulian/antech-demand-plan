package ph.edu.up.antech.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.Customer;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;
import ph.edu.up.antech.domain.sales.raw.CustomerItemSalesPerPeriod;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;
import ph.edu.up.antech.service.*;
import ph.edu.up.antech.util.CsvToObjectConverter;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/reports")
public class StatusReportController {

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

    @GetMapping("")
    public String loadStatusReportHomePage() {
        return "status-report";
    }

    @PostMapping("/upload")
    public String addCsvFiles(RedirectAttributes redirectAttributes,
                              @RequestParam("customerItemSalesPerPeriodFile") MultipartFile customerItemSalesPerPeriodFile,
                              @RequestParam("dispensingDistributorFile") MultipartFile dispensingDistributorFile,
                              @RequestParam("date") String date) {
        try {
            List<CustomerItemSalesPerPeriod> customerItemSalesPerPeriodList = CsvToObjectConverter
                    .convertCsvToListOfCustomerItemSalesPerPeriod(customerItemSalesPerPeriodFile.getInputStream());
            List<DispensingDistributor> dispensingDistributorList = CsvToObjectConverter
                    .convertCsvToListOfDispensingDistributor(dispensingDistributorFile.getInputStream());
            LocalDate localDate = LocalDate.parse(date);

            handleZolPerDoors(customerItemSalesPerPeriodList, localDate);
            handleDispensingDistributor(dispensingDistributorList, localDate);

            initializeSuccessMessage(redirectAttributes);
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }

        return "redirect:/reports";
    }

    private void handleZolPerDoors(List<CustomerItemSalesPerPeriod> customerItemSalesPerPeriodList, LocalDate localDate) {
        removeZolPerDoorsByDate(localDate);
        createZolPerDoorsBasedOnCustomerItemSalesPerPeriodCsvFile(customerItemSalesPerPeriodList, localDate);
    }

    private void removeZolPerDoorsByDate(LocalDate localDate) {
        List<ZolPerDoors> zolPerDoorsList = zolPerDoorsService.findByDate(localDate);
        if (zolPerDoorsList != null) {
            for (ZolPerDoors zolPerDoors : zolPerDoorsList) {
                zolPerDoorsService.remove(zolPerDoors.getId());
            }
        }
    }

    private void createZolPerDoorsBasedOnCustomerItemSalesPerPeriodCsvFile(
            List<CustomerItemSalesPerPeriod> customerItemSalesPerPeriodList, LocalDate date) {
        for (CustomerItemSalesPerPeriod customerItemSalesPerPeriod : customerItemSalesPerPeriodList) {
            customerItemSalesPerPeriod.convertAllStringValuesToProperType();

            Customer customer = customerService.findCustomerByCustomerCode(customerItemSalesPerPeriod.getCustomerCode());
            customerItemSalesPerPeriod.updateValuesBasedOnCustomer(customer);

            String materialCode = customerService.findZolMaterialCodeByMaterialCode(customerItemSalesPerPeriod.getMaterialCode());
            customerItemSalesPerPeriod.setMaterialCode(materialCode);

            ZolPerDoors zolPerDoors = new ZolPerDoors(customerItemSalesPerPeriod);
            zolPerDoors.setDate(date);

            ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = zolPerDoorsGeneralInformationService
                    .findByZpcItemCode(zolPerDoors.getItemCode());
            zolPerDoors.generateValuesBasedOnZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);

            ZolPerDoorsPerAcct zolPerDoorsPerAcct = zolPerDoorsPerAcctService.findByZol(zolPerDoors.getCustomerCode());
            zolPerDoors.generateValuesBasedOnZolPerDoorsPerAcct(zolPerDoorsPerAcct);

            zolPerDoorsService.create(zolPerDoors);
        }
    }

    private void handleDispensingDistributor(List<DispensingDistributor> dispensingDistributorList,
                                             LocalDate localDate) {
        removeDispensingDistributorByDate(localDate);
        createDispensingDistributorBasedOnCsvFile(dispensingDistributorList, localDate);
    }

    private void removeDispensingDistributorByDate(LocalDate date) {
        List<DispensingDistributor> dispensingDistributorList = dispensingDistributorService.findByDate(date);
        if (dispensingDistributorList != null) {
            for (DispensingDistributor dispensingDistributor : dispensingDistributorList) {
                dispensingDistributorService.remove(dispensingDistributor.getId());
            }
        }
    }

    private void createDispensingDistributorBasedOnCsvFile(List<DispensingDistributor> dispensingDistributorList,
                                                           LocalDate localDate) {
        for (DispensingDistributor dispensingDistributor : dispensingDistributorList) {
            dispensingDistributor.convertAllStringTypeToProperType();
            dispensingDistributor.setDate(localDate);
            dispensingDistributorService.create(dispensingDistributor);
        }
    }

    private void initializeSuccessMessage(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMessage",
                "The uploaded files were successfully converted to master files. You can view them in the master files area.");
    }

}
