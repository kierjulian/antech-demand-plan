package ph.edu.up.antech.domain.master.config;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "netsuite_other_info")
@NamedQueries({
        @NamedQuery(name = "findAllNetsuiteOtherInformation",
                query = "select o from NetsuiteOtherInformation o"),
        @NamedQuery(name = "findNetsuiteOtherInformationById",
                query = "select o from NetsuiteOtherInformation o where o.id = :id")
})
public class NetsuiteOtherInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    @CsvBindByName(column = "Type")
    private String type;

    @Column(name = "description")
    @CsvBindByName(column = "Description")
    private String description;

    @Column(name = "other_description")
    @CsvBindByName(column = "Other Description")
    private String otherDescription;

    public NetsuiteOtherInformation() {
    }

    public NetsuiteOtherInformation(Integer id, String type, String description, String otherDescription) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.otherDescription = otherDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

}
