package ph.edu.up.antech.domain.output;

import ph.edu.up.antech.domain.master.Netsuite;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NetsuiteCombination {

    private String transfersCatRecode;
    private String mgmt;
    private String region;
    private String kamReferenceName;
    private List<ProductSalesAmountAndUnit> productSalesAmountAndUnitList;

    public NetsuiteCombination(List<Netsuite> netsuiteList) {
        transfersCatRecode = netsuiteList.get(0).getTransfersCatRecode();
        mgmt = netsuiteList.get(0).getMgmt();
        region = netsuiteList.get(0).getRegion();
        kamReferenceName = netsuiteList.get(0).getKamRefName1();
        productSalesAmountAndUnitList = new ArrayList<>();

        netsuiteList.forEach(netsuite -> {
            if (!netsuite.getTransfersCatRecode().equals(transfersCatRecode)
                    && !netsuite.getMgmt().equals(mgmt)
                    && !netsuite.getRegion().equals(region)
                    && !netsuite.getKamRefName1().equals(kamReferenceName)) {
                throw new RuntimeException("Kam reference name and transfers cat record should be the same for one Netsuite Combination");
            }

            ProductSalesAmountAndUnit productSalesAmountAndUnit = new ProductSalesAmountAndUnit(
                    netsuite.getBrand(), netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue(),
                    netsuite.getQuantity());
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

    public String getTransfersCatRecode() {
        return transfersCatRecode;
    }

    public void setTransfersCatRecode(String transfersCatRecode) {
        this.transfersCatRecode = transfersCatRecode;
    }

    public String getMgmt() {
        return mgmt;
    }

    public void setMgmt(String mgmt) {
        this.mgmt = mgmt;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getKamReferenceName() {
        return kamReferenceName;
    }

    public void setKamReferenceName(String kamReferenceName) {
        this.kamReferenceName = kamReferenceName;
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
                .filter(productSalesAmountAndUnit -> productSalesAmountAndUnit.getProduct().startsWith("CS") ||
                        productSalesAmountAndUnit.getProduct().startsWith("S"))
                .filter(productSalesAmountAndUnit -> Objects.nonNull(productSalesAmountAndUnit.getSalesAmount()))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesAmount())
                .sum();
    }

    public Integer calculateJarSalesAmount() {
        return productSalesAmountAndUnitList.stream()
                .filter(productSalesAmountAndUnit -> productSalesAmountAndUnit.getProduct().startsWith("Jar"))
                .filter(productSalesAmountAndUnit -> Objects.nonNull(productSalesAmountAndUnit.getSalesAmount()))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesAmount())
                .sum();
    }

    public Integer calculateWaterSalesAmount() {
        return productSalesAmountAndUnitList.stream()
                .filter(productSalesAmountAndUnit -> productSalesAmountAndUnit.getProduct().startsWith("Water"))
                .filter(productSalesAmountAndUnit -> Objects.nonNull(productSalesAmountAndUnit.getSalesAmount()))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesAmount())
                .sum();
    }

    public Integer calculateTotalSalesAmount() {
        return productSalesAmountAndUnitList.stream()
                .filter(productSalesAmountAndUnit -> Objects.nonNull(productSalesAmountAndUnit.getSalesAmount()))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesAmount())
                .sum();
    }

    public Integer calculateMilkSalesUnit() {
        return productSalesAmountAndUnitList.stream()
                .filter(productSalesAmountAndUnit -> productSalesAmountAndUnit.getProduct().startsWith("CS") ||
                        productSalesAmountAndUnit.getProduct().startsWith("S"))
                .filter(productSalesAmountAndUnit -> Objects.nonNull(productSalesAmountAndUnit.getSalesUnit()))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesUnit())
                .sum();
    }

    public Integer calculateJarSalesUnit() {
        return productSalesAmountAndUnitList.stream()
                .filter(productSalesAmountAndUnit -> productSalesAmountAndUnit.getProduct().startsWith("Jar"))
                .filter(productSalesAmountAndUnit -> Objects.nonNull(productSalesAmountAndUnit.getSalesUnit()))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesUnit())
                .sum();
    }

    public Integer calculateWaterSalesUnit() {
        return productSalesAmountAndUnitList.stream()
                .filter(productSalesAmountAndUnit -> productSalesAmountAndUnit.getProduct().startsWith("Water"))
                .filter(productSalesAmountAndUnit -> Objects.nonNull(productSalesAmountAndUnit.getSalesUnit()))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesUnit())
                .sum();
    }

    public Integer calculateTotalSalesUnit() {
        return productSalesAmountAndUnitList.stream()
                .filter(productSalesAmountAndUnit -> Objects.nonNull(productSalesAmountAndUnit.getSalesUnit()))
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesUnit())
                .sum();
    }

}

