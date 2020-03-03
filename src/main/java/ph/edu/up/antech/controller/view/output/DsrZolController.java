package ph.edu.up.antech.controller.view.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.domain.ProductType;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.domain.sales.output.DsrZol;
import ph.edu.up.antech.domain.sales.output.DsrZolCombination;
import ph.edu.up.antech.service.ProductService;
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

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @Autowired
    private ProductService productService;

    private List<Product> productList;

    @GetMapping("")
    public String loadDsrZolPage(Model model,
                                 @RequestParam(required = false) String startDate,
                                 @RequestParam(required = false) String endDate) {
        LocalDate start = !StringUtils.isNullOrEmpty(startDate)
                ? LocalDate.parse(startDate) : LocalDate.now();
        LocalDate end = !StringUtils.isNullOrEmpty(endDate)
                ? LocalDate.parse(endDate) : LocalDate.now();

        List<ZolPerDoors> zolPerDoorsList = zolPerDoorsService.findZolPerDoorsBetweenTwoDates(start, end);
        List<DsrZol> dsrZolList = generateDsrZolFromZolPerDoorsList(zolPerDoorsList);
        List<String> kamReferenceNameList = findDistinctKamReferenceNameInZolPerDoorsList(zolPerDoorsList);
        List<String> accountList = findDistinctAccountInZolPerDoorsList(zolPerDoorsList);
        List<DsrZolCombination> dsrZolCombinationList =
                generateDsrZolCombinationByLocalDateAndKamReferenceNameAndAccount(dsrZolList, kamReferenceNameList,
                        accountList);
        DsrZolCalculator dsrZolCalculator = new DsrZolCalculator(dsrZolList);

        List<String> milkProductList = getAllProducts().stream()
                .filter(product -> product.getProductType().equals(ProductType.MILK))
                .map(Product::getCode)
                .collect(Collectors.toList());
        List<String> jarProductList = getAllProducts().stream()
                .filter(product -> product.getProductType().equals(ProductType.JAR))
                .map(Product::getCode)
                .collect(Collectors.toList());
        List<String> waterProductList = getAllProducts().stream()
                .filter(product -> product.getProductType().equals(ProductType.WATER))
                .map(Product::getCode)
                .collect(Collectors.toList());

        model.addAttribute("searchedStartDate", start);
        model.addAttribute("searchedEndDate", end);
        model.addAttribute("dsrZolList", dsrZolList);
        model.addAttribute("milkProductList", milkProductList);
        model.addAttribute("waterProductList", waterProductList);
        model.addAttribute("kamReferenceNameList", kamReferenceNameList);
        model.addAttribute("dsrZolCalculator", dsrZolCalculator);
        model.addAttribute("dsrZolCombinationList", dsrZolCombinationList);
        return "dsr-zol";
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

        kamReferenceNameList.forEach(kamReferenceName -> {
            antechProductDescriptionList.forEach(antechProductDescription -> {
                List<ZolPerDoors> filteredZolPerDoorsList = zolPerDoorsList.stream()
                        .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getKamReferenceName()))
                        .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getAntechProductDescription()))
                        .filter(zolPerDoors -> zolPerDoors.getKamReferenceName().equals(kamReferenceName))
                        .filter(zolPerDoors -> zolPerDoors.getAntechProductDescription().equals(antechProductDescription))
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

    private List<Product> getAllProducts() {
        if (productList == null) {
            productList = productService.findAllProducts();
        }

        return productList;
    }

}
