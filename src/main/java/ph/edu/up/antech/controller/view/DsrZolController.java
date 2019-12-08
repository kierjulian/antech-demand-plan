package ph.edu.up.antech.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.domain.sales.output.DsrZol;
import ph.edu.up.antech.service.ZolPerDoorsService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dsr-zol")
public class DsrZolController {

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @GetMapping("")
    public String loadDsrZolPage(Model model, @RequestParam(required = false) String date) {
        LocalDate localDate = !StringUtils.isNullOrEmpty(date)
                ? LocalDate.parse(date) : LocalDate.now();
        List<DsrZol> dsrZolList = generateDsrZolByLocalDate(localDate);
        List<String> antechProductDescriptionList = getZolPerDoorsProductByDate(localDate);

        model.addAttribute("dsrZolList", dsrZolList);
        model.addAttribute("productList", antechProductDescriptionList);
        return "dsr-zol";
    }

    private List<DsrZol> generateDsrZolByLocalDate(LocalDate date) {
        List<String> kamReferenceNameList = zolPerDoorsService
                .findDistinctZolPerDoorsKamReferenceNameByLocalDate(date);
        List<String> antechProductDescriptionList =
                getZolPerDoorsProductByDate(date);

        List<DsrZol> dsrZolList = new ArrayList<>();
        for (String kamReferenceName : kamReferenceNameList) {
            for (String antechProductDescription : antechProductDescriptionList) {
                List<ZolPerDoors> zolPerDoorsList = zolPerDoorsService
                        .findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(date,
                                kamReferenceName, antechProductDescription);
                for (ZolPerDoors zolPerDoors : zolPerDoorsList) {
                    DsrZol dsrZol = new DsrZol(zolPerDoors);
                    dsrZolList.add(dsrZol);
                }
            }
        }

        return dsrZolList;
    }

    private List<String> getZolPerDoorsProductByDate(LocalDate localDate) {
        return zolPerDoorsService.findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(localDate);
    }

}
