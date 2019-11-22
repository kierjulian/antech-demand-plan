package ph.edu.up.antech.domain.monthly.sales;

import com.opencsv.bean.CsvBindByPosition;

import java.math.BigDecimal;

public class CustomerItemSalesPerPeriod {

    @CsvBindByPosition(position = 0)
    private Integer row;

    @CsvBindByPosition(position = 1)
    private String customerCode;

    @CsvBindByPosition(position = 2)
    private String customerName;

    @CsvBindByPosition(position = 3)
    private String materialCode;

    @CsvBindByPosition(position = 4)
    private String materialDescription;

    @CsvBindByPosition(position = 5)
    private Integer quantity;

    @CsvBindByPosition(position = 6)
    private Integer quantityBonus;

    @CsvBindByPosition(position = 7)
    private String salesAmountInString;

    private BigDecimal salesAmount;

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantityBonus() {
        return quantityBonus;
    }

    public void setQuantityBonus(Integer quantityBonus) {
        this.quantityBonus = quantityBonus;
    }

    public String getSalesAmountInString() {
        return salesAmountInString;
    }

    public void setSalesAmountInString(String salesAmountInString) {
        this.salesAmountInString = salesAmountInString;
    }

    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    public void convertSalesAmount() {
        String salesAmountInString = this.salesAmountInString.replaceAll(",", "");
        this.salesAmount = new BigDecimal(salesAmountInString);
    }

}
