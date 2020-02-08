package ph.edu.up.antech.controller.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;
import ph.edu.up.antech.service.ZolMtAccountService;

import java.util.List;

@Controller
@RequestMapping("/config/zol-mt-accounts")
public class ZolMtAccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZolMtAccountController.class);

    @Autowired
    private ZolMtAccountService zolMtAccountService;

    @GetMapping("")
    public String loadZolMtAccountPage(Model model) {
        List<ZolMtAccount> zolMtAccountList = zolMtAccountService.findAllZolMtAccount();
        model.addAttribute("zolMtAccountList", zolMtAccountList);
        return "zol-mt-account";
    }

}
