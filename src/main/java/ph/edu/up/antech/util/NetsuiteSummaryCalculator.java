package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.master.Netsuite;

import java.math.BigDecimal;
import java.util.List;

public class NetsuiteSummaryCalculator {

    private List<Netsuite> netsuiteList;
    private List<String> productList;

    public NetsuiteSummaryCalculator(List<Netsuite> netsuiteList, List<String> productList) {
        this.netsuiteList = netsuiteList;
        this.productList = productList;
    }

    public Integer calculateTotalAmountPerProduct(String product) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> product.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalMilkAmount() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalWaterAmount() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalAmount() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalUnitPerProduct(String product) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> product.equals(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalMilkUnit() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("CS"))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalWaterUnit() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalUnit() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> netsuite.getQuantity() != null)
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalAmountPerTransferCatRecodePerProduct(
            String transfersCatRecode, String antechProductDescription) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> antechProductDescription.equals(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalUnitsPerTransfersCatRecodePerProduct(
            String transfersCatRecode, String antechProductDescription) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> antechProductDescription.equals(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalMilkAmountPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalWaterAmountPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalAmountPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalMilkUnitsPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalWaterUnitsPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalUnitsPerTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

}
