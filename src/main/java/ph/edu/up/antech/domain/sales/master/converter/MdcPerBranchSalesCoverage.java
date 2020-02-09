package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "mdc_per_branch_sales_coverage")
@NamedQueries({
        @NamedQuery(name = "findAllMdcPerBranchSalesCoverage",
                query = "select o from MdcPerBranchSalesCoverage o"),
        @NamedQuery(name = "findMdcPerBranchSalesCoverageById",
                query = "select o from MdcPerBranchSalesCoverage o where o.id = :id")
})
public class MdcPerBranchSalesCoverage {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "branch_code")
    @CsvBindByName(column = "Branch Code")
    private String branchCode;

    @Column(name = "branch_name")
    @CsvBindByName(column = "BRANCH NAME")
    private String branchName;

    @Column(name = "new_coverage")
    @CsvBindByName(column = "NEW COVERAGE")
    private String newCoverage;

    @Column(name = "old_coverage")
    @CsvBindByName(column = "OLD COVERAGE")
    private String oldCoverage;

    @Column(name = "coordinator")
    @CsvBindByName(column = "COORDINATOR")
    private String coordinator;

    @Column(name = "region")
    @CsvBindByName(column = "REGION")
    private String region;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getNewCoverage() {
        return newCoverage;
    }

    public void setNewCoverage(String newCoverage) {
        this.newCoverage = newCoverage;
    }

    public String getOldCoverage() {
        return oldCoverage;
    }

    public void setOldCoverage(String oldCoverage) {
        this.oldCoverage = oldCoverage;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
