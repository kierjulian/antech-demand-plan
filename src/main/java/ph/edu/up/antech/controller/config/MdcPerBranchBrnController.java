package ph.edu.up.antech.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesBrn;
import ph.edu.up.antech.service.MdcPerBranchSalesBrnService;

import java.util.List;

@Controller
@RequestMapping("/config/mdc-branch-brn")
public class MdcPerBranchBrnController {

    @Autowired
    private MdcPerBranchSalesBrnService mdcPerBranchSalesBrnService;

    @GetMapping("")
    public String loadMdcPerBranchBrnPage(Model model) {
        List<MdcPerBranchSalesBrn> mdcPerBranchSalesBrnList = mdcPerBranchSalesBrnService.findAllMdcPerBranchSalesBrn();
        model.addAttribute("mdcPerBranchSalesBrnList", mdcPerBranchSalesBrnList);
        return "mdc-branch-brn";
    }

}
