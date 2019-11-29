package ph.edu.up.antech.domain.sales.master;

import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;
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
    private Integer amount;
    private String account;
    private String kam;
    private String kamReferenceName;
    private String stage;
    private Integer amountConverted;
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
        this.itemCode = "0000000000" + customerItemSalesPerPeriod.getMaterialCode();
        this.itemName = customerItemSalesPerPeriod.getMaterialDescription();
        this.salesUnit = customerItemSalesPerPeriod.getQuantity();
        this.salesValue = customerItemSalesPerPeriod.getSalesAmount();
        generateLessThan00375();
        generateV1();
        generateLessThan0853();
        generateV2();
        generateFinalAmount();
        generalAmountTimes1000();
        generateA();
        this.amount = a;
        generateAmountConverted();
        generateType();
        generateCm();
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getKam() {
        return kam;
    }

    public void setKam(String kam) {
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

    public Integer getAmountConverted() {
        return amountConverted;
    }

    public void setAmountConverted(Integer amountConverted) {
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

    public void generateValuesBasedOnZolPerDoorsGeneralInformation
            (ZolPerDoorsGeneralInformation generalInformation) {
        if (generalInformation != null) {
            this.antechProductDescription = generalInformation.getBrand();
            this.antechPrice = generalInformation.getNewPrice();
            this.stage = generalInformation.getStage();
        }
    }

    public void generateValuesBasedOnZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct) {
        if (zolPerDoorsPerAcct != null) {
            this.account = zolPerDoorsPerAcct.getAccount();
            this.kam = zolPerDoorsPerAcct.getKam();
            this.kamReferenceName = zolPerDoorsPerAcct.getKamReferenceName();
            this.location = zolPerDoorsPerAcct.getLocation2();
        }
    }

    private void generateLessThan00375() {
        if (salesValue != null) {
            less00375Percent = salesValue.multiply(new BigDecimal("0.00375"));
        }
    }

    private void generateV1() {
        if (salesValue != null && less00375Percent != null) {
            v1 = salesValue.subtract(less00375Percent);
        }
    }

    private void generateLessThan0853() {
        if (true && v1 != null) {
            less0853Percent = v1.multiply(new BigDecimal("0.0853"));
        } else {
            less0853Percent = v1.multiply(new BigDecimal("0.05"));
        }
    }

    private void generateV2() {
        if (v1 != null && less0853Percent != null) {
            v2 = v1.subtract(less0853Percent);
        }
    }

    private void generateFinalAmount() {
        if (salesValue != null && less00375Percent != null && less0853Percent != null) {
            finalAmount = salesValue
                    .subtract(less00375Percent)
                    .subtract(less0853Percent)
                    .multiply(new BigDecimal("0.001"));
        }
    }

    private void generalAmountTimes1000() {
        if (finalAmount != null) {
            amountTimesOneThousand = finalAmount.multiply(new BigDecimal("1000"));
        }
    }

    private void generateA() {
        if (finalAmount != null) {
            a = finalAmount.intValue();
        }
    }

    private void generateAmountConverted() {
        if (amount != null) {
            BigDecimal amountConvertedInBigDecimal = new BigDecimal("0.001").multiply(BigDecimal.valueOf(amount));
            this.amountConverted = amountConvertedInBigDecimal.intValue();
        }
    }

    private void generateType() {
        if (amount != null && amount < 0) {
            type = "CM";
        } else {
            type = "FALSE";
        }
    }

    private void generateCm() {
        if (salesValue.compareTo(BigDecimal.ZERO) < 0) {
            cm = "CM";
        } else {
            cm = "";
        }
    }

}
