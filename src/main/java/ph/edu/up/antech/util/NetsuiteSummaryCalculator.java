package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.master.Netsuite;

import java.math.BigDecimal;
import java.util.List;

public class NetsuiteSummaryCalculator {

    private List<Netsuite> netsuiteList;

    public NetsuiteSummaryCalculator(List<Netsuite> netsuiteList) {
        this.netsuiteList = netsuiteList;
    }

    public Integer calculateTotalAmountPerProduct(String product) {
        return netsuiteList.stream()
                .filter(netsuite -> product.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().
                        setScale(2, BigDecimal.ROUND_HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateTotalAmount() {
        return netsuiteList.stream()
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalUnitPerProduct(String product) {
        return netsuiteList.stream()
                .filter(netsuite -> product.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalUnit() {
        return netsuiteList.stream()
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

}
