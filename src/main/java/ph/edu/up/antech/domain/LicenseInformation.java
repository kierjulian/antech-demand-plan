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

	@Column(name = "code")
	@Enumerated(EnumType.STRING)
	private IMSTherapeuticClassCode code;

	@Column(name = "registration_no")
	private String certifateOfProductRegistrationNo;

	@Column(name = "validity_period")
	private LocalDate validityPeriod;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public IMSTherapeuticClassCode getCode() {
		return code;
	}

	public void setCode(IMSTherapeuticClassCode code) {
		this.code = code;
	}

	public String getCertifateOfProductRegistrationNo() {
		return certifateOfProductRegistrationNo;
	}

	public void setCertifateOfProductRegistrationNo(String certifateOfProductRegistrationNo) {
		this.certifateOfProductRegistrationNo = certifateOfProductRegistrationNo;
	}

	public LocalDate getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(LocalDate validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

}
