package ph.edu.up.antech.controller.view.output;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/output/dsr-zol")
public class DsrZolController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DsrZolController.class);

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @GetMapping("")
    public String loadDsrZolPage(Model model, @RequestParam(required = false) String date) {
        LocalDate localDate = !StringUtils.isNullOrEmpty(date)
                ? LocalDate.parse(date) : LocalDate.now();

        List<ZolPerDoors> zolPerDoorsList = findZolPerDoorsByLocalDate(localDate);
        List<DsrZol> dsrZolList = generateDsrZolFromZolPerDoorsList(zolPerDoorsList);
        List<String> kamReferenceNameList = findDistinctKamReferenceNameInZolPerDoorsList(zolPerDoorsList);
        List<String> accountList = findDistinctAccountInZolPerDoorsList(zolPerDoorsList);
        List<DsrZolCombination> dsrZolCombinationList =
                generateDsrZolCombinationByLocalDateAndKamReferenceNameAndAccount(dsrZolList, kamReferenceNameList,
                        accountList);
        DsrZolCalculator dsrZolCalculator = new DsrZolCalculator(dsrZolList);

        List<String> antechProductDescriptionList = findDistinctAntechProductDescriptionInZolPerDoorsList(zolPerDoorsList);

        model.addAttribute("searchedDate", localDate);
        model.addAttribute("dsrZolList", dsrZolList);
        model.addAttribute("productList", antechProductDescriptionList);
        model.addAttribute("kamReferenceNameList", kamReferenceNameList);
        model.addAttribute("dsrZolCalculator", dsrZolCalculator);
        model.addAttribute("dsrZolCombinationList", dsrZolCombinationList);
        return "dsr-zol";
    }

    private List<ZolPerDoors> findZolPerDoorsByLocalDate(LocalDate localDate) {
        return zolPerDoorsService.findZolPerDoorsByDate(localDate);
    }

    private List<String> findDistinctKamReferenceNameInZolPerDoorsList(List<ZolPerDoors> zolPerDoorsList) {
        return zolPerDoorsList.stream()
                .map(ZolPerDoors::getKamReferenceName)
                .distinct()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private List<String> findDistinctAccountInZolPerDoorsList(List<ZolPerDoors> zolPerDoorsList) {
        return zolPerDoorsList.stream()
                .map(ZolPerDoors::getAccount)
                .distinct()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private List<String> findDistinctAntechProductDescriptionInZolPerDoorsList(List<ZolPerDoors> zolPerDoorsList) {
        return zolPerDoorsList.stream()
                .map(ZolPerDoors::getAntechProductDescription)
                .distinct()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private List<DsrZol> generateDsrZolFromZolPerDoorsList(List<ZolPerDoors> zolPerDoorsList) {
        List<String> kamReferenceNameList = findDistinctKamReferenceNameInZolPerDoorsList(zolPerDoorsList);
        List<String> antechProductDescriptionList =
                findDistinctAntechProductDescriptionInZolPerDoorsList(zolPerDoorsList);

        List<DsrZol> dsrZolList = new ArrayList<>();
        for (String kamReferenceName : kamReferenceNameList) {
            for (String antechProductDescription : antechProductDescriptionList) {
                List<ZolPerDoors> filteredZolPerDoorsList = zolPerDoorsList.stream()
                        .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getKamReferenceName()))
                        .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getAntechProductDescription()))
                        .filter(zolPerDoors -> zolPerDoors.getKamReferenceName().equals(kamReferenceName))
                        .filter(zolPerDoors -> zolPerDoors.getAntechProductDescription().equals(antechProductDescription))
                        .collect(Collectors.toList());
                for (ZolPerDoors zolPerDoors : filteredZolPerDoorsList) {
                    DsrZol dsrZol = new DsrZol(zolPerDoors);
                    dsrZolList.add(dsrZol);
                }
            }
        }

        return dsrZolList;
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
