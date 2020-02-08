package ph.edu.up.antech.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesCoverage;
import ph.edu.up.antech.service.MdcPerBranchSalesCoverageService;

import java.util.List;

@Controller
@RequestMapping("/config/mdc-branch-coverage")
public class MdcPerBranchSalesCoverageController {

    @Autowired
    private MdcPerBranchSalesCoverageService mdcPerBranchSalesCoverageService;

    @GetMapping("")
    public String loadMdcPerBranchSalesCoveragePage(Model model) {
        List<MdcPerBranchSalesCoverage> mdcPerBranchSalesCoverageList =
                mdcPerBranchSalesCoverageService.findAllMdcPerBranchSalesCoverage();
        model.addAttribute("mdcPerBranchSalesCoverageList", mdcPerBranchSalesCoverageList);
        return "mdc-branch-coverage";
    }

}
