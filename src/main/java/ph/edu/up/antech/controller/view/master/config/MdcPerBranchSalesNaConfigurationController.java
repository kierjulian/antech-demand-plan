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
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesNaConfiguration;
import ph.edu.up.antech.service.MdcPerBranchSalesNaConfigurationService;
import ph.edu.up.antech.util.StringUtils;

@Controller
@RequestMapping("/master/mdc-branch/config/na")
public class MdcPerBranchSalesNaConfigurationController {

    private static final Logger LOGGER = Logger.getLogger(MdcPerBranchSalesNaConfigurationController.class);

    @Autowired
    private MdcPerBranchSalesNaConfigurationService mdcPerBranchSalesNaConfigurationService;

    @GetMapping("")
    public String loadMdcPerBranchSalesNaConfigurationPage(Model model, @PageableDefault Pageable pageable,
                                                           @RequestParam(required = false) String filter) {
        Page<MdcPerBranchSalesNaConfiguration> page = StringUtils.isNullOrEmpty(filter)
                ? mdcPerBranchSalesNaConfigurationService.findAll(pageable)
                : mdcPerBranchSalesNaConfigurationService.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
        return "master/config/mdc-branch-na-configuration";
    }

    @GetMapping("/view/{id}")
    public String viewMdcPerBranchSalesNaConfiguration(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration = mdcPerBranchSalesNaConfigurationService
                .findMdcPerBranchSalesNaConfigurationById(id);
        model.addAttribute("mdcPerBranchSalesNaConfiguration", mdcPerBranchSalesNaConfiguration);
        return "master/config/mdc-branch-na-configuration-view";
    }

    @GetMapping("/edit/{id}")
    public String editMdcPerBranchSalesNaConfiguration(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration = mdcPerBranchSalesNaConfigurationService
                .findMdcPerBranchSalesNaConfigurationById(id);
        model.addAttribute("mdcPerBranchSalesNaConfiguration", mdcPerBranchSalesNaConfiguration);
        return "master/config/mdc-branch-na-configuration-edit";
    }

    @PostMapping("/update")
    public String updateMdcPerBranchSalesNaConfiguration(RedirectAttributes redirectAttributes,
                                                         @ModelAttribute(value = "mdcPerBranchSalesNaConfiguration")
                                                                 MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration) {
        try {
            mdcPerBranchSalesNaConfigurationService.updateMdcPerBranchSalesNaConfiguration(mdcPerBranchSalesNaConfiguration);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales NA Configuration was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while updating MDC Per Branch Sales NA Configuration.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/mdc-branch/config/na/view/" + mdcPerBranchSalesNaConfiguration.getId();
    }

    @GetMapping("/add")
    public String addMdcPerBranchSalesNaConfiguration(Model model) {
        MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration = new MdcPerBranchSalesNaConfiguration();
        model.addAttribute("mdcPerBranchSalesNaConfiguration", mdcPerBranchSalesNaConfiguration);
        return "master/config/mdc-branch-na-configuration-add";
    }

    @PostMapping("/create")
    public String createMdcPerBranchSalesNaConfiguration(RedirectAttributes redirectAttributes,
                                                         @ModelAttribute(value = "mdcPerBranchSalesNaConfiguration")
                                                                 MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration) {
        try {
            mdcPerBranchSalesNaConfiguration = mdcPerBranchSalesNaConfigurationService.saveMdcPerBranchSalesNaConfiguration(mdcPerBranchSalesNaConfiguration);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales NA Configuration was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while saving MDC Per Branch Sales NA Configuration.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/mdc-branch/config/na/view/" + mdcPerBranchSalesNaConfiguration.getId();
    }

    @GetMapping("/delete/{id}")
    public String removeMdcPerBranchSalesNaConfiguration(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            mdcPerBranchSalesNaConfigurationService.removeMdcPerBranchSalesNaConfiguration(id);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales NA Configuration was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while deleting MDC Per Branch Sales NA Configuration.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/mdc-branch/config/na";
    }

}
