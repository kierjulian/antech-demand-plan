package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "mdc_per_branch_sales_acct")
@NamedQueries({
        @NamedQuery(name = "findAllMdcPerBranchSalesAccount",
                query = "select o from MdcPerBranchSalesAccount o"),
        @NamedQuery(name = "findMdcPerBranchSalesAccountById",
                query = "select o from MdcPerBranchSalesAccount o where o.id = :id")
})
public class MdcPerBranchSalesAccount {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shpcn")
    @CsvBindByName(column = "SHPCN")
    private String shpcn;

    @Column(name = "customer_name")
    @CsvBindByName(column = "CUSTNM")
    private String customerName;

    @Column(name = "branch_name")
    @CsvBindByName(column = "Branch Name")
    private String branchName;

    @Column(name = "cadd1")
    @CsvBindByName(column = "CADD1")
    private String cadd1;

    @Column(name = "cadd2")
    @CsvBindByName(column = "CADD2")
    private String cadd2;

    @Column(name = "na")
    @CsvBindByName(column = "NA")
    private String na;

    @Column(name = "dsm")
    @CsvBindByName(column = "DSM")
    private String dsm;

    @Column(name = "str_code")
    @CsvBindByName(column = "STR CODE")
    private String strCode;

    @Column(name = "coverage")
    @CsvBindByName(column = "COVERAGE")
    private String coverage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShpcn() {
        return shpcn;
    }

    public void setShpcn(String shpcn) {
        this.shpcn = shpcn;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCadd1() {
        return cadd1;
    }

    public void setCadd1(String cadd1) {
        this.cadd1 = cadd1;
    }

    public String getCadd2() {
        return cadd2;
    }

    public void setCadd2(String cadd2) {
        this.cadd2 = cadd2;
    }

    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na;
    }

    public String getDsm() {
        return dsm;
    }

    public void setDsm(String dsm) {
        this.dsm = dsm;
    }

    public String getStrCode() {
        return strCode;
    }

    public void setStrCode(String strCode) {
        this.strCode = strCode;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

}
