package ph.edu.up.antech.controller.view.master;

import ph.edu.up.antech.domain.sales.master.ZolMtPerBranch;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ZolMtPerBranchCalculator {

    private List<ZolMtPerBranch> zolMtPerBranchList;

    public ZolMtPerBranchCalculator(List<ZolMtPerBranch> zolMtPerBranchList) {
        this.zolMtPerBranchList = zolMtPerBranchList;
    }

    public Integer calculateSalesUnit() {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> Objects.nonNull(zolMtPerBranch.getSalesUnit()))
                .mapToInt(ZolMtPerBranch::getSalesUnit)
                .sum();
    }

    public BigDecimal calculateSalesValue() {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> Objects.nonNull(zolMtPerBranch.getSalesValue()))
                .map(ZolMtPerBranch::getSalesValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateAntechPrice() {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> Objects.nonNull(zolMtPerBranch.getAntechPrice()))
                .map(ZolMtPerBranch::getAntechPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer calculateAmount() {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> Objects.nonNull(zolMtPerBranch.getAmount()))
                .mapToInt(ZolMtPerBranch::getAmount)
                .sum();
    }

    public Integer calculateAmountConverted() {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> Objects.nonNull(zolMtPerBranch.getAmountConverted()))
                .mapToInt(ZolMtPerBranch::getAmountConverted)
                .sum();
    }

    public BigDecimal calculateSecondDiscount() {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> Objects.nonNull(zolMtPerBranch.getLess00375Percent()))
                .map(ZolMtPerBranch::getLess00375Percent)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateV1() {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> Objects.nonNull(zolMtPerBranch.getV1()))
                .map(ZolMtPerBranch::getV1)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateFirstDiscount() {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> Objects.nonNull(zolMtPerBranch.getLess0853Percent()))
                .map(ZolMtPerBranch::getLess0853Percent)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateV2() {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> Objects.nonNull(zolMtPerBranch.getV2()))
                .map(ZolMtPerBranch::getV2)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateFinalAmount() {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> Objects.nonNull(zolMtPerBranch.getFinalAmount()))
                .map(ZolMtPerBranch::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateAmountTimesOneThousand() {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> Objects.nonNull(zolMtPerBranch.getAmountTimesOneThousand()))
                .map(ZolMtPerBranch::getAmountTimesOneThousand)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer calculateA() {
        return zolMtPerBranchList.stream()
                .filter(zolMtPerBranch -> Objects.nonNull(zolMtPerBranch.getA()))
                .mapToInt(ZolMtPerBranch::getA)
                .sum();
    }

}
