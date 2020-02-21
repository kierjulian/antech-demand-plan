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
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalUnit() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalAmountPerTransferCatRecodePerProduct(
            String transfersCatRecode, String antechProductDescription) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> antechProductDescription.equals(netsuite.getBrand()))
                .mapToInt(dsrZol -> dsrZol.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalUnitsPerTransfersCatRecodePerProduct(
            String transfersCatRecode, String antechProductDescription) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> antechProductDescription.equals(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(dsrZol -> dsrZol.getQuantity())
                .sum();
    }

    public Integer calculateTotalAmountPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(dsrZol -> transfersCatRecode.equals(dsrZol.getTransfersCatRecode()))
                .filter(dsrZol -> dsrZol.getRevenueConverted() != null)
                .mapToInt(dsrZol -> dsrZol.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalUnitsPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(dsrZol -> transfersCatRecode.equals(dsrZol.getTransfersCatRecode()))
                .filter(dsrZor -> dsrZor.getQuantity() != null)
                .mapToInt(dsrZol -> dsrZol.getQuantity())
                .sum();
    }

}
