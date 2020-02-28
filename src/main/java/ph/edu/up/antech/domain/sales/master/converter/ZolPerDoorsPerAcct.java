package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "zol_door_acct")
@NamedQueries({
        @NamedQuery(name = "findZolPerDoorsPerAcctByZol",
                query = "select o from ZolPerDoorsPerAcct o where o.zol = :zol"),
        @NamedQuery(name = "findAllZolPerDoorsPerAcct",
                query = "select o from ZolPerDoorsPerAcct o"),
        @NamedQuery(name = "findZolPerDoorsPerAcctById",
                query = "select o from ZolPerDoorsPerAcct o where o.accountId = :id")
})
public class ZolPerDoorsPerAcct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    @CsvBindByName(column = "Loc")
    @Column(name = "location")
    private String location;

    @CsvBindByName(column = "ID")
    @Column(name = "id")
    private String id;

    @CsvBindByName(column = "SAP")
    @Column(name = "sap")
    private String sap;

    @CsvBindByName(column = "ZOL")
    @Column(name = "zol")
    private String zol;

    @CsvBindByName(column = "Branch")
    @Column(name = "branch")
    private String branch;

    @CsvBindByName(column = "Account")
    @Column(name = "account")
    private String account;

    @CsvBindByName(column = "KAM")
    @Column(name = "kam")
    private String kam;

    @CsvBindByName(column = "TM")
    @Column(name = "tm")
    private String tm;

    @CsvBindByName(column = "Share")
    @Column(name = "share")
    private String share;

    @CsvBindByName(column = "KAMREFNAME")
    @Column(name = "kam_refname")
    private String kamReferenceName;

    @CsvBindByName(column = "LOC2")
    @Column(name = "location2")
    private String location2;

    @CsvBindByName(column = "NA NAME")
    @Column(name = "na_name")
    private String naName;

    public ZolPerDoorsPerAcct() {
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSap() {
        return sap;
    }

    public void setSap(String sap) {
        this.sap = sap;
    }

    public String getZol() {
        return zol;
    }

    public void setZol(String zol) {
        this.zol = zol;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getKam() {
        return kam;
    }

    public void setKam(String kam) {
        this.kam = kam;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

    public String getLocation2() {
        return location2;
    }

    public void setLocation2(String location2) {
        this.location2 = location2;
    }

    public String getNaName() {
        return naName;
    }

    public void setNaName(String naName) {
        this.naName = naName;
    }

    public String getKamReferenceName() {
        return kamReferenceName;
    }

    public void setKamReferenceName(String kamReferenceName) {
        this.kamReferenceName = kamReferenceName;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

}
