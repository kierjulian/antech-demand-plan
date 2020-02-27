package ph.edu.up.antech.controller.view.master;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.MdcPerBranchSales;
import ph.edu.up.antech.service.MdcPerBranchSalesService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/master/mdc-branch")
public class MdcPerBranchSalesController {

    private static final Logger LOGGER = Logger.getLogger(MdcPerBranchSalesController.class);

    @Autowired
    private MdcPerBranchSalesService mdcPerBranchSalesService;

    @GetMapping("")
    public String loadMdcPerBranch(Model model, @RequestParam(required = false) String startDate,
                                   @RequestParam(required = false) String endDate) {
        LocalDate start = !StringUtils.isNullOrEmpty(startDate) ? LocalDate.parse(startDate) : LocalDate.now();
        LocalDate end = !StringUtils.isNullOrEmpty(endDate) ? LocalDate.parse(endDate) : LocalDate.now();
        List<MdcPerBranchSales> mdcPerBranchSalesList = mdcPerBranchSalesService
                .findMdcPerBranchSalesBetweenTwoDates(start, end);

        model.addAttribute("mdcPerBranchSalesList", mdcPerBranchSalesList);
        model.addAttribute("searchedStartDate", start);
        model.addAttribute("searchedEndDate", end);
        return "mdc-branch";
    }

    @GetMapping("/view/{id}")
    public String viewMdcPerBranchSales(Model model, @PathVariable Integer id) {
        MdcPerBranchSales mdcPerBranchSales = mdcPerBranchSalesService.findMdcPerBranchSalesById(id);
        model.addAttribute("mdcPerBranchSales", mdcPerBranchSales);
        return "mdc-branch-view";
    }

    @GetMapping("/edit/{id}")
    public String editMdcPerBranchSales(Model model, @PathVariable Integer id) {
        MdcPerBranchSales mdcPerBranchSales = mdcPerBranchSalesService.findMdcPerBranchSalesById(id);
        model.addAttribute("mdcPerBranchSales", mdcPerBranchSales);
        return "mdc-branch-edit";
    }

    @PostMapping("/update")
    public String updateMdcPerBranchSales(RedirectAttributes redirectAttributes,
                                          @ModelAttribute(value = "mdcPerBranchSales") MdcPerBranchSales mdcPerBranchSales) {
        try {
            mdcPerBranchSalesService.updateMdcPerBranchSales(mdcPerBranchSales);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/view/" + mdcPerBranchSales.getId();
    }

    @GetMapping("/add")
    public String addMdcPerBranchSales(Model model) {
        MdcPerBranchSales mdcPerBranchSales = new MdcPerBranchSales();
        model.addAttribute("mdcPerBranchSales", mdcPerBranchSales);
        return "mdc-branch-add";
    }

    @PostMapping("/create")
    public String createMdcPerBranchSales(RedirectAttributes redirectAttributes,
                                          @ModelAttribute(value = "mdcPerBranchSales") MdcPerBranchSales mdcPerBranchSales) {
        try {
            mdcPerBranchSales = mdcPerBranchSalesService.saveMdcPerBranchSales(mdcPerBranchSales);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/view/" + mdcPerBranchSales.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteMdcPerBranchSales(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            mdcPerBranchSalesService.removeMdcPerBranchSales(id);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch";
    }

}
