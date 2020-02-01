package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "mdc_per_branch_sales_na_configuration")
@NamedQueries({
        @NamedQuery(name = "findAllMdcPerBranchSalesNaConfiguration",
                query = "select o from MdcPerBranchSalesNaConfiguration o")
})
public class MdcPerBranchSalesNaConfiguration {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "na_name")
    @CsvBindByName(column = "NA_NAME")
    private String naName;

    @Column(name = "dsm")
    @CsvBindByName(column = "DSM")
    private String dsm;

    @Column(name = "region")
    @CsvBindByName(column = "REGION")
    private String region;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaName() {
        return naName;
    }

    public void setNaName(String naName) {
        this.naName = naName;
    }

    public String getDsm() {
        return dsm;
    }

    public void setDsm(String dsm) {
        this.dsm = dsm;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
