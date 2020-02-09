package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "netsuite_gen_info")
@NamedQueries({
        @NamedQuery(name = "findAllNetsuiteGeneralInformation",
                query = "select o from NetsuiteGeneralInformation o"),
        @NamedQuery(name = "findNetsuiteGeneralInformationById",
                query = "select o from NetsuiteGeneralInformation o where o.id = :id")
})
public class NetsuiteGeneralInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_job")
    @CsvBindByName(column = "Customer/Job")
    private String customerJob;

    @Column(name = "account")
    @CsvBindByName(column = "Account")
    private String account;

    @Column(name = "name")
    @CsvBindByName(column = "Name")
    private String name;

    @Column(name = "na_number")
    @CsvBindByName(column = "NA #")
    private String naNumber;

    @Column(name = "kam_ref_name")
    @CsvBindByName(column = "KAM_REF_NAME")
    private String kamReferenceName;

    @Column(name = "location")
    @CsvBindByName(column = "Location")
    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
