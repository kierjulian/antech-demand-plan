package ph.edu.up.antech.domain.sales.master;

import ph.edu.up.antech.domain.sales.raw.CustomerItemSalesPerPeriod;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ZolPerDoors {

    private LocalDate date;
    private String customerCode;
    private String customerName;
    private String itemCode;
    private String itemName;
    private Integer salesUnit;
    private BigDecimal salesValue;
    private String antechProductDescription;
    private BigDecimal antechPrice;
    private BigDecimal amount;
    private String account;
    private Integer kam;
    private String kamReferenceName;
    private String stage;
    private BigDecimal amountConverted;
    private String type;
    private String location;
    private String cm;
    private BigDecimal less00375Percent;
    private BigDecimal v1;
    private BigDecimal less0853Percent;
    private BigDecimal v2;
    private BigDecimal finalAmount;
    private BigDecimal amountTimesOneThousand;
    private Integer a;

    public ZolPerDoors(CustomerItemSalesPerPeriod customerItemSalesPerPeriod) {
        this.date = customerItemSalesPerPeriod.getDate();
        this.customerCode = customerItemSalesPerPeriod.getCustomerCode();
        this.customerName = customerItemSalesPerPeriod.getCustomerName();
        this.itemCode = customerItemSalesPerPeriod.getMaterialCode();
        this.itemName = customerItemSalesPerPeriod.getMaterialDescription();
        this.salesUnit = customerItemSalesPerPeriod.getQuantity();
        this.salesValue = customerItemSalesPerPeriod.getSalesAmount();
    }

    public ZolPerDoors() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getSalesUnit() {
        return salesUnit;
    }

    public void setSalesUnit(Integer salesUnit) {
        this.salesUnit = salesUnit;
    }

    public BigDecimal getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(BigDecimal salesValue) {
        this.salesValue = salesValue;
    }

    public String getAntechProductDescription() {
        return antechProductDescription;
    }

    public void setAntechProductDescription(String antechProductDescription) {
        this.antechProductDescription = antechProductDescription;
    }

    public BigDecimal getAntechPrice() {
        return antechPrice;
    }

    public void setAntechPrice(BigDecimal antechPrice) {
        this.antechPrice = antechPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getKam() {
        return kam;
    }

    public void setKam(Integer kam) {
        this.kam = kam;
    }

    public String getKamReferenceName() {
        return kamReferenceName;
    }

    public void setKamReferenceName(String kamReferenceName) {
        this.kamReferenceName = kamReferenceName;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public BigDecimal getAmountConverted() {
        return amountConverted;
    }

    public void setAmountConverted(BigDecimal amountConverted) {
        this.amountConverted = amountConverted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCm() {
        return cm;
    }

    public void setCm(String cm) {
        this.cm = cm;
    }

    public BigDecimal getLess00375Percent() {
        return less00375Percent;
    }

    public void setLess00375Percent(BigDecimal less00375Percent) {
        this.less00375Percent = less00375Percent;
    }

    public BigDecimal getV1() {
        return v1;
    }

    public void setV1(BigDecimal v1) {
        this.v1 = v1;
    }

    public BigDecimal getLess0853Percent() {
        return less0853Percent;
    }

    public void setLess0853Percent(BigDecimal less0853Percent) {
        this.less0853Percent = less0853Percent;
    }

    public BigDecimal getV2() {
        return v2;
    }

    public void setV2(BigDecimal v2) {
        this.v2 = v2;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public BigDecimal getAmountTimesOneThousand() {
        return amountTimesOneThousand;
    }

    public void setAmountTimesOneThousand(BigDecimal amountTimesOneThousand) {
        this.amountTimesOneThousand = amountTimesOneThousand;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

}
