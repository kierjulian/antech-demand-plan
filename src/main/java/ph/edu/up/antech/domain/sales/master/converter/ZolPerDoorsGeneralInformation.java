package ph.edu.up.antech.domain.sales.master.converter;

import java.math.BigDecimal;

public class ZolPerDoorsGeneralInformation {

    private String zpcItemCode;
    private String itemCode;
    private String itemName;
    private String antechProductDescription;
    private String pcsCs;
    private BigDecimal pcAmount;
    private BigDecimal perCase;
    private String brand;
    private String stage;
    private BigDecimal oldPrice;
    private BigDecimal newPrice;

    public ZolPerDoorsGeneralInformation() {
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

    public String getPcsCs() {
        return pcsCs;
    }

    public void setPcsCs(String pcsCs) {
        this.pcsCs = pcsCs;
    }

    public BigDecimal getPcAmount() {
        return pcAmount;
    }

    public void setPcAmount(BigDecimal pcAmount) {
        this.pcAmount = pcAmount;
    }

    public BigDecimal getPerCase() {
        return perCase;
    }

    public void setPerCase(BigDecimal perCase) {
        this.perCase = perCase;
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

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

}
