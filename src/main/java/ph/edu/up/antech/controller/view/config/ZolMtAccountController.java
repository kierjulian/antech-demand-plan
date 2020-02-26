package ph.edu.up.antech.controller.view.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;
import ph.edu.up.antech.service.ZolMtAccountService;

import java.util.List;

@Controller
@RequestMapping("/master/zol-mt/config/accounts")
public class ZolMtAccountController {

    private static final Logger LOGGER = Logger.getLogger(ZolMtAccountController.class);

    @Autowired
    private ZolMtAccountService zolMtAccountService;

    @GetMapping("")
    public String loadZolMtAccountPage(Model model) {
        List<ZolMtAccount> zolMtAccountList = zolMtAccountService.findAllZolMtAccount();
        model.addAttribute("zolMtAccountList", zolMtAccountList);
        return "zol-mt-account";
    }

    @GetMapping("/view/{id}")
    public String viewZolMtAccount(Model model, @PathVariable Integer id) {
        ZolMtAccount zolMtAccount = zolMtAccountService.findZolMtAccountById(id);
        model.addAttribute("zolMtAccount", zolMtAccount);
        return "zol-mt-account-view";
    }

    @GetMapping("/edit/{id}")
    public String editZolMtAccount(Model model, @PathVariable Integer id) {
        ZolMtAccount zolMtAccount = zolMtAccountService.findZolMtAccountById(id);
        model.addAttribute("zolMtAccount", zolMtAccount);
        return "zol-mt-account-edit";
    }

    @PostMapping("/update")
    public String updateZolMdcAccount(RedirectAttributes redirectAttributes,
                                      @ModelAttribute(value = "zolMtAccount") ZolMtAccount zolMtAccount) {
        try {
            zolMtAccountService.updateZolMtAccount(zolMtAccount);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MT Account was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/zol-mt/config/accounts/view/" + zolMtAccount.getId();
    }

    @GetMapping("/add")
    public String addZolMtAccount(Model model) {
        ZolMtAccount zolMtAccount = new ZolMtAccount();
        model.addAttribute("zolMtAccount", zolMtAccount);
        return "zol-mt-account-add";
    }

    @PostMapping("/create")
    public String createZolMdcAccount(RedirectAttributes redirectAttributes,
                                      @ModelAttribute(value = "zolMtAccount") ZolMtAccount zolMtAccount) {
        try {
            zolMtAccount = zolMtAccountService.createZolMtAccount(zolMtAccount);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MT Account was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/zol-mt/config/accounts/view/" + zolMtAccount.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteZolMdcAccount(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            zolMtAccountService.removeZolMtAccount(id);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MT Account was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/zol-mt/config/accounts";
    }

}
