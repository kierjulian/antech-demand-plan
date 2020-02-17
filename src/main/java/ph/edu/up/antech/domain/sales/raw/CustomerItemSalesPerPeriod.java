package ph.edu.up.antech.domain.sales.raw;

import com.opencsv.bean.CsvBindByPosition;
import ph.edu.up.antech.domain.Customer;
import ph.edu.up.antech.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class CustomerItemSalesPerPeriod {

    private LocalDate date;

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
    private String quantityInString;

    private Integer quantity;

    @CsvBindByPosition(position = 6)
    private String quantityBonusInString;

    private Integer quantityBonus;

    @CsvBindByPosition(position = 7)
    private String salesAmountInString;

    private BigDecimal salesAmount;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

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

    public String getQuantityInString() {
        return quantityInString;
    }

    public void setQuantityInString(String quantityInString) {
        this.quantityInString = quantityInString;
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

    public String getQuantityBonusInString() {
        return quantityBonusInString;
    }

    public void setQuantityBonusInString(String quantityBonusInString) {
        this.quantityBonusInString = quantityBonusInString;
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

    public void convertAllStringValuesToProperType() {
        convertSalesAmountFromStringToBigDecimal();
        convertQuantityBonusInStringToInteger();
        convertQuantityInStringToInteger();
    }

    private void convertQuantityInStringToInteger() {
        quantity = Integer.parseInt(quantityInString.replace(",", ""));
    }

    private void convertQuantityBonusInStringToInteger() {
        quantityBonus = Integer.parseInt(quantityBonusInString.replace(",", ""));
    }

    private void convertSalesAmountFromStringToBigDecimal() {
        if (!StringUtils.isTrimmedValueNullOrEmpty(salesAmountInString)) {
            this.salesAmount = new BigDecimal(this.salesAmountInString.replaceAll(",", ""))
                    .divide(new BigDecimal("1.12"), 2, RoundingMode.HALF_EVEN);
        }
    }

    public void updateValuesBasedOnCustomer(Customer customer) {
        if (customer != null) {
            customerCode = customer.getZolCustomerCode();
            customerName = customer.getZolCustomerName();
        }
    }


}
