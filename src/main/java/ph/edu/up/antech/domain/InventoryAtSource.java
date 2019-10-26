package ph.edu.up.antech.domain;

public class InventoryAtSource {

	private Integer production;
	private Integer totalGoodsAvailable;
	private Integer loading;
	private Integer hippEndingInventory;
	private Integer hippDaysOnHand;

	public InventoryAtSource() {
	}

	public Integer getProduction() {
		return production;
	}

	public void setProduction(Integer production) {
		this.production = production;
	}

	public Integer getTotalGoodsAvailable() {
		return totalGoodsAvailable;
	}

	public void setTotalGoodsAvailable(Integer totalGoodsAvailable) {
		this.totalGoodsAvailable = totalGoodsAvailable;
	}

	public Integer getLoading() {
		return loading;
	}

	public void setLoading(Integer loading) {
		this.loading = loading;
	}

	public Integer getHippEndingInventory() {
		return hippEndingInventory;
	}

	public void setHippEndingInventory(Integer hippEndingInventory) {
		this.hippEndingInventory = hippEndingInventory;
	}

	public Integer getHippDaysOnHand() {
		return hippDaysOnHand;
	}

	public void setHippDaysOnHand(Integer hippDaysOnHand) {
		this.hippDaysOnHand = hippDaysOnHand;
	}


	public static final class Builder {
		private Integer production;
		private Integer totalGoodsAvailable;
		private Integer loading;
		private Integer hippEndingInvetory;
		private Integer hippDaysOnHand;

		private Builder() {
		}

		public static Builder buildInventoryAtSource() {
			return new Builder();
		}

		public Builder production(Integer production) {
			this.production = production;
			return this;
		}

		public Builder totalGoodsAvailable(Integer totalGoodsAvailable) {
			this.totalGoodsAvailable = totalGoodsAvailable;
			return this;
		}

		public Builder loading(Integer loading) {
			this.loading = loading;
			return this;
		}

		public Builder hippEndingInvetory(Integer hippEndingInvetory) {
			this.hippEndingInvetory = hippEndingInvetory;
			return this;
		}

		public Builder hippDaysOnHand(Integer hippDaysOnHand) {
			this.hippDaysOnHand = hippDaysOnHand;
			return this;
		}

		public InventoryAtSource build() {
			InventoryAtSource inventoryAtSource = new InventoryAtSource();
			inventoryAtSource.setProduction(production);
			inventoryAtSource.setTotalGoodsAvailable(totalGoodsAvailable);
			inventoryAtSource.setLoading(loading);
			inventoryAtSource.setHippEndingInventory(hippEndingInvetory);
			inventoryAtSource.setHippDaysOnHand(hippDaysOnHand);
			return inventoryAtSource;
		}
	}

}
