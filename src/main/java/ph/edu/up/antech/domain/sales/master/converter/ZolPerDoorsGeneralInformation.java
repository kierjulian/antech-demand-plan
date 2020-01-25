package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "zol_door_gen_info")
@NamedQueries({
        @NamedQuery(name = "findZolPerDoorsGeneralInformationByItemCode",
                query = "select o from ZolPerDoorsGeneralInformation o where o.itemCode = :itemCode"),
        @NamedQuery(name = "findZolPerDoorsGeneralInformationByZpcItemCode",
                query = "select o from ZolPerDoorsGeneralInformation o where o.zpcItemCode = :zpcItemCode")
})
public class ZolPerDoorsGeneralInformation implements Serializable {

    @Id
    @Column(name = "info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer generalInformationId;

    @CsvBindByName(column = "ZPCItemCode")
    @Column(name = "zpc_item_code")
    private String zpcItemCode;

    @CsvBindByName(column = "Item Code")
    @Column(name = "item_code")
    private String itemCode;

    @CsvBindByName(column = "Item Name")
    @Column(name = "item_name")
    private String itemName;

    @CsvBindByName(column = "Antech Prod Desc")
    @Column(name = "antech_prod_desc")
    private String antechProductDescription;

    @CsvBindByName(column = "Pcs/Cs")
    @Transient
    private String pcsCsInString;

    @Column(name = "pcs_cs")
    private Integer pcsCs;

    @CsvBindByName(column = "PC Amount")
    @Transient
    private String pcAmountInString;

    @Column(name = "pc_amount")
    private Integer pcAmount;

    @CsvBindByName(column = "per Case")
    @Transient
    private String perCaseInString;

    @Column(name = "per_case")
    private BigDecimal perCase;

    @CsvBindByName(column = "BRAND")
    @Column(name = "brand")
    private String brand;

    @CsvBindByName(column = "STAGE")
    @Column(name = "stage")
    private String stage;

    @CsvBindByName(column = "old price")
    @Transient
    private String oldPriceInString;

    @Column(name = "old_price")
    private BigDecimal oldPrice;

    @CsvBindByName(column = "new price effective")
    @Transient
    private String newPriceInString;

    @Column(name = "new_price")
    private BigDecimal newPrice;

    public ZolPerDoorsGeneralInformation() {
    }

    public Integer getGeneralInformationId() {
        return generalInformationId;
    }

    public void setGeneralInformationId(Integer generalInformationId) {
        this.generalInformationId = generalInformationId;
    }

    public String getZpcItemCode() {
        return zpcItemCode;
    }

    public void setZpcItemCode(String zpcItemCode) {
        this.zpcItemCode = zpcItemCode;
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

    public String getAntechProductDescription() {
        return antechProductDescription;
    }

    public void setAntechProductDescription(String antechProductDescription) {
        this.antechProductDescription = antechProductDescription;
    }

    public String getPcsCsInString() {
        return pcsCsInString;
    }

    public void setPcsCsInString(String pcsCsInString) {
        this.pcsCsInString = pcsCsInString;
    }

    public String getPcAmountInString() {
        return pcAmountInString;
    }

    public void setPcAmountInString(String pcAmountInString) {
        this.pcAmountInString = pcAmountInString;
    }

    public String getPerCaseInString() {
        return perCaseInString;
    }

    public void setPerCaseInString(String perCaseInString) {
        this.perCaseInString = perCaseInString;
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

    public String getOldPriceInString() {
        return oldPriceInString;
    }

    public void setOldPriceInString(String oldPriceInString) {
        this.oldPriceInString = oldPriceInString;
    }

    public String getNewPriceInString() {
        return newPriceInString;
    }

    public void setNewPriceInString(String newPriceInString) {
        this.newPriceInString = newPriceInString;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

    public Integer getPcsCs() {
        return pcsCs;
    }

    public void setPcsCs(Integer pcsCs) {
        this.pcsCs = pcsCs;
    }

    public Integer getPcAmount() {
        return pcAmount;
    }

    public void setPcAmount(Integer pcAmount) {
        this.pcAmount = pcAmount;
    }

    public BigDecimal getPerCase() {
        return perCase;
    }

    public void setPerCase(BigDecimal perCase) {
        this.perCase = perCase;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void removeBlankSpacesInStrings() {
        removeSpacesInZpcItemCode();
        removeSpacesInItemCode();
        removeSpacesInItemName();
        removeSpacesInAntechProductDescription();
        removeSpacesInPcsCsInString();
        removeSpacesInPcAmountInString();
        removeSpacesInPerCaseInString();
        removeSpacesInBrand();
        removeSpacesInStage();
        removeSpacesInOldPriceInString();
        removeSpacesInNewPriceInString();
    }

    private void removeSpacesInZpcItemCode() {
        if (zpcItemCode != null) {
            zpcItemCode = zpcItemCode.trim();
        }
    }

    private void removeSpacesInItemCode() {
        if (itemCode != null) {
            itemCode = itemCode.trim();
        }
    }

    private void removeSpacesInItemName() {
        if (itemName != null) {
            itemName = itemName.trim();
        }
    }

    private void removeSpacesInAntechProductDescription() {
        if (antechProductDescription != null) {
            antechProductDescription = antechProductDescription.trim();
        }
    }

    private void removeSpacesInPcsCsInString() {
        if (pcsCsInString != null) {
            pcsCsInString = pcsCsInString.trim();
        }
    }

    private void removeSpacesInPcAmountInString() {
        if (pcAmountInString != null) {
            pcAmountInString = pcAmountInString.trim();
        }
    }

    private void removeSpacesInPerCaseInString() {
        if (perCaseInString != null) {
            perCaseInString = perCaseInString.trim();
        }
    }

    private void removeSpacesInBrand() {
        if (brand != null) {
            brand = brand.trim();
        }
    }

    private void removeSpacesInStage() {
        if (stage != null) {
            stage = stage.trim();
        }
    }

    private void removeSpacesInOldPriceInString() {
        if (oldPriceInString != null) {
            oldPriceInString = oldPriceInString.trim();
        }
    }

    private void removeSpacesInNewPriceInString() {
        if (newPriceInString != null) {
            newPriceInString = newPriceInString.trim();
        }
    }

    public void convertStringsToCorrectType() {
        convertPcsCsFromStringToInt();
        convertPcAmountFromStringToInt();
        convertPerCaseFromStringToBigDecimal();
        convertOldPriceFromStringToBigDecimal();
        convertNewPriceFromStringToBigDecimal();
    }

    private void convertPcsCsFromStringToInt() {
        if (pcsCsInString != null && !pcsCsInString.trim().isEmpty()) {
            pcsCs = Integer.parseInt(pcsCsInString);
        }
    }

    private void convertPcAmountFromStringToInt() {
        if (pcAmountInString != null && !pcAmountInString.trim().isEmpty()) {
            pcAmount = Integer.parseInt(pcAmountInString);
        }
    }

    private void convertPerCaseFromStringToBigDecimal() {
        if (perCaseInString != null && !perCaseInString.trim().isEmpty()) {
            perCase = new BigDecimal(perCaseInString.trim());
        }
    }

    private void convertOldPriceFromStringToBigDecimal() {
        if (oldPriceInString != null && !oldPriceInString.trim().isEmpty()) {
            oldPrice = new BigDecimal(oldPriceInString.trim().replaceAll(",", ""));
        }
    }

    private void convertNewPriceFromStringToBigDecimal() {
        if (newPriceInString != null && !newPriceInString.trim().isEmpty()) {
            newPrice = new BigDecimal(newPriceInString.trim().replaceAll(",", ""));
        }
    }

}