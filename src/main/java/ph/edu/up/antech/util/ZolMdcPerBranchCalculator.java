package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.master.ZolMdcPerBranch;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

public class ZolMdcPerBranchCalculator {

    private List<ZolMdcPerBranch> zolMdcPerBranchList;

    public ZolMdcPerBranchCalculator(List<ZolMdcPerBranch> zolMdcPerBranchList,
                                     List<String> productList) {
        this.zolMdcPerBranchList = zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> productList.contains(zolMdcPerBranch.getAntechProductDescription()))
                .collect(Collectors.toList());
    }

    public BigDecimal getTotalFinalAmountPerYearMonthPerProduct(YearMonth yearMonth, String productCode) {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> YearMonth.from(zolMdcPerBranch.getDate()).equals(yearMonth))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getAntechProductDescription().equals(productCode))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getFinalAmount() != null)
                .map(ZolMdcPerBranch::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalFinalAmountPerYearMonth(YearMonth yearMonth) {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> YearMonth.from(zolMdcPerBranch.getDate()).equals(yearMonth))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getFinalAmount() != null)
                .map(ZolMdcPerBranch::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer getTotalUnitsByYearMonthByProduct(YearMonth yearMonth, String productCode) {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> YearMonth.from(zolMdcPerBranch.getDate()).equals(yearMonth))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getAntechProductDescription().equals(productCode))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getSalesUnit() != null)
                .mapToInt(ZolMdcPerBranch::getSalesUnit)
                .sum();
    }

    public Integer getTotalUnitsByYearMonth(YearMonth yearMonth) {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> YearMonth.from(zolMdcPerBranch.getDate()).equals(yearMonth))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getSalesUnit() != null)
                .mapToInt(ZolMdcPerBranch::getSalesUnit)
                .sum();
    }

}
