package ph.edu.up.antech.domain.sales.output;

import ph.edu.up.antech.domain.sales.master.Netsuite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NetsuiteCombination {

    private String kamReferenceName;
    private String transfersCatRecode;
    private List<ProductSalesAmountAndUnit> productSalesAmountAndUnitList;

    public NetsuiteCombination(List<Netsuite> netsuiteList) {
        kamReferenceName = netsuiteList.get(0).getKamRefName1();
        transfersCatRecode = netsuiteList.get(0).getTransfersCatRecode();
        productSalesAmountAndUnitList = new ArrayList<>();

        netsuiteList.forEach(netsuite -> {
            if (!netsuite.getKamRefName1().equals(kamReferenceName)
                    && !netsuite.getTransfersCatRecode().equals(transfersCatRecode)) {
                throw new RuntimeException("Kam reference name and transfers cat record should be the same for one Netsuite Combination");
            }

            ProductSalesAmountAndUnit productSalesAmountAndUnit = new ProductSalesAmountAndUnit(
                    netsuite.getBrand(), netsuite.getRevenueConverted().intValue(), netsuite.getQuantity());
            if (productSalesAmountAndUnitList.contains(productSalesAmountAndUnit)) {
                Integer indexOfExistingProductSalesAmountAndUnit =
                        productSalesAmountAndUnitList.indexOf(productSalesAmountAndUnit);
                ProductSalesAmountAndUnit retrievedProductSalesAndAmountUnit = productSalesAmountAndUnitList.get(indexOfExistingProductSalesAmountAndUnit);
                retrievedProductSalesAndAmountUnit.addAmount(productSalesAmountAndUnit.getAmount());
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

    public String getTransfersCatRecode() {
        return transfersCatRecode;
    }

    public void setTransfersCatRecode(String transfersCatRecode) {
        this.transfersCatRecode = transfersCatRecode;
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

    public Integer getTotalAmount() {
        return productSalesAmountAndUnitList.stream()
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getAmount())
                .sum();
    }

    public Integer getTotalSalesUnit() {
        return productSalesAmountAndUnitList.stream()
                .mapToInt(productSalesAmountAndUnit -> productSalesAmountAndUnit.getSalesUnit())
                .sum();
    }

}

