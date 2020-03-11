package ph.edu.up.antech.controller.view.demand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.domain.sales.master.ZolMdcPerBranch;
import ph.edu.up.antech.domain.sales.master.ZolMtPerBranch;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;
import ph.edu.up.antech.service.*;
import ph.edu.up.antech.util.*;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/demand/hipp/sales")
public class HippMarketSalesController {

    @Autowired
    private ProductService productService;

    @Autowired
    private DispensingDistributorService dispensingDistributorService;

    @Autowired
    private ZolMdcPerBranchService zolMdcPerBranchService;

    @Autowired
    private ZolMtPerBranchService zolMtPerBranchService;

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @Autowired
    private NetsuiteService netsuiteService;

    @GetMapping("")
    public String loadHippInMarketSalesAmountPage(Model model,
                                                  @RequestParam(required = false) String startDate,
                                                  @RequestParam(required = false) String endDate) {
        YearMonth yearMonthStart = !StringUtils.isNullOrEmpty(startDate)
                ? YearMonth.parse(startDate) : YearMonth.of(Year.now().getValue(), 1);
        YearMonth yearMonthEnd = !StringUtils.isNullOrEmpty(endDate)
                ? YearMonth.parse(endDate) : YearMonth.of(Year.now().getValue(), 12);

        List<YearMonth> yearMonthList = DateUtils.generateListOfYearMonthBetweenTwoYearMonths(yearMonthStart, yearMonthEnd);
        List<Product> productList = productService.findAllProducts();
        List<String> productCodeList = productList.stream()
                .map(Product::getCode)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        LocalDate start = DateUtils.generateStartLocalDateFromYearMonth(yearMonthStart);
        LocalDate end = DateUtils.generateEndLocalDateFromYearMonth(yearMonthEnd);

        List<DispensingDistributor> dispensingDistributorList =
                dispensingDistributorService.findDispensingDistributorBetweenTwoDates(start, end);
        List<ZolMdcPerBranch> zolMdcPerBranchList =
                zolMdcPerBranchService.findZolMdcPerBranchBetweenTwoDates(start, end);
        List<ZolMtPerBranch> zolMtPerBranchList =
                zolMtPerBranchService.findZolMtPerBranchBetweenTwoDates(start, end);
        List<ZolPerDoors> zolPerDoorsList =
                zolPerDoorsService.findZolPerDoorsBetweenTwoDates(start, end);
        List<Netsuite> netsuiteList =
                netsuiteService.findNetsuiteSalesAmountAndUnitBetweenTwoDates(start, end);

        DispensingDistributorCalculator dispensingDistributorCalculator =
                generateDispensingDistributorCalculator(dispensingDistributorList, productCodeList);
        ZolMdcPerBranchCalculator zolMdcPerBranchCalculator =
                generateZolMdcPerBranchCalculator(zolMdcPerBranchList, productCodeList);
        ZolMtPerBranchCalculator zolMtPerBranchCalculator =
                generateZolMtPerBranchCalculator(zolMtPerBranchList, productCodeList);
        ZolPerDoorsCalculator zolPerDoorsCalculator =
                generateZolPerDoorsCalculator(zolPerDoorsList, productCodeList);
        NetsuiteCalculator netsuiteLazadaCalculator =
                generateNetsuiteLazadaCalculator(netsuiteList, productCodeList, "Lazada");
        NetsuiteCalculator netsuiteBbjCalculator =
                generateNetsuiteLazadaCalculator(netsuiteList, productCodeList, "BBJ");

        model.addAttribute("yearMonthStart", yearMonthStart);
        model.addAttribute("yearMonthEnd", yearMonthEnd);
        model.addAttribute("yearMonthList", yearMonthList);
        model.addAttribute("products", productList);
        model.addAttribute("channels", ChannelUtils.getChannels());
        model.addAttribute("dispensingDistributorCalculator", dispensingDistributorCalculator);
        model.addAttribute("zolMdcPerBranchCalculator", zolMdcPerBranchCalculator);
        model.addAttribute("zolMtPerBranchCalculator", zolMtPerBranchCalculator);
        model.addAttribute("zolPerDoorsCalculator", zolPerDoorsCalculator);
        model.addAttribute("netsuiteLazadaCalculator", netsuiteLazadaCalculator);
        model.addAttribute("netsuiteBbjCalculator", netsuiteBbjCalculator);

        return "demand/hipp-market-sales-summary";
    }

    private DispensingDistributorCalculator generateDispensingDistributorCalculator(
            List<DispensingDistributor> dispensingDistributorList, List<String> productList) {
        DispensingDistributorCalculator dispensingDistributorCalculator =
                new DispensingDistributorCalculator(dispensingDistributorList, productList);
        return dispensingDistributorCalculator;
    }

    private ZolMdcPerBranchCalculator generateZolMdcPerBranchCalculator(List<ZolMdcPerBranch> zolMdcPerBranchList,
                                                                        List<String> productList) {
        ZolMdcPerBranchCalculator zolMdcPerBranchCalculator = new ZolMdcPerBranchCalculator(zolMdcPerBranchList, productList);
        return zolMdcPerBranchCalculator;
    }

    private ZolMtPerBranchCalculator generateZolMtPerBranchCalculator(List<ZolMtPerBranch> zolMtPerBranchList,
                                                                      List<String> productList) {
        ZolMtPerBranchCalculator zolMtPerBranchCalculator = new ZolMtPerBranchCalculator(
                zolMtPerBranchList, productList);
        return zolMtPerBranchCalculator;
    }

    private ZolPerDoorsCalculator generateZolPerDoorsCalculator(List<ZolPerDoors> zolPerDoorsList,
                                                                List<String> productList) {
        ZolPerDoorsCalculator zolPerDoorsCalculator = new ZolPerDoorsCalculator(
                zolPerDoorsList, productList);
        return zolPerDoorsCalculator;
    }

    private NetsuiteCalculator generateNetsuiteLazadaCalculator(List<Netsuite> netsuiteList,
                                                                List<String> productList, String kamReferenceNameFilter) {
        return new NetsuiteCalculator(netsuiteList, productList, kamReferenceNameFilter);
    }

}
