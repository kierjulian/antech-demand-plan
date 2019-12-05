package ph.edu.up.antech.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;
import ph.edu.up.antech.service.DispensingDistributorService;
import ph.edu.up.antech.service.ZolPerDoorsService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/master")
public class MasterFileController {

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @Autowired
    private DispensingDistributorService dispensingDistributorService;

    @GetMapping("/zol-per-doors")
    public String loadZolPerDoorsMasterFile(Model model, @RequestParam(required = false) String date) {
        List<ZolPerDoors> zolPerDoorsList = new ArrayList<>();
        if (date != null && !date.trim().isEmpty()) {
            LocalDate dateToFind = LocalDate.parse(date);
            zolPerDoorsList = zolPerDoorsService.findByDate(dateToFind);
        } else {
            zolPerDoorsList = zolPerDoorsService.findByDate(LocalDate.now());
        }

        model.addAttribute("zolPerDoorsList", zolPerDoorsList);
        return "zol-per-doors";
    }

    @GetMapping("/zol-mdc")
    public String loadZolMdc() {
        return "zol-mdc";
    }

    @GetMapping("/zol-mt")
    public String loadZolMt() {
        return "zol-mt";
    }

    @GetMapping("/dispensing-distributor")
    public String loadDispensingDistributorMasterFile(Model model, @RequestParam(required = false) String date) {
        List<DispensingDistributor> dispensingDistributorList;
        if (date != null && !date.trim().isEmpty()) {
            LocalDate dateToFind = LocalDate.parse(date);
            dispensingDistributorList = dispensingDistributorService.findByDate(dateToFind);
        } else {
            dispensingDistributorList = dispensingDistributorService.findByDate(LocalDate.now());
        }

        model.addAttribute("dispensingDistributorList", dispensingDistributorList);
        return "dispensing-distributor";
    }

    @GetMapping("/netsuite")
    public String loadNetsuiteMasterFile() {
        return "netsuite";
    }

    @GetMapping("/mdc-branch")
    public String loadMdcPerBranch() {
        return "mdc-branch";
    }

}
