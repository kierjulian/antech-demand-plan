package ph.edu.up.antech.controller.view.output;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/output/netsuite/table-inv")
public class NetsuiteTableInventoryController {

    @GetMapping("")
    public String loadNetsuiteTableInventoryPage(Model model) {
        return "netsuite-table-inv";
    }

}
