package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.master.Netsuite;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NetsuiteSummaryCalculator {

    private List<Netsuite> netsuiteList;

    public NetsuiteSummaryCalculator(List<Netsuite> netsuiteList, List<String> productList) {
        this.netsuiteList = netsuiteList.stream()
                .filter(netsuite -> Objects.nonNull(netsuite.getKamRefName1()))
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .collect(Collectors.toList());
    }

    public Integer calculateTotalAmountPerProduct(String product) {
        return netsuiteList.stream()
                .filter(netsuite -> product.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalMilkAmount() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalJarAmount() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalWaterAmount() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalAmount() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
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

    public Integer calculateTotalMilkUnit() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("CS"))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalJarUnit() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalWaterUnit() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
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
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> antechProductDescription.equals(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalUnitsPerTransfersCatRecodePerProduct(
            String transfersCatRecode, String antechProductDescription) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> antechProductDescription.equals(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalMilkAmountPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalJarAmountPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalWaterAmountPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalAmountPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalMilkUnitsPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalJarUnitsPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalWaterUnitsPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalUnitsPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

}
