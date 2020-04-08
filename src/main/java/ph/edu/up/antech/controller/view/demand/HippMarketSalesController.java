package ph.edu.up.antech.controller.view.demand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.domain.master.Netsuite;
import ph.edu.up.antech.domain.master.ZolPerDoors;
import ph.edu.up.antech.domain.raw.DispensingDistributor;
import ph.edu.up.antech.service.DispensingDistributorService;
import ph.edu.up.antech.service.NetsuiteService;
import ph.edu.up.antech.service.ProductService;
import ph.edu.up.antech.service.ZolPerDoorsService;
import ph.edu.up.antech.util.*;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
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

        List<ZolPerDoors> zolPerDoorsList =
                zolPerDoorsService.findZolPerDoorsSalesAmountAndUnitBetweenTwoDates(start, end);
        List<Netsuite> netsuiteList =
                netsuiteService.findNetsuiteSalesAmountAndUnitBetweenTwoDates(start, end);
        List<DispensingDistributor> dispensingDistributorList =
                dispensingDistributorService.findDispensingDistributorSalesAmountAndUnitBetweenTwoDates(start, end);

        ZolPerDoorsCalculator zolPerDoorsMercuryDrugCorpCalculator =
                new ZolPerDoorsCalculator(zolPerDoorsList, productCodeList, ZolPerDoorsChannel.MDC);
        ZolPerDoorsCalculator zolPerDoorsGmaCalculator =
                new ZolPerDoorsCalculator(zolPerDoorsList, productCodeList, ZolPerDoorsChannel.ZPC_GMA);
        ZolPerDoorsCalculator zolPerDoorsVisayasCalculator =
                new ZolPerDoorsCalculator(zolPerDoorsList, productCodeList, ZolPerDoorsChannel.ZPC_VIS);
        ZolPerDoorsCalculator zolPerDoorsMindanaoCalculator =
                new ZolPerDoorsCalculator(zolPerDoorsList, productCodeList, ZolPerDoorsChannel.ZPC_MIN);
        NetsuiteCalculator netsuiteDispensingDistributorCalculator = new NetsuiteCalculator(netsuiteList,
                productCodeList, NetsuiteChannel.IN_MARKET_DISPENSING_DISTRIBUTOR);
        NetsuiteCalculator netsuiteBbjCalculator = new NetsuiteCalculator(netsuiteList, productCodeList, NetsuiteChannel.IN_MARKET_BBJ);
        NetsuiteCalculator netsuiteDirectAcctCalculator = new NetsuiteCalculator(netsuiteList, productCodeList, NetsuiteChannel.IN_MARKET_DIRECT_ACCTS);
        NetsuiteCalculator netsuiteLazadaCalculator = new NetsuiteCalculator(netsuiteList, productCodeList, NetsuiteChannel.IN_MARKET_LAZADA);
        DispensingDistributorCalculator dispensingDistributorCalculator =
                generateDispensingDistributorCalculator(dispensingDistributorList, productCodeList);

        NetsuiteCalculator netsuiteZpcDpCalculator = new NetsuiteCalculator(netsuiteList, productCodeList, NetsuiteChannel.TO_MARKET_ZPC);
        NetsuiteCalculator netsuiteToMarketBbjCalculator = new NetsuiteCalculator(netsuiteList, productCodeList, NetsuiteChannel.TO_MARKET_BBJ);
        NetsuiteCalculator netsuiteToMarketDispensingDistributorCalculator = new NetsuiteCalculator(netsuiteList, productCodeList, NetsuiteChannel.TO_MARKET_DISPENSING_DISTRIBUTOR);

        InMarketProductCalculator inMarketProductCalculator =
                new InMarketProductCalculator(zolPerDoorsMercuryDrugCorpCalculator, zolPerDoorsGmaCalculator, zolPerDoorsVisayasCalculator,
                        zolPerDoorsMindanaoCalculator, netsuiteDispensingDistributorCalculator, netsuiteBbjCalculator,
                        netsuiteDirectAcctCalculator, netsuiteLazadaCalculator);
        ToMarketProductCalculator toMarketProductCalculator = new ToMarketProductCalculator(
                netsuiteZpcDpCalculator, netsuiteToMarketDispensingDistributorCalculator, netsuiteToMarketBbjCalculator,
                netsuiteDirectAcctCalculator, netsuiteLazadaCalculator);

        model.addAttribute("yearMonthStart", yearMonthStart);
        model.addAttribute("yearMonthEnd", yearMonthEnd);
        model.addAttribute("yearMonthList", yearMonthList);
        model.addAttribute("products", productList);

        model.addAttribute("zolPerDoorsMercuryDrugCorpCalculator", zolPerDoorsMercuryDrugCorpCalculator);
        model.addAttribute("zolPerDoorsGmaCalculator", zolPerDoorsGmaCalculator);
        model.addAttribute("zolPerDoorsVisayasCalculator", zolPerDoorsVisayasCalculator);
        model.addAttribute("zolPerDoorsMindanaoCalculator", zolPerDoorsMindanaoCalculator);
        model.addAttribute("netsuiteDispensingDistributorCalculator", netsuiteDispensingDistributorCalculator);
        model.addAttribute("netsuiteBbjCalculator", netsuiteBbjCalculator);
        model.addAttribute("netsuiteDirectAcctCalculator", netsuiteDirectAcctCalculator);
        model.addAttribute("netsuiteLazadaCalculator", netsuiteLazadaCalculator);
        model.addAttribute("dispensingDistributorCalculator", dispensingDistributorCalculator);
        model.addAttribute("inMarketProductCalculator", inMarketProductCalculator);

        model.addAttribute("netsuiteToMarketDispensingDistributorCalculator", netsuiteToMarketDispensingDistributorCalculator);
        model.addAttribute("netsuiteZpcDpCalculator", netsuiteZpcDpCalculator);
        model.addAttribute("netsuiteToMarketBbjCalculator", netsuiteToMarketBbjCalculator);
        model.addAttribute("toMarketProductCalculator", toMarketProductCalculator);

        return "demand/hipp-market-sales-summary";
    }

    private DispensingDistributorCalculator generateDispensingDistributorCalculator(
            List<DispensingDistributor> dispensingDistributorList, List<String> productList) {
        return new DispensingDistributorCalculator(dispensingDistributorList, productList);
    }

}
