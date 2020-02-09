package ph.edu.up.antech.controller.view.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesCode;
import ph.edu.up.antech.service.MdcPerBranchSalesCodeService;

import java.util.List;

@Controller
@RequestMapping("/config/mdc-branch-code")
public class MdcPerBranchSalesCodeController {

    @Autowired
    private MdcPerBranchSalesCodeService mdcPerBranchSalesCodeService;

    @GetMapping("")
    public String loadMdcPerBranchSalesCodePage(Model model) {
        List<MdcPerBranchSalesCode> mdcPerBranchSalesCodeList =
                mdcPerBranchSalesCodeService.findAllMdcPerBranchSalesCode();
        model.addAttribute("mdcPerBranchSalesCodeList", mdcPerBranchSalesCodeList);
        return "mdc-branch-code";
    }

}
