package ph.edu.up.antech.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.service.ZolPerDoorsService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/master")
public class MasterFileController {

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @GetMapping("/zol-per-doors")
    public String loadZolPerDoorsMasterFile(Model model, @RequestParam(required = false) String date) {
        List<ZolPerDoors> zolPerDoorsList = new ArrayList<>();
        if (date != null && !date.trim().isEmpty()) {
            LocalDate dateToFind = LocalDate.parse(date);
            zolPerDoorsList = zolPerDoorsService.findByDate(LocalDate.now());
        } else {
            zolPerDoorsList = zolPerDoorsService.findByDate(LocalDate.now());
        }

        model.addAttribute("zolPerDoorsList", zolPerDoorsList);
        return "zol-per-doors";
    }


}
