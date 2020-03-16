package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "mdc_per_branch_sales_code")
@NamedQueries({
        @NamedQuery(name = "findAllMdcPerBranchSalesCode",
                query = "select o from MdcPerBranchSalesCode o"),
        @NamedQuery(name = "findMdcPerBranchSalesCodeById",
                query = "select o from MdcPerBranchSalesCode o where o.id = :id")
})
public class MdcPerBranchSalesCode {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    @CsvBindByName(column = "Code")
    private String code;

    @Column(name = "description")
    @CsvBindByName(column = "Description")
    private String description;

    public MdcPerBranchSalesCode() {
    }

    public MdcPerBranchSalesCode(Integer id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
