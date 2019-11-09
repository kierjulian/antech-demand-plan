package ph.edu.up.antech.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_sales_trade")
public class InventoryAtTrade implements Serializable {

	@Id
	@JoinColumn(name = "id", referencedColumnName = "id")
	@OneToOne
	private ProductSales productSales;

	@Column(name = "beginning_inventory")
	private Integer beginningInventory;

	@Column(name = "total_ending_inventory")
	private Integer totalEndingInventory;

	@Column(name = "days_on_hand")
	private Integer daysOnHand;

	public InventoryAtTrade() {
	}

	public ProductSales getProductSales() {
		return productSales;
	}

	public void setProductSales(ProductSales productSales) {
		this.productSales = productSales;
	}

	public Integer getBeginningInventory() {
		return beginningInventory;
	}

	public void setBeginningInventory(Integer beginningInventory) {
		this.beginningInventory = beginningInventory;
	}

	public Integer getTotalEndingInventory() {
		return totalEndingInventory;
	}

	public void setTotalEndingInventory(Integer totalEndingInventory) {
		this.totalEndingInventory = totalEndingInventory;
	}

	public Integer getDaysOnHand() {
		return daysOnHand;
	}

	public void setDaysOnHand(Integer daysOnHand) {
		this.daysOnHand = daysOnHand;
	}


	public static final class Builder {
		private Integer beginningInventory;
		private Integer totalEndingInventory;
		private Integer daysOnHand;

		private Builder() {
		}

		public static Builder buildInventoryAtTrade() {
			return new Builder();
		}

		public Builder beginningInventory(Integer beginningInventory) {
			this.beginningInventory = beginningInventory;
			return this;
		}

		public Builder totalEndingInventory(Integer totalEndingInventory) {
			this.totalEndingInventory = totalEndingInventory;
			return this;
		}

		public Builder daysOnHand(Integer daysOnHand) {
			this.daysOnHand = daysOnHand;
			return this;
		}

		public InventoryAtTrade build() {
			InventoryAtTrade inventoryAtTrade = new InventoryAtTrade();
			inventoryAtTrade.setBeginningInventory(beginningInventory);
			inventoryAtTrade.setTotalEndingInventory(totalEndingInventory);
			inventoryAtTrade.setDaysOnHand(daysOnHand);
			return inventoryAtTrade;
		}
	}

}
