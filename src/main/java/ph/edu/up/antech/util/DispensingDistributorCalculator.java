package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

public class DispensingDistributorCalculator {

    private List<DispensingDistributor> dispensingDistributorList;
    private List<String> productList;

    public DispensingDistributorCalculator(List<DispensingDistributor> dispensingDistributorList, List<String> productList) {
        this.dispensingDistributorList = dispensingDistributorList;
        this.productList = productList;
    }

    public BigDecimal getTotalFinalAmountPerYearMonthPerProduct(YearMonth yearMonth, String productCode) {
        return dispensingDistributorList.stream()
                .filter(dispensingDistributor -> YearMonth.from(dispensingDistributor.getDate()).equals(yearMonth))
                .filter(dispensingDistributor -> dispensingDistributor.getItemKey().equals(productCode))
                .filter(dispensingDistributor -> dispensingDistributor.getFinalAmount() != null)
                .map(DispensingDistributor::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalFinalAmountPerYearMonth(YearMonth yearMonth) {
        return dispensingDistributorList.stream()
                .filter(dispensingDistributor -> YearMonth.from(dispensingDistributor.getDate()).equals(yearMonth))
                .filter(dispensingDistributor -> productList.contains(dispensingDistributor.getItemKey()))
                .filter(dispensingDistributor -> dispensingDistributor.getFinalAmount() != null)
                .map(DispensingDistributor::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer getTotalUnitsByYearMonthByProduct(YearMonth yearMonth, String product) {
        return dispensingDistributorList.stream()
                .filter(dispensingDistributor -> YearMonth.from(dispensingDistributor.getDate()).equals(yearMonth))
                .filter(dispensingDistributor -> dispensingDistributor.getItemKey().equals(product))
                .filter(dispensingDistributor -> dispensingDistributor.getUnits() != null)
                .mapToInt(DispensingDistributor::getUnits)
                .sum();
    }

    public Integer getTotalUnitsByYearMonth(YearMonth yearMonth) {
        return dispensingDistributorList.stream()
                .filter(dispensingDistributor -> YearMonth.from(dispensingDistributor.getDate()).equals(yearMonth))
                .filter(dispensingDistributor -> productList.contains(dispensingDistributor.getItemKey()))
                .filter((dispensingDistributor -> dispensingDistributor.getUnits() != null))
                .mapToInt(DispensingDistributor::getUnits)
                .sum();
    }

}
