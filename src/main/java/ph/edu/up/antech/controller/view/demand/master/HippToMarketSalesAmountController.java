package ph.edu.up.antech.controller.view.demand.master;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demand/master")
public class HippToMarketSalesAmountController {

    @GetMapping("/hipp/to-market/amount")
    public String loadHippToMarketSalesAmountPage(Model model) {
        return "hipp-to-market-sales-amount";
    }

}
