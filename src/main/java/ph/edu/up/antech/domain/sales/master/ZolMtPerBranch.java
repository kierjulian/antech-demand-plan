package ph.edu.up.antech.domain.sales.master;

import org.springframework.format.annotation.DateTimeFormat;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesNaConfiguration;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtSheet;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Entity
@Table(name = "zol_mt_per_branch")
@NamedQueries({
        @NamedQuery(name = "findZolMtPerBranchByLocalDate",
                query = "select o from ZolMtPerBranch o where o.date = :localDate"),
        @NamedQuery(name = "deleteZolMtPerBranchByLocalDate",
                query = "delete from ZolMtPerBranch o where o.date = :localDate"),
        @NamedQuery(name = "findZolMtPerBranchBetweenTwoDates",
                query = "select o from ZolMtPerBranch o where o.date between :startDate and :endDate"),
        @NamedQuery(name = "findZolMtPerBranchById",
                query = "select o from ZolMtPerBranch o where o.id = :id")
})
public class ZolMtPerBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "sales_unit")
    private Integer salesUnit;

    @Column(name = "sales_value")
    private BigDecimal salesValue;

    @Column(name = "antech_prod_desc")
    private String antechProductDescription;

    @Column(name = "antech_price")
    private BigDecimal antechPrice;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "account")
    private String account;

    @Column(name = "kam")
    private String kam;

    @Column(name = "kam_ref_name")
    private String kamRefName;

    @Column(name = "stage")
    private String stage;

    @Column(name = "amount_converted")
    private String amountConverted;

    @Column(name = "type")
    private String type;

    @Column(name = "loc")
    private String loc;

    @Column(name = "cm")
    private String cm;

    @Column(name = "less_than_00375")
    private BigDecimal lessThan00375;

    @Column(name = "v1")
    private BigDecimal v1;

    @Column(name = "less_than_0853")
    private BigDecimal lessThan0853;

    @Column(name = "v2")
    private BigDecimal v2;

    @Column(name = "final_amount")
    private BigDecimal finalAmount;

    @Column(name = "amount_times_1000")
    private BigDecimal amountTimes1000;

    @Column(name = "a")
    private Integer a;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "cm_ind")
    private LocalDate cmInd;

    @Column(name = "dsm")
    private String dsm;

    public ZolMtPerBranch() {
    }

    public ZolMtPerBranch(Integer id, LocalDate date, String customerCode, String customerName, String itemCode,
                          String itemName, Integer salesUnit, BigDecimal salesValue, String antechProductDescription,
                          BigDecimal antechPrice, BigDecimal amount, String account, String kam, String kamRefName,
                          String stage, String amountConverted, String type, String loc, String cm,
                          BigDecimal lessThan00375, BigDecimal v1, BigDecimal lessThan0853, BigDecimal v2,
                          BigDecimal finalAmount, BigDecimal amountTimes1000, Integer a, LocalDate cmInd, String dsm) {
        this.id = id;
        this.date = date;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.salesUnit = salesUnit;
        this.salesValue = salesValue;
        this.antechProductDescription = antechProductDescription;
        this.antechPrice = antechPrice;
        this.amount = amount;
        this.account = account;
        this.kam = kam;
        this.kamRefName = kamRefName;
        this.stage = stage;
        this.amountConverted = amountConverted;
        this.type = type;
        this.loc = loc;
        this.cm = cm;
        this.lessThan00375 = lessThan00375;
        this.v1 = v1;
        this.lessThan0853 = lessThan0853;
        this.v2 = v2;
        this.finalAmount = finalAmount;
        this.amountTimes1000 = amountTimes1000;
        this.a = a;
        this.cmInd = cmInd;
        this.dsm = dsm;
    }

    public ZolMtPerBranch(ZolMtSheet zolMtSheet) {
        this.customerName = zolMtSheet.getAccountName();
        this.itemCode = zolMtSheet.getZapCode();
        this.itemName = zolMtSheet.getItemDescription();
        this.salesUnit = zolMtSheet.getSumOfUnits();

        if (zolMtSheet.getSumOfFinalNetValue() != null) {
            this.salesValue = BigDecimal.valueOf(zolMtSheet.getSumOfFinalNetValue());
        }

        generateLessThan00375();
        generateV1();
        generateLessThan0853();
        generateV2();
        generateFinalAmount();
        generalAmountTimes1000();
        generateA();

        if (a != null) {
            this.amount = BigDecimal.valueOf(a);
        }

        generateAmountConverted();
        generateType();
        generateCm();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAmountConverted() {
        return amountConverted;
    }

    public void setAmountConverted(String amountConverted) {
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
                    .multiply(new BigDecimal("0.001"))
                    .setScale(2, RoundingMode.HALF_EVEN);
        }
    }

    private void generalAmountTimes1000() {
        if (finalAmount != null) {
            amountTimes1000 = finalAmount.multiply(new BigDecimal("1000"))
                    .setScale(2, RoundingMode.HALF_EVEN);
        }
    }

    private void generateA() {
        if (finalAmount != null) {
            BigDecimal roundOffNumber = finalAmount.setScale(0, RoundingMode.HALF_EVEN);
            a = roundOffNumber.intValue();
        }
    }

    private void generateAmountConverted() {
        if (amount != null) {
            BigDecimal amountConvertedInBigDecimal = new BigDecimal("0.001")
                    .multiply(amount)
                    .setScale(0, RoundingMode.HALF_EVEN);
            this.amountConverted = String.valueOf(amountConvertedInBigDecimal.intValue());
        }
    }

    private void generateType() {
        if (amount != null && amount.compareTo(BigDecimal.ZERO) < 0) {
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

    public void generateValuesFromZolMdcPerBranchNaConfiguration(MdcPerBranchSalesNaConfiguration
                                                                         mdcPerBranchSalesNaConfiguration) {
        if (mdcPerBranchSalesNaConfiguration != null) {
            this.dsm = mdcPerBranchSalesNaConfiguration.getDsm();
        }
    }

}
