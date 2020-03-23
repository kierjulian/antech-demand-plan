package ph.edu.up.antech.controller.view.master;

import ph.edu.up.antech.domain.sales.master.Netsuite;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class NetsuiteCalculator {

    private List<Netsuite> netsuiteList;

    public NetsuiteCalculator(List<Netsuite> netsuiteList) {
        this.netsuiteList = netsuiteList;
    }

    public Integer calculateQuantity() {
        return netsuiteList.stream()
                .filter(netsuite -> Objects.nonNull(netsuite.getQuantity()))
                .mapToInt(Netsuite::getQuantity)
                .sum();
    }

    public BigDecimal calculateSalesPrice() {
        return netsuiteList.stream()
                .filter(netsuite -> Objects.nonNull(netsuite.getSalesPrice()))
                .map(Netsuite::getSalesPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateRevenue() {
        return netsuiteList.stream()
                .filter(netsuite -> Objects.nonNull(netsuite.getRevenue()))
                .map(Netsuite::getRevenue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer calculateInPcs() {
        return netsuiteList.stream()
                .filter(netsuite -> Objects.nonNull(netsuite.getInPcs()))
                .mapToInt(Netsuite::getInPcs)
                .sum();
    }

    public Integer calculateConvUnits() {
        return netsuiteList.stream()
                .filter(netsuite -> Objects.nonNull(netsuite.getConvUnits()))
                .mapToInt(Netsuite::getConvUnits)
                .sum();
    }

    public BigDecimal calculateRevenueConverted() {
        return netsuiteList.stream()
                .filter(netsuite -> Objects.nonNull(netsuite.getRevenueConverted()))
                .map(Netsuite::getRevenueConverted)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
