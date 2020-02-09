package ph.edu.up.antech.controller.view.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.converter.ZolMdcAccount;
import ph.edu.up.antech.service.ZolMdcAccountService;

import java.util.List;

@Controller
@RequestMapping("/config/zol-mdc-accounts")
public class ZolMdcAccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZolMdcAccountController.class);

    @Autowired
    private ZolMdcAccountService zolMdcAccountService;

    @GetMapping("")
    public String loadZolMdcAccountPage(Model model) {
        List<ZolMdcAccount> zolMdcAccountList = zolMdcAccountService.findAllZolMdcAccount();
        model.addAttribute("zolMdcAccountList", zolMdcAccountList);
        return "zol-mdc-account";
    }

    @GetMapping("/view/{id}")
    public String viewZolMdcAccount(Model model, @PathVariable Integer id) {
        ZolMdcAccount zolMdcAccount = zolMdcAccountService.findZolMdcAccountById(id);
        model.addAttribute("zolMdcAccount", zolMdcAccount);
        return "zol-mdc-account-view";
    }

    @GetMapping("/edit/{id}")
    public String editZolMdcAccount(Model model, @PathVariable Integer id) {
        ZolMdcAccount zolMdcAccount = zolMdcAccountService.findZolMdcAccountById(id);
        model.addAttribute("zolMdcAccount", zolMdcAccount);
        return "zol-mdc-account-edit";
    }

    @PostMapping("/update")
    public String updateZolMdcAccount(RedirectAttributes redirectAttributes,
                                      @ModelAttribute(value = "zolMdcAccount") ZolMdcAccount zolMdcAccount) {
        try {
            zolMdcAccountService.updateZolMdcAccount(zolMdcAccount);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MDC Account was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/config/zol-mdc-accounts/view/" + zolMdcAccount.getId();
    }

    @GetMapping("/add")
    public String addZolMdcAccount(Model model) {
        ZolMdcAccount zolMdcAccount = new ZolMdcAccount();
        model.addAttribute("zolMdcAccount", zolMdcAccount);
        return "zol-mdc-account-add";
    }

    @PostMapping("/create")
    public String createZolMdcAccount(RedirectAttributes redirectAttributes,
                                      @ModelAttribute(value = "zolMdcAccount") ZolMdcAccount zolMdcAccount) {
        try {
            zolMdcAccount = zolMdcAccountService.createZolMdcAccount(zolMdcAccount);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MDC Account was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/config/zol-mdc-accounts/view/" + zolMdcAccount.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteZolMdcAccount(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            zolMdcAccountService.removeZolMdcAccount(id);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MDC Account was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/config/zol-mdc-accounts";
    }

}
