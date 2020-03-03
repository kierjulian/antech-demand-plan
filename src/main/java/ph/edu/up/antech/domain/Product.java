package ph.edu.up.antech.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllProducts", query = "SELECT o FROM Product o"),
        @NamedQuery(name = "findProductById", query = "SELECT o FROM Product o WHERE o.id = :id"),
        @NamedQuery(name = "findProductByCode", query = "SELECT o FROM Product o WHERE o.code = :code")
})
@Table(name = "product")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Product implements Serializable, Comparable<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "base")
    private String base;

    @Column(name = "material_group")
    @Enumerated(EnumType.STRING)
    private MaterialGroup materialGroup;

    @Column(name = "shelf_life")
    private Integer shelfLifeInDays;

    @Column(name = "minimum_saleable_shelf_life")
    private Integer minimumSaleableShelfLifeInDays;

    @Column(name = "item_barcode")
    private String itemBarcode;

    @Column(name = "case_barcode")
    private String caseBarcode;

    @Column(name = "life_saving")
    private Boolean lifeSaving;

    @Column(name = "bom_relevant")
    private Boolean bomRelevant;

    @Column(name = "batch_managed")
    private Boolean batchManaged;

    @Column(name = "with_expiry_date")
    private Boolean withExpiryDate;

    @Column(name = "serial_managed")
    private Boolean serialManaged;

    @Column(name = "centrally_stocked")
    private Boolean centrallyStocked;

    @Column(name = "for_ims_extraction")
    private Boolean forImsExtraction;

    @Column(name = "download_asiarx")
    private Boolean downloadAsiarx;

    @Column(name = "biological")
    private Boolean biological;

    @Column(name = "with_special_arrangement")
    private Boolean withSpecialArrangement;

    @Column(name = "antibiotic")
    private Boolean antibiotic;

    @Column(name = "product_license_code")
    @Enumerated(EnumType.STRING)
    private ProductLicenseCode productLicenseCode;

    @Column(name = "therapeutic_code")
    private String imsTherapeuticCode;

    @Column(name = "product_registration_no")
    private String certificateOfProductRegistrationNo;

    @Column(name = "validity_period")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate validityPeriod;

    @Lob
    @Column(name = "certificate_file")
    private byte[] certificateFile;

    @Column(name = "confirmed_by")
    private String confirmedBy;

    @Column(name = "confirmation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate confirmationDate;

    @Column(name = "confirmation_remarks")
    private String confirmationRemarks;

    @Column(name = "storage_condition")
    @Enumerated(EnumType.STRING)
    private StorageCondition storageCondition;

    @Column(name = "pieces_per_carton")
    private Integer piecesPerCarton;

    @Column(name = "pieces_per_pallet")
    private Integer piecesPerPallet;

    @Column(name = "length")
    private BigDecimal length;

    @Column(name = "width")
    private BigDecimal width;

    @Column(name = "height")
    private BigDecimal height;

    @Column(name = "gross_weight_sku")
    private BigDecimal grossWeightPerSKU;

    @Column(name = "net_weight_sku")
    private BigDecimal netWeightPerSKU;

    @Column(name = "gross_weight_standard")
    private BigDecimal grossWeightPerStandard;

    @Column(name = "net_weight_standard")
    private BigDecimal netWeightPerStandard;

    @Column(name = "box")
    private Integer box;

    @Column(name = "cartons_per_layer")
    private Integer shippingCartonsPerLayer;

    @Column(name = "layers_per_pallet")
    private Integer layersPerPallet;

    @Column(name = "completed_by")
    private String completedBy;

    @Column(name = "completed_by_position")
    private String completedByPosition;

    @Column(name = "completion_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate completionDate;

    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    public Product() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MaterialGroup getMaterialGroup() {
        return materialGroup;
    }

    public void setMaterialGroup(MaterialGroup materialGroup) {
        this.materialGroup = materialGroup;
    }

    public Integer getShelfLifeInDays() {
        return shelfLifeInDays;
    }

    public void setShelfLifeInDays(Integer shelfLifeInDays) {
        this.shelfLifeInDays = shelfLifeInDays;
    }

    public Integer getMinimumSaleableShelfLifeInDays() {
        return minimumSaleableShelfLifeInDays;
    }

    public void setMinimumSaleableShelfLifeInDays(Integer minimumSaleableShelfLifeInDays) {
        this.minimumSaleableShelfLifeInDays = minimumSaleableShelfLifeInDays;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public String getCaseBarcode() {
        return caseBarcode;
    }

    public void setCaseBarcode(String caseBarcode) {
        this.caseBarcode = caseBarcode;
    }

    public StorageCondition getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(StorageCondition storageCondition) {
        this.storageCondition = storageCondition;
    }

    public Boolean getLifeSaving() {
        return lifeSaving;
    }

    public void setLifeSaving(Boolean lifeSaving) {
        this.lifeSaving = lifeSaving;
    }

    public Boolean getBomRelevant() {
        return bomRelevant;
    }

    public void setBomRelevant(Boolean bomRelevant) {
        this.bomRelevant = bomRelevant;
    }

    public Boolean getBatchManaged() {
        return batchManaged;
    }

    public void setBatchManaged(Boolean batchManaged) {
        this.batchManaged = batchManaged;
    }

    public Boolean getWithExpiryDate() {
        return withExpiryDate;
    }

    public void setWithExpiryDate(Boolean withExpiryDate) {
        this.withExpiryDate = withExpiryDate;
    }

    public Boolean getSerialManaged() {
        return serialManaged;
    }

    public void setSerialManaged(Boolean serialManaged) {
        this.serialManaged = serialManaged;
    }

    public Boolean getCentrallyStocked() {
        return centrallyStocked;
    }

    public void setCentrallyStocked(Boolean centrallyStocked) {
        this.centrallyStocked = centrallyStocked;
    }

    public Boolean getForImsExtraction() {
        return forImsExtraction;
    }

    public void setForImsExtraction(Boolean forImsExtraction) {
        this.forImsExtraction = forImsExtraction;
    }

    public Boolean getDownloadAsiarx() {
        return downloadAsiarx;
    }

    public void setDownloadAsiarx(Boolean downloadAsiarx) {
        this.downloadAsiarx = downloadAsiarx;
    }

    public Boolean getBiological() {
        return biological;
    }

    public void setBiological(Boolean biological) {
        this.biological = biological;
    }

    public Boolean getWithSpecialArrangement() {
        return withSpecialArrangement;
    }

    public void setWithSpecialArrangement(Boolean withSpecialArrangement) {
        this.withSpecialArrangement = withSpecialArrangement;
    }

    public Boolean getAntibiotic() {
        return antibiotic;
    }

    public void setAntibiotic(Boolean antibiotic) {
        this.antibiotic = antibiotic;
    }

    public ProductLicenseCode getProductLicenseCode() {
        return productLicenseCode;
    }

    public void setProductLicenseCode(ProductLicenseCode productLicenseCode) {
        this.productLicenseCode = productLicenseCode;
    }

    public String getImsTherapeuticCode() {
        return imsTherapeuticCode;
    }

    public void setImsTherapeuticCode(String imsTherapeuticCode) {
        this.imsTherapeuticCode = imsTherapeuticCode;
    }

    public String getCertificateOfProductRegistrationNo() {
        return certificateOfProductRegistrationNo;
    }

    public void setCertificateOfProductRegistrationNo(String certificateOfProductRegistrationNo) {
        this.certificateOfProductRegistrationNo = certificateOfProductRegistrationNo;
    }

    public LocalDate getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(LocalDate validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public byte[] getCertificateFile() {
        return certificateFile;
    }

    public void setCertificateFile(byte[] certificateFile) {
        this.certificateFile = certificateFile;
    }

    public String getConfirmedBy() {
        return confirmedBy;
    }

    public void setConfirmedBy(String confirmedBy) {
        this.confirmedBy = confirmedBy;
    }

    public LocalDate getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(LocalDate confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public String getConfirmationRemarks() {
        return confirmationRemarks;
    }

    public void setConfirmationRemarks(String confirmationRemarks) {
        this.confirmationRemarks = confirmationRemarks;
    }

    public Integer getPiecesPerCarton() {
        return piecesPerCarton;
    }

    public void setPiecesPerCarton(Integer piecesPerCarton) {
        this.piecesPerCarton = piecesPerCarton;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getGrossWeightPerSKU() {
        return grossWeightPerSKU;
    }

    public void setGrossWeightPerSKU(BigDecimal grossWeightPerSKU) {
        this.grossWeightPerSKU = grossWeightPerSKU;
    }

    public BigDecimal getNetWeightPerSKU() {
        return netWeightPerSKU;
    }

    public void setNetWeightPerSKU(BigDecimal netWeightPerSKU) {
        this.netWeightPerSKU = netWeightPerSKU;
    }

    public BigDecimal getGrossWeightPerStandard() {
        return grossWeightPerStandard;
    }

    public void setGrossWeightPerStandard(BigDecimal grossWeightPerStandard) {
        this.grossWeightPerStandard = grossWeightPerStandard;
    }

    public BigDecimal getNetWeightPerStandard() {
        return netWeightPerStandard;
    }

    public void setNetWeightPerStandard(BigDecimal netWeightPerStandard) {
        this.netWeightPerStandard = netWeightPerStandard;
    }

    public Integer getBox() {
        return box;
    }

    public void setBox(Integer box) {
        this.box = box;
    }

    public String getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(String completedBy) {
        this.completedBy = completedBy;
    }

    public String getCompletedByPosition() {
        return completedByPosition;
    }

    public void setCompletedByPosition(String completedByPosition) {
        this.completedByPosition = completedByPosition;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public Integer getPiecesPerPallet() {
        return piecesPerPallet;
    }

    public void setPiecesPerPallet(Integer piecesPerPallet) {
        this.piecesPerPallet = piecesPerPallet;
    }

    public Integer getShippingCartonsPerLayer() {
        return shippingCartonsPerLayer;
    }

    public void setShippingCartonsPerLayer(Integer shippingCartonsPerLayer) {
        this.shippingCartonsPerLayer = shippingCartonsPerLayer;
    }

    public Integer getLayersPerPallet() {
        return layersPerPallet;
    }

    public void setLayersPerPallet(Integer layersPerPallet) {
        this.layersPerPallet = layersPerPallet;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Product o) {
        return this.code.compareTo(o.code);
    }

}
