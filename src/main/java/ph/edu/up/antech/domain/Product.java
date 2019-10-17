package ph.edu.up.antech.domain;

import java.math.BigDecimal;

public class Product {

	private String name;
	private String description;
	private BigDecimal price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public static final class Builder {
		private String name;
		private String description;
		private BigDecimal price;

		private Builder() {
		}

		public static Builder buildProduct() {
			return new Builder();
		}

		public Builder name(String name) {
			this.name = name;
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
			product.setName(name);
			product.setDescription(description);
			product.setPrice(price);
			return product;
		}
	}

}
