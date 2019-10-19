package ph.edu.up.antech.dto;

import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.domain.ProductSales;
import ph.edu.up.antech.domain.ProductSalesDetails;

public class ProductSalesDTO {

	private Product product;
	private ProductSales productSalesOneMonthBefore;
	private ProductSales productSalesTwoMonthBefore;
	private ProductSales productSalesThreeMonthBefore;
	private ProductSalesDetails productSalesDetails;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
		private ProductSales productSalesOneMonthBefore;
		private ProductSales productSalesTwoMonthBefore;
		private ProductSales productSalesThreeMonthBefore;
		private ProductSalesDetails productSalesDetails;

		private Builder() {
		}

		public static Builder buildProductSalesDTO() {
			return new Builder();
		}

		public Builder product(Product product) {
			this.product = product;
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

		public ProductSalesDTO build() {
			ProductSalesDTO productSalesDTO = new ProductSalesDTO();
			productSalesDTO.setProduct(product);
			productSalesDTO.setProductSalesOneMonthBefore(productSalesOneMonthBefore);
			productSalesDTO.setProductSalesTwoMonthBefore(productSalesTwoMonthBefore);
			productSalesDTO.setProductSalesThreeMonthBefore(productSalesThreeMonthBefore);
			productSalesDTO.setProductSalesDetails(productSalesDetails);
			return productSalesDTO;
		}
	}

}
