package ph.edu.up.antech.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class StatusReportController {

    @GetMapping("")
    public String loadStatusReportHomePage() {
        return "status-report";
    }

    @GetMapping("/add")
    public String addCsvFiles() {
        return "";
    }

    // Call this in addCsvFiles method
    private void processCsvFiles() {

    }

}
