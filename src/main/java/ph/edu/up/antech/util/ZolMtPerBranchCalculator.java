package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.master.ZolMtPerBranch;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

public class ZolMtPerBranchCalculator {

    private List<ZolMtPerBranch> zolMtPerBranchList;

    public ZolMtPerBranchCalculator(List<ZolMtPerBranch> zolMtPerBranchList, List<String> productList) {
        this.zolMtPerBranchList = zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> productList.contains(zolMtPerBranch.getAntechProductDescription()))
                .collect(Collectors.toList());
    }

    public BigDecimal getTotalFinalAmountByYearMonthAndProduct(YearMonth yearMonth, String productCode) {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> YearMonth.from(zolMtPerBranch.getDate()).equals(yearMonth))
                .filter(zolMtPerBranch -> zolMtPerBranch.getAntechProductDescription().equals(productCode))
                .map(ZolMtPerBranch::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalFinalAmountByYearMonth(YearMonth yearMonth) {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> YearMonth.from(zolMtPerBranch.getDate()).equals(yearMonth))
                .map(ZolMtPerBranch::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer getTotalUnitsByYearMonthAndProductCode(YearMonth yearMonth, String productCode) {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> YearMonth.from(zolMtPerBranch.getDate()).equals(yearMonth))
                .filter(zolMtPerBranch -> zolMtPerBranch.getAntechProductDescription().equals(productCode))
                .mapToInt(ZolMtPerBranch::getSalesUnit)
                .sum();
    }

    public Integer getTotalUnitsByYearMonth(YearMonth yearMonth) {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> YearMonth.from(zolMtPerBranch.getDate()).equals(yearMonth))
                .mapToInt(ZolMtPerBranch::getSalesUnit)
                .sum();
    }

}
