package ph.edu.up.antech.controller.view.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.domain.ProductType;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.domain.sales.output.NetsuiteCombination;
import ph.edu.up.antech.service.NetsuiteService;
import ph.edu.up.antech.service.ProductService;
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

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String loadNetsuiteSummaryPage(Model model,
                                          @RequestParam(required = false) String startDate,
                                          @RequestParam(required = false) String endDate) {
        LocalDate start = !StringUtils.isNullOrEmpty(startDate)
                ? LocalDate.parse(startDate) : LocalDate.now();
        LocalDate end = !StringUtils.isNullOrEmpty(endDate)
                ? LocalDate.parse(endDate) : LocalDate.now();
        List<Netsuite> netsuiteList = netsuiteService.findNetsuiteSalesAmountAndUnitBetweenTwoDates(start, end);

        List<Product> productList = productService.findAllProducts();
        List<String> productCodeList = productList.stream()
                .map(Product::getCode)
                .collect(Collectors.toList());
        List<String> milkProductList = productList.stream()
                .filter(product -> product.getProductType().equals(ProductType.MILK))
                .map(Product::getCode)
                .collect(Collectors.toList());
        List<String> jarProductList = productList.stream()
                .filter(product -> product.getProductType().equals(ProductType.JAR))
                .map(Product::getCode)
                .collect(Collectors.toList());
        List<String> waterProductList = productList.stream()
                .filter(product -> product.getProductType().equals(ProductType.WATER))
                .map(Product::getCode)
                .collect(Collectors.toList());
        List<String> kamReferenceNameList = generateListOfUniqueKamReferenceNameFromNetsuiteList(netsuiteList);
        List<String> transfersCatRecodeList = generateListOfUniqueTransfersCatRecordFromNetsuiteList(netsuiteList);
        List<NetsuiteCombination> netsuiteCombinationList =
                generateNetsuiteCombination(netsuiteList, kamReferenceNameList, transfersCatRecodeList, productCodeList);
        NetsuiteSummaryCalculator netsuiteSummaryCalculator = new NetsuiteSummaryCalculator(netsuiteList, productCodeList);

        model.addAttribute("searchedStartDate", start);
        model.addAttribute("searchedEndDate", end);
        model.addAttribute("netsuiteList", netsuiteList);
        model.addAttribute("milkProductList", milkProductList);
        model.addAttribute("jarProductList", jarProductList);
        model.addAttribute("waterProductList", waterProductList);
        model.addAttribute("transfersCatRecodeList", transfersCatRecodeList);
        model.addAttribute("netsuiteCombinationList", netsuiteCombinationList);
        model.addAttribute("netsuiteSummaryCalculator", netsuiteSummaryCalculator);
        return "output/netsuite-summary";
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
            List<Netsuite> netsuiteList, List<String> kamReferenceNameList, List<String> transfersCatRecodeList,
            List<String> productListCode) {
        List<NetsuiteCombination> netsuiteCombinationList = new ArrayList<>();

        kamReferenceNameList.forEach(kamReferenceName -> {
            transfersCatRecodeList.forEach(transfersCatRecode -> {
                List<Netsuite> netsuiteFilteredList = netsuiteList.stream()
                        .filter(netsuite -> productListCode.contains(netsuite.getBrand()))
                        .filter(netsuite -> netsuite.getKamRefName1() != null)
                        .filter(netsuite -> netsuite.getBrand() != null)
                        .filter(netsuite -> netsuite.getTransfersCatRecode() != null)
                        .filter(netsuite -> netsuite.getRevenueConverted() != null)
                        .filter(netsuite -> netsuite.getQuantity() != null)
                        .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                        .filter(netsuite -> netsuite.getTransfersCatRecode().equals(transfersCatRecode))
                        .collect(Collectors.toList());
                if (!netsuiteFilteredList.isEmpty()) {
                    netsuiteCombinationList.add(new NetsuiteCombination(netsuiteFilteredList));
                }
            });
        });

        return netsuiteCombinationList;
    }

}
