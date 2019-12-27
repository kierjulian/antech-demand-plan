package ph.edu.up.antech.domain.sales.output;

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

}
