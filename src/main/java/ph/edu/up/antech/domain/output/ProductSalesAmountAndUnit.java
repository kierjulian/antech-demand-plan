package ph.edu.up.antech.domain.output;

import java.util.Objects;

public class ProductSalesAmountAndUnit {

    private String product;
    private Integer salesAmount;
    private Integer salesUnit;

    public ProductSalesAmountAndUnit(String product, Integer salesAmount, Integer salesUnit) {
        this.product = product;
        this.salesAmount = salesAmount != null ? salesAmount : 0;
        this.salesUnit = salesUnit != null ? salesUnit : 0;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Integer salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Integer getSalesUnit() {
        return salesUnit;
    }

    public void setSalesUnit(Integer salesUnit) {
        this.salesUnit = salesUnit;
    }

    public void addAmount(Integer amount) {
        if (this.salesAmount != null) {
            this.salesAmount += amount;
        }
    }

    public void addSalesUnit(Integer salesUnit) {
        if (this.salesUnit != null && salesUnit != null) {
            this.salesUnit += salesUnit;
        }
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
