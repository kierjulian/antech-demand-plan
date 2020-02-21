package ph.edu.up.antech.controller.view.demand.master;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demand/master")
public class HippInMarketSalesUnitsController {

    @GetMapping("/hipp/in-market/units")
    public String loadHippInMarketSalesUnitsPage(Model model) {
        return "hipp-in-market-sales-units";
    }

}
