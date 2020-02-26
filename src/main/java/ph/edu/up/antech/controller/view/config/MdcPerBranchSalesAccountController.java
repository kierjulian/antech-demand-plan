package ph.edu.up.antech.controller.view.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesAccount;
import ph.edu.up.antech.service.MdcPerBranchSalesAccountService;

import java.util.List;

@Controller
@RequestMapping("/master/mdc-branch/config/accounts")
public class MdcPerBranchSalesAccountController {

    private static final Logger LOGGER = Logger.getLogger(MdcPerBranchSalesAccountController.class);

    @Autowired
    private MdcPerBranchSalesAccountService mdcPerBranchSalesAccountService;

    @GetMapping("")
    public String loadMdcPerBranchSalesAccountPage(Model model) {
        List<MdcPerBranchSalesAccount> mdcPerBranchSalesAccountList = mdcPerBranchSalesAccountService.findAllMdcPerBranchSalesAccount();
        model.addAttribute("mdcPerBranchSalesAccountList", mdcPerBranchSalesAccountList);
        return "mdc-branch-account";
    }

    @GetMapping("/view/{id}")
    public String viewMdcPerBranchSalesAccount(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesAccount mdcPerBranchSalesAccount = mdcPerBranchSalesAccountService
                .findMdcPerBranchSalesAccount(id);
        model.addAttribute("mdcPerBranchSalesAccount", mdcPerBranchSalesAccount);
        return "mdc-branch-account-view";
    }

    @GetMapping("/edit/{id}")
    public String editMdcPerBranchSalesAccount(Model model, @PathVariable Integer id) {
        MdcPerBranchSalesAccount mdcPerBranchSalesAccount = mdcPerBranchSalesAccountService
                .findMdcPerBranchSalesAccount(id);
        model.addAttribute("mdcPerBranchSalesAccount", mdcPerBranchSalesAccount);
        return "mdc-branch-account-edit";
    }

    @PostMapping("/update")
    public String updateMdcPerBranchSalesAccount(RedirectAttributes redirectAttributes,
                                                 @ModelAttribute(value = "mdcPerBranchSalesAccount")
                                                         MdcPerBranchSalesAccount mdcPerBranchSalesAccount) {
        try {
            mdcPerBranchSalesAccountService.updateMdcPerBranchSalesAccount(mdcPerBranchSalesAccount);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Account was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/accounts/view/" + mdcPerBranchSalesAccount.getId();
    }

    @GetMapping("/add")
    public String addMdcPerBranchSalesAccount(Model model) {
        MdcPerBranchSalesAccount mdcPerBranchSalesAccount = new MdcPerBranchSalesAccount();
        model.addAttribute("mdcPerBranchSalesAccount", mdcPerBranchSalesAccount);
        return "mdc-branch-account-add";
    }

    @PostMapping("/create")
    public String createMdcPerBranchSalesAccount(RedirectAttributes redirectAttributes,
                                                 @ModelAttribute(value = "mdcPerBranchSalesAccount")
                                                         MdcPerBranchSalesAccount mdcPerBranchSalesAccount) {
        try {
            mdcPerBranchSalesAccount = mdcPerBranchSalesAccountService.saveMdcPerBranchSalesAccount(mdcPerBranchSalesAccount);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Account was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/accounts/view/" + mdcPerBranchSalesAccount.getId();
    }

    @GetMapping("/delete/{id}")
    public String removeMdcPerBranchSalesAccount(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            mdcPerBranchSalesAccountService.removeMdcPerBranchSalesAccount(id);
            redirectAttributes.addFlashAttribute("successMessage", "MDC Per Branch Sales Account was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/mdc-branch/config/accounts";
    }

}
