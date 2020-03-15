package ph.edu.up.antech.controller.view.demand;

import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DispensingDistributorCalculator {

    private List<DispensingDistributor> dispensingDistributorList;

    public DispensingDistributorCalculator(List<DispensingDistributor> dispensingDistributorList, List<String> productList) {
        this.dispensingDistributorList = dispensingDistributorList.stream()
                .filter(dispensingDistributor -> productList.contains(dispensingDistributor.getItemKey()))
                .filter(dispensingDistributor -> Objects.nonNull(dispensingDistributor.getFinalAmount()))
                .filter(dispensingDistributor -> Objects.nonNull(dispensingDistributor.getUnits()))
                .collect(Collectors.toList());
    }

    public BigDecimal calculateSalesAmountByYearMonthAndProductCode(YearMonth yearMonth, String productCode) {
        return dispensingDistributorList.stream()
                .filter(dispensingDistributor -> YearMonth.from(dispensingDistributor.getDate()).equals(yearMonth))
                .filter(dispensingDistributor -> dispensingDistributor.getItemKey().equals(productCode))
                .map(DispensingDistributor::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateSalesAmountByYearMonth(YearMonth yearMonth) {
        return dispensingDistributorList.stream()
                .filter(dispensingDistributor -> YearMonth.from(dispensingDistributor.getDate()).equals(yearMonth))
                .map(DispensingDistributor::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer calculateSalesUnitByYearMonthAndProductCode(YearMonth yearMonth, String product) {
        return dispensingDistributorList.stream()
                .filter(dispensingDistributor -> YearMonth.from(dispensingDistributor.getDate()).equals(yearMonth))
                .filter(dispensingDistributor -> dispensingDistributor.getItemKey().equals(product))
                .mapToInt(DispensingDistributor::getUnits)
                .sum();
    }

    public Integer calculateSalesUnitByYearMonth(YearMonth yearMonth) {
        return dispensingDistributorList.stream()
                .filter(dispensingDistributor -> YearMonth.from(dispensingDistributor.getDate()).equals(yearMonth))
                .mapToInt(DispensingDistributor::getUnits)
                .sum();
    }

}
