package ph.edu.up.antech.domain.sales.master;

import org.springframework.format.annotation.DateTimeFormat;
import ph.edu.up.antech.domain.sales.master.converter.*;
import ph.edu.up.antech.domain.sales.raw.CustomerSalesByItem;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "netsuite")
@NamedQueries({
        @NamedQuery(name = "findNetsuiteByItemDate",
                query = "select o from Netsuite o where o.itemDate = :itemDate"),
        @NamedQuery(name = "removeNetsuiteByDate",
                query = "delete from Netsuite o where o.itemDate = :itemDate"),
        @NamedQuery(name = "findNetsuiteBetweenTwoDates",
                query = "select o from Netsuite o where o.itemDate >= :startDate and o.itemDate <= :endDate"),
        @NamedQuery(name = "findNetsuiteById",
                query = "select o from Netsuite o where o.id = :id")
})

@NamedNativeQueries({
        @NamedNativeQuery(
                name = "findNetsuiteSalesAmountAndUnitBetweenTwoDates",
                query = "select o.id, o.item_date, o.kam_ref_name1, o.brand, o.transfers_cat_recode, " +
                        "o.mgmt, o.revenue_converted, o.quantity " +
                        "from netsuite o where o.item_date >= :startDate and o.item_date <= :endDate",
                resultSetMapping = "netsuiteSalesAmountAndUnitResult")
})

@SqlResultSetMapping(name = "netsuiteSalesAmountAndUnitResult", classes = {
        @ConstructorResult(targetClass = Netsuite.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "item_date", type = LocalDate.class),
                        @ColumnResult(name = "kam_ref_name1", type = String.class),
                        @ColumnResult(name = "brand", type = String.class),
                        @ColumnResult(name = "transfers_cat_recode", type = String.class),
                        @ColumnResult(name = "mgmt", type = String.class),
                        @ColumnResult(name = "revenue_converted", type = BigDecimal.class),
                        @ColumnResult(name = "quantity", type = Integer.class)
                })
})
public class Netsuite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "item_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate itemDate;

    @Column(name = "type")
    private String type;

    @Column(name = "customer")
    private String customer;

    @Column(name = "category")
    private String category;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "num")
    private String num;

    @Column(name = "created_from")
    private String createdFrom;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "sales_price")
    private BigDecimal salesPrice;

    @Column(name = "revenue")
    private BigDecimal revenue;

    @Column(name = "price_level")
    private String priceLevel;

    @Column(name = "territorial_manager")
    private String creditedToTerritorialManager;

    @Column(name = "sales_rep")
    private String salesRep;

    @Column(name = "acquisition_credited")
    private String acquisitionCsrCreditedTo;

    @Column(name = "retention_credited")
    private String retentionCsrCreditedTo;

    @Column(name = "order_taken_by")
    private String orderTakenBy;

    @Column(name = "awareness")
    private String awareness;

    @Column(name = "customer_since")
    private String customerSince;

    @Column(name = "zone")
    private String zone;

    @Column(name = "customer_job_zone")
    private String customerJobZone;

    @Column(name = "pickup")
    private String pickup;

    @Column(name = "bill_address_1")
    private String billingAddressLine1;

    @Column(name = "bill_address_2")
    private String billingAddressLine2;

    @Column(name = "customer_job_hosp1")
    private String customerJobHospital1;

    @Column(name = "x")
    private String x;

    @Column(name = "a")
    private String a;

    @Column(name = "formula")
    private String formula;

    @Column(name = "brand")
    private String brand;

    @Column(name = "stage")
    private String stage;

    @Column(name = "transfers_cat")
    private String transfersCat;

    @Column(name = "transfers_cat_recode")
    private String transfersCatRecode;

    @Column(name = "in_pcs")
    private Integer inPcs;

    @Column(name = "conv_units")
    private Integer convUnits;

    @Column(name = "prod_desc")
    private String desc;

    @Column(name = "kam_ref_name1")
    private String kamRefName1;

    @Column(name = "region")
    private String region;

    @Column(name = "revenue_converted")
    private BigDecimal revenueConverted;

    @Column(name = "na_left")
    private String naLeft;

    @Column(name = "trim")
    private String trim;

    @Column(name = "kam_ref_name2")
    private String kamRefName2;

    @Column(name = "mgmt")
    private String mgmt;

    @Column(name = "csr_tagging")
    private String csrTagging;

    @Column(name = "asm")
    private String asm;

    @Column(name = "product_category")
    private String productCategory;

    public Netsuite() {
    }

    public Netsuite(Integer id, LocalDate itemDate, String kamRefName1, String brand, String transfersCatRecode,
                    String mgmt, BigDecimal revenueConverted, Integer quantity) {
        this.id = id;
        this.itemDate = itemDate;
        this.kamRefName1 = kamRefName1;
        this.brand = brand;
        this.transfersCatRecode = transfersCatRecode;
        this.mgmt = mgmt;
        this.revenueConverted = revenueConverted;
        this.quantity = quantity;
    }

    public Netsuite(Integer id, LocalDate itemDate, String type, String customer, String category, LocalDate date, String num,
                    String createdFrom, String description, Integer quantity, BigDecimal salesPrice,
                    BigDecimal revenue, String priceLevel, String creditedToTerritorialManager, String salesRep,
                    String acquisitionCsrCreditedTo, String retentionCsrCreditedTo, String orderTakenBy,
                    String awareness, String customerSince, String zone, String customerJobZone, String pickup,
                    String billingAddressLine1, String billingAddressLine2, String customerJobHospital1, String x,
                    String a, String formula, String brand, String stage, String transfersCat,
                    String transfersCatRecode, Integer inPcs, Integer convUnits, String desc, String kamRefName1,
                    String region, BigDecimal revenueConverted, String naLeft, String trim, String kamRefName2,
                    String mgmt, String csrTagging, String asm, String productCategory) {
        this.id = id;
        this.itemDate = itemDate;
        this.type = type;
        this.customer = customer;
        this.category = category;
        this.date = date;
        this.num = num;
        this.createdFrom = createdFrom;
        this.description = description;
        this.quantity = quantity;
        this.salesPrice = salesPrice;
        this.revenue = revenue;
        this.priceLevel = priceLevel;
        this.creditedToTerritorialManager = creditedToTerritorialManager;
        this.salesRep = salesRep;
        this.acquisitionCsrCreditedTo = acquisitionCsrCreditedTo;
        this.retentionCsrCreditedTo = retentionCsrCreditedTo;
        this.orderTakenBy = orderTakenBy;
        this.awareness = awareness;
        this.customerSince = customerSince;
        this.zone = zone;
        this.customerJobZone = customerJobZone;
        this.pickup = pickup;
        this.billingAddressLine1 = billingAddressLine1;
        this.billingAddressLine2 = billingAddressLine2;
        this.customerJobHospital1 = customerJobHospital1;
        this.x = x;
        this.a = a;
        this.formula = formula;
        this.brand = brand;
        this.stage = stage;
        this.transfersCat = transfersCat;
        this.transfersCatRecode = transfersCatRecode;
        this.inPcs = inPcs;
        this.convUnits = convUnits;
        this.desc = desc;
        this.kamRefName1 = kamRefName1;
        this.region = region;
        this.revenueConverted = revenueConverted;
        this.naLeft = naLeft;
        this.trim = trim;
        this.kamRefName2 = kamRefName2;
        this.mgmt = mgmt;
        this.csrTagging = csrTagging;
        this.asm = asm;
        this.productCategory = productCategory;
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
        this.acquisitionCsrCreditedTo = customerSalesByItem.getCustomerJobAcquisitionCsrCreditedTo();
        this.retentionCsrCreditedTo = customerSalesByItem.getCustomerJobRetentionCsrCreditedTo();
        this.orderTakenBy = customerSalesByItem.getOrderTakenBy();
        this.awareness = customerSalesByItem.getAddressZipCode();
        this.customerSince = customerSalesByItem.getSalesRoleName();
        this.zone = customerSalesByItem.getAddressShippingAddressCity();
        this.customerJobZone = customerSalesByItem.getAddressBillingAddress1();
        this.pickup = customerSalesByItem.getAddressBillingAddress2();
        this.billingAddressLine1 = customerSalesByItem.getCustomerJobHospital1();
        this.billingAddressLine2 = customerSalesByItem.getCustomerJobDoctor1();
        this.customerJobHospital1 = customerSalesByItem.getCustomerJobReferredBy();
        this.x = customerSalesByItem.getPoNumber();
        this.a = customerSalesByItem.getMobileNo();
        generateOtherValues();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAcquisitionCsrCreditedTo() {
        return acquisitionCsrCreditedTo;
    }

    public void setAcquisitionCsrCreditedTo(String acquisitionCsrCreditedTo) {
        this.acquisitionCsrCreditedTo = acquisitionCsrCreditedTo;
    }

    public String getRetentionCsrCreditedTo() {
        return retentionCsrCreditedTo;
    }

    public void setRetentionCsrCreditedTo(String retentionCsrCreditedTo) {
        this.retentionCsrCreditedTo = retentionCsrCreditedTo;
    }

    public String getOrderTakenBy() {
        return orderTakenBy;
    }

    public void setOrderTakenBy(String orderTakenBy) {
        this.orderTakenBy = orderTakenBy;
    }

    public String getAwareness() {
        return awareness;
    }

    public void setAwareness(String awareness) {
        this.awareness = awareness;
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

    public String getCustomerJobHospital1() {
        return customerJobHospital1;
    }

    public void setCustomerJobHospital1(String customerJobHospital1) {
        this.customerJobHospital1 = customerJobHospital1;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getTransfersCat() {
        return transfersCat;
    }

    public void setTransfersCat(String transfersCat) {
        this.transfersCat = transfersCat;
    }

    public String getTransfersCatRecode() {
        return transfersCatRecode;
    }

    public void setTransfersCatRecode(String transfersCatRecode) {
        this.transfersCatRecode = transfersCatRecode;
    }

    public Integer getInPcs() {
        return inPcs;
    }

    public void setInPcs(Integer inPcs) {
        this.inPcs = inPcs;
    }

    public Integer getConvUnits() {
        return convUnits;
    }

    public void setConvUnits(Integer convUnits) {
        this.convUnits = convUnits;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public void generateOtherValues() {
        generateRevenueConverted();
        generateNaLeftAndTrim();
    }

    private void generateRevenueConverted() {
        if (revenue != null) {
            revenueConverted = revenue.multiply(new BigDecimal("0.001"));
        }
    }

    private void generateNaLeftAndTrim() {
        if (creditedToTerritorialManager != null) {
            naLeft = creditedToTerritorialManager;
            trim = creditedToTerritorialManager;
        }
    }

    public void generateValuesFromNetsuiteGeneralInformation(NetsuiteGeneralInformation netsuiteGeneralInformation) {
        if (netsuiteGeneralInformation != null) {
            this.kamRefName1 = netsuiteGeneralInformation.getKamReferenceName();
        }
    }

    public void generateValuesFromMdcPerBranchSalesNaConfiguration(
            MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration) {
        if (mdcPerBranchSalesNaConfiguration != null) {
            this.region = mdcPerBranchSalesNaConfiguration.getDsm();
            this.asm = mdcPerBranchSalesNaConfiguration.getRegion();
        }
    }

    public void generateValuesFromNetsuiteProductListSource(NetsuiteProductListSource netsuiteProductListSource) {
        if (netsuiteProductListSource != null) {
            this.formula = netsuiteProductListSource.getDestination();
            this.inPcs = netsuiteProductListSource.getInPcs();
            this.desc = netsuiteProductListSource.getProduct();
        }
    }

    public void generateValuesFromNetsuiteProductListDe(NetsuiteProductListDe netsuiteProductListDe) {
        if (netsuiteProductListDe != null) {
            this.brand = netsuiteProductListDe.getProductCode();
            this.stage = netsuiteProductListDe.getStage();
            this.productCategory = netsuiteProductListDe.getProductType();
        }
    }

    public void generateValuesFromNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation) {
        if (netsuiteOtherInformation != null) {
            this.mgmt = netsuiteOtherInformation.getDescription();
        }
    }

    public void generateValuesFromNetsuiteBjjTagging(NetsuiteBbjTagging netsuiteBbjTagging) {
        if (netsuiteBbjTagging != null) {
            this.csrTagging = netsuiteBbjTagging.getNewTaggingOfCsr();
        }
    }

    public void generateValuesFromNetsuiteTransfersCat(NetsuiteTransferCat netsuiteTransferCat) {
        if (netsuiteTransferCat != null) {
            this.transfersCat = netsuiteTransferCat.getCode();
            this.transfersCatRecode = netsuiteTransferCat.getRecode();
        }
    }

    public void generateValuesWhenOtherValuesArePopulated() {
        if (this.inPcs != null && this.quantity != null) {
            this.convUnits = this.inPcs * quantity;
        }
    }

}
