package ph.edu.up.antech.controller.view.master.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesCoverage;
import ph.edu.up.antech.service.MdcPerBranchSalesCoverageService;
import ph.edu.up.antech.util.StringUtils;

@Controller
@RequestMapping("/master/mdc-branch/config/coverage")
public class MdcPerBranchSalesCoverageController {

    private static final Logger LOGGER = Logger.getLogger(MdcPerBranchSalesCoverageController.class);

    @Autowired
    private MdcPerBranchSalesCoverageService mdcPerBranchSalesCoverageService;

    @GetMapping("")
    public String loadMdcPerBranchSalesCoveragePage(Model model, @PageableDefault Pageable pageable,
                                                    @RequestParam(required = false) String filter) {
        Page<MdcPerBranchSalesCoverage> page = StringUtils.isNullOrEmpty(filter)
                ? mdcPerBranchSalesCoverageService.findAll(pageable)
                : mdcPerBranchSalesCoverageService.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
        return "master/config/mdc-branch-coverage";
    }

    @GetMapping("/view/{id}")
    public String viewMdcPerBranchSalesCoverage(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage = mdcPerBranchSalesCoverageService
                .findMdcPerBranchSalesCoverageById(id);
        model.addAttribute("mdcPerBranchSalesCoverage", mdcPerBranchSalesCoverage);
        return "master/config/mdc-branch-coverage-view";
    }

    @GetMapping("/edit/{id}")
    public String editMdcPerBranchSalesCoverage(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage = mdcPerBranchSalesCoverageService
                .findMdcPerBranchSalesCoverageById(id);
        model.addAttribute("mdcPerBranchSalesCoverage", mdcPerBranchSalesCoverage);
        return "master/config/mdc-branch-coverage-edit";
    }

    @PostMapping("/update")
    public String updateMdcPerBranchSalesCoverage(RedirectAttributes redirectAttributes,
                                                  @ModelAttribute(value = "mdcPerBranchSalesCoverage")
                                                          MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage) {
        try {
            mdcPerBranchSalesCoverageService.updateMdcPerBranchSalesCoverage(mdcPerBranchSalesCoverage);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Coverage was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while updating MDC Per Branch Sales Coverage.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/mdc-branch/config/coverage/view/" + mdcPerBranchSalesCoverage.getId();
    }

    @GetMapping("/add")
    public String addMdcPerBranchSalesCoverage(Model model) {
        MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage = new MdcPerBranchSalesCoverage();
        model.addAttribute("mdcPerBranchSalesCoverage", mdcPerBranchSalesCoverage);
        return "master/config/mdc-branch-coverage-add";
    }

    @PostMapping("/create")
    public String createMdcPerBranchSalesCoverage(RedirectAttributes redirectAttributes,
                                                  @ModelAttribute(value = "mdcPerBranchSalesCoverage")
                                                          MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage) {
        try {
            mdcPerBranchSalesCoverage = mdcPerBranchSalesCoverageService.saveMdcPerBranchSalesCoverage(mdcPerBranchSalesCoverage);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Coverage was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while saving MDC Per Branch Sales Coverage.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/mdc-branch/config/coverage/view/" + mdcPerBranchSalesCoverage.getId();
    }

    @GetMapping("/delete/{id}")
    public String removeMdcPerBranchSalesCoverage(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            mdcPerBranchSalesCoverageService.removeMdcPerBranchSalesCoverage(id);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Coverage was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while deleting MDC Per Branch Sales Coverage");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/mdc-branch/config/coverage";
    }

}
