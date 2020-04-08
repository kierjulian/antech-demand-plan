package ph.edu.up.antech.domain.master.config;

import com.opencsv.bean.CsvBindByName;
import ph.edu.up.antech.util.StringUtils;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "mdc_per_branch_sales_info")
@NamedQueries({
        @NamedQuery(name = "findAllMdcPerBranchSalesInformation",
                query = "select o from MdcPerBranchSalesInformation o"),
        @NamedQuery(name = "findMdcPerBranchSalesInformationById",
                query = "select o from MdcPerBranchSalesInformation o where o.id = :id")
})
public class MdcPerBranchSalesInformation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item_number")
    @CsvBindByName(column = "Item Number")
    private String itemNumber;

    @Column(name = "item_description")
    @CsvBindByName(column = "Item Description")
    private String itemDescription;

    @Column(name = "item_short_desc")
    @CsvBindByName(column = "Item Short Description")
    private String itemShortDescription;

    @Column(name = "quantity")
    @CsvBindByName(column = "Quantity")
    private Integer quantity;

    @Transient
    @CsvBindByName(column = "Price")
    private String priceInString;

    @Column(name = "price")
    private BigDecimal price;

    @Transient
    @CsvBindByName(column = "Total")
    private String totalInString;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "item_code")
    @CsvBindByName(column = "Item Code")
    private String itemCode;

    @Column(name = "stage")
    @CsvBindByName(column = "Stage")
    private String stage;

    @Column(name = "item_type")
    @CsvBindByName(column = "Item Type")
    private String itemType;

    public MdcPerBranchSalesInformation() {
    }

    public MdcPerBranchSalesInformation(Integer id, String itemNumber, String itemDescription,
                                        String itemShortDescription, Integer quantity, BigDecimal price,
                                        BigDecimal total, String itemCode, String stage, String itemType) {
        this.id = id;
        this.itemNumber = itemNumber;
        this.itemDescription = itemDescription;
        this.itemShortDescription = itemShortDescription;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.itemCode = itemCode;
        this.stage = stage;
        this.itemType = itemType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemShortDescription() {
        return itemShortDescription;
    }

    public void setItemShortDescription(String itemShortDescription) {
        this.itemShortDescription = itemShortDescription;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public String getTotalInString() {
        return totalInString;
    }

    public void setTotalInString(String totalInString) {
        this.totalInString = totalInString;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void convertStringTypesToCorrectTypes() {
        convertPriceInStringToBigDecimal();
        convertTotalInStringToBigDecimal();
    }

    private void convertPriceInStringToBigDecimal() {
        if (!StringUtils.isNullOrEmpty(priceInString)) {
            price = new BigDecimal(priceInString);
        }
    }

    private void convertTotalInStringToBigDecimal() {
        if (!StringUtils.isNullOrEmpty(totalInString)) {
            total = new BigDecimal(totalInString);
        }
    }

}
