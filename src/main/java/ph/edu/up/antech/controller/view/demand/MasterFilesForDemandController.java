package ph.edu.up.antech.controller.view.demand;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demand/master")
public class MasterFilesForDemandController {

    @GetMapping("")
    public String loadDemandPlanMasterController() {
        return "demand/master-files-for-demand";
    }

}
