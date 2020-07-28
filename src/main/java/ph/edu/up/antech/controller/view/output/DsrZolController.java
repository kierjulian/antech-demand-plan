package ph.edu.up.antech.controller.view.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.domain.ProductType;
import ph.edu.up.antech.domain.master.ZolPerDoors;
import ph.edu.up.antech.domain.output.DsrZol;
import ph.edu.up.antech.domain.output.DsrZolCombination;
import ph.edu.up.antech.service.ProductService;
import ph.edu.up.antech.service.ZolPerDoorsService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/output/dsr-zol")
public class DsrZolController {

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String loadDsrZolPage(Model model,
                                 @RequestParam(required = false) String startDate,
                                 @RequestParam(required = false) String endDate) {
        LocalDate start = !StringUtils.isNullOrEmpty(startDate)
                ? LocalDate.parse(startDate) : LocalDate.now();
        LocalDate end = !StringUtils.isNullOrEmpty(endDate)
                ? LocalDate.parse(endDate) : LocalDate.now();

        List<Product> productList = productService.findAllProducts();
        List<String> productCodeList = productList.stream()
                .map(Product::getCode)
                .collect(Collectors.toList());

        List<ZolPerDoors> zolPerDoorsList = zolPerDoorsService.findZolPerDoorsSalesAmountAndUnitBetweenTwoDates(start, end);
        List<DsrZol> dsrZolList = generateDsrZolFromZolPerDoorsList(zolPerDoorsList, productCodeList);
        List<String> kamReferenceNameList = findDistinctKamReferenceNameInZolPerDoorsList(zolPerDoorsList);
        Collections.sort(kamReferenceNameList);

        List<String> accountList = findDistinctAccountInZolPerDoorsList(zolPerDoorsList);
        Collections.sort(accountList);

        List<DsrZolCombination> dsrZolCombinationList =
                generateDsrZolCombinationByLocalDateAndKamReferenceNameAndAccount(dsrZolList, kamReferenceNameList,
                        accountList);

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

        DsrZolCalculator dsrZolCalculator = new DsrZolCalculator(dsrZolList, productCodeList);

        model.addAttribute("searchedStartDate", start);
        model.addAttribute("searchedEndDate", end);
        model.addAttribute("dsrZolList", dsrZolList);
        model.addAttribute("milkProductList", milkProductList);
        model.addAttribute("jarProductList", jarProductList);
        model.addAttribute("waterProductList", waterProductList);
        model.addAttribute("kamReferenceNameList", kamReferenceNameList);
        model.addAttribute("dsrZolCalculator", dsrZolCalculator);
        model.addAttribute("dsrZolCombinationList", dsrZolCombinationList);
        return "output/dsr-zol";
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

    private List<DsrZol> generateDsrZolFromZolPerDoorsList(List<ZolPerDoors> zolPerDoorsList, List<String> productCodeList) {
        List<String> kamReferenceNameList = findDistinctKamReferenceNameInZolPerDoorsList(zolPerDoorsList);

        List<DsrZol> dsrZolList = new ArrayList<>();

        kamReferenceNameList.forEach(kamReferenceName -> {
            productCodeList.forEach(productCode -> {
                List<ZolPerDoors> filteredZolPerDoorsList = zolPerDoorsList.stream()
                        .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getKamReferenceName()))
                        .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getAntechProductDescription()))
                        .filter(zolPerDoors -> zolPerDoors.getKamReferenceName().equals(kamReferenceName))
                        .filter(zolPerDoors -> zolPerDoors.getAntechProductDescription().equals(productCode))
                        .collect(Collectors.toList());
                filteredZolPerDoorsList.forEach(zolPerDoors -> {
                    DsrZol dsrZol = new DsrZol(zolPerDoors);
                    dsrZolList.add(dsrZol);
                });
            });
        });

        return dsrZolList;
    }

    private List<DsrZolCombination> generateDsrZolCombinationByLocalDateAndKamReferenceNameAndAccount(
            List<DsrZol> dsrZolList, List<String> kamReferenceNameList, List<String> accountList) {
        List<DsrZolCombination> dsrZolCombinationList = new ArrayList<>();

        kamReferenceNameList.forEach(kamReferenceName -> {
            accountList.forEach(account -> {
                List<DsrZol> dsrZolListFiltered = dsrZolList.stream()
                        .filter(dsrZol -> dsrZol.getKamReferenceName().equals(kamReferenceName))
                        .filter(dsrZol -> dsrZol.getAccount().equals(account))
                        .collect(Collectors.toList());
                if (!dsrZolListFiltered.isEmpty()) {
                    dsrZolCombinationList.add(new DsrZolCombination(dsrZolListFiltered));
                }
            });
        });

        return dsrZolCombinationList;
    }

}
