package ph.edu.up.antech.controller.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.up.antech.domain.sales.master.converter.ZolMdcAccount;
import ph.edu.up.antech.service.ZolMdcAccountService;

import java.util.List;

@Controller
@RequestMapping("/zol-mdc-accounts")
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

}
