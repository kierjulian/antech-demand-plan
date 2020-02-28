package ph.edu.up.antech.controller.view.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesInformation;
import ph.edu.up.antech.service.MdcPerBranchSalesInformationService;

import java.util.List;

@Controller
@RequestMapping("/master/mdc-branch/config/info")
public class MdcPerBranchSalesInformationController {

    private static final Logger LOGGER = Logger.getLogger(MdcPerBranchSalesInformationController.class);

    @Autowired
    private MdcPerBranchSalesInformationService mdcPerBranchSalesInformationService;

    @GetMapping("")
    public String loadMdcPerBranchSalesInformation(Model model) {
        List<MdcPerBranchSalesInformation> mdcPerBranchSalesInformationList =
                mdcPerBranchSalesInformationService.findAllMdcPerBranchSalesInformation();
        model.addAttribute("mdcPerBranchSalesInformationList", mdcPerBranchSalesInformationList);
        return "mdc-branch-info";
    }

    @GetMapping("/view/{id}")
    public String viewMdcPerBranchSalesInformation(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesInformation mdcPerBranchSalesInformation = mdcPerBranchSalesInformationService
                .findMdcPerBranchSalesInformation(id);
        model.addAttribute("mdcPerBranchSalesInformation", mdcPerBranchSalesInformation);
        return "mdc-branch-info-view";
    }

    @GetMapping("/edit/{id}")
    public String editMdcPerBranchSalesInformation(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesInformation mdcPerBranchSalesInformation = mdcPerBranchSalesInformationService
                .findMdcPerBranchSalesInformation(id);
        model.addAttribute("mdcPerBranchSalesInformation", mdcPerBranchSalesInformation);
        return "mdc-branch-info-edit";
    }

    @PostMapping("/update")
    public String updateMdcPerBranchSalesInformation(RedirectAttributes redirectAttributes,
                                                     @ModelAttribute(value = "mdcPerBranchSalesInformation")
                                                             MdcPerBranchSalesInformation mdcPerBranchSalesInformation) {
        try {
            mdcPerBranchSalesInformationService.updateMdcPerBranchSalesInformation(mdcPerBranchSalesInformation);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Information was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/info/view/" + mdcPerBranchSalesInformation.getId();
    }

    @GetMapping("/add")
    public String addMdcPerBranchSalesInformation(Model model) {
        MdcPerBranchSalesInformation mdcPerBranchSalesInformation = new MdcPerBranchSalesInformation();
        model.addAttribute("mdcPerBranchSalesInformation", mdcPerBranchSalesInformation);
        return "mdc-branch-info-add";
    }

    @PostMapping("/create")
    public String createMdcPerBranchSalesInformation(RedirectAttributes redirectAttributes,
                                                     @ModelAttribute(value = "mdcPerBranchSalesInformation")
                                                             MdcPerBranchSalesInformation mdcPerBranchSalesInformation) {
        try {
            mdcPerBranchSalesInformation = mdcPerBranchSalesInformationService.saveMdcPerBranchSalesInformation(mdcPerBranchSalesInformation);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Information was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/info/view/" + mdcPerBranchSalesInformation.getId();
    }

    @GetMapping("/delete/{id}")
    public String removeMdcPerBranchSalesInformation(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            mdcPerBranchSalesInformationService.removeMdcPerBranchSalesInformation(id);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Information was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/info";
    }

}
