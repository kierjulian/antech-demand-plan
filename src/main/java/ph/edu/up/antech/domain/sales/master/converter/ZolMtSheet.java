package ph.edu.up.antech.domain.sales.master.converter;

public class ZolMtSheet {

    private String accountName;
    private String zapCode;
    private String itemDescription;
    private Integer sumOfUnits;
    private Integer sumOfFinalNetValue;

    public ZolMtSheet() {
    }

    public ZolMtSheet(ZolMtRaw zolMtRaw) {
        this.accountName = zolMtRaw.getAccountName();
        this.zapCode = zolMtRaw.getZapCode();
        this.itemDescription = zolMtRaw.getItemDescription();
        this.sumOfUnits = zolMtRaw.getUnits();
        if (zolMtRaw.getFinalNetVat() != null) {
            this.sumOfFinalNetValue = zolMtRaw.getFinalNetVat().intValue();
        }
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
