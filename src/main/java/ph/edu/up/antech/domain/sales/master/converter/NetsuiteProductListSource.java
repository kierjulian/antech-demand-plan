package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "netsuite_prod_list_source")
@NamedQueries({
        @NamedQuery(name = "findAllNetsuiteProductListSource",
                query = "select o from NetsuiteProductListSource o"),
        @NamedQuery(name = "findNetsuiteProductListSourceById",
                query = "select o from NetsuiteProductListSource o where o.id = :id")
})
public class NetsuiteProductListSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "source")
    @CsvBindByName(column = "SOURCE")
    private String source;

    @Column(name = "origin")
    @CsvBindByName(column = "FROM")
    private String origin;

    @Column(name = "destination")
    @CsvBindByName(column = "TO")
    private String destination;

    @Column(name = "description")
    @CsvBindByName(column = "DESC")
    private String description;

    @Column(name = "in_pcs")
    @CsvBindByName(column = "In PCS")
    private Integer inPcs;

    @Column(name = "product")
    @CsvBindByName(column = "Prod")
    private String product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInPcs() {
        return inPcs;
    }

    public void setInPcs(Integer inPcs) {
        this.inPcs = inPcs;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

}
