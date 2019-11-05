package ph.edu.up.antech.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "product_license")
public class LicenseInformation implements Serializable {

	@Id
	@JoinColumn(name = "id", referencedColumnName = "id")
	@OneToOne
	private Product product;

	@Column(name = "license_code")
	@Enumerated(EnumType.STRING)
	private ProductLicenseCode licenseCode;

	@Column(name = "code")
	private String code;

	@Column(name = "registration_no")
	private String certificateOfProductRegistrationNo;

	@Column(name = "validity_period")
	private LocalDate validityPeriod;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductLicenseCode getLicenseCode() {
		return licenseCode;
	}

	public void setLicenseCode(ProductLicenseCode licenseCode) {
		this.licenseCode = licenseCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

}
