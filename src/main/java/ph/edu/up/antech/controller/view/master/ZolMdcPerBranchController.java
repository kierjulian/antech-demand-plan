package ph.edu.up.antech.controller.view.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.sales.master.ZolMdcPerBranch;
import ph.edu.up.antech.service.ZolMdcPerBranchService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ZolMdcPerBranchController {

    @Autowired
    private ZolMdcPerBranchService zolMdcPerBranchService;

    @GetMapping("/master/zol-mdc")
    public String loadZolMdc(Model model, @RequestParam(required = false) String date) {
        LocalDate localDate = !StringUtils.isNullOrEmpty(date) ? LocalDate.parse(date) : LocalDate.now();
        List<ZolMdcPerBranch> zolMdcPerBranchList = zolMdcPerBranchService.findZolMdcPerBranchByLocalDate(localDate);

        model.addAttribute("searchedDate", localDate);
        model.addAttribute("zolMdcPerBranchList", zolMdcPerBranchList);
        return "zol-mdc";
    }

}
