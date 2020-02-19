package ph.edu.up.antech.domain.sales.raw;

import com.opencsv.bean.CsvBindByName;
import ph.edu.up.antech.domain.Customer;
import ph.edu.up.antech.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class CustomerItemSalesPerPeriod {

    private LocalDate date;

    @CsvBindByName(column = "Row No.")
    private Integer row;

    @CsvBindByName(column = "Sold To Customer Code")
    private String customerCode;

    @CsvBindByName(column = "Sold To Customer Name")
    private String customerName;

    @CsvBindByName(column = "Material Code")
    private String materialCode;

    @CsvBindByName(column = "Material Desc")
    private String materialDescription;

    @CsvBindByName(column = "Quantity - Transaction")
    private String quantityInString;

    private Integer quantity;

    @CsvBindByName(column = "Qty Bonus")
    private String quantityBonusInString;

    private Integer quantityBonus;

    @CsvBindByName(column = "Sales Amount")
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
        trimAllStringEntries();
        convertSalesAmountFromStringToBigDecimal();
        convertQuantityBonusInStringToInteger();
        convertQuantityInStringToInteger();
    }

    private void trimAllStringEntries() {
        trimCustomerCode();
        trimCustomerName();
        trimMaterialCode();
        trimMaterialDescription();
        trimQuantityInString();
        trimQuantityBonusInString();
        trimSalesAmountInString();
    }

    private void trimCustomerCode() {
        if (customerCode != null) {
            customerCode = customerCode.trim();
        }
    }

    private void trimCustomerName() {
        if (customerName != null) {
            customerName = customerName.trim();
        }
    }

    private void trimMaterialCode() {
        if (materialCode != null) {
            materialCode = materialCode.trim();
        }
    }

    private void trimMaterialDescription() {
        if (materialDescription != null) {
            materialDescription = materialDescription.trim();
        }
    }

    private void trimQuantityInString() {
        if (quantityInString != null) {
            quantityInString = quantityInString.trim();
        }
    }

    private void trimQuantityBonusInString() {
        if (quantityBonusInString != null) {
            quantityBonusInString = quantityInString.trim();
        }
    }

    private void trimSalesAmountInString() {
        if (salesAmountInString != null) {
            salesAmountInString = salesAmountInString.trim();
        }
    }

    private void convertQuantityInStringToInteger() {
        if (quantityInString != null) {
            quantity = Integer.parseInt(quantityInString.replace(",", ""));
        }
    }

    private void convertQuantityBonusInStringToInteger() {
        if (quantityBonusInString != null) {
            quantityBonus = Integer.parseInt(quantityBonusInString.replace(",", ""));
        }
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

    public void updateMaterialCodeBasedOnCustomer(Customer customer) {
        if (customer != null) {
            materialCode = customer.getZolMaterialCode();
        }
    }


}
