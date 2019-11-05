package ph.edu.up.antech.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "product_completion")
public class Completion implements Serializable {

	@Id
	@JoinColumn(name = "id", referencedColumnName = "id")
	@OneToOne
	private Product product;

	@Column(name = "completed_by")
	private String completedBy;

	@Column(name = "completion_date")
	private LocalDate completionDate;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCompletedBy() {
		return completedBy;
	}

	public void setCompletedBy(String completedBy) {
		this.completedBy = completedBy;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

}
