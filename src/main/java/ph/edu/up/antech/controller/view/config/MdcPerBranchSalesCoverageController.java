package ph.edu.up.antech.controller.view.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesCoverage;
import ph.edu.up.antech.service.MdcPerBranchSalesCoverageService;

import java.util.List;

@Controller
@RequestMapping("/config/mdc-branch-coverage")
public class MdcPerBranchSalesCoverageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MdcPerBranchSalesCoverageController.class);

    @Autowired
    private MdcPerBranchSalesCoverageService mdcPerBranchSalesCoverageService;

    @GetMapping("")
    public String loadMdcPerBranchSalesCoveragePage(Model model) {
        List<MdcPerBranchSalesCoverage> mdcPerBranchSalesCoverageList =
                mdcPerBranchSalesCoverageService.findAllMdcPerBranchSalesCoverage();
        model.addAttribute("mdcPerBranchSalesCoverageList", mdcPerBranchSalesCoverageList);
        return "mdc-branch-coverage";
    }

    @GetMapping("/view/{id}")
    public String viewMdcPerBranchSalesCoverage(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage = mdcPerBranchSalesCoverageService
                .findMdcPerBranchSalesCoverageById(id);
        model.addAttribute("mdcPerBranchSalesCoverage", mdcPerBranchSalesCoverage);
        return "mdc-branch-coverage-view";
    }

    @GetMapping("/edit/{id}")
    public String editMdcPerBranchSalesCoverage(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage = mdcPerBranchSalesCoverageService
                .findMdcPerBranchSalesCoverageById(id);
        model.addAttribute("mdcPerBranchSalesCoverage", mdcPerBranchSalesCoverage);
        return "mdc-branch-coverage-edit";
    }

    @PostMapping("/update")
    public String updateMdcPerBranchSalesCoverage(RedirectAttributes redirectAttributes,
                                                  @ModelAttribute(value = "mdcPerBranchSalesCoverage")
                                                          MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage) {
        try {
            mdcPerBranchSalesCoverageService.updateMdcPerBranchSalesCoverage(mdcPerBranchSalesCoverage);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Coverage was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/config/mdc-branch-coverage/view/" + mdcPerBranchSalesCoverage.getId();
    }

    @GetMapping("/add")
    public String addMdcPerBranchSalesCoverage(Model model) {
        MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage = new MdcPerBranchSalesCoverage();
        model.addAttribute("mdcPerBranchSalesCoverage", mdcPerBranchSalesCoverage);
        return "mdc-branch-coverage-add";
    }

    @PostMapping("/create")
    public String createMdcPerBranchSalesCoverage(RedirectAttributes redirectAttributes,
                                                  @ModelAttribute(value = "mdcPerBranchSalesCoverage")
                                                          MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage) {
        try {
            mdcPerBranchSalesCoverage = mdcPerBranchSalesCoverageService.saveMdcPerBranchSalesCoverage(mdcPerBranchSalesCoverage);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Coverage was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/config/mdc-branch-coverage/view/" + mdcPerBranchSalesCoverage.getId();
    }

    @GetMapping("/delete/{id}")
    public String removeMdcPerBranchSalesCoverage(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            mdcPerBranchSalesCoverageService.removeMdcPerBranchSalesCoverage(id);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Coverage was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/config/mdc-branch-coverage";
    }

}
