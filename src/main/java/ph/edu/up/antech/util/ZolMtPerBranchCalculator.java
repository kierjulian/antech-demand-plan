package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.master.ZolMtPerBranch;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

public class ZolMtPerBranchCalculator {

    private List<ZolMtPerBranch> zolMtPerBranchList;
    private List<String> products;

    public ZolMtPerBranchCalculator(List<ZolMtPerBranch> zolMtPerBranchList, List<String> products) {
        this.zolMtPerBranchList = zolMtPerBranchList;
        this.products = products;
    }

    public BigDecimal getTotalFinalAmountByYearMonthAndProduct(YearMonth yearMonth, String productCode) {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> YearMonth.from(zolMtPerBranch.getDate()).equals(yearMonth))
                .filter(zolMtPerBranch -> zolMtPerBranch.getAntechProductDescription() != null)
                .filter(zolMtPerBranch -> zolMtPerBranch.getAntechProductDescription().equals(productCode))
                .map(ZolMtPerBranch::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalFinalAmountByYearMonth(YearMonth yearMonth) {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> YearMonth.from(zolMtPerBranch.getDate()).equals(yearMonth))
                .filter(zolMtPerBranch -> zolMtPerBranch.getAntechProductDescription() != null)
                .filter(zolMtPerBranch -> products.contains(zolMtPerBranch.getAntechProductDescription()))
                .map(ZolMtPerBranch::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
