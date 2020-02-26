package ph.edu.up.antech.controller.view.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesNaConfiguration;
import ph.edu.up.antech.service.MdcPerBranchSalesNaConfigurationService;

import java.util.List;

@Controller
@RequestMapping("/master/mdc-branch/config/na")
public class MdcPerBranchSalesNaConfigurationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MdcPerBranchSalesNaConfigurationController.class);

    @Autowired
    private MdcPerBranchSalesNaConfigurationService mdcPerBranchSalesNaConfigurationService;

    @GetMapping("")
    public String loadMdcPerBranchSalesNaConfigurationPage(Model model) {
        List<MdcPerBranchSalesNaConfiguration> mdcPerBranchSalesNaConfigurationList =
                mdcPerBranchSalesNaConfigurationService.findAllMdcPerBranchSalesNaConfiguration();
        model.addAttribute("mdcPerBranchSalesNaConfigurationList", mdcPerBranchSalesNaConfigurationList);
        return "mdc-branch-na-configuration";
    }

    @GetMapping("/view/{id}")
    public String viewMdcPerBranchSalesNaConfiguration(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration = mdcPerBranchSalesNaConfigurationService
                .findMdcPerBranchSalesNaConfigurationById(id);
        model.addAttribute("mdcPerBranchSalesNaConfiguration", mdcPerBranchSalesNaConfiguration);
        return "mdc-branch-na-configuration-view";
    }

    @GetMapping("/edit/{id}")
    public String editMdcPerBranchSalesNaConfiguration(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration = mdcPerBranchSalesNaConfigurationService
                .findMdcPerBranchSalesNaConfigurationById(id);
        model.addAttribute("mdcPerBranchSalesNaConfiguration", mdcPerBranchSalesNaConfiguration);
        return "mdc-branch-na-configuration-edit";
    }

    @PostMapping("/update")
    public String updateMdcPerBranchSalesNaConfiguration(RedirectAttributes redirectAttributes,
                                                         @ModelAttribute(value = "mdcPerBranchSalesNaConfiguration")
                                                                 MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration) {
        try {
            mdcPerBranchSalesNaConfigurationService.updateMdcPerBranchSalesNaConfiguration(mdcPerBranchSalesNaConfiguration);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales NA Configuration was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/na/view/" + mdcPerBranchSalesNaConfiguration.getId();
    }

    @GetMapping("/add")
    public String addMdcPerBranchSalesNaConfiguration(Model model) {
        MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration = new MdcPerBranchSalesNaConfiguration();
        model.addAttribute("mdcPerBranchSalesNaConfiguration", mdcPerBranchSalesNaConfiguration);
        return "mdc-branch-na-configuration-add";
    }

    @PostMapping("/create")
    public String createMdcPerBranchSalesNaConfiguration(RedirectAttributes redirectAttributes,
                                                         @ModelAttribute(value = "mdcPerBranchSalesNaConfiguration")
                                                                 MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration) {
        try {
            mdcPerBranchSalesNaConfiguration = mdcPerBranchSalesNaConfigurationService.saveMdcPerBranchSalesNaConfiguration(mdcPerBranchSalesNaConfiguration);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales NA Configuration was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
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
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/na";
    }

}
