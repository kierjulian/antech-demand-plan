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
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;
import ph.edu.up.antech.service.ZolPerDoorsPerAcctService;
import ph.edu.up.antech.util.StringUtils;

@Controller
@RequestMapping("/master/zol-doors/config/accounts")
public class ZolPerDoorsPerAcctController {

    private static final Logger LOGGER = Logger.getLogger(ZolPerDoorsPerAcctController.class);

    @Autowired
    private ZolPerDoorsPerAcctService zolPerDoorsPerAcctService;

    @GetMapping("")
    public String loadZolPerDoorsPerAcct(Model model, @PageableDefault Pageable pageable,
                                         @RequestParam(required = false) String filter) {
        Page<ZolPerDoorsPerAcct> page = StringUtils.isNullOrEmpty(filter)
                ? zolPerDoorsPerAcctService.findAll(pageable)
                : zolPerDoorsPerAcctService.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
        return "master/config/zol-per-doors-account";
    }

    @GetMapping("/view/{id}")
    public String viewZolPerDoorsPerAcct(Model model, @PathVariable Integer id) {
        ZolPerDoorsPerAcct zolPerDoorsPerAcct = zolPerDoorsPerAcctService
                .findZolPerDoorsPerAcctById(id);
        model.addAttribute("zolPerDoorsPerAcct", zolPerDoorsPerAcct);
        return "master/config/zol-per-doors-account-view";
    }

    @GetMapping("/edit/{id}")
    public String editZolPerDoorsPerAcct(Model model, @PathVariable Integer id) {
        ZolPerDoorsPerAcct zolPerDoorsPerAcct = zolPerDoorsPerAcctService
                .findZolPerDoorsPerAcctById(id);
        model.addAttribute("zolPerDoorsPerAcct", zolPerDoorsPerAcct);
        return "master/config/zol-per-doors-account-edit";
    }

    @PostMapping("/update")
    public String updateZolPerDoorsPerAcct(RedirectAttributes redirectAttributes,
                                           @ModelAttribute(value = "zolPerDoorsPerAcct")
                                                   ZolPerDoorsPerAcct zolPerDoorsPerAcct) {
        try {
            zolPerDoorsPerAcctService.updateZolPerDoorsPerAcct(zolPerDoorsPerAcct);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL Per Doors Per Acct was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-doors/config/accounts/view/" + zolPerDoorsPerAcct.getAccountId();
    }

    @GetMapping("/add")
    public String addZolPerDoorsPerAcct(Model model) {
        ZolPerDoorsPerAcct zolPerDoorsPerAcct = new ZolPerDoorsPerAcct();
        model.addAttribute("zolPerDoorsPerAcct", zolPerDoorsPerAcct);
        return "master/config/zol-per-doors-account-add";
    }

    @PostMapping("/create")
    public String createZolPerDoorsPerAcct(RedirectAttributes redirectAttributes,
                                           @ModelAttribute(value = "zolPerDoorsPerAcct")
                                                   ZolPerDoorsPerAcct zolPerDoorsPerAcct) {
        try {
            zolPerDoorsPerAcct = zolPerDoorsPerAcctService.saveZolPerDoorsPerAcct(zolPerDoorsPerAcct);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL Per Doors Per Acct was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-doors/config/accounts/view/" + zolPerDoorsPerAcct.getAccountId();
    }

    @GetMapping("/delete/{id}")
    public String removeZolPerDoorsPerAcct(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            zolPerDoorsPerAcctService.removeZolPerDoorsPerAcct(id);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL Per Doors Per Acct was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-doors/config/accounts";
    }

}
