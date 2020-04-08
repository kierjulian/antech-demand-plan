package ph.edu.up.antech.domain.master.config;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "netsuite_transfer_cat")
@NamedQueries({
        @NamedQuery(name = "findNetsuiteTransfersCatById",
                query = "select o from NetsuiteTransfersCat o where o.id = :id"),
        @NamedQuery(name = "findAllNetsuiteTransfersCat",
                query = "select o from NetsuiteTransfersCat o")
})
public class NetsuiteTransfersCat {

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

    public NetsuiteTransfersCat() {
    }

    public NetsuiteTransfersCat(Integer id, String name, String code, String recode) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.recode = recode;
    }

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
