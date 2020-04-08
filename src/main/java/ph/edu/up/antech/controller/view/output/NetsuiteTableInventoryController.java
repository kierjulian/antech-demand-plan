package ph.edu.up.antech.controller.view.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.domain.ProductType;
import ph.edu.up.antech.domain.master.Netsuite;
import ph.edu.up.antech.domain.output.NetsuiteCombination;
import ph.edu.up.antech.service.NetsuiteService;
import ph.edu.up.antech.service.ProductService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/output/netsuite/table-inv")
public class NetsuiteTableInventoryController {

    @Autowired
    private NetsuiteService netsuiteService;

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String loadNetsuiteTableInventoryPage(Model model,
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
        List<String> mgmtList = generateUniqueMgmtFromNetsuiteList(netsuiteList);
        List<String> regionList = generateUniqueRegionFromNetsuiteList(netsuiteList);
        List<String> kamReferenceNameList = generateUniqueKamReferenceNameFromNetsuiteList(netsuiteList);
        List<NetsuiteCombination> netsuiteCombinationList = generateNetsuiteCombination(netsuiteList, mgmtList,
                regionList, kamReferenceNameList, productCodeList);

        Set<UniqueTuple> regionSet = new HashSet<>();
        List<NetsuiteCombination> netsuiteCombinationRegionList = netsuiteCombinationList.stream()
                .filter(netsuiteCombination -> regionSet.add(
                        new UniqueTuple(netsuiteCombination.getMgmt(), netsuiteCombination.getRegion())))
                .collect(Collectors.toList());

        NetsuiteTableInventoryCalculator netsuiteTableInventoryCalculator =
                new NetsuiteTableInventoryCalculator(netsuiteList, productCodeList);

        model.addAttribute("searchedStartDate", start);
        model.addAttribute("searchedEndDate", end);
        model.addAttribute("milkProductList", milkProductList);
        model.addAttribute("jarProductList", jarProductList);
        model.addAttribute("waterProductList", waterProductList);
        model.addAttribute("mgmtList", mgmtList);
        model.addAttribute("regionList", regionList);
        model.addAttribute("kamReferenceNameList", kamReferenceNameList);
        model.addAttribute("netsuiteCombinationList", netsuiteCombinationList);
        model.addAttribute("netsuiteCombinationRegionList", netsuiteCombinationRegionList);
        model.addAttribute("netsuiteTableInventoryCalculator", netsuiteTableInventoryCalculator);
        return "output/netsuite-table-inv";
    }

    private List<String> generateUniqueMgmtFromNetsuiteList(List<Netsuite> netsuiteList) {
        return netsuiteList.stream()
                .map(Netsuite::getMgmt)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    private List<String> generateUniqueRegionFromNetsuiteList(List<Netsuite> netsuiteList) {
        return netsuiteList.stream()
                .map(Netsuite::getRegion)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    private List<String> generateUniqueKamReferenceNameFromNetsuiteList(List<Netsuite> netsuiteList) {
        return netsuiteList.stream()
                .map(Netsuite::getKamRefName1)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    private List<NetsuiteCombination> generateNetsuiteCombination(
            List<Netsuite> netsuiteList, List<String> mgmtList,
            List<String> regionList, List<String> kamReferenceNameList, List<String> productListCode) {
        List<NetsuiteCombination> netsuiteCombinationList = new ArrayList<>();

        mgmtList.forEach(mgmt -> {
            regionList.forEach(region -> {
                kamReferenceNameList.forEach(kamReferenceName -> {
                    List<Netsuite> netsuiteFilteredList = netsuiteList.stream()
                            .filter(netsuite -> productListCode.contains(netsuite.getBrand()))
                            .filter(netsuite -> Objects.nonNull(netsuite.getTransfersCatRecode()))
                            .filter(netsuite -> Objects.nonNull(netsuite.getMgmt()))
                            .filter(netsuite -> Objects.nonNull(netsuite.getRegion()))
                            .filter(netsuite -> Objects.nonNull(netsuite.getKamRefName1()))
                            .filter(netsuite -> Objects.nonNull(netsuite.getRevenueConverted()))
                            .filter(netsuite -> Objects.nonNull(netsuite.getQuantity()))
                            .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                            .filter(netsuite -> netsuite.getRegion().equals(region))
                            .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                            .collect(Collectors.toList());
                    if (!netsuiteFilteredList.isEmpty()) {
                        netsuiteCombinationList.add(new NetsuiteCombination(netsuiteFilteredList));
                    }
                });
            });
        });

        return netsuiteCombinationList;
    }

}
