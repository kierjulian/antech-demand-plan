package ph.edu.up.antech.domain;

import java.time.Month;
import java.time.Year;

public class ProductSalesGeneration {

	private Product product;
	private Year year;
	private Month month;
	private ProductSales productSalesOneMonthBefore;
	private ProductSales productSalesTwoMonthBefore;
	private ProductSales productSalesThreeMonthBefore;
	private ProductSalesDetails productSalesDetails;

	public ProductSalesGeneration() {
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public ProductSales getProductSalesOneMonthBefore() {
		return productSalesOneMonthBefore;
	}

	public void setProductSalesOneMonthBefore(ProductSales productSalesOneMonthBefore) {
		this.productSalesOneMonthBefore = productSalesOneMonthBefore;
	}

	public ProductSales getProductSalesTwoMonthBefore() {
		return productSalesTwoMonthBefore;
	}

	public void setProductSalesTwoMonthBefore(ProductSales productSalesTwoMonthBefore) {
		this.productSalesTwoMonthBefore = productSalesTwoMonthBefore;
	}

	public ProductSales getProductSalesThreeMonthBefore() {
		return productSalesThreeMonthBefore;
	}

	public void setProductSalesThreeMonthBefore(ProductSales productSalesThreeMonthBefore) {
		this.productSalesThreeMonthBefore = productSalesThreeMonthBefore;
	}

	public ProductSalesDetails getProductSalesDetails() {
		return productSalesDetails;
	}

	public void setProductSalesDetails(ProductSalesDetails productSalesDetails) {
		this.productSalesDetails = productSalesDetails;
	}


	public static final class Builder {
		private Product product;
		private Year year;
		private Month month;
		private ProductSales productSalesOneMonthBefore;
		private ProductSales productSalesTwoMonthBefore;
		private ProductSales productSalesThreeMonthBefore;
		private ProductSalesDetails productSalesDetails;

		private Builder() {
		}

		public static Builder buildProductSalesGeneration() {
			return new Builder();
		}

		public Builder product(Product product) {
			this.product = product;
			return this;
		}

		public Builder year(Year year) {
			this.year = year;
			return this;
		}

		public Builder month(Month month) {
			this.month = month;
			return this;
		}

		public Builder productSalesOneMonthBefore(ProductSales productSalesOneMonthBefore) {
			this.productSalesOneMonthBefore = productSalesOneMonthBefore;
			return this;
		}

		public Builder productSalesTwoMonthBefore(ProductSales productSalesTwoMonthBefore) {
			this.productSalesTwoMonthBefore = productSalesTwoMonthBefore;
			return this;
		}

		public Builder productSalesThreeMonthBefore(ProductSales productSalesThreeMonthBefore) {
			this.productSalesThreeMonthBefore = productSalesThreeMonthBefore;
			return this;
		}

		public Builder productSalesDetails(ProductSalesDetails productSalesDetails) {
			this.productSalesDetails = productSalesDetails;
			return this;
		}

		public ProductSalesGeneration build() {
			ProductSalesGeneration productSalesGeneration = new ProductSalesGeneration();
			productSalesGeneration.setYear(year);
			productSalesGeneration.setMonth(month);
			productSalesGeneration.setProduct(product);
			productSalesGeneration.setProductSalesOneMonthBefore(productSalesOneMonthBefore);
			productSalesGeneration.setProductSalesTwoMonthBefore(productSalesTwoMonthBefore);
			productSalesGeneration.setProductSalesThreeMonthBefore(productSalesThreeMonthBefore);
			productSalesGeneration.setProductSalesDetails(productSalesDetails);
			return productSalesGeneration;
		}
	}

}
