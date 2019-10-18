package ph.edu.up.antech.domain;

import ph.edu.ph.antech.exception.DifferentProductException;

import java.time.Month;
import java.time.Year;

public class ProductSales {

	private Product product;
	private Year year;
	private Month month;
	private GeneralInformation generalInformation;
	private InventoryAtAntechZPC inventoryAtAntechZPC;
	private InventoryAtSource inventoryAtSource;
	private InventoryAtTrade inventoryAtTrade;

	public ProductSales() {
	}

	public ProductSales(Product product, ProductSales productSalesOneMonthBefore,
			ProductSales productSalesTwoMonthsBefore, ProductSales productSalesThreeMonthsBefore,
			ProductSalesDetails productSalesDetails) {
		this(productSalesOneMonthBefore, productSalesTwoMonthsBefore, productSalesThreeMonthsBefore,
				productSalesDetails);
		this.product = product;

		if (!this.product.equals(productSalesOneMonthBefore.product)
				|| !this.product.equals(productSalesTwoMonthsBefore.product)
				|| !this.product.equals(productSalesThreeMonthsBefore.product)) {
			throw new DifferentProductException("Products of product sales should not be different");
		}
	}

	public ProductSales(ProductSales productSalesOneMonthBefore,
			ProductSales productSalesTwoMonthsBefore, ProductSales productSalesThreeMonthsBefore,
			ProductSalesDetails productSalesDetails) {
		initializeGeneralInformation(productSalesOneMonthBefore, productSalesTwoMonthsBefore,
				productSalesThreeMonthsBefore, productSalesDetails);
		initializeInventoryAtSource(productSalesOneMonthBefore, productSalesTwoMonthsBefore,
				productSalesDetails);
		initializeInventoryAtAntechZPC(productSalesOneMonthBefore, productSalesTwoMonthsBefore,
				productSalesThreeMonthsBefore, productSalesDetails);
		initializeInventoryAtTrade(productSalesOneMonthBefore);
	}

	private void initializeGeneralInformation(ProductSales productSalesOneMonthBefore,
			ProductSales productSalesTwoMonthBefore, ProductSales productSalesThreeMonthsBefore,
			ProductSalesDetails productSalesDetails) {
		Integer averageInMarketSales = (productSalesThreeMonthsBefore.getGeneralInformation()
				.getInMarketSales() + productSalesTwoMonthBefore.getGeneralInformation()
				.getInMarketSales() + productSalesOneMonthBefore.getGeneralInformation()
				.getInMarketSales()) / 3;
		Integer offTake = (productSalesThreeMonthsBefore.getGeneralInformation()
				.getOffTake() + productSalesTwoMonthBefore.getGeneralInformation()
				.getOffTake() + productSalesOneMonthBefore.getGeneralInformation()
				.getOffTake()) / 3;

		this.generalInformation = GeneralInformation.Builder.buildGeneralInformation()
				.plan(productSalesDetails.getPlan())
				.inMarketSales(productSalesDetails.getInMarketSales())
				.averageInMarketSales(averageInMarketSales)
				.offTake(offTake)
				.build();
	}

	private void initializeInventoryAtSource(ProductSales productSalesOneMonthBefore,
			ProductSales productSalesTwoMonthsBefore, ProductSalesDetails productSalesDetails) {
		Integer production = productSalesDetails.getProduction();
		Integer totalGoodsAvailable = productSalesOneMonthBefore.getInventoryAtSource()
				.getHippEndingInvetory() + production;
		Integer loading = productSalesDetails.getLoading();
		Integer hippEndingInventory = totalGoodsAvailable + loading;

		Double hippDaysOnHandInDoubleFormat =
				(hippEndingInventory.doubleValue() / ((productSalesTwoMonthsBefore.getGeneralInformation()
						.getInMarketSales() + productSalesOneMonthBefore.getGeneralInformation()
						.getInMarketSales()) / 2)) * 30;
		Long hippDaysOnHandInLongFormat = Math.round(hippDaysOnHandInDoubleFormat);
		Integer hippDaysOnHand = hippDaysOnHandInLongFormat.intValue();

		this.inventoryAtSource = InventoryAtSource.Builder.buildInventoryAtSource()
				.production(production)
				.totalGoodsAvailable(totalGoodsAvailable)
				.loading(loading)
				.hippEndingInvetory(hippEndingInventory)
				.hippDaysOnHand(hippDaysOnHand)
				.build();
	}

	private void initializeInventoryAtAntechZPC(ProductSales productSalesOneMonthBefore,
			ProductSales productSalesTwoMonthsBefore, ProductSales productSalesThreeMonthsBefore,
			ProductSalesDetails productSalesDetails) {
		Integer beginningInventory = productSalesOneMonthBefore.getInventoryAtAntechZPC()
				.getEndingInventory();
		Integer shipmentReceived = productSalesDetails.getShipmentReceived();
		Integer totalAvailable = beginningInventory + shipmentReceived;
		Integer actualSales = productSalesDetails.getActualSales();
		Integer endingInventory = totalAvailable - actualSales;

		Double daysOnHandInDoubleFormat =
				(endingInventory.doubleValue() / ((productSalesThreeMonthsBefore.getGeneralInformation()
						.getInMarketSales() + productSalesTwoMonthsBefore.getGeneralInformation()
						.getInMarketSales() + productSalesOneMonthBefore.getGeneralInformation()
						.getInMarketSales()) / 3)) * 30;
		Long daysOnHandInLongFormat = Math.round(daysOnHandInDoubleFormat);
		Integer daysOnHand = daysOnHandInLongFormat.intValue();

		this.inventoryAtAntechZPC = InventoryAtAntechZPC.Builder.buildInventoryAtAntechZPC()
				.beginningInventory(beginningInventory)
				.shipmentsReceived(productSalesDetails.getShipmentReceived())
				.totalAvailableForSaleInPhilippines(totalAvailable)
				.actualSales(actualSales)
				.endingInventory(endingInventory)
				.daysOnHand(daysOnHand)
				.build();
	}

	private void initializeInventoryAtTrade(ProductSales productSalesOneMonthBefore) {
		Integer beginningInventory = productSalesOneMonthBefore.getInventoryAtTrade()
				.getTotalEndingInventory();
		Integer totalEndingInventory =
				beginningInventory + this.inventoryAtAntechZPC.getActualSales() - generalInformation.getOffTake();
		Double daysOnHandInDoubleFormat = totalEndingInventory.doubleValue() / generalInformation.getOffTake() * 30;
		Integer daysOnHand = daysOnHandInDoubleFormat.intValue();

		this.inventoryAtTrade = InventoryAtTrade.Builder.buildInventoryAtTrade()
				.beginningInventory(beginningInventory)
				.totalEndingInventory(totalEndingInventory)
				.daysOnHand(daysOnHand)
				.build();
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

	public GeneralInformation getGeneralInformation() {
		return generalInformation;
	}

	public void setGeneralInformation(GeneralInformation generalInformation) {
		this.generalInformation = generalInformation;
	}

	public InventoryAtAntechZPC getInventoryAtAntechZPC() {
		return inventoryAtAntechZPC;
	}

	public void setInventoryAtAntechZPC(InventoryAtAntechZPC inventoryAtAntechZPC) {
		this.inventoryAtAntechZPC = inventoryAtAntechZPC;
	}

	public InventoryAtSource getInventoryAtSource() {
		return inventoryAtSource;
	}

	public void setInventoryAtSource(InventoryAtSource inventoryAtSource) {
		this.inventoryAtSource = inventoryAtSource;
	}

	public InventoryAtTrade getInventoryAtTrade() {
		return inventoryAtTrade;
	}

	public void setInventoryAtTrade(InventoryAtTrade inventoryAtTrade) {
		this.inventoryAtTrade = inventoryAtTrade;
	}


	public static final class Builder {
		private Product product;
		private Year year;
		private Month month;
		private GeneralInformation generalInformation;
		private InventoryAtAntechZPC inventoryAtAntechZPC;
		private InventoryAtSource inventoryAtSource;
		private InventoryAtTrade inventoryAtTrade;

		private Builder() {
		}

		public static Builder buildProduct() {
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

		public Builder generalInformation(GeneralInformation generalInformation) {
			this.generalInformation = generalInformation;
			return this;
		}

		public Builder inventoryAtAntechZPC(InventoryAtAntechZPC inventoryAtAntechZPC) {
			this.inventoryAtAntechZPC = inventoryAtAntechZPC;
			return this;
		}

		public Builder inventoryAtSource(InventoryAtSource inventoryAtSource) {
			this.inventoryAtSource = inventoryAtSource;
			return this;
		}

		public Builder inventoryAtTrade(InventoryAtTrade inventoryAtTrade) {
			this.inventoryAtTrade = inventoryAtTrade;
			return this;
		}

		public ProductSales build() {
			ProductSales productSales = new ProductSales();
			productSales.setProduct(product);
			productSales.setYear(year);
			productSales.setMonth(month);
			productSales.setGeneralInformation(generalInformation);
			productSales.setInventoryAtAntechZPC(inventoryAtAntechZPC);
			productSales.setInventoryAtSource(inventoryAtSource);
			productSales.setInventoryAtTrade(inventoryAtTrade);
			return productSales;
		}
	}

}
