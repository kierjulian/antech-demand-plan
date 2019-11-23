package ph.edu.up.antech.domain.sales.raw;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;

public class DispensingDistributor {

    @CsvBindByName(column = "Month")
    private String month;

    @CsvBindByName(column = "Accounts")
    private String accounts;

    @CsvBindByName(column = "DSM_Name")
    private String dsmName;

    @CsvBindByName(column = "Doctors Name")
    private String doctorName;

    @CsvBindByName(column = "NA_NAME")
    private String naName;

    @CsvBindByName(column = "Item Key")
    private String itemKey;

    @CsvBindByName(column = "Item Description")
    private String itemDescription;

    @CsvBindByName(column = "Category")
    private String category;

    @CsvBindByName(column = "Ref #")
    private String referenceNo;

    @CsvBindByName(column = "Price")
    private String priceInString;

    private BigDecimal price;

    @CsvBindByName(column = "Units")
    private Integer units;

    @CsvBindByName(column = "Total Amount")
    private String totalAmountInString;

    private BigDecimal totalAmount;

    @CsvBindByName(column = "Final Amt ('000')")
    private String finalAmountInString;

    private BigDecimal finalAmount;

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

    public void convertPriceFromStringToBigDecimal() {
        if (this.priceInString != null
                && !this.priceInString.trim().isEmpty()
                && !this.priceInString.startsWith("#")) {
            this.price = new BigDecimal(priceInString.trim()
                    .replaceAll(",", "")
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", ""));
        }
    }

    public void convertTotalAmountFromStringToBigDecimal() {
        if (this.totalAmountInString != null
                && !this.priceInString.trim().isEmpty()
                && !this.priceInString.startsWith("#")) {
            this.totalAmount = new BigDecimal(totalAmountInString.trim()
                    .replaceAll(",", "")
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", ""));
        }
    }

    public void convertFinalAmountFromStringToBigDecimal() {
        if (this.finalAmountInString != null
                && !this.priceInString.trim().isEmpty()
                && !this.priceInString.startsWith("#")) {
            this.finalAmount = new BigDecimal(finalAmountInString.trim()
                    .replaceAll(",", "")
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", ""));
        }
    }

}
