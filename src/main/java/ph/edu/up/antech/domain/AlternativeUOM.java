package ph.edu.up.antech.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_alternative_uom")
public class AlternativeUOM implements Serializable {

	@Id
	@JoinColumn(name = "id", referencedColumnName = "id")
	@OneToOne
	private Product product;

	@Column(name = "pieces_per_carton")
	private Integer piecesPerCarton;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getPiecesPerCarton() {
		return piecesPerCarton;
	}

	public void setPiecesPerCarton(Integer piecesPerCarton) {
		this.piecesPerCarton = piecesPerCarton;
	}

}
