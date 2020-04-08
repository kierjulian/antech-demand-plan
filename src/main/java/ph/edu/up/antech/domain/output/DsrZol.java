package ph.edu.up.antech.domain.output;

import ph.edu.up.antech.domain.master.ZolPerDoors;

import java.util.Objects;

public class DsrZol {

    private String kamReferenceName;
    private String antechProductDescription;
    private Integer amount;
    private String account;
    private Integer salesUnit;

    public DsrZol() {
    }

    public DsrZol(ZolPerDoors zolPerDoors) {
        if (Objects.nonNull(zolPerDoors)) {
            this.kamReferenceName = zolPerDoors.getKamReferenceName();
            this.antechProductDescription = zolPerDoors.getAntechProductDescription();
            this.amount = zolPerDoors.getAmount();
            this.account = zolPerDoors.getAccount();
            this.salesUnit = zolPerDoors.getSalesUnit();
        }
    }

    public String getKamReferenceName() {
        return kamReferenceName;
    }

    public void setKamReferenceName(String kamReferenceName) {
        this.kamReferenceName = kamReferenceName;
    }

    public String getAntechProductDescription() {
        return antechProductDescription;
    }

    public void setAntechProductDescription(String antechProductDescription) {
        this.antechProductDescription = antechProductDescription;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getSalesUnit() {
        return salesUnit;
    }

    public void setSalesUnit(Integer salesUnit) {
        this.salesUnit = salesUnit;
    }

}
