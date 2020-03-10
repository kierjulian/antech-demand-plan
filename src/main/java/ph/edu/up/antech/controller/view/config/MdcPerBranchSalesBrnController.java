package ph.edu.up.antech.controller.view.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesBrn;
import ph.edu.up.antech.service.MdcPerBranchSalesBrnService;
import ph.edu.up.antech.util.StringUtils;

@Controller
@RequestMapping("/master/mdc-branch/config/brn")
public class MdcPerBranchSalesBrnController {

    private static final Logger LOGGER = Logger.getLogger(MdcPerBranchSalesBrnController.class);

    @Autowired
    private MdcPerBranchSalesBrnService mdcPerBranchSalesBrnService;

    @GetMapping("")
    public String loadMdcPerBranchBrnPage(Model model, @PageableDefault Pageable pageable,
                                          @RequestParam(required = false) String filter) {
        Page<MdcPerBranchSalesBrn> page = StringUtils.isNullOrEmpty(filter)
                ? mdcPerBranchSalesBrnService.findAll(pageable)
                : mdcPerBranchSalesBrnService.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
        return "master/config/mdc-branch-brn";
    }

    @GetMapping("/view/{id}")
    public String viewMdcPerBranchSalesBrn(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesBrn mdcPerBranchSalesBrn = mdcPerBranchSalesBrnService
                .findMdcPerBranchSalesBrnById(id);
        model.addAttribute("mdcPerBranchSalesBrn", mdcPerBranchSalesBrn);
        return "master/config/mdc-branch-brn-view";
    }

    @GetMapping("/edit/{id}")
    public String editMdcPerBranchSalesBrn(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesBrn mdcPerBranchSalesBrn = mdcPerBranchSalesBrnService
                .findMdcPerBranchSalesBrnById(id);
        model.addAttribute("mdcPerBranchSalesBrn", mdcPerBranchSalesBrn);
        return "master/config/mdc-branch-brn-edit";
    }

    @PostMapping("/update")
    public String updateMdcPerBranchSalesBrn(RedirectAttributes redirectAttributes,
                                             @ModelAttribute(value = "mdcPerBranchSalesBrn")
                                                     MdcPerBranchSalesBrn mdcPerBranchSalesBrn) {
        try {
            mdcPerBranchSalesBrnService.updateMdcPerBranchSalesBrn(mdcPerBranchSalesBrn);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales BRN was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/brn/view/" + "An error occurred: " + mdcPerBranchSalesBrn.getId();
    }

    @GetMapping("/add")
    public String addMdcPerBranchSalesBrn(Model model) {
        MdcPerBranchSalesBrn mdcPerBranchSalesBrn = new MdcPerBranchSalesBrn();
        model.addAttribute("mdcPerBranchSalesBrn", mdcPerBranchSalesBrn);
        return "master/config/mdc-branch-brn-add";
    }

    @PostMapping("/create")
    public String createMdcPerBranchSalesBrn(RedirectAttributes redirectAttributes,
                                             @ModelAttribute(value = "mdcPerBranchSalesBrn")
                                                     MdcPerBranchSalesBrn mdcPerBranchSalesBrn) {
        try {
            mdcPerBranchSalesBrn = mdcPerBranchSalesBrnService.saveMdcPerBranchSalesBrn(mdcPerBranchSalesBrn);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales BRN was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/brn/view/" + mdcPerBranchSalesBrn.getId();
    }

    @GetMapping("/delete/{id}")
    public String removeMdcPerBranchSalesBrn(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            mdcPerBranchSalesBrnService.removeMdcPerBranchSalesBrn(id);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales BRN was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/brn";
    }

}
