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
import ph.edu.up.antech.service.NetsuiteService;
import ph.edu.up.antech.service.ProductService;
import ph.edu.up.antech.util.NetsuiteTableInventoryCalculator;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
        List<Netsuite> netsuiteList = netsuiteService.findNetsuiteBetweenTwoDates(start, end);

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
        List<String> kamReferenceNameList = generateUniqueKamReferenceNameFromNetsuiteList(netsuiteList);
        NetsuiteTableInventoryCalculator netsuiteTableInventoryCalculator =
                new NetsuiteTableInventoryCalculator(netsuiteList, productCodeList);

        model.addAttribute("searchedStartDate", start);
        model.addAttribute("searchedEndDate", end);
        model.addAttribute("milkProductList", milkProductList);
        model.addAttribute("jarProductList", jarProductList);
        model.addAttribute("waterProductList", waterProductList);
        model.addAttribute("kamReferenceNameList", kamReferenceNameList);
        model.addAttribute("netsuiteTableInventoryCalculator", netsuiteTableInventoryCalculator);
        return "output/netsuite-table-inv";
    }

    private List<String> generateUniqueKamReferenceNameFromNetsuiteList(List<Netsuite> netsuiteList) {
        return netsuiteList.stream()
                .map(Netsuite::getKamRefName1)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

}
