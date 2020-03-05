package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.master.ZolPerDoors;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

public class ZolPerDoorsCalculator {

    private List<ZolPerDoors> zolPerDoorsList;

    public ZolPerDoorsCalculator(List<ZolPerDoors> zolPerDoorsList, List<String> productList) {
        this.zolPerDoorsList = zolPerDoorsList.stream()
                .filter(zolPerDoors -> productList.contains(zolPerDoors.getAntechProductDescription()))
                .collect(Collectors.toList());
    }

    public BigDecimal getTotalFinalAmountByYearMonthAndProduct(YearMonth yearMonth, String product) {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> YearMonth.from(zolPerDoors.getDate()).equals(yearMonth))
                .filter(zolPerDoors -> zolPerDoors.getAntechProductDescription().equals(product))
                .map(ZolPerDoors::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalFinalAmountByYearMonth(YearMonth yearMonth) {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> YearMonth.from(zolPerDoors.getDate()).equals(yearMonth))
                .map(ZolPerDoors::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer getTotalUnitsByYearMonthAndProductCode(YearMonth yearMonth, String productCode) {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> YearMonth.from(zolPerDoors.getDate()).equals(yearMonth))
                .filter(zolPerDoors -> zolPerDoors.getAntechProductDescription().equals(productCode))
                .mapToInt(ZolPerDoors::getSalesUnit)
                .sum();
    }

    public Integer getTotalUnitsByYearMonth(YearMonth yearMonth) {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> YearMonth.from(zolPerDoors.getDate()).equals(yearMonth))
                .mapToInt(ZolPerDoors::getSalesUnit)
                .sum();
    }

}
