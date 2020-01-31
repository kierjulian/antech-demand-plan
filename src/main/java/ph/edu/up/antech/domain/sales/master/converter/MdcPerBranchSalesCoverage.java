package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

public class MdcPerBranchSalesCoverage {

    private Integer id;

    @CsvBindByName(column = "Branch Code")
    private String branchCode;

    @CsvBindByName(column = "BRANCH NAME")
    private String branchName;

    @CsvBindByName(column = "NEW COVERAGE")
    private String newCoverage;

    @CsvBindByName(column = "OLD COVERAGE")
    private String oldCoverage;

    @CsvBindByName(column = "COORDINATOR")
    private String coordinator;

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
