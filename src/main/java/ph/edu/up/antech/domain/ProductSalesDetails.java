package ph.edu.up.antech.domain;

public class ProductSalesDetails {

	private Integer plan;
	private Integer inMarketSales;
	private Integer production;
	private Integer loading;
	private Integer shipmentReceived;
	private Integer actualSales;

	public Integer getPlan() {
		return plan;
	}

	public void setPlan(Integer plan) {
		this.plan = plan;
	}

	public Integer getInMarketSales() {
		return inMarketSales;
	}

	public void setInMarketSales(Integer inMarketSales) {
		this.inMarketSales = inMarketSales;
	}

	public Integer getProduction() {
		return production;
	}

	public void setProduction(Integer production) {
		this.production = production;
	}

	public Integer getLoading() {
		return loading;
	}

	public void setLoading(Integer loading) {
		this.loading = loading;
	}

	public Integer getShipmentReceived() {
		return shipmentReceived;
	}

	public void setShipmentReceived(Integer shipmentReceived) {
		this.shipmentReceived = shipmentReceived;
	}

	public Integer getActualSales() {
		return actualSales;
	}

	public void setActualSales(Integer actualSales) {
		this.actualSales = actualSales;
	}


	public static final class Builder {
		private Integer plan;
		private Integer inMarketSales;
		private Integer production;
		private Integer loading;
		private Integer shipmentReceived;
		private Integer actualSales;

		private Builder() {
		}

		public static Builder buildProductSalesDetails() {
			return new Builder();
		}

		public Builder plan(Integer plan) {
			this.plan = plan;
			return this;
		}

		public Builder inMarketSales(Integer inMarketSales) {
			this.inMarketSales = inMarketSales;
			return this;
		}

		public Builder production(Integer production) {
			this.production = production;
			return this;
		}

		public Builder loading(Integer loading) {
			this.loading = loading;
			return this;
		}

		public Builder shipmentReceived(Integer shipmentReceived) {
			this.shipmentReceived = shipmentReceived;
			return this;
		}

		public Builder actualSales(Integer actualSales) {
			this.actualSales = actualSales;
			return this;
		}

		public ProductSalesDetails build() {
			ProductSalesDetails productSalesDetails = new ProductSalesDetails();
			productSalesDetails.setPlan(plan);
			productSalesDetails.setInMarketSales(inMarketSales);
			productSalesDetails.setProduction(production);
			productSalesDetails.setLoading(loading);
			productSalesDetails.setShipmentReceived(shipmentReceived);
			productSalesDetails.setActualSales(actualSales);
			return productSalesDetails;
		}
	}

}
