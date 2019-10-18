package ph.edu.up.antech.domain;

public class InventoryAtAntechZPC {

	private Integer beginningInventory;
	private Integer shipmentsReceived;
	private Integer totalAvailableForSaleInPhilippines;
	private Integer actualSales;
	private Integer endingInventory;
	private Integer daysOnHand;

	public InventoryAtAntechZPC() {
	}

	public Integer getBeginningInventory() {
		return beginningInventory;
	}

	public void setBeginningInventory(Integer beginningInventory) {
		this.beginningInventory = beginningInventory;
	}

	public Integer getShipmentsReceived() {
		return shipmentsReceived;
	}

	public void setShipmentsReceived(Integer shipmentsReceived) {
		this.shipmentsReceived = shipmentsReceived;
	}

	public Integer getTotalAvailableForSaleInPhilippines() {
		return totalAvailableForSaleInPhilippines;
	}

	public void setTotalAvailableForSaleInPhilippines(Integer totalAvailableForSaleInPhilippines) {
		this.totalAvailableForSaleInPhilippines = totalAvailableForSaleInPhilippines;
	}

	public Integer getActualSales() {
		return actualSales;
	}

	public void setActualSales(Integer actualSales) {
		this.actualSales = actualSales;
	}

	public Integer getEndingInventory() {
		return endingInventory;
	}

	public void setEndingInventory(Integer endingInventory) {
		this.endingInventory = endingInventory;
	}

	public Integer getDaysOnHand() {
		return daysOnHand;
	}

	public void setDaysOnHand(Integer daysOnHand) {
		this.daysOnHand = daysOnHand;
	}


	public static final class Builder {
		private Integer beginningInventory;
		private Integer shipmentsReceived;
		private Integer totalAvailableForSaleInPhilippines;
		private Integer actualSales;
		private Integer endingInventory;
		private Integer daysOnHand;

		private Builder() {
		}

		public static Builder buildInventoryAtAntechZPC() {
			return new Builder();
		}

		public Builder beginningInventory(Integer beginningInventory) {
			this.beginningInventory = beginningInventory;
			return this;
		}

		public Builder shipmentsReceived(Integer shipmentsReceived) {
			this.shipmentsReceived = shipmentsReceived;
			return this;
		}

		public Builder totalAvailableForSaleInPhilippines(Integer totalAvailableForSaleInPhilippines) {
			this.totalAvailableForSaleInPhilippines = totalAvailableForSaleInPhilippines;
			return this;
		}

		public Builder actualSales(Integer actualSales) {
			this.actualSales = actualSales;
			return this;
		}

		public Builder endingInventory(Integer endingInventory) {
			this.endingInventory = endingInventory;
			return this;
		}

		public Builder daysOnHand(Integer daysOnHand) {
			this.daysOnHand = daysOnHand;
			return this;
		}

		public InventoryAtAntechZPC build() {
			InventoryAtAntechZPC inventoryAtAntechZPC = new InventoryAtAntechZPC();
			inventoryAtAntechZPC.setBeginningInventory(beginningInventory);
			inventoryAtAntechZPC.setShipmentsReceived(shipmentsReceived);
			inventoryAtAntechZPC.setTotalAvailableForSaleInPhilippines(totalAvailableForSaleInPhilippines);
			inventoryAtAntechZPC.setActualSales(actualSales);
			inventoryAtAntechZPC.setEndingInventory(endingInventory);
			inventoryAtAntechZPC.setDaysOnHand(daysOnHand);
			return inventoryAtAntechZPC;
		}
	}

}
