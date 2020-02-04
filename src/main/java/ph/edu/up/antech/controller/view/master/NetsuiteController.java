package ph.edu.up.antech.controller.view.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.service.NetsuiteService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Controller
public class NetsuiteController {

    @Autowired
    private NetsuiteService netsuiteService;

    @GetMapping("/master/netsuite")
    public String loadNetsuiteMasterFile(Model model, @RequestParam(required = false) String date) {
        LocalDate localDate = !StringUtils.isNullOrEmpty(date) ? LocalDate.parse(date) : LocalDate.now();
        List<Netsuite> netsuiteList = netsuiteService.findNetsuiteByItemDate(localDate);

        model.addAttribute("searchedDate", localDate);
        model.addAttribute("netsuiteList", netsuiteList);
        return "netsuite";
    }

}
