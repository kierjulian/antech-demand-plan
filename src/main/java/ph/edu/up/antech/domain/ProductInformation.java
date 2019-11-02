package ph.edu.up.antech.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product_information")
public class ProductInformation implements Serializable {

	@Id
	@JoinColumn(name = "id", referencedColumnName = "id")
	@OneToOne
	private Product product;

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductInformation that = (ProductInformation) o;
		return Objects.equals(product, that.product);
	}

	@Override
	public int hashCode() {
		return Objects.hash(product);
	}

}
