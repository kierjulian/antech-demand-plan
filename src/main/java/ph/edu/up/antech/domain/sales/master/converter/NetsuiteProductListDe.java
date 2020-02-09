package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "netsuite_prod_list_de")
@NamedQueries({
        @NamedQuery(name = "findAllNetsuiteProductListDe",
                query = "select o from NetsuiteProductListDe o"),
        @NamedQuery(name = "findNetsuiteProductListDeById",
                query = "select o from NetsuiteProductListDe o where o.id = :id")
})
public class NetsuiteProductListDe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    @CsvBindByName(column = "Item Description")
    private String description;

    @Column(name = "stage")
    @CsvBindByName(column = "Stage")
    private String stage;

    @Column(name = "product_code")
    @CsvBindByName(column = "Product Code")
    private String productCode;

    @Column(name = "product_type")
    @CsvBindByName(column = "Type")
    private String productType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

}
