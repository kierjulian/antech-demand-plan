package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

public class NetsuiteGeneralInformation {

    @CsvBindByName(column = "Customer/Job")
    private String customerJob;

    @CsvBindByName(column = "Account")
    private String account;

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "NA #")
    private String naNumber;

    @CsvBindByName(column = "KAM_REF_NAME")
    private String kamReferenceName;

    @CsvBindByName(column = "Location")
    private String location;

    public String getCustomerJob() {
        return customerJob;
    }

    public void setCustomerJob(String customerJob) {
        this.customerJob = customerJob;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNaNumber() {
        return naNumber;
    }

    public void setNaNumber(String naNumber) {
        this.naNumber = naNumber;
    }

    public String getKamReferenceName() {
        return kamReferenceName;
    }

    public void setKamReferenceName(String kamReferenceName) {
        this.kamReferenceName = kamReferenceName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
