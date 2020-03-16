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
import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;
import ph.edu.up.antech.service.ZolMtAccountService;
import ph.edu.up.antech.util.StringUtils;

@Controller
@RequestMapping("/master/zol-mt/config/accounts")
public class ZolMtAccountController {

    private static final Logger LOGGER = Logger.getLogger(ZolMtAccountController.class);

    @Autowired
    private ZolMtAccountService zolMtAccountService;

    @GetMapping("")
    public String loadZolMtAccountPage(Model model, @PageableDefault Pageable pageable,
                                       @RequestParam(required = false) String filter) {
        Page<ZolMtAccount> page = StringUtils.isNullOrEmpty(filter)
                ? zolMtAccountService.findAll(pageable)
                : zolMtAccountService.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
        return "master/config/zol-mt-account";
    }

    @GetMapping("/view/{id}")
    public String viewZolMtAccount(Model model, @PathVariable Integer id) {
        ZolMtAccount zolMtAccount = zolMtAccountService.findZolMtAccountById(id);
        model.addAttribute("zolMtAccount", zolMtAccount);
        return "master/config/zol-mt-account-view";
    }

    @GetMapping("/edit/{id}")
    public String editZolMtAccount(Model model, @PathVariable Integer id) {
        ZolMtAccount zolMtAccount = zolMtAccountService.findZolMtAccountById(id);
        model.addAttribute("zolMtAccount", zolMtAccount);
        return "master/config/zol-mt-account-edit";
    }

    @PostMapping("/update")
    public String updateZolMdcAccount(RedirectAttributes redirectAttributes,
                                      @ModelAttribute(value = "zolMtAccount") ZolMtAccount zolMtAccount) {
        try {
            zolMtAccountService.updateZolMtAccount(zolMtAccount);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MT Account was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while updating ZOL MT Account.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-mt/config/accounts/view/" + zolMtAccount.getId();
    }

    @GetMapping("/add")
    public String addZolMtAccount(Model model) {
        ZolMtAccount zolMtAccount = new ZolMtAccount();
        model.addAttribute("zolMtAccount", zolMtAccount);
        return "master/config/zol-mt-account-add";
    }

    @PostMapping("/create")
    public String createZolMdcAccount(RedirectAttributes redirectAttributes,
                                      @ModelAttribute(value = "zolMtAccount") ZolMtAccount zolMtAccount) {
        try {
            zolMtAccount = zolMtAccountService.saveZolMtAccount(zolMtAccount);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MT Account was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while saving ZOL MT Account.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-mt/config/accounts/view/" + zolMtAccount.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteZolMdcAccount(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            zolMtAccountService.removeZolMtAccount(id);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MT Account was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while deleting ZOL MT Account.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-mt/config/accounts";
    }

}
