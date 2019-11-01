package ph.edu.up.antech.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_issuance")
public class Issuance implements Serializable {

	@Id
	@JoinColumn(name = "id", referencedColumnName = "id")
	@OneToOne
	private Product product;

	@Column(name = "box")
	private Integer box;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getBox() {
		return box;
	}

	public void setBox(Integer box) {
		this.box = box;
	}

}
