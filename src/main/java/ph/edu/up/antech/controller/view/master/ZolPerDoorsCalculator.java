package ph.edu.up.antech.controller.view.master;

import ph.edu.up.antech.domain.sales.master.ZolPerDoors;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ZolPerDoorsCalculator {

    private List<ZolPerDoors> zolPerDoorsList;

    public ZolPerDoorsCalculator(List<ZolPerDoors> zolPerDoorsList) {
        this.zolPerDoorsList = zolPerDoorsList;
    }

    public Integer calculateSalesUnit() {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getSalesUnit()))
                .mapToInt(ZolPerDoors::getSalesUnit)
                .sum();
    }

    public BigDecimal calculateSalesValue() {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getSalesValue()))
                .map(ZolPerDoors::getSalesValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateAntechPrice() {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getAntechPrice()))
                .map(ZolPerDoors::getAntechPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer calculateAmount() {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getAmount()))
                .mapToInt(ZolPerDoors::getAmount)
                .sum();
    }

    public Integer calculateAmountConverted() {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getAmountConverted()))
                .mapToInt(ZolPerDoors::getAmountConverted)
                .sum();
    }

    public BigDecimal calculateFirstDiscount() {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getLess00375Percent()))
                .map(ZolPerDoors::getLess00375Percent)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateV1() {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getV1()))
                .map(ZolPerDoors::getV1)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateSecondDiscount() {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getLess0853Percent()))
                .map(ZolPerDoors::getLess0853Percent)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateV2() {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getV2()))
                .map(ZolPerDoors::getV2)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateFinalAmount() {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getFinalAmount()))
                .map(ZolPerDoors::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateAmountTimesOneThousand() {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getAmountTimesOneThousand()))
                .map(ZolPerDoors::getAmountTimesOneThousand)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer calculateA() {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> Objects.nonNull(zolPerDoors.getA()))
                .mapToInt(ZolPerDoors::getA)
                .sum();
    }

}
