package ph.edu.up.antech.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "product_weight")
public class ProductWeight implements Serializable {

	@Id
	@JoinColumn(name = "id", referencedColumnName = "id")
	@OneToOne
	private Product product;

	@Column(name = "gross_weight_sku")
	private BigDecimal grossWeightPerSKU;

	@Column(name = "net_weight_sku")
	private BigDecimal netWeightPerSKU;

	@Column(name = "gross_weight_standard")
	private BigDecimal grossWeightPerStandard;

	@Column(name = "net_weight_standard")
	private BigDecimal netWeightPerStandard;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
}
