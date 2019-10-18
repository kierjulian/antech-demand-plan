package ph.edu.up.antech.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

	private ProductType productType;
	private String description;
	private BigDecimal price;

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return productType == product.productType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productType);
	}

	public static final class Builder {
		private ProductType productType;
		private String description;
		private BigDecimal price;

		private Builder() {
		}

		public static Builder buildProduct() {
			return new Builder();
		}

		public Builder productType(ProductType productType) {
			this.productType = productType;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder price(BigDecimal price) {
			this.price = price;
			return this;
		}

		public Product build() {
			Product product = new Product();
			product.setProductType(productType);
			product.setDescription(description);
			product.setPrice(price);
			return product;
		}
	}

}
