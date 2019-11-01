package ph.edu.up.antech.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Transient
	private String code;

	@Transient
	private String name;

	@Transient
	private Manufacturer manufacturer;

	@Transient
	private Base base;

	@Transient
	private MaterialGroup materialGroup;

	@Transient
	private Integer shelfLifeInDays;

	@Transient
	private Integer minimumSaleableShelfLifeInDays;

	@Transient
	private String itemBarcode;

	@Transient
	private String caseBarcode;

	@Transient
	private ProductInformation productInformation;

	@Transient
	private LicenseInformation licenseInformation;

	@Transient
	private Confirmation confirmation;

	@Transient
	private StorageCondition storageCondition;

	@Transient
	private AlternativeUOM alternativeUOM;

	@Transient
	private Dimension dimension;

	@Transient
	private ProductWeight productWeight;

	@Transient
	private Completion completion;

	public Product() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
