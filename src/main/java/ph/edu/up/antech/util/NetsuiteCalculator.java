package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.master.Netsuite;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

public class NetsuiteCalculator {

    public List<Netsuite> netsuiteList;

    public NetsuiteCalculator(List<Netsuite> netsuiteList, List<String> productList,
                              String kamReferenceNameFilter) {
        this.netsuiteList = netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getTransfersCatRecode() != null)
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equalsIgnoreCase(kamReferenceNameFilter))
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
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

}
