package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "netsuite_transfer_cat")
@NamedQueries({
        @NamedQuery(name = "findNetsuiteTransferCatById",
                query = "select o from NetsuiteTransferCat o where o.id = :id"),
        @NamedQuery(name = "findAllNetsuiteTransferCat",
                query = "select o from NetsuiteTransferCat o")
})
public class NetsuiteTransferCat {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @CsvBindByName(column = "Name")
    private String name;

    @Column(name = "code")
    @CsvBindByName(column = "Code")
    private String code;

    @Column(name = "recode")
    @CsvBindByName(column = "Recode")
    private String recode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRecode() {
        return recode;
    }

    public void setRecode(String recode) {
        this.recode = recode;
    }

}
