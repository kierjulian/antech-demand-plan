package ph.edu.up.antech.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesAccount;
import ph.edu.up.antech.service.MdcPerBranchSalesAccountService;

import java.util.List;

@Controller
@RequestMapping("/mdc-branch-accounts")
public class MdcPerBranchSalesAccountController {

    @Autowired
    private MdcPerBranchSalesAccountService mdcPerBranchSalesAccountService;

    @GetMapping("")
    public String loadZolMtAccountPage(Model model) {
        List<MdcPerBranchSalesAccount> mdcPerBranchSalesAccountList = mdcPerBranchSalesAccountService.findAllMdcPerBranchSalesAccount();
        model.addAttribute("mdcPerBranchSalesAccountList", mdcPerBranchSalesAccountList);
        return "mdc-branch-account";
    }

}
