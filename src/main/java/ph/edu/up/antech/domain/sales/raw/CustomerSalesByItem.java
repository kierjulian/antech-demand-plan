package ph.edu.up.antech.domain.sales.raw;

import com.opencsv.bean.CsvBindByName;
import ph.edu.up.antech.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerSalesByItem {

    private LocalDate itemDate;

    @CsvBindByName(column = "Item")
    private String item;

    @CsvBindByName(column = "Type")
    private String type;

    @CsvBindByName(column = "Customer Name")
    private String customerName;

    @CsvBindByName(column = "Category")
    private String category;

    @CsvBindByName(column = "Date")
    private String dateInString;

    private LocalDate date;

    @CsvBindByName(column = "Num")
    private String num;

    @CsvBindByName(column = "Sales Invoice")
    private String salesInvoice;

    @CsvBindByName(column = "Description")
    private String description;

    @CsvBindByName(column = "Qty. Sold")
    private String quantitySoldInString;

    private Integer quantitySold;

    @CsvBindByName(column = "Sales Price")
    private String salesPriceInString;

    private BigDecimal salesPrice;

    @CsvBindByName(column = "Amount (Net)")
    private String netAmountInString;

    private BigDecimal netAmount;

    @CsvBindByName(column = "Price Level")
    private String priceLevel;

    @CsvBindByName(column = "Credited to Territory Manager")
    private String creditedToTerritorialManager;

    @CsvBindByName(column = "Sales Rep: Name")
    private String salesRepName;

    @CsvBindByName(column = "Customer/Job: Acquisition CSR Credited To")
    private String customerJobAcquisitionCsrCreditedTo;

    @CsvBindByName(column = "Customer/Job: Retention CSR Credited To")
    private String customerJobRetentionCsrCreditedTo;

    @CsvBindByName(column = "Order Taken By")
    private String orderTakenBy;

    @CsvBindByName(column = "Address:Zip Code")
    private String addressZipCode;

    @CsvBindByName(column = "Sales Role: Name")
    private String salesRoleName;

    @CsvBindByName(column = "Address: Shipping Address City")
    private String addressShippingAddressCity;

    @CsvBindByName(column = "Address: Billing Address Line 1")
    private String addressBillingAddress1;

    @CsvBindByName(column = "Address: Billing Address Line 2")
    private String addressBillingAddress2;

    @CsvBindByName(column = "Customer/Job: Hospital 1")
    private String customerJobHospital1;

    @CsvBindByName(column = "Customer/Job: Doctor 1")
    private String customerJobDoctor1;

    @CsvBindByName(column = "Customer/Job: Referred By")
    private String customerJobReferredBy;

    @CsvBindByName(column = "PO Number")
    private String poNumber;

    @CsvBindByName(column = "Customer/Job: Mobile Phone")
    private String mobileNo;

    public LocalDate getItemDate() {
        return itemDate;
    }

    public void setItemDate(LocalDate itemDate) {
        this.itemDate = itemDate;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDateInString() {
        return dateInString;
    }

    public void setDateInString(String dateInString) {
        this.dateInString = dateInString;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSalesInvoice() {
        return salesInvoice;
    }

    public void setSalesInvoice(String salesInvoice) {
        this.salesInvoice = salesInvoice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantitySoldInString() {
        return quantitySoldInString;
    }

    public void setQuantitySoldInString(String quantitySoldInString) {
        this.quantitySoldInString = quantitySoldInString;
    }

    public Integer getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(Integer quantitySold) {
        this.quantitySold = quantitySold;
    }

    public String getSalesPriceInString() {
        return salesPriceInString;
    }

    public void setSalesPriceInString(String salesPriceInString) {
        this.salesPriceInString = salesPriceInString;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getNetAmountInString() {
        return netAmountInString;
    }

    public void setNetAmountInString(String netAmountInString) {
        this.netAmountInString = netAmountInString;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public String getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }

    public String getCreditedToTerritorialManager() {
        return creditedToTerritorialManager;
    }

    public void setCreditedToTerritorialManager(String creditedToTerritorialManager) {
        this.creditedToTerritorialManager = creditedToTerritorialManager;
    }

    public String getSalesRepName() {
        return salesRepName;
    }

    public void setSalesRepName(String salesRepName) {
        this.salesRepName = salesRepName;
    }

    public String getCustomerJobAcquisitionCsrCreditedTo() {
        return customerJobAcquisitionCsrCreditedTo;
    }

    public void setCustomerJobAcquisitionCsrCreditedTo(String customerJobAcquisitionCsrCreditedTo) {
        this.customerJobAcquisitionCsrCreditedTo = customerJobAcquisitionCsrCreditedTo;
    }

    public String getCustomerJobRetentionCsrCreditedTo() {
        return customerJobRetentionCsrCreditedTo;
    }

    public void setCustomerJobRetentionCsrCreditedTo(String customerJobRetentionCsrCreditedTo) {
        this.customerJobRetentionCsrCreditedTo = customerJobRetentionCsrCreditedTo;
    }

    public String getOrderTakenBy() {
        return orderTakenBy;
    }

    public void setOrderTakenBy(String orderTakenBy) {
        this.orderTakenBy = orderTakenBy;
    }

    public String getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public String getSalesRoleName() {
        return salesRoleName;
    }

    public void setSalesRoleName(String salesRoleName) {
        this.salesRoleName = salesRoleName;
    }

    public String getAddressShippingAddressCity() {
        return addressShippingAddressCity;
    }

    public void setAddressShippingAddressCity(String addressShippingAddressCity) {
        this.addressShippingAddressCity = addressShippingAddressCity;
    }

    public String getAddressBillingAddress1() {
        return addressBillingAddress1;
    }

    public void setAddressBillingAddress1(String addressBillingAddress1) {
        this.addressBillingAddress1 = addressBillingAddress1;
    }

    public String getAddressBillingAddress2() {
        return addressBillingAddress2;
    }

    public void setAddressBillingAddress2(String addressBillingAddress2) {
        this.addressBillingAddress2 = addressBillingAddress2;
    }

    public String getCustomerJobHospital1() {
        return customerJobHospital1;
    }

    public void setCustomerJobHospital1(String customerJobHospital1) {
        this.customerJobHospital1 = customerJobHospital1;
    }

    public String getCustomerJobDoctor1() {
        return customerJobDoctor1;
    }

    public void setCustomerJobDoctor1(String customerJobDoctor1) {
        this.customerJobDoctor1 = customerJobDoctor1;
    }

    public String getCustomerJobReferredBy() {
        return customerJobReferredBy;
    }

    public void setCustomerJobReferredBy(String customerJobReferredBy) {
        this.customerJobReferredBy = customerJobReferredBy;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void convertAllStringFieldsToProperType() {
        trimAllStringEntries();
        convertSalesPriceInStringToBigDecimal();
        convertDateInStringToLocalDate();
        convertQuantitySoldInStringToInteger();
        convertNetAmountInStringToBigDecimal();
    }

    private void trimAllStringEntries() {
        trimItem();
        trimType();
        trimCustomerName();
        trimCategory();
        trimDateInString();
        trimNum();
        trimSalesInvoice();
        trimDescription();
        trimQuantitySoldInString();
        trimSalesPriceInString();
        trimNetPriceInString();
        trimPriceLevel();
        trimCreditedToTerritorialManager();
        trimSalesRepName();
        trimCustomerJobAcquisitionCsrCreditedTo();
        trimCustomerJobRetentionCsrCreditedTo();
        trimOrderTakenBy();
        trimAddressZipCode();
        trimSalesRoleName();
        trimAddressShippingAddressCity();
        trimAddressBillingAddress1();
        trimAddressBillingAddress2();
        trimCustomerJobHospital1();
        trimCustomerJobDoctor1();
        trimCustomerJobReferredBy();
        trimMobileNo();
        trimPoNumber();
    }

    private void trimItem() {
        if (item != null) {
            item = item.trim();
        }
    }

    private void trimType() {
        if (type != null) {
            type = type.trim();
        }
    }

    private void trimCustomerName() {
        if (customerName != null) {
            customerName = customerName.trim();
        }
    }

    private void trimCategory() {
        if (category != null) {
            category = category.trim();
        }
    }

    private void trimDateInString() {
        if (dateInString != null) {
            dateInString = dateInString.trim();
        }
    }

    private void trimNum() {
        if (num != null) {
            num = num.trim();
        }
    }

    private void trimSalesInvoice() {
        if (salesInvoice != null) {
            salesInvoice = salesInvoice.trim();
        }
    }

    private void trimDescription() {
        if (description != null) {
            description = description.trim();
        }
    }

    private void trimQuantitySoldInString() {
        if (quantitySoldInString != null) {
            quantitySoldInString = quantitySoldInString.trim();
        }
    }

    private void trimSalesPriceInString() {
        if (salesPriceInString != null) {
            salesPriceInString = salesPriceInString.trim();
        }
    }

    private void trimNetPriceInString() {
        if (netAmountInString != null) {
            netAmountInString = netAmountInString.trim();
        }
    }

    private void trimPriceLevel() {
        if (priceLevel != null) {
            priceLevel = priceLevel.trim();
        }
    }

    private void trimCreditedToTerritorialManager() {
        if (creditedToTerritorialManager != null) {
            creditedToTerritorialManager = creditedToTerritorialManager.trim();
        }
    }

    private void trimSalesRepName() {
        if (salesRepName != null) {
            salesRepName = salesRepName.trim();
        }
    }

    private void trimCustomerJobAcquisitionCsrCreditedTo() {
        if (customerJobAcquisitionCsrCreditedTo != null) {
            customerJobAcquisitionCsrCreditedTo = customerJobAcquisitionCsrCreditedTo.trim();
        }
    }

    private void trimCustomerJobRetentionCsrCreditedTo() {
        if (customerJobRetentionCsrCreditedTo != null) {
            customerJobRetentionCsrCreditedTo = customerJobRetentionCsrCreditedTo.trim();
        }
    }

    private void trimOrderTakenBy() {
        if (orderTakenBy != null) {
            orderTakenBy = orderTakenBy.trim();
        }
    }

    private void trimAddressZipCode() {
        if (addressZipCode != null) {
            addressZipCode = addressZipCode.trim();
        }
    }

    private void trimSalesRoleName() {
        if (salesRoleName != null) {
            salesRoleName = salesRoleName.trim();
        }
    }

    private void trimAddressShippingAddressCity() {
        if (addressShippingAddressCity != null) {
            addressShippingAddressCity = addressShippingAddressCity.trim();
        }
    }

    private void trimAddressBillingAddress1() {
        if (addressBillingAddress1 != null) {
            addressBillingAddress1 = addressBillingAddress1.trim();
        }
    }

    private void trimAddressBillingAddress2() {
        if (addressBillingAddress2 != null) {
            addressBillingAddress2 = addressBillingAddress2.trim();
        }
    }

    private void trimCustomerJobHospital1() {
        if (customerJobHospital1 != null) {
            customerJobHospital1 = customerJobHospital1.trim();
        }
    }

    private void trimCustomerJobDoctor1() {
        if (customerJobDoctor1 != null) {
            customerJobDoctor1 = customerJobDoctor1.trim();
        }
    }

    private void trimCustomerJobReferredBy() {
        if (customerJobReferredBy != null) {
            customerJobReferredBy = customerJobReferredBy.trim();
        }
    }

    private void trimPoNumber() {
        if (poNumber != null) {
            poNumber = poNumber.trim();
        }
    }

    private void trimMobileNo() {
        if (mobileNo != null) {
            mobileNo = mobileNo.trim();
        }
    }

    private void convertDateInStringToLocalDate() {
        if (!StringUtils.isTrimmedValueNullOrEmpty(dateInString)) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yy");
            date = LocalDate.parse(dateInString, dateTimeFormatter);
        }
    }

    private void convertQuantitySoldInStringToInteger() {
        if (!StringUtils.isTrimmedValueNullOrEmpty(quantitySoldInString)) {
            quantitySoldInString = quantitySoldInString.replaceAll(",", "").trim();
            Double quantitySoldInDouble = Double.parseDouble(quantitySoldInString);
            quantitySold = quantitySoldInDouble.intValue();
        }
    }

    private void convertSalesPriceInStringToBigDecimal() {
        if (!StringUtils.isTrimmedValueNullOrEmpty(salesPriceInString)) {
            salesPrice = new BigDecimal(
                    salesPriceInString.replaceAll("PHP", "").replaceAll(",", ""));
        }
    }

    private void convertNetAmountInStringToBigDecimal() {
        if (!StringUtils.isTrimmedValueNullOrEmpty(netAmountInString)) {
            netAmount = new BigDecimal(
                    netAmountInString.replaceAll("PHP", "").replaceAll(",", ""));
        }
    }

}
