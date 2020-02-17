package ph.edu.up.antech.domain.sales.raw;

import com.opencsv.bean.CsvBindByName;
import org.springframework.format.annotation.DateTimeFormat;
import ph.edu.up.antech.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "dispensing_distributor")
@NamedQueries({
        @NamedQuery(name = "findDispensingDistributorByDate",
                query = "SELECT o FROM DispensingDistributor o where o.date = :date"),
        @NamedQuery(name = "deleteDispensingDistributorByLocalDate",
                query = "delete from DispensingDistributor o where o.date = :localDate"),
        @NamedQuery(name = "findDispensingDistributorById",
                query = "select o from DispensingDistributor o where o.id = :id"),
        @NamedQuery(name = "findDispensingDistributorBetweenTwoDates",
                query = "select o from DispensingDistributor o where o.date between :startDate and :endDate")
})
public class DispensingDistributor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "month")
    @CsvBindByName(column = "Month")
    private String month;

    @Column(name = "accounts")
    @CsvBindByName(column = "Accounts")
    private String accounts;

    @Column(name = "dsm_name")
    @CsvBindByName(column = "DSM_Name")
    private String dsmName;

    @Column(name = "doctor_name")
    @CsvBindByName(column = "Doctors Name")
    private String doctorName;

    @Column(name = "na_name")
    @CsvBindByName(column = "NA_NAME")
    private String naName;

    @Column(name = "item_key")
    @CsvBindByName(column = "Item Key")
    private String itemKey;

    @Column(name = "item_desc")
    @CsvBindByName(column = "Item Description")
    private String itemDescription;

    @Column(name = "category")
    @CsvBindByName(column = "Category")
    private String category;

    @Column(name = "reference_no")
    @CsvBindByName(column = "Ref #")
    private String referenceNo;

    @Transient
    @CsvBindByName(column = "Price")
    private String priceInString;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "units")
    @CsvBindByName(column = "Units")
    private Integer units;

    @Transient
    @CsvBindByName(column = "Total Amount")
    private String totalAmountInString;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Transient
    @CsvBindByName(column = "Final Amt ('000')")
    private String finalAmountInString;

    @Column(name = "final_amount")
    private BigDecimal finalAmount;

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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getDsmName() {
        return dsmName;
    }

    public void setDsmName(String dsmName) {
        this.dsmName = dsmName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getNaName() {
        return naName;
    }

    public void setNaName(String naName) {
        this.naName = naName;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getPriceInString() {
        return priceInString;
    }

    public void setPriceInString(String priceInString) {
        this.priceInString = priceInString;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public String getTotalAmountInString() {
        return totalAmountInString;
    }

    public void setTotalAmountInString(String totalAmountInString) {
        this.totalAmountInString = totalAmountInString;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getFinalAmountInString() {
        return finalAmountInString;
    }

    public void setFinalAmountInString(String finalAmountInString) {
        this.finalAmountInString = finalAmountInString;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public void convertAllStringTypeToProperType() {
        convertFinalAmountFromStringToBigDecimal();
        convertTotalAmountFromStringToBigDecimal();
        convertPriceFromStringToBigDecimal();
    }

    private void convertPriceFromStringToBigDecimal() {
        if (!StringUtils.isTrimmedValueNullOrEmpty(priceInString)
                && !this.priceInString.startsWith("#")) {
            this.price = new BigDecimal(priceInString.trim()
                    .replaceAll(",", "")
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", ""));
        }
    }

    private void convertTotalAmountFromStringToBigDecimal() {
        if (!StringUtils.isTrimmedValueNullOrEmpty(totalAmountInString)
                && !this.totalAmountInString.startsWith("#")) {
            this.totalAmount = new BigDecimal(totalAmountInString.trim()
                    .replaceAll(",", "")
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", ""));
        }
    }

    private void convertFinalAmountFromStringToBigDecimal() {
        if (!StringUtils.isTrimmedValueNullOrEmpty(finalAmountInString)
                && !this.finalAmountInString.startsWith("#")) {
            this.finalAmount = new BigDecimal(finalAmountInString.trim()
                    .replaceAll(",", "")
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", ""));
        }
    }

}
