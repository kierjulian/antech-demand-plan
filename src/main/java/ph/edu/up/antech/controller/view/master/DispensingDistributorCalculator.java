package ph.edu.up.antech.controller.view.master;

import ph.edu.up.antech.domain.raw.DispensingDistributor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class DispensingDistributorCalculator {

    private List<DispensingDistributor> dispensingDistributorList;

    public DispensingDistributorCalculator(List<DispensingDistributor> dispensingDistributorList) {
        this.dispensingDistributorList = dispensingDistributorList;
    }

    public BigDecimal calculatePrice() {
        return dispensingDistributorList.stream()
                .filter(dispensingDistributor -> Objects.nonNull(dispensingDistributor.getPrice()))
                .map(DispensingDistributor::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer calculateUnits() {
        return dispensingDistributorList.stream()
                .filter(dispensingDistributor -> Objects.nonNull(dispensingDistributor.getUnits()))
                .mapToInt(DispensingDistributor::getUnits)
                .sum();
    }

    public BigDecimal calculateTotalAmount() {
        return dispensingDistributorList.stream()
                .filter(dispensingDistributor -> Objects.nonNull(dispensingDistributor.getTotalAmount()))
                .map(DispensingDistributor::getTotalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateFinalAmount() {
        return dispensingDistributorList.stream()
                .filter(dispensingDistributor -> Objects.nonNull(dispensingDistributor.getFinalAmount()))
                .map(DispensingDistributor::getFinalAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
