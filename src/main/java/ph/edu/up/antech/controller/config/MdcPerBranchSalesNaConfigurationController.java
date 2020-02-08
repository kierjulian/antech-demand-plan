package ph.edu.up.antech.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesNaConfiguration;
import ph.edu.up.antech.service.MdcPerBranchSalesNaConfigurationService;

import java.util.List;

@Controller
@RequestMapping("/config/mdc-branch-na")
public class MdcPerBranchSalesNaConfigurationController {

    @Autowired
    private MdcPerBranchSalesNaConfigurationService mdcPerBranchSalesNaConfigurationService;

    @GetMapping("")
    public String loadMdcPerBranchSalesNaConfigurationPage(Model model) {
        List<MdcPerBranchSalesNaConfiguration> mdcPerBranchSalesNaConfigurationList =
                mdcPerBranchSalesNaConfigurationService.findAllMdcPerBranchSalesNaConfiguration();
        model.addAttribute("mdcPerBranchSalesNaConfigurationList", mdcPerBranchSalesNaConfigurationList);
        return "mdc-branch-na-configuration";
    }

}
