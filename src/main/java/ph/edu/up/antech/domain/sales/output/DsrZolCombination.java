package ph.edu.up.antech.domain.sales.output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DsrZolCombination {

    private String kamReferenceName;
    private String account;
    private List<ProductSalesAmountAndUnit> productSalesAmountAndUnitList;

    public DsrZolCombination(List<DsrZol> dsrZolList) {
        kamReferenceName = dsrZolList.get(0).getKamReferenceName();
        account = dsrZolList.get(0).getAccount();
        productSalesAmountAndUnitList = new ArrayList<>();

        dsrZolList.forEach(dsrZol -> {
            if (!dsrZol.getKamReferenceName().equals(kamReferenceName)
                    || !dsrZol.getAccount().equals(account)) {
                throw new RuntimeException("Kam reference name and account should be the same for one Dsr Zol Combination");
            }

            ProductSalesAmountAndUnit productSalesAmountAndUnit = new ProductSalesAmountAndUnit(
                    dsrZol.getAntechProductDescription(), dsrZol.getAmount(), dsrZol.getSalesUnit());
            if (productSalesAmountAndUnitList.contains(productSalesAmountAndUnit)) {
                Integer indexOfExistingProductSalesAmountAndUnit =
                        productSalesAmountAndUnitList.indexOf(productSalesAmountAndUnit);
                ProductSalesAmountAndUnit retrievedProductSalesAndAmountUnit = productSalesAmountAndUnitList.get(indexOfExistingProductSalesAmountAndUnit);
                retrievedProductSalesAndAmountUnit.addAmount(productSalesAmountAndUnit.getSalesAmount());
                retrievedProductSalesAndAmountUnit.addSalesUnit(productSalesAmountAndUnit.getSalesUnit());
            } else {
                this.productSalesAmountAndUnitList.add(productSalesAmountAndUnit);
            }
        });
    }

    public String getKamReferenceName() {
        return kamReferenceName;
    }

    public void setKamReferenceName(String kamReferenceName) {
        this.kamReferenceName = kamReferenceName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<ProductSalesAmountAndUnit> getProductSalesAmountAndUnitList() {
        return productSalesAmountAndUnitList;
    }

    public void setProductSalesAmountAndUnitList(List<ProductSalesAmountAndUnit> productSalesAmountAndUnitList) {
        this.productSalesAmountAndUnitList = productSalesAmountAndUnitList;
    }

    public Boolean doesProductExistInProductSalesAmountAndUnitList(String product) {
        return productSalesAmountAndUnitList.stream()
                .map(productSalesAmountAndUnit -> productSalesAmountAndUnit.getProduct())
                .collect(Collectors.toList())
                .stream()
                .anyMatch(productName -> productName.equals(product));
    }

    public Integer calculateMilkSalesAmount() {
        return productSalesAmountAndUnitList.stream()
                .filter(productSalesAmountAndUnit -> productSalesAmountAndUnit.getProduct().startsWith("C")
                        || productSalesAmountAndUnit.getProduct().startsWith("S"))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesAmount())
                .sum();
    }

    public Integer calculateJarSalesAmount() {
        return productSalesAmountAndUnitList.stream()
                .filter(productSalesAmountAndUnit -> productSalesAmountAndUnit.getProduct().startsWith("Jar"))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesAmount())
                .sum();
    }

    public Integer calculateWaterSalesAmount() {
        return productSalesAmountAndUnitList.stream()
                .filter(productSalesAmountAndUnit -> productSalesAmountAndUnit.getProduct().startsWith("Water"))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesAmount())
                .sum();
    }

    public Integer calculateTotalAmount() {
        return productSalesAmountAndUnitList.stream()
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesAmount())
                .sum();
    }

    public Integer calculateMilkSalesUnit() {
        return productSalesAmountAndUnitList.stream()
                .filter(productSalesAmountAndUnit -> productSalesAmountAndUnit.getProduct().startsWith("C")
                        || productSalesAmountAndUnit.getProduct().startsWith("S"))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesUnit())
                .sum();
    }

    public Integer calculateJarSalesUnit() {
        return productSalesAmountAndUnitList.stream()
                .filter(productSalesAmountAndUnit -> productSalesAmountAndUnit.getProduct().startsWith("Jar"))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesUnit())
                .sum();
    }

    public Integer calculateWaterSalesUnit() {
        return productSalesAmountAndUnitList.stream()
                .filter(productSalesAmountAndUnit -> productSalesAmountAndUnit.getProduct().startsWith("Water"))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesUnit())
                .sum();
    }

    public Integer calculateTotalSalesUnit() {
        return productSalesAmountAndUnitList.stream()
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesUnit())
                .sum();
    }

}
