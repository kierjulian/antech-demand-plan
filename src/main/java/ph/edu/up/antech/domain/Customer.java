package ph.edu.up.antech.domain;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(name = "findCustomerByCustomerCodeAndMaterialCode",
                query = "select o from Customer o where o.customerCode = :customerCode " +
                        "and o.materialCode = :materialCode"),
        @NamedQuery(name = "findCustomerByCustomerCode",
                query = "select o from Customer o where o.customerCode = :customerCode"),
        @NamedQuery(name = "findZolMaterialCodeByMaterialCode",
                query = "select o.zolMaterialCode from Customer o where o.materialCode = :materialCode"),
        @NamedQuery(name = "findAllCustomers",
                query = "select o from Customer o"),
        @NamedQuery(name = "findAllCustomersByCustomerCode",
                query = "select o from Customer o where o.customerCode = :customerCode"),
        @NamedQuery(name = "findCustomerById",
                query = "select o from Customer o where o.id = :id")
})
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_code")
    @CsvBindByName(column = "Sold To Customer Code")
    private String customerCode;

    @Column(name = "customer_name")
    @CsvBindByName(column = "Sold To Customer Name")
    private String customerName;

    @Column(name = "zol_customer_code")
    @CsvBindByName(column = "ZOL Customer Code")
    private String zolCustomerCode;

    @Column(name = "zol_customer_name")
    @CsvBindByName(column = "ZOL Customer Name")
    private String zolCustomerName;

    @Column(name = "material_code")
    @CsvBindByName(column = "Material Code")
    private String materialCode;

    @Column(name = "zol_material_code")
    @CsvBindByName(column = "ZOL Material Code")
    private String zolMaterialCode;

    @Column(name = "material_desc")
    @CsvBindByName(column = "Material Desc")
    private String materialDescription;

    public Customer() {
    }

    public Customer(Integer id, String customerCode, String customerName, String zolCustomerCode,
                    String zolCustomerName, String materialCode, String zolMaterialCode, String materialDescription) {
        this.id = id;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.zolCustomerCode = zolCustomerCode;
        this.zolCustomerName = zolCustomerName;
        this.materialCode = materialCode;
        this.zolMaterialCode = zolMaterialCode;
        this.materialDescription = materialDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getZolCustomerCode() {
        return zolCustomerCode;
    }

    public void setZolCustomerCode(String zolCustomerCode) {
        this.zolCustomerCode = zolCustomerCode;
    }

    public String getZolCustomerName() {
        return zolCustomerName;
    }

    public void setZolCustomerName(String zolCustomerName) {
        this.zolCustomerName = zolCustomerName;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getZolMaterialCode() {
        return zolMaterialCode;
    }

    public void setZolMaterialCode(String zolMaterialCode) {
        this.zolMaterialCode = zolMaterialCode;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

}
