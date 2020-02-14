package ph.edu.up.antech.controller.view.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.domain.sales.output.NetsuiteCombination;
import ph.edu.up.antech.service.NetsuiteService;
import ph.edu.up.antech.util.NetsuiteSummaryCalculator;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/output/netsuite/summary")
public class NetsuiteSummaryController {

    @Autowired
    private NetsuiteService netsuiteService;

    @GetMapping("")
    public String loadNetsuiteSummaryPage(Model model, @RequestParam(required = false) String date) {
        LocalDate localDate = !StringUtils.isNullOrEmpty(date)
                ? LocalDate.parse(date) : LocalDate.now();
        List<Netsuite> netsuiteList = netsuiteService.findNetsuiteByItemDate(localDate);
        List<String> productList = generateListOfUniqueProductBrandFromNetsuiteList(netsuiteList);
        List<String> kamReferenceNameList = generateListOfUniqueKamReferenceNameFromNetsuiteList(netsuiteList);
        List<String> transfersCatRecodeList = generateListOfUniqueTransfersCatRecordFromNetsuiteList(netsuiteList);
        List<NetsuiteCombination> netsuiteCombinationList =
                generateNetsuiteCombination(netsuiteList, kamReferenceNameList, transfersCatRecodeList);
        NetsuiteSummaryCalculator netsuiteSummaryCalculator = new NetsuiteSummaryCalculator(netsuiteList);

        model.addAttribute("searchedDate", localDate);
        model.addAttribute("netsuiteList", netsuiteList);
        model.addAttribute("productList", productList);
        model.addAttribute("transfersCatRecodeList", transfersCatRecodeList);
        model.addAttribute("netsuiteCombinationList", netsuiteCombinationList);
        model.addAttribute("netsuiteSummaryCalculator", netsuiteSummaryCalculator);
        return "netsuite-summary";
    }

    private List<String> generateListOfUniqueProductBrandFromNetsuiteList(List<Netsuite> netsuiteList) {
        return netsuiteList.stream()
                .map(Netsuite::getBrand)
                .distinct()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private List<String> generateListOfUniqueKamReferenceNameFromNetsuiteList(List<Netsuite> netsuiteList) {
        return netsuiteList.stream()
                .map(Netsuite::getKamRefName1)
                .distinct()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private List<String> generateListOfUniqueTransfersCatRecordFromNetsuiteList(List<Netsuite> netsuiteList) {
        return netsuiteList.stream()
                .map(Netsuite::getTransfersCatRecode)
                .distinct()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private List<NetsuiteCombination> generateNetsuiteCombination(
            List<Netsuite> netsuiteList, List<String> kamReferenceNameList, List<String> transfersCatRecordList) {
        List<NetsuiteCombination> netsuiteCombinationList = new ArrayList<>();
        for (String kamReferenceName : kamReferenceNameList) {
            for (String transferCatRecode : transfersCatRecordList) {
                List<Netsuite> netsuiteFilteredList = netsuiteList.stream()
                        .filter(netsuite -> netsuite.getKamRefName1() != null)
                        .filter(netsuite -> netsuite.getBrand() != null)
                        .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                        .filter(netsuite -> netsuite.getTransfersCatRecode().equals(transferCatRecode))
                        .collect(Collectors.toList());
                if (!netsuiteFilteredList.isEmpty()) {
                    netsuiteCombinationList.add(new NetsuiteCombination(netsuiteFilteredList));
                }
            }
        }

        return netsuiteCombinationList;
    }

}
