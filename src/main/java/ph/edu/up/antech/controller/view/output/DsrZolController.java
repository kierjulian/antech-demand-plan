package ph.edu.up.antech.controller.view.output;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.domain.sales.output.DsrZol;
import ph.edu.up.antech.domain.sales.output.DsrZolCombination;
import ph.edu.up.antech.service.ZolPerDoorsService;
import ph.edu.up.antech.util.DsrZolCalculator;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class DsrZolController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DsrZolController.class);

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @GetMapping("/output/dsr-zol")
    public String loadDsrZolPage(Model model, @RequestParam(required = false) String date) {
        LocalDate localDate = !StringUtils.isNullOrEmpty(date)
                ? LocalDate.parse(date) : LocalDate.now();
        List<DsrZol> dsrZolList = generateDsrZolByLocalDate(localDate);
        List<String> antechProductDescriptionList = getZolPerDoorsProductByDate(localDate);
        List<String> kamReferenceNameList = getZolPerDoorsKamReferenceNameByDate(localDate);
        List<String> accountList = getDistinctZolPerDoorsAccountByDate(localDate);
        List<DsrZolCombination> dsrZolCombinationList =
                generateDsrZolCombinationByLocalDateAndKamReferenceNameAndAccount(dsrZolList, kamReferenceNameList,
                        accountList);
        DsrZolCalculator dsrZolCalculator = new DsrZolCalculator(dsrZolList);

        model.addAttribute("searchedDate", localDate);
        model.addAttribute("dsrZolList", dsrZolList);
        model.addAttribute("productList", antechProductDescriptionList);
        model.addAttribute("kamReferenceNameList", kamReferenceNameList);
        model.addAttribute("dsrZolCalculator", dsrZolCalculator);
        model.addAttribute("dsrZolCombinationList", dsrZolCombinationList);
        return "dsr-zol";
    }

    private List<DsrZol> generateDsrZolByLocalDate(LocalDate date) {
        List<String> kamReferenceNameList = getZolPerDoorsKamReferenceNameByDate(date);
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

    private List<String> getZolPerDoorsKamReferenceNameByDate(LocalDate localDate) {
        return zolPerDoorsService
                .findDistinctZolPerDoorsKamReferenceNameByLocalDate(localDate);
    }

    private List<String> getDistinctZolPerDoorsAccountByDate(LocalDate localDate) {
        return zolPerDoorsService
                .findDistinctZolPerDoorsAccountByLocalDate(localDate);
    }

    private List<DsrZolCombination> generateDsrZolCombinationByLocalDateAndKamReferenceNameAndAccount(
            List<DsrZol> dsrZolList, List<String> kamReferenceNameList, List<String> accountList) {
        List<DsrZolCombination> dsrZolCombinationList = new ArrayList<>();
        for (String kamReferenceName : kamReferenceNameList) {
            for (String account : accountList) {
                List<DsrZol> dsrZolListFiltered = dsrZolList.stream()
                        .filter(dsrZol -> dsrZol.getKamReferenceName().equals(kamReferenceName))
                        .filter(dsrZol -> dsrZol.getAccount().equals(account))
                        .collect(Collectors.toList());
                if (!dsrZolListFiltered.isEmpty()) {
                    dsrZolCombinationList.add(new DsrZolCombination(dsrZolListFiltered));
                }
            }
        }

        return dsrZolCombinationList;
    }

}
