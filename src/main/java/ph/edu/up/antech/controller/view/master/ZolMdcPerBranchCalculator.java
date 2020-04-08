package ph.edu.up.antech.controller.view.master;

import ph.edu.up.antech.domain.master.ZolMdcPerBranch;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ZolMdcPerBranchCalculator {

    private List<ZolMdcPerBranch> zolMdcPerBranchList;

    public ZolMdcPerBranchCalculator(List<ZolMdcPerBranch> zolMdcPerBranchList) {
        this.zolMdcPerBranchList = zolMdcPerBranchList;
    }

    public Integer calculateSalesUnit() {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> Objects.nonNull(zolMdcPerBranch.getSalesUnit()))
                .mapToInt(ZolMdcPerBranch::getSalesUnit)
                .sum();
    }

    public BigDecimal calculateSalesValue() {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> Objects.nonNull(zolMdcPerBranch.getSalesValue()))
                .map(ZolMdcPerBranch::getSalesValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateAntechPrice() {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> Objects.nonNull(zolMdcPerBranch.getAntechPrice()))
                .map(ZolMdcPerBranch::getAntechPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer calculateAmount() {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> Objects.nonNull(zolMdcPerBranch.getAmount()))
                .mapToInt(zolMdcPerBranch -> zolMdcPerBranch.getAmount())
                .sum();
    }

    public Integer calculateAmountConverted() {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> Objects.nonNull(zolMdcPerBranch.getAmountConverted()))
                .mapToInt(ZolMdcPerBranch::getAmountConverted)
                .sum();
    }

    public BigDecimal calculateSecondDiscount() {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> Objects.nonNull(zolMdcPerBranch.getLess00375Percent()))
                .map(ZolMdcPerBranch::getLess00375Percent)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateV1() {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> Objects.nonNull(zolMdcPerBranch.getV1()))
                .map(ZolMdcPerBranch::getV1)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateFirstDiscount() {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> Objects.nonNull(zolMdcPerBranch.getLess0853Percent()))
                .map(ZolMdcPerBranch::getLess0853Percent)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateV2() {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> Objects.nonNull(zolMdcPerBranch.getV2()))
                .map(ZolMdcPerBranch::getV2)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateFinalAmount() {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> Objects.nonNull(zolMdcPerBranch.getFinalAmount()))
                .map(ZolMdcPerBranch::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateAmountTimesOneThousand() {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> Objects.nonNull(zolMdcPerBranch.getAmountTimesOneThousand()))
                .map(ZolMdcPerBranch::getAmountTimesOneThousand)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer calculateA() {
        return zolMdcPerBranchList.stream()
                .filter(zolMdcPerBranch -> Objects.nonNull(zolMdcPerBranch.getA()))
                .mapToInt(ZolMdcPerBranch::getA)
                .sum();
    }

}
