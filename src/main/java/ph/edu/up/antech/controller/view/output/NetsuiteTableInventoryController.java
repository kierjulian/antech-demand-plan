package ph.edu.up.antech.controller.view.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.service.NetsuiteService;
import ph.edu.up.antech.util.NetsuiteTableInventoryCalculator;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/output/netsuite/table-inv")
public class NetsuiteTableInventoryController {

    @Autowired
    private NetsuiteService netsuiteService;

    @GetMapping("")
    public String loadNetsuiteTableInventoryPage(Model model,
                                                 @RequestParam(required = false) String startDate,
                                                 @RequestParam(required = false) String endDate) {
        LocalDate start = !StringUtils.isNullOrEmpty(startDate)
                ? LocalDate.parse(startDate) : LocalDate.now();
        LocalDate end = !StringUtils.isNullOrEmpty(endDate)
                ? LocalDate.parse(endDate) : LocalDate.now();

        List<Netsuite> netsuiteList = netsuiteService.findNetsuiteBetweenTwoDates(start, end);
        List<String> hippProductList = generateUniqueHippProductNameFromNetsuiteList(netsuiteList);
        List<String> jarProductList = generateUniqueJarProductNameFromNetsuiteList(netsuiteList);
        List<String> kamReferenceNameList = generateUniqueKamReferenceNameFromNetsuiteList(netsuiteList);
        NetsuiteTableInventoryCalculator netsuiteTableInventoryCalculator =
                new NetsuiteTableInventoryCalculator(netsuiteList);

        model.addAttribute("searchedStartDate", start);
        model.addAttribute("searchedEndDate", end);
        model.addAttribute("hippProductList", hippProductList);
        model.addAttribute("jarProductList", jarProductList);
        model.addAttribute("kamReferenceNameList", kamReferenceNameList);
        model.addAttribute("netsuiteTableInventoryCalculator", netsuiteTableInventoryCalculator);
        return "netsuite-table-inv";
    }

    private List<String> generateUniqueHippProductNameFromNetsuiteList(List<Netsuite> netsuiteList) {
        return netsuiteList.stream()
                .map(Netsuite::getBrand)
                .filter(Objects::nonNull)
                .distinct()
                .filter(productName -> productName.startsWith("CS") || productName.startsWith("S"))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    private List<String> generateUniqueJarProductNameFromNetsuiteList(List<Netsuite> netsuiteList) {
        return netsuiteList.stream()
                .map(Netsuite::getBrand)
                .filter(Objects::nonNull)
                .distinct()
                .filter(productName -> productName.startsWith("Jar"))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    private List<String> generateUniqueKamReferenceNameFromNetsuiteList(List<Netsuite> netsuiteList) {
        return netsuiteList.stream()
                .map(Netsuite::getKamRefName1)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

}
