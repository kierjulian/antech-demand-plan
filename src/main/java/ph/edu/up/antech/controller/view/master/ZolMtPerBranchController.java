package ph.edu.up.antech.controller.view.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.sales.master.ZolMtPerBranch;
import ph.edu.up.antech.service.ZolMtPerBranchService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ZolMtPerBranchController {

    @Autowired
    private ZolMtPerBranchService zolMtPerBranchService;

    @GetMapping("/master/zol-mt")
    public String loadZolMt(Model model, @RequestParam(required = false) String date) {
        LocalDate localDate = !StringUtils.isNullOrEmpty(date) ? LocalDate.parse(date) : LocalDate.now();
        List<ZolMtPerBranch> zolMtPerBranchList = zolMtPerBranchService.findZolMtPerBranchByLocalDate(localDate);

        model.addAttribute("searchedDate", localDate);
        model.addAttribute("zolMtPerBranchList", zolMtPerBranchList);
        return "zol-mt";
    }

}
