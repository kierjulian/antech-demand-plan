package ph.edu.up.antech.domain.sales.master;

import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtSheet;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ZolMtPerBranch {

    private Integer id;
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
    private String kam;
    private String kamRefName;
    private String stage;
    private BigDecimal amountConverted;
    private String type;
    private String loc;
    private String cm;
    private BigDecimal lessThan00375;
    private BigDecimal v1;
    private BigDecimal lessThan0853;
    private BigDecimal v2;
    private BigDecimal finalAmount;
    private BigDecimal amountTimes1000;
    private Integer a;
    private LocalDate cmInd;
    private String dsm;

    public ZolMtPerBranch() {
    }

    public ZolMtPerBranch(ZolMtSheet zolMtSheet) {
        this.customerName = zolMtSheet.getAccountName();
        this.itemCode = zolMtSheet.getZapCode();
        this.itemName = zolMtSheet.getItemDescription();
        this.salesUnit = zolMtSheet.getSumOfUnits();
        this.salesValue = BigDecimal.valueOf(zolMtSheet.getSumOfFinalNetValue());
        generateLessThan00375();
        generateV1();
        generateLessThan0853();
        generateV2();
        generateFinalAmount();
        generalAmountTimes1000();
        generateA();
        this.amount = BigDecimal.valueOf(a);
        generateAmountConverted();
        generateType();
        generateCm();
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

    public String getKam() {
        return kam;
    }

    public void setKam(String kam) {
        this.kam = kam;
    }

    public String getKamRefName() {
        return kamRefName;
    }

    public void setKamRefName(String kamRefName) {
        this.kamRefName = kamRefName;
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

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getCm() {
        return cm;
    }

    public void setCm(String cm) {
        this.cm = cm;
    }

    public BigDecimal getLessThan00375() {
        return lessThan00375;
    }

    public void setLessThan00375(BigDecimal lessThan00375) {
        this.lessThan00375 = lessThan00375;
    }

    public BigDecimal getV1() {
        return v1;
    }

    public void setV1(BigDecimal v1) {
        this.v1 = v1;
    }

    public BigDecimal getLessThan0853() {
        return lessThan0853;
    }

    public void setLessThan0853(BigDecimal lessThan0853) {
        this.lessThan0853 = lessThan0853;
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

    public BigDecimal getAmountTimes1000() {
        return amountTimes1000;
    }

    public void setAmountTimes1000(BigDecimal amountTimes1000) {
        this.amountTimes1000 = amountTimes1000;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public LocalDate getCmInd() {
        return cmInd;
    }

    public void setCmInd(LocalDate cmInd) {
        this.cmInd = cmInd;
    }

    public String getDsm() {
        return dsm;
    }

    public void setDsm(String dsm) {
        this.dsm = dsm;
    }

    private void generateLessThan00375() {
        if (salesValue != null) {
            lessThan00375 = salesValue.multiply(new BigDecimal("0.00375"));
        }
    }

    private void generateV1() {
        if (salesValue != null && lessThan00375 != null) {
            v1 = salesValue.subtract(lessThan00375);
        }
    }

    private void generateLessThan0853() {
        if (v1 != null) {
            if (true) {
                lessThan0853 = v1.multiply(new BigDecimal("0.0853"));
            } else {
                lessThan0853 = v1.multiply(new BigDecimal("0.05"));
            }
        }
    }

    private void generateV2() {
        if (v1 != null && lessThan0853 != null) {
            v2 = v1.subtract(lessThan0853);
        }
    }

    private void generateFinalAmount() {
        if (salesValue != null && lessThan00375 != null && lessThan0853 != null) {
            finalAmount = salesValue
                    .subtract(lessThan00375)
                    .subtract(lessThan0853)
                    .multiply(new BigDecimal("0.001"));
        }
    }

    private void generalAmountTimes1000() {
        if (finalAmount != null) {
            amountTimes1000 = finalAmount.multiply(new BigDecimal("1000"));
        }
    }

    private void generateA() {
        if (finalAmount != null) {
            a = finalAmount.intValue();
        }
    }

    private void generateAmountConverted() {
        if (amount != null) {
            BigDecimal amountConvertedInBigDecimal = new BigDecimal("0.001").multiply(amount);
            //this.amountConverted = amountConvertedInBigDecimal.intValue();
        }
    }

    private void generateType() {
        if (amount != null) {
            type = "CM";
        } else {
            type = "FALSE";
        }
    }

    private void generateCm() {
        if (salesValue != null && salesValue.compareTo(BigDecimal.ZERO) < 0) {
            cm = "CM";
        } else {
            cm = "";
        }
    }

    public void setValuesFromZolPerDoorsGeneralInformation(
            ZolPerDoorsGeneralInformation generalInformation) {
        if (generalInformation != null) {
            this.antechProductDescription = generalInformation.getBrand();
            this.antechPrice = generalInformation.getNewPrice();
            this.stage = generalInformation.getStage();
        }
    }

    public void setValuesFromZolMtAccount(ZolMtAccount zolMtAccount) {
        if (zolMtAccount != null) {
            this.account = zolMtAccount.getBranchName();
            this.kamRefName = zolMtAccount.getNa();
        }
    }

}
