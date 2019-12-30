package ph.edu.up.antech.controller.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;
import ph.edu.up.antech.service.DispensingDistributorService;
import ph.edu.up.antech.service.NetsuiteService;
import ph.edu.up.antech.service.ZolPerDoorsService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/master")
public class MasterFileController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MasterFileController.class);

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @Autowired
    private DispensingDistributorService dispensingDistributorService;

    @Autowired
    private NetsuiteService netsuiteService;

    @GetMapping("/zol-per-doors")
    public String loadZolPerDoorsMasterFile(Model model, @RequestParam(required = false) String date) {
        LocalDate localDate = !StringUtils.isNullOrEmpty(date) ? LocalDate.parse(date) : LocalDate.now();
        List<ZolPerDoors> zolPerDoorsList = zolPerDoorsService.findZolPerDoorsByDate(localDate);

        model.addAttribute("searchedDate", localDate);
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
        LocalDate localDate = !StringUtils.isNullOrEmpty(date) ? LocalDate.parse(date) : LocalDate.now();
        List<DispensingDistributor> dispensingDistributorList =
                dispensingDistributorService.findDispensingDistributorByDate(localDate);

        model.addAttribute("searchedDate", localDate);
        model.addAttribute("dispensingDistributorList", dispensingDistributorList);
        return "dispensing-distributor";
    }

    @GetMapping("/netsuite")
    public String loadNetsuiteMasterFile(Model model, @RequestParam(required = false) String date) {
        LocalDate localDate = !StringUtils.isNullOrEmpty(date) ? LocalDate.parse(date) : LocalDate.now();
        List<Netsuite> netsuiteList = netsuiteService.findNetsuiteByItemDate(localDate);

        model.addAttribute("searchedDate", localDate);
        model.addAttribute("netsuiteList", netsuiteList);
        return "netsuite";
    }

    @GetMapping("/mdc-branch")
    public String loadMdcPerBranch() {
        return "mdc-branch";
    }

}
