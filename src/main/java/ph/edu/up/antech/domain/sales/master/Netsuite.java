package ph.edu.up.antech.domain.sales.master;

import ph.edu.up.antech.domain.sales.raw.CustomerSalesByItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class Netsuite {

    private LocalDate itemDate;
    private String type;
    private String customer;
    private String category;
    private LocalDate date;
    private String num;
    private String createdFrom;
    private String description;
    private Integer quantity;
    private BigDecimal salesPrice;
    private BigDecimal revenue;
    private String priceLevel;
    private String creditedToTerritorialManager;
    private String salesRep;
    private String customerSince;
    private String zone;
    private String customerJobZone;
    private String pickup;
    private String billingAddressLine1;
    private String billingAddressLine2;
    private String kamRefName1;
    private String region;
    private BigDecimal revenueConverted;
    private Month month;
    private String naLeft;
    private String trim;
    private String kamRefName2;
    private String mgmt;
    private String csrTagging;
    private String asm;
    private String productCategory;

    public Netsuite() {
    }

    public Netsuite(CustomerSalesByItem customerSalesByItem) {
        this.itemDate = customerSalesByItem.getItemDate();
        this.type = customerSalesByItem.getType();
        this.customer = customerSalesByItem.getCustomerName();
        this.category = customerSalesByItem.getCategory();
        this.date = customerSalesByItem.getDate();
        this.num = customerSalesByItem.getNum();
        this.createdFrom = customerSalesByItem.getSalesInvoice();
        this.description = customerSalesByItem.getDescription();
        this.quantity = customerSalesByItem.getQuantitySold();
        this.salesPrice = customerSalesByItem.getSalesPrice();
        this.revenue = customerSalesByItem.getNetAmount();
        this.priceLevel = customerSalesByItem.getPriceLevel();
        this.creditedToTerritorialManager = customerSalesByItem.getCreditedToTerritorialManager();
        this.salesRep = customerSalesByItem.getSalesRepName();
        this.customerSince = customerSalesByItem.getSalesRoleName();
        this.zone = customerSalesByItem.getAddressZipCode();
        this.customerJobZone = customerSalesByItem.getAddressBillingAddress1();
        this.pickup = customerSalesByItem.getAddressBillingAddress2();
    }

    public LocalDate getItemDate() {
        return itemDate;
    }

    public void setItemDate(LocalDate itemDate) {
        this.itemDate = itemDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getCreatedFrom() {
        return createdFrom;
    }

    public void setCreatedFrom(String createdFrom) {
        this.createdFrom = createdFrom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
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

    public String getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(String salesRep) {
        this.salesRep = salesRep;
    }

    public String getCustomerSince() {
        return customerSince;
    }

    public void setCustomerSince(String customerSince) {
        this.customerSince = customerSince;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCustomerJobZone() {
        return customerJobZone;
    }

    public void setCustomerJobZone(String customerJobZone) {
        this.customerJobZone = customerJobZone;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getBillingAddressLine1() {
        return billingAddressLine1;
    }

    public void setBillingAddressLine1(String billingAddressLine1) {
        this.billingAddressLine1 = billingAddressLine1;
    }

    public String getBillingAddressLine2() {
        return billingAddressLine2;
    }

    public void setBillingAddressLine2(String billingAddressLine2) {
        this.billingAddressLine2 = billingAddressLine2;
    }

    public String getKamRefName1() {
        return kamRefName1;
    }

    public void setKamRefName1(String kamRefName1) {
        this.kamRefName1 = kamRefName1;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getRevenueConverted() {
        return revenueConverted;
    }

    public void setRevenueConverted(BigDecimal revenueConverted) {
        this.revenueConverted = revenueConverted;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public String getNaLeft() {
        return naLeft;
    }

    public void setNaLeft(String naLeft) {
        this.naLeft = naLeft;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getKamRefName2() {
        return kamRefName2;
    }

    public void setKamRefName2(String kamRefName2) {
        this.kamRefName2 = kamRefName2;
    }

    public String getMgmt() {
        return mgmt;
    }

    public void setMgmt(String mgmt) {
        this.mgmt = mgmt;
    }

    public String getCsrTagging() {
        return csrTagging;
    }

    public void setCsrTagging(String csrTagging) {
        this.csrTagging = csrTagging;
    }

    public String getAsm() {
        return asm;
    }

    public void setAsm(String asm) {
        this.asm = asm;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

}
