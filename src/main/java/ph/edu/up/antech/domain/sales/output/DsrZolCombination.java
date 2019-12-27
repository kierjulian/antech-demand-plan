package ph.edu.up.antech.domain.sales.output;

import java.util.ArrayList;
import java.util.List;

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
            this.productSalesAmountAndUnitList.add(productSalesAmountAndUnit);
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

}
