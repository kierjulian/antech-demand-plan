package ph.edu.up.antech.controller.view.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;
import ph.edu.up.antech.service.DispensingDistributorService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DispensingDistributorController {

    @Autowired
    private DispensingDistributorService dispensingDistributorService;

    @GetMapping("/master/dispensing-distributor")
    public String loadDispensingDistributorMasterFile(Model model, @RequestParam(required = false) String date) {
        LocalDate localDate = !StringUtils.isNullOrEmpty(date) ? LocalDate.parse(date) : LocalDate.now();
        List<DispensingDistributor> dispensingDistributorList =
                dispensingDistributorService.findDispensingDistributorByDate(localDate);

        model.addAttribute("searchedDate", localDate);
        model.addAttribute("dispensingDistributorList", dispensingDistributorList);
        return "dispensing-distributor";
    }

}
