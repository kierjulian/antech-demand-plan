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
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesCode;
import ph.edu.up.antech.service.MdcPerBranchSalesCodeService;
import ph.edu.up.antech.util.StringUtils;

@Controller
@RequestMapping("/master/mdc-branch/config/code")
public class MdcPerBranchSalesCodeController {

    private static final Logger LOGGER = Logger.getLogger(MdcPerBranchSalesCodeController.class);

    @Autowired
    private MdcPerBranchSalesCodeService mdcPerBranchSalesCodeService;

    @GetMapping("")
    public String loadMdcPerBranchSalesCodePage(Model model, @PageableDefault Pageable pageable,
                                                @RequestParam(required = false) String filter) {
        Page<MdcPerBranchSalesCode> page = StringUtils.isNullOrEmpty(filter)
                ? mdcPerBranchSalesCodeService.findAll(pageable)
                : mdcPerBranchSalesCodeService.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
        return "master/config/mdc-branch-code";
    }

    @GetMapping("/view/{id}")
    public String viewMdcPerBranchSalesCode(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesCode mdcPerBranchSalesCode = mdcPerBranchSalesCodeService
                .findMdcPerBranchSalesCodeById(id);
        model.addAttribute("mdcPerBranchSalesCode", mdcPerBranchSalesCode);
        return "master/config/mdc-branch-code-view";
    }

    @GetMapping("/edit/{id}")
    public String editMdcPerBranchSalesCode(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesCode mdcPerBranchSalesCode = mdcPerBranchSalesCodeService
                .findMdcPerBranchSalesCodeById(id);
        model.addAttribute("mdcPerBranchSalesCode", mdcPerBranchSalesCode);
        return "master/config/mdc-branch-code-edit";
    }

    @PostMapping("/update")
    public String updateMdcPerBranchSalesCode(RedirectAttributes redirectAttributes,
                                              @ModelAttribute(value = "mdcPerBranchSalesCode")
                                                      MdcPerBranchSalesCode mdcPerBranchSalesCode) {
        try {
            mdcPerBranchSalesCodeService.updateMdcPerBranchSalesCode(mdcPerBranchSalesCode);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Code was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while updating MDC Per Branch Sales Code.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/mdc-branch/config/code/view/" + mdcPerBranchSalesCode.getId();
    }

    @GetMapping("/add")
    public String addMdcPerBranchSalesCode(Model model) {
        MdcPerBranchSalesCode mdcPerBranchSalesCode = new MdcPerBranchSalesCode();
        model.addAttribute("mdcPerBranchSalesCode", mdcPerBranchSalesCode);
        return "master/config/mdc-branch-code-add";
    }

    @PostMapping("/create")
    public String createMdcPerBranchSalesCode(RedirectAttributes redirectAttributes,
                                              @ModelAttribute(value = "mdcPerBranchSalesCode")
                                                      MdcPerBranchSalesCode mdcPerBranchSalesCode) {
        try {
            mdcPerBranchSalesCode = mdcPerBranchSalesCodeService.saveMdcPerBranchSalesCoverage(mdcPerBranchSalesCode);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Code was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while saving MDC Per Branch Sales Code.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/mdc-branch/config/code/view/" + mdcPerBranchSalesCode.getId();
    }

    @DeleteMapping("/delete/{id}")
    public String removeMdcPerBranchSalesCode(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            mdcPerBranchSalesCodeService.removeMdcPerBranchSalesCode(id);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Code was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while deleting MDC Per Branch Sales Code.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/mdc-branch/config/code";
    }

}
