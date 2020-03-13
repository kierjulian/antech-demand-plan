package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.master.Netsuite;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

public class NetsuiteCalculator {

    public List<Netsuite> netsuiteList;

    public NetsuiteCalculator(List<Netsuite> netsuiteList, List<String> productList,
                              NetsuiteChannel netsuiteChannel) {
        this.netsuiteList = netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getTransfersCatRecode() != null)
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .filter(netsuite -> netsuite.getQuantity() != null)
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .filter(netsuite -> {
                    switch (netsuiteChannel) {
                        case DISPENSING_DISTRIBUTOR:
                            return netsuite.getMgmt().contains("Dispensing MD");
                        case BBJ:
                            return netsuite.getMgmt().contains("Home Delivery");
                        case DIRECT_ACCTS:
                            return netsuite.getKamRefName1().contains("Marjonken")
                                    || netsuite.getKamRefName1().contains("St Francis")
                                    || netsuite.getKamRefName1().contains("Tiongsan");
                        case LAZADA:
                            return netsuite.getKamRefName1().contains("Lazada");
                        case TO_MARKET_ZPC:
                            return netsuite.getKamRefName1().contains("ZPC");
                        case TO_MARKET_BBJ:
                            return netsuite.getKamRefName1().contains("BBJ");
                        case TO_MARKET_DISPENSING_DISTRIBUTOR:
                            return netsuite.getMgmt().contains("Dispensing MD");
                        default:
                            return true;
                    }
                })
                .collect(Collectors.toList());
    }

    public Integer getTotalAmountByYearMonthByProduct(YearMonth yearMonth, String productCode) {
        return netsuiteList.stream()
                .filter(netsuite -> YearMonth.from(netsuite.getItemDate()).equals(yearMonth))
                .filter(netsuite -> netsuite.getBrand().equals(productCode))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getRevenueConverted() != null)
                .mapToInt(netsuiteList -> netsuiteList.getRevenueConverted().intValue())
                .sum();
    }

    public Integer getTotalAmountByYearMonth(YearMonth yearMonth) {
        return netsuiteList.stream()
                .filter(netsuite -> YearMonth.from(netsuite.getItemDate()).equals(yearMonth))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getRevenueConverted() != null)
                .mapToInt(netsuiteList -> netsuiteList.getRevenueConverted().intValue())
                .sum();
    }

    public Integer getTotalUnitsByYearMonthByProduct(YearMonth yearMonth, String productCode) {
        return netsuiteList.stream()
                .filter(netsuite -> YearMonth.from(netsuite.getItemDate()).equals(yearMonth))
                .filter(netsuite -> netsuite.getBrand().equals(productCode))
                .mapToInt(netsuiteList -> netsuiteList.getQuantity())
                .sum();
    }

    public Integer getTotalUnitsByYearMonth(YearMonth yearMonth) {
        return netsuiteList.stream()
                .filter(netsuite -> YearMonth.from(netsuite.getItemDate()).equals(yearMonth))
                .mapToInt(netsuiteList -> netsuiteList.getQuantity())
                .sum();
    }

}
