package ph.edu.up.antech.controller.view.master;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;
import ph.edu.up.antech.service.DispensingDistributorService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/master/dispensing-distributor")
public class DispensingDistributorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DispensingDistributorController.class);

    @Autowired
    private DispensingDistributorService dispensingDistributorService;

    @GetMapping("")
    public String loadDispensingDistributorMasterFile(Model model, @RequestParam(required = false) String startDate,
                                                      @RequestParam(required = false) String endDate) {
        LocalDate localStartDate = !StringUtils.isNullOrEmpty(startDate)
                ? LocalDate.parse(startDate) : LocalDate.now();
        LocalDate localEndDate = !StringUtils.isNullOrEmpty(endDate)
                ? LocalDate.parse(endDate) : LocalDate.now();
        List<DispensingDistributor> dispensingDistributorList =
                dispensingDistributorService.findDispensingDistributorBetweenTwoDates(localStartDate, localEndDate);

        model.addAttribute("searchedStartDate", localStartDate);
        model.addAttribute("searchedEndDate", localEndDate);
        model.addAttribute("dispensingDistributorList", dispensingDistributorList);
        return "dispensing-distributor";
    }

    @GetMapping("/view/{id}")
    public String viewDispensingDistributor(Model model, @PathVariable Integer id) {
        DispensingDistributor dispensingDistributor = dispensingDistributorService.findDispensingDistributorById(id);
        model.addAttribute("dispensingDistributor", dispensingDistributor);
        return "dispensing-distributor-view";
    }

    @GetMapping("/edit/{id}")
    public String editDispensingDistributor(Model model, @PathVariable Integer id) {
        DispensingDistributor dispensingDistributor = dispensingDistributorService.findDispensingDistributorById(id);
        model.addAttribute("dispensingDistributor", dispensingDistributor);
        return "dispensing-distributor-edit";
    }

    @PostMapping("/update")
    public String updateDispensingDistributor(RedirectAttributes redirectAttributes,
                                              @ModelAttribute(value = "dispensingDistributor") DispensingDistributor dispensingDistributor) {
        try {
            dispensingDistributorService.updateDispensingDistributor(dispensingDistributor);
            redirectAttributes.addFlashAttribute("successMessage", "Dispensing Distributor was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/dispensing-distributor/view/" + dispensingDistributor.getId();
    }

    @GetMapping("/add")
    public String addDispensingDistributor(Model model) {
        DispensingDistributor dispensingDistributor = new DispensingDistributor();
        model.addAttribute("dispensingDistributor", dispensingDistributor);
        return "dispensing-distributor-add";
    }

    @PostMapping("/create")
    public String createDispensingDistributor(RedirectAttributes redirectAttributes,
                                              @ModelAttribute(value = "dispensingDistributor") DispensingDistributor dispensingDistributor) {
        try {
            dispensingDistributor = dispensingDistributorService.createDispensingDistributor(dispensingDistributor);
            redirectAttributes.addFlashAttribute("successMessage", "Dispensing Distributor was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/dispensing-distributor/view/" + dispensingDistributor.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteDispensingDistributor(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            dispensingDistributorService.removeDispensingDistributor(id);
            redirectAttributes.addFlashAttribute("successMessage", "Dispensing Distributor was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/dispensing-distributor";
    }

}
