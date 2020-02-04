package ph.edu.up.antech.controller.view.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.sales.master.MdcPerBranchSales;
import ph.edu.up.antech.service.MdcPerBranchSalesService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MdcPerBranchSalesController {

    @Autowired
    private MdcPerBranchSalesService mdcPerBranchSalesService;

    @GetMapping("/master/mdc-branch")
    public String loadMdcPerBranch(Model model, @RequestParam(required = false) String date) {
        LocalDate localDate = !StringUtils.isNullOrEmpty(date) ? LocalDate.parse(date) : LocalDate.now();
        List<MdcPerBranchSales> mdcPerBranchSalesList = mdcPerBranchSalesService.findMdcPerBranchSalesByDate(localDate);

        model.addAttribute("mdcPerBranchSalesList", mdcPerBranchSalesList);
        model.addAttribute("searchedDate", localDate);
        return "mdc-branch";
    }

}
