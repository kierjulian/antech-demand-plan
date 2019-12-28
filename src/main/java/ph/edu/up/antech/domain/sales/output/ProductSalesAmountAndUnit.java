package ph.edu.up.antech.domain.sales.output;

import java.util.Objects;

public class ProductSalesAmountAndUnit {

    private String product;
    private Integer amount;
    private Integer salesUnit;

    public ProductSalesAmountAndUnit(String product, Integer amount, Integer salesUnit) {
        this.product = product;
        this.amount = amount;
        this.salesUnit = salesUnit;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getSalesUnit() {
        return salesUnit;
    }

    public void setSalesUnit(Integer salesUnit) {
        this.salesUnit = salesUnit;
    }

    public void addAmount(Integer amount) {
        this.amount += amount;
    }

    public void addSalesUnit(Integer salesUnit) {
        this.salesUnit += salesUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSalesAmountAndUnit that = (ProductSalesAmountAndUnit) o;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

}
