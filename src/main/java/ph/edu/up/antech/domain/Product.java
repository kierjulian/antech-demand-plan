package ph.edu.up.antech.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "base")
	@Enumerated(EnumType.STRING)
	private Base base;

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

	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
	private ProductInformation productInformation;

	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
	private LicenseInformation licenseInformation;

	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
	private Confirmation confirmation;

	@Column(name = "storage_condition")
	@Enumerated(EnumType.STRING)
	private StorageCondition storageCondition;

	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
	private AlternativeUOM alternativeUOM;

	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
	private Dimension dimension;

	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
	private ProductWeight productWeight;

	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
	private Issuance issuance;

	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
	private Completion completion;

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

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
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

	public ProductInformation getProductInformation() {
		return productInformation;
	}

	public void setProductInformation(ProductInformation productInformation) {
		this.productInformation = productInformation;
	}

	public LicenseInformation getLicenseInformation() {
		return licenseInformation;
	}

	public void setLicenseInformation(LicenseInformation licenseInformation) {
		this.licenseInformation = licenseInformation;
	}

	public Confirmation getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(Confirmation confirmation) {
		this.confirmation = confirmation;
	}

	public StorageCondition getStorageCondition() {
		return storageCondition;
	}

	public void setStorageCondition(StorageCondition storageCondition) {
		this.storageCondition = storageCondition;
	}

	public AlternativeUOM getAlternativeUOM() {
		return alternativeUOM;
	}

	public void setAlternativeUOM(AlternativeUOM alternativeUOM) {
		this.alternativeUOM = alternativeUOM;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public ProductWeight getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(ProductWeight productWeight) {
		this.productWeight = productWeight;
	}

	public Issuance getIssuance() {
		return issuance;
	}

	public void setIssuance(Issuance issuance) {
		this.issuance = issuance;
	}

	public Completion getCompletion() {
		return completion;
	}

	public void setCompletion(Completion completion) {
		this.completion = completion;
	}

}
