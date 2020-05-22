package ph.edu.up.antech.controller.view.demand;

import ph.edu.up.antech.domain.master.Netsuite;

import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NetsuiteCalculator {

    public List<Netsuite> netsuiteList;

    public NetsuiteCalculator(List<Netsuite> netsuiteList, List<String> productList,
                              NetsuiteChannel netsuiteChannel) {
        this.netsuiteList = netsuiteList.stream()
                .filter(netsuite -> Objects.nonNull(netsuite.getKamRefName1()))
                .filter(netsuite -> Objects.nonNull(netsuite.getBrand()))
                .filter(netsuite -> Objects.nonNull(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> Objects.nonNull(netsuite.getRevenueConverted()))
                .filter(netsuite -> Objects.nonNull(netsuite.getConvUnits()))
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .filter(netsuite -> {
                    switch (netsuiteChannel) {
                        case IN_MARKET_DISPENSING_DISTRIBUTOR:
                            return netsuite.getMgmt().contains("Dispensing MD");
                        case IN_MARKET_BBJ:
                            return netsuite.getMgmt().contains("Home Delivery");
                        case IN_MARKET_DIRECT_ACCTS:
                            return netsuite.getKamRefName1().contains("Marjonken Corp")
                                    || netsuite.getKamRefName1().contains("St Francis")
                                    || netsuite.getKamRefName1().contains("Tiongsan Supermarket")
                                    || netsuite.getKamRefName1().contains("AFPCES");
                        case IN_MARKET_LAZADA:
                            return netsuite.getKamRefName1().contains("Lazada");
                        case TO_MARKET_ZPC:
                            return netsuite.getKamRefName1().contains("ZPC");
                        case TO_MARKET_BBJ:
                            return netsuite.getKamRefName1().contains("BBJ");
                        case TO_MARKET_DISPENSING_DISTRIBUTOR:
                            return netsuite.getMgmt().contains("Dispensing MD")
                                    || netsuite.getKamRefName1().contains("Blocs")
                                    || netsuite.getKamRefName1().contains("JAC2010")
                                    || netsuite.getKamRefName1().contains("Vaximax")
                                    || netsuite.getKamRefName1().contains("ZRN BIOCORE CEBU")
                                    || netsuite.getKamRefName1().contains("ZRN BIOCORE CDO")
                                    || netsuite.getKamRefName1().contains("MAGGOT Pharma Trading")
                                    || netsuite.getKamRefName1().contains("St. Raphael Lifeline Co.");
                        case TO_MARKET_OTHERS:
                            return true;
                        default:
                            return true;
                    }
                })
                .collect(Collectors.toList());
    }

    public Integer calculateSalesAmountByYearMonthAndProductCode(YearMonth yearMonth, String productCode) {
        return netsuiteList.stream()
                .filter(netsuite -> YearMonth.from(netsuite.getItemDate()).equals(yearMonth))
                .filter(netsuite -> netsuite.getBrand().equals(productCode))
                .mapToInt(netsuiteList -> netsuiteList.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateSalesAmountByYearMonth(YearMonth yearMonth) {
        return netsuiteList.stream()
                .filter(netsuite -> YearMonth.from(netsuite.getItemDate()).equals(yearMonth))
                .mapToInt(netsuiteList -> netsuiteList.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateSalesUnitByYearMonthAndProductCode(YearMonth yearMonth, String productCode) {
        return netsuiteList.stream()
                .filter(netsuite -> YearMonth.from(netsuite.getItemDate()).equals(yearMonth))
                .filter(netsuite -> netsuite.getBrand().equals(productCode))
                .mapToInt(netsuiteList -> netsuiteList.getConvUnits())
                .sum();
    }

    public Integer calculateSalesUnitByYearMonth(YearMonth yearMonth) {
        return netsuiteList.stream()
                .filter(netsuite -> YearMonth.from(netsuite.getItemDate()).equals(yearMonth))
                .mapToInt(netsuiteList -> netsuiteList.getConvUnits())
                .sum();
    }

}
