package ph.edu.up.antech.helper;

import ph.edu.up.antech.domain.*;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;

public class ProductSalesHelper {

	public static ProductSales initializeProductSalesForS1400Jan2019() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1400)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();

		GeneralInformation generalInformation = GeneralInformation.Builder.buildGeneralInformation()
				.plan(2015)
				.inMarketSales(701)
				.averageInMarketSales(2011)
				.offTake(1388)
				.build();

		InventoryAtSource inventoryAtSource = InventoryAtSource.Builder.buildInventoryAtSource()
				.production(3312)
				.totalGoodsAvailable(3812)
				.loading(0)
				.hippEndingInvetory(3812)
				.hippDaysOnHand(57)
				.build();

		InventoryAtAntechZPC inventoryAtAntechZPC = InventoryAtAntechZPC.Builder.buildInventoryAtAntechZPC()
				.beginningInventory(155)
				.shipmentsReceived(2528)
				.totalAvailableForSaleInPhilippines(2683)
				.actualSales(701)
				.endingInventory(1982)
				.daysOnHand(30)
				.build();

		InventoryAtTrade inventoryAtTrade = InventoryAtTrade.Builder.buildInventoryAtTrade()
				.beginningInventory(4291)
				.totalEndingInventory(3604)
				.daysOnHand(78)
				.build();

		return ProductSales.Builder.buildProductSales()
				.product(product)
				.month(Month.JANUARY)
				.year(Year.of(2019))
				.generalInformation(generalInformation)
				.inventoryAtSource(inventoryAtSource)
				.inventoryAtAntechZPC(inventoryAtAntechZPC)
				.inventoryAtTrade(inventoryAtTrade)
				.build();
	}

	public static ProductSales initializeProductSalesForS1400Feb2019() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1400)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();

		GeneralInformation generalInformation = GeneralInformation.Builder.buildGeneralInformation()
				.plan(880)
				.inMarketSales(701)
				.averageInMarketSales(2011)
				.offTake(1388)
				.build();

		InventoryAtSource inventoryAtSource = InventoryAtSource.Builder.buildInventoryAtSource()
				.production(5472)
				.totalGoodsAvailable(3812)
				.loading(0)
				.hippEndingInvetory(3812)
				.hippDaysOnHand(57)
				.build();

		InventoryAtAntechZPC inventoryAtAntechZPC = InventoryAtAntechZPC.Builder.buildInventoryAtAntechZPC()
				.beginningInventory(155)
				.shipmentsReceived(2528)
				.totalAvailableForSaleInPhilippines(2683)
				.actualSales(701)
				.endingInventory(1982)
				.daysOnHand(30)
				.build();

		InventoryAtTrade inventoryAtTrade = InventoryAtTrade.Builder.buildInventoryAtTrade()
				.beginningInventory(4291)
				.totalEndingInventory(3604)
				.daysOnHand(78)
				.build();

		return ProductSales.Builder.buildProductSales()
				.product(product)
				.month(Month.FEBRUARY)
				.year(Year.of(2019))
				.generalInformation(generalInformation)
				.inventoryAtSource(inventoryAtSource)
				.inventoryAtAntechZPC(inventoryAtAntechZPC)
				.inventoryAtTrade(inventoryAtTrade)
				.build();
	}

	public static ProductSales initializeProductSalesForS1400March2019() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1400)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();

		GeneralInformation generalInformation = GeneralInformation.Builder.buildGeneralInformation()
				.plan(880)
				.inMarketSales(701)
				.averageInMarketSales(2011)
				.offTake(1388)
				.build();

		InventoryAtSource inventoryAtSource = InventoryAtSource.Builder.buildInventoryAtSource()
				.production(5472)
				.totalGoodsAvailable(3812)
				.loading(0)
				.hippEndingInvetory(3812)
				.hippDaysOnHand(57)
				.build();

		InventoryAtAntechZPC inventoryAtAntechZPC = InventoryAtAntechZPC.Builder.buildInventoryAtAntechZPC()
				.beginningInventory(155)
				.shipmentsReceived(2528)
				.totalAvailableForSaleInPhilippines(2683)
				.actualSales(701)
				.endingInventory(1982)
				.daysOnHand(30)
				.build();

		InventoryAtTrade inventoryAtTrade = InventoryAtTrade.Builder.buildInventoryAtTrade()
				.beginningInventory(4291)
				.totalEndingInventory(3604)
				.daysOnHand(78)
				.build();

		return ProductSales.Builder.buildProductSales()
				.product(product)
				.month(Month.MARCH)
				.year(Year.of(2019))
				.generalInformation(generalInformation)
				.inventoryAtSource(inventoryAtSource)
				.inventoryAtAntechZPC(inventoryAtAntechZPC)
				.inventoryAtTrade(inventoryAtTrade)
				.build();
	}

	public static ProductSales initializeProductSalesFors1400April2019() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1400)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();

		GeneralInformation generalInformation = GeneralInformation.Builder.buildGeneralInformation()
				.plan(880)
				.inMarketSales(701)
				.averageInMarketSales(2011)
				.offTake(1388)
				.build();

		InventoryAtSource inventoryAtSource = InventoryAtSource.Builder.buildInventoryAtSource()
				.production(5472)
				.totalGoodsAvailable(3812)
				.loading(0)
				.hippEndingInvetory(3812)
				.hippDaysOnHand(57)
				.build();

		InventoryAtAntechZPC inventoryAtAntechZPC = InventoryAtAntechZPC.Builder.buildInventoryAtAntechZPC()
				.beginningInventory(155)
				.shipmentsReceived(2528)
				.totalAvailableForSaleInPhilippines(2683)
				.actualSales(701)
				.endingInventory(1982)
				.daysOnHand(30)
				.build();

		InventoryAtTrade inventoryAtTrade = InventoryAtTrade.Builder.buildInventoryAtTrade()
				.beginningInventory(4291)
				.totalEndingInventory(3604)
				.daysOnHand(78)
				.build();

		return ProductSales.Builder.buildProductSales()
				.product(product)
				.month(Month.APRIL)
				.year(Year.of(2019))
				.generalInformation(generalInformation)
				.inventoryAtSource(inventoryAtSource)
				.inventoryAtAntechZPC(inventoryAtAntechZPC)
				.inventoryAtTrade(inventoryAtTrade)
				.build();
	}

	public static ProductSales initializeProductSalesForS1400May2019() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1400)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();

		GeneralInformation generalInformation = GeneralInformation.Builder.buildGeneralInformation()
				.plan(880)
				.inMarketSales(701)
				.averageInMarketSales(2011)
				.offTake(1388)
				.build();

		InventoryAtSource inventoryAtSource = InventoryAtSource.Builder.buildInventoryAtSource()
				.production(5472)
				.totalGoodsAvailable(3812)
				.loading(0)
				.hippEndingInvetory(3812)
				.hippDaysOnHand(57)
				.build();

		InventoryAtAntechZPC inventoryAtAntechZPC = InventoryAtAntechZPC.Builder.buildInventoryAtAntechZPC()
				.beginningInventory(155)
				.shipmentsReceived(2528)
				.totalAvailableForSaleInPhilippines(2683)
				.actualSales(701)
				.endingInventory(1982)
				.daysOnHand(30)
				.build();

		InventoryAtTrade inventoryAtTrade = InventoryAtTrade.Builder.buildInventoryAtTrade()
				.beginningInventory(4291)
				.totalEndingInventory(3604)
				.daysOnHand(78)
				.build();

		return ProductSales.Builder.buildProductSales()
				.product(product)
				.month(Month.MAY)
				.year(Year.of(2019))
				.generalInformation(generalInformation)
				.inventoryAtSource(inventoryAtSource)
				.inventoryAtAntechZPC(inventoryAtAntechZPC)
				.inventoryAtTrade(inventoryAtTrade)
				.build();
	}

	public static ProductSales initializeProductSalesForS1400June2019() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1400)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();

		GeneralInformation generalInformation = GeneralInformation.Builder.buildGeneralInformation()
				.plan(906)
				.inMarketSales(1424)
				.averageInMarketSales(1574)
				.offTake(1382)
				.build();

		InventoryAtSource inventoryAtSource = InventoryAtSource.Builder.buildInventoryAtSource()
				.production(0)
				.totalGoodsAvailable(3812)
				.loading(2528)
				.hippEndingInvetory(1284)
				.hippDaysOnHand(35)
				.build();

		InventoryAtAntechZPC inventoryAtAntechZPC = InventoryAtAntechZPC.Builder.buildInventoryAtAntechZPC()
				.beginningInventory(1133)
				.shipmentsReceived(0)
				.totalAvailableForSaleInPhilippines(1333)
				.actualSales(1424)
				.endingInventory(-291)
				.daysOnHand(-6)
				.build();

		InventoryAtTrade inventoryAtTrade = InventoryAtTrade.Builder.buildInventoryAtTrade()
				.beginningInventory(3604)
				.totalEndingInventory(3646)
				.daysOnHand(79)
				.build();

		return ProductSales.Builder.buildProductSales()
				.product(product)
				.month(Month.JUNE)
				.year(Year.of(2019))
				.generalInformation(generalInformation)
				.inventoryAtSource(inventoryAtSource)
				.inventoryAtAntechZPC(inventoryAtAntechZPC)
				.inventoryAtTrade(inventoryAtTrade)
				.build();
	}

	public static ProductSales initializeProductSalesForS1400July2019() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1400)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();

		GeneralInformation generalInformation = GeneralInformation.Builder.buildGeneralInformation()
				.plan(871)
				.inMarketSales(75)
				.averageInMarketSales(1200)
				.offTake(1383)
				.build();

		InventoryAtSource inventoryAtSource = InventoryAtSource.Builder.buildInventoryAtSource()
				.production(0)
				.totalGoodsAvailable(1284)
				.loading(1284)
				.hippEndingInvetory(0)
				.hippDaysOnHand(0)
				.build();

		InventoryAtAntechZPC inventoryAtAntechZPC = InventoryAtAntechZPC.Builder.buildInventoryAtAntechZPC()
				.beginningInventory(72)
				.shipmentsReceived(0)
				.totalAvailableForSaleInPhilippines(72)
				.actualSales(75)
				.endingInventory(-3)
				.daysOnHand(0)
				.build();

		InventoryAtTrade inventoryAtTrade = InventoryAtTrade.Builder.buildInventoryAtTrade()
				.beginningInventory(3646)
				.totalEndingInventory(2338)
				.daysOnHand(51)
				.build();

		return ProductSales.Builder.buildProductSales()
				.product(product)
				.month(Month.JULY)
				.year(Year.of(2019))
				.generalInformation(generalInformation)
				.inventoryAtSource(inventoryAtSource)
				.inventoryAtAntechZPC(inventoryAtAntechZPC)
				.inventoryAtTrade(inventoryAtTrade)
				.build();
	}

}
