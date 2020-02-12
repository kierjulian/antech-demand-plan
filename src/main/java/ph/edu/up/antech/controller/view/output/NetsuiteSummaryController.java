package ph.edu.up.antech.controller.view.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.service.NetsuiteService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
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

        model.addAttribute("searchedDate", localDate);
        model.addAttribute("netsuiteList", netsuiteList);
        model.addAttribute("productList", productList);
        model.addAttribute("kamReferenceNameList", kamReferenceNameList);
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

}
