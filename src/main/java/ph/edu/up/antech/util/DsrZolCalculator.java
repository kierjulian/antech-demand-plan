package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.output.DsrZol;

import java.util.List;

public class DsrZolCalculator {

    private List<DsrZol> dsrZolList;
    private List<String> productList;

    public DsrZolCalculator(List<DsrZol> dsrZolList, List<String> productList) {
        this.dsrZolList = dsrZolList;
        this.productList = productList;
    }

    public Integer calculateTotalAmountPerAccountPerProduct(
            String kamReferenceName, String antechProductDescription) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateTotalUnitsPerAccountPerProduct(
            String kamReferenceName, String antechProductDescription) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateTotalAmountPerProduct(String antechProductDescription) {
        return dsrZolList.stream()
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateTotalUnitsPerProduct(String antechProductDescription) {
        return dsrZolList.stream()
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateTotalMilkAmountPerAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> productList.contains(dsrZol.getAntechProductDescription()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("C") || dsrZol.getAntechProductDescription().startsWith("S"))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateTotalWaterAmountPerAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> productList.contains(dsrZol.getAntechProductDescription()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("Water"))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateTotalAmountPerAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> productList.contains(dsrZol.getAntechProductDescription()))
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateTotalMilkUnitsPerAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> productList.contains(dsrZol.getAntechProductDescription()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("C") || dsrZol.getAntechProductDescription().startsWith("S"))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateTotalWaterUnitsPerAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> productList.contains(dsrZol.getAntechProductDescription()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("Water"))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateTotalUnitsPerAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> productList.contains(dsrZol.getAntechProductDescription()))
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateTotalMilkAmount() {
        return dsrZolList.stream()
                .filter(dsrZol -> productList.contains(dsrZol.getAntechProductDescription()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("C") || dsrZol.getAntechProductDescription().startsWith("S"))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateTotalWaterAmount() {
        return dsrZolList.stream()
                .filter(dsrZol -> productList.contains(dsrZol.getAntechProductDescription()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("Water"))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateTotalAmount() {
        return dsrZolList.stream()
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateTotalMilkUnits() {
        return dsrZolList.stream()
                .filter(dsrZol -> productList.contains(dsrZol.getAntechProductDescription()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("C") || dsrZol.getAntechProductDescription().startsWith("S"))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateTotalWaterUnits() {
        return dsrZolList.stream()
                .filter(dsrZol -> productList.contains(dsrZol.getAntechProductDescription()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("Water"))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateTotalUnits() {
        return dsrZolList.stream()
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }


}
