package ph.edu.up.antech.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "product_confirmation")
public class Confirmation implements Serializable {

	@Id
	@JoinColumn(name = "id", referencedColumnName = "id")
	@OneToOne
	private Product product;

	@Column(name = "confirmed_by")
	private String confirmedBy;

	@Column(name = "confirmation_date")
	private LocalDate confirmationDate;

	@Column(name = "remarks")
	private String remarks;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}

