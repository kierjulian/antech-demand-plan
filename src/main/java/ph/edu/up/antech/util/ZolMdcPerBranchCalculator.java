package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.master.ZolMdcPerBranch;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

public class ZolMdcPerBranchCalculator {

    private List<ZolMdcPerBranch> zolMdcPerBranchList;
    private List<String> productList;

    public ZolMdcPerBranchCalculator(List<ZolMdcPerBranch> zolMdcPerBranchList,
                                     List<String> productList) {
        this.zolMdcPerBranchList = zolMdcPerBranchList;
        this.productList = productList;
    }

    public BigDecimal getTotalFinalAmountPerYearMonthPerProduct(YearMonth yearMonth, String productCode) {
        return zolMdcPerBranchList.stream()
                .filter(mdcPerBranchSales -> YearMonth.from(mdcPerBranchSales.getDate()).equals(yearMonth))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getAntechProductDescription() != null)
                .filter(mdcPerBranchSales -> mdcPerBranchSales.getAntechProductDescription().equals(productCode))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getFinalAmount() != null)
                .map(ZolMdcPerBranch::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalFinalAmountPerYearMonth(YearMonth yearMonth) {
        return zolMdcPerBranchList.stream()
                .filter(mdcPerBranchSales -> YearMonth.from(mdcPerBranchSales.getDate()).equals(yearMonth))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getAntechProductDescription() != null)
                .filter(zolMdcPerBranch -> productList.contains(zolMdcPerBranch.getAntechProductDescription()))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getFinalAmount() != null)
                .map(ZolMdcPerBranch::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer getTotalUnitsByYearMonthByProduct(YearMonth yearMonth, String productCode) {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> YearMonth.from(zolMdcPerBranch.getDate()).equals(yearMonth))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getAntechProductDescription() != null)
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getAntechProductDescription().equals(productCode))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getSalesUnit() != null)
                .mapToInt(ZolMdcPerBranch::getSalesUnit)
                .sum();
    }

    public Integer getTotalUnitsByYearMonth(YearMonth yearMonth) {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> YearMonth.from(zolMdcPerBranch.getDate()).equals(yearMonth))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getAntechProductDescription() != null)
                .filter(zolMdcPerBranch -> productList.contains(zolMdcPerBranch.getAntechProductDescription()))
                .filter(zolMdcPerBranch -> zolMdcPerBranch.getSalesUnit() != null)
                .mapToInt(ZolMdcPerBranch::getSalesUnit)
                .sum();
    }

}
