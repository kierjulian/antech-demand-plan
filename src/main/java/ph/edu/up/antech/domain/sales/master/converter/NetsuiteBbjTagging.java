package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "netsuite_bjj_tagging")
@NamedQueries({
        @NamedQuery(name = "findAllNetsuiteBbjTagging",
                query = "select o from NetsuiteBbjTagging o")
})
public class NetsuiteBbjTagging implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @CsvBindByName(column = "Customer Name")
    @Column(name = "customer_name")
    private String customerName;

    @CsvBindByName(column = "Zone")
    @Column(name = "zone")
    private String zone;

    @CsvBindByName(column = "Address")
    @Column(name = "address")
    private String address;

    @CsvBindByName(column = "NEW CSR")
    @Column(name = "new_csr")
    private String newCsr;

    @CsvBindByName(column = "New Tagging of CSR")
    @Column(name = "new_tag_csr")
    private String newTaggingOfCsr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNewCsr() {
        return newCsr;
    }

    public void setNewCsr(String newCsr) {
        this.newCsr = newCsr;
    }

    public String getNewTaggingOfCsr() {
        return newTaggingOfCsr;
    }

    public void setNewTaggingOfCsr(String newTaggingOfCsr) {
        this.newTaggingOfCsr = newTaggingOfCsr;
    }

}
