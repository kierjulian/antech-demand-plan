package ph.edu.up.antech.domain.master.config;

public class ZolMdcSheet {

    private String accountName;
    private String zapCode;
    private String itemDescription;
    private Integer sumOfUnits;
    private Integer sumOfFinalNetValue;

    public ZolMdcSheet() {
    }

    public ZolMdcSheet(ZolMdcRaw zolMdcRaw) {
        this.accountName = zolMdcRaw.getAccountName();
        this.zapCode = zolMdcRaw.getZapCode();
        this.itemDescription = zolMdcRaw.getItemDescription();
        this.sumOfUnits = zolMdcRaw.getUnits();
        this.sumOfFinalNetValue = zolMdcRaw.getFinalNetVat().intValue();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getZapCode() {
        return zapCode;
    }

    public void setZapCode(String zapCode) {
        this.zapCode = zapCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getSumOfUnits() {
        return sumOfUnits;
    }

    public void setSumOfUnits(Integer sumOfUnits) {
        this.sumOfUnits = sumOfUnits;
    }

    public Integer getSumOfFinalNetValue() {
        return sumOfFinalNetValue;
    }

    public void setSumOfFinalNetValue(Integer sumOfFinalNetValue) {
        this.sumOfFinalNetValue = sumOfFinalNetValue;
    }

}
