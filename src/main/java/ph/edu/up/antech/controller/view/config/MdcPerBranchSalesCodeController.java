package ph.edu.up.antech.controller.view.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesCode;
import ph.edu.up.antech.service.MdcPerBranchSalesCodeService;

import java.util.List;

@Controller
@RequestMapping("/master/mdc-branch/config/code")
public class MdcPerBranchSalesCodeController {

    private static final Logger LOGGER = Logger.getLogger(MdcPerBranchSalesCodeController.class);

    @Autowired
    private MdcPerBranchSalesCodeService mdcPerBranchSalesCodeService;

    @GetMapping("")
    public String loadMdcPerBranchSalesCodePage(Model model) {
        List<MdcPerBranchSalesCode> mdcPerBranchSalesCodeList =
                mdcPerBranchSalesCodeService.findAllMdcPerBranchSalesCode();
        model.addAttribute("mdcPerBranchSalesCodeList", mdcPerBranchSalesCodeList);
        return "mdc-branch-code";
    }

    @GetMapping("/view/{id}")
    public String viewMdcPerBranchSalesCode(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesCode mdcPerBranchSalesCode = mdcPerBranchSalesCodeService
                .findMdcPerBranchSalesCodeById(id);
        model.addAttribute("mdcPerBranchSalesCode", mdcPerBranchSalesCode);
        return "mdc-branch-code-view";
    }

    @GetMapping("/edit/{id}")
    public String editMdcPerBranchSalesCode(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesCode mdcPerBranchSalesCode = mdcPerBranchSalesCodeService
                .findMdcPerBranchSalesCodeById(id);
        model.addAttribute("mdcPerBranchSalesCode", mdcPerBranchSalesCode);
        return "mdc-branch-code-edit";
    }

    @PostMapping("/update")
    public String updateMdcPerBranchSalesCode(RedirectAttributes redirectAttributes,
                                              @ModelAttribute(value = "mdcPerBranchSalesCode")
                                                      MdcPerBranchSalesCode mdcPerBranchSalesCode) {
        try {
            mdcPerBranchSalesCodeService.updateMdcPerBranchSalesCode(mdcPerBranchSalesCode);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Code was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/code/view/" + mdcPerBranchSalesCode.getId();
    }

    @GetMapping("/add")
    public String addMdcPerBranchSalesCode(Model model) {
        MdcPerBranchSalesCode mdcPerBranchSalesCode = new MdcPerBranchSalesCode();
        model.addAttribute("mdcPerBranchSalesCode", mdcPerBranchSalesCode);
        return "mdc-branch-code-add";
    }

    @PostMapping("/create")
    public String createMdcPerBranchSalesCode(RedirectAttributes redirectAttributes,
                                              @ModelAttribute(value = "mdcPerBranchSalesCode")
                                                      MdcPerBranchSalesCode mdcPerBranchSalesCode) {
        try {
            mdcPerBranchSalesCode = mdcPerBranchSalesCodeService.saveMdcPerBranchSalesCoverage(mdcPerBranchSalesCode);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Code was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/code/view/" + mdcPerBranchSalesCode.getId();
    }

    @GetMapping("/delete/{id}")
    public String removeMdcPerBranchSalesCode(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            mdcPerBranchSalesCodeService.removeMdcPerBranchSalesCode(id);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Code was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/code";
    }

}
