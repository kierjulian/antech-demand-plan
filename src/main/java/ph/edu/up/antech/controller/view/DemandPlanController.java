package ph.edu.up.antech.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demand-plan")
public class DemandPlanController {

    @GetMapping("")
    public String loadDemandPlanPage() {
        return "demand-plan";
    }

}
