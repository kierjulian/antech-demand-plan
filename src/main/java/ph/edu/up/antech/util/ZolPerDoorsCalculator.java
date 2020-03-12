package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.master.ZolPerDoors;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

public class ZolPerDoorsCalculator {

    private List<ZolPerDoors> zolPerDoorsList;

    public ZolPerDoorsCalculator(List<ZolPerDoors> zolPerDoorsList, List<String> productList,
                                 ZolPerDoorsChannel zolPerDoorsChannel) {
        this.zolPerDoorsList = zolPerDoorsList.stream()
                .filter(zolPerDoors -> productList.contains(zolPerDoors.getAntechProductDescription()))
                .filter(zolPerDoors -> {
                    switch (zolPerDoorsChannel) {
                        case MDC:
                            return zolPerDoors.getAccount().contains("MERCURY");
                        case ZPC_GMA:
                            return !zolPerDoors.getKamReferenceName().contains("Vis")
                                    && !zolPerDoors.getKamReferenceName().contains("Min")
                                    && !zolPerDoors.getAccount().contains("MERCURY");
                        case ZPC_VIS:
                            return zolPerDoors.getKamReferenceName().contains("Vis");
                        case ZPC_MIN:
                            return zolPerDoors.getKamReferenceName().contains("Min");
                        default:
                            return true;
                    }
                })
                .collect(Collectors.toList());
    }

    public Integer getSalesAmountByYearMonthAndProduct(YearMonth yearMonth, String product) {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> YearMonth.from(zolPerDoors.getDate()).equals(yearMonth))
                .filter(zolPerDoors -> zolPerDoors.getAntechProductDescription().equals(product))
                .mapToInt(ZolPerDoors::getAmount)
                .sum();
    }

    public Integer getSalesAmountByYearMonth(YearMonth yearMonth) {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> YearMonth.from(zolPerDoors.getDate()).equals(yearMonth))
                .mapToInt(ZolPerDoors::getAmount)
                .sum();
    }

    public Integer getSalesUnitByYearMonthAndProductCode(YearMonth yearMonth, String productCode) {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> YearMonth.from(zolPerDoors.getDate()).equals(yearMonth))
                .filter(zolPerDoors -> zolPerDoors.getAntechProductDescription().equals(productCode))
                .mapToInt(ZolPerDoors::getSalesUnit)
                .sum();
    }

    public Integer getSalesUnitByYearMonth(YearMonth yearMonth) {
        return zolPerDoorsList.stream()
                .filter(zolPerDoors -> YearMonth.from(zolPerDoors.getDate()).equals(yearMonth))
                .mapToInt(ZolPerDoors::getSalesUnit)
                .sum();
    }

}
