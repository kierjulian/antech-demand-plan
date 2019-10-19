package ph.edu.up.antech.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ph.edu.up.antech.exception.DifferentProductException;

import java.math.BigDecimal;
import java.time.Month;
import java.time.Year;

public class ProductSalesTest {

	private ProductSales productSalesForS1400May2019;
	private ProductSales productSalesForS1400June2019;
	private ProductSales productSalesForS1400July2019;

	@Before
	public void initializeProductSalesFors1400OnMay2019() {
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

		productSalesForS1400May2019 = ProductSales.Builder.buildProduct()
				.product(product)
				.month(Month.MAY)
				.year(Year.of(2019))
				.generalInformation(generalInformation)
				.inventoryAtSource(inventoryAtSource)
				.inventoryAtAntechZPC(inventoryAtAntechZPC)
				.inventoryAtTrade(inventoryAtTrade)
				.build();
	}

	@Before
	public void initializeProductSalesFors1400OnJune2019() {
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

		productSalesForS1400June2019 = ProductSales.Builder.buildProduct()
				.product(product)
				.month(Month.JUNE)
				.year(Year.of(2019))
				.generalInformation(generalInformation)
				.inventoryAtSource(inventoryAtSource)
				.inventoryAtAntechZPC(inventoryAtAntechZPC)
				.inventoryAtTrade(inventoryAtTrade)
				.build();
	}

	@Before
	public void initializeProductSalesFors1400OnJuly2019() {
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

		productSalesForS1400July2019 = ProductSales.Builder.buildProduct()
				.product(product)
				.month(Month.JULY)
				.year(Year.of(2019))
				.generalInformation(generalInformation)
				.inventoryAtSource(inventoryAtSource)
				.inventoryAtAntechZPC(inventoryAtAntechZPC)
				.inventoryAtTrade(inventoryAtTrade)
				.build();
	}

	@Test
	public void createProductSalesForAugust2019_basedOnGivenDetails_shouldBeSuccessful() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1400)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();

		Integer plan = 895;
		Integer inMarketSales = 2000;
		Integer averageInMarketSales = (productSalesForS1400May2019.getGeneralInformation()
				.getInMarketSales() + productSalesForS1400June2019.getGeneralInformation()
				.getInMarketSales() + productSalesForS1400July2019.getGeneralInformation()
				.getInMarketSales()) / 3;
		Integer offTake = (productSalesForS1400May2019.getGeneralInformation()
				.getOffTake() + productSalesForS1400June2019.getGeneralInformation()
				.getOffTake() + productSalesForS1400July2019.getGeneralInformation()
				.getOffTake()) / 3;

		GeneralInformation generalInformation = GeneralInformation.Builder.buildGeneralInformation()
				.plan(plan)
				.inMarketSales(inMarketSales)
				.averageInMarketSales(averageInMarketSales)
				.offTake(offTake)
				.build();

		Integer production = 5660;
		Integer totalGoodsAvailable = productSalesForS1400July2019.getInventoryAtSource()
				.getHippEndingInvetory() + production;
		Integer loading = 0;
		Integer hippEndingInventory = totalGoodsAvailable + loading;
		Double hippDaysOnHandInDouble =
				(hippEndingInventory.doubleValue() / ((productSalesForS1400June2019.getGeneralInformation()
						.getInMarketSales() + productSalesForS1400July2019.getGeneralInformation()
						.getInMarketSales()) / 2)) * 30;
		Long hippDaysOnHandInLong = Math.round(hippDaysOnHandInDouble);
		Integer hippDaysOnHand = hippDaysOnHandInLong.intValue();

		InventoryAtSource inventoryAtSource = InventoryAtSource.Builder.buildInventoryAtSource()
				.production(production)
				.totalGoodsAvailable(totalGoodsAvailable)
				.loading(loading)
				.hippEndingInvetory(hippEndingInventory)
				.hippDaysOnHand(hippDaysOnHand)
				.build();

		Integer antechBeginningInventory = productSalesForS1400July2019.getInventoryAtAntechZPC()
				.getEndingInventory();
		Integer shipmentsReceived = 3812;
		Integer totalAvailable = antechBeginningInventory + shipmentsReceived;
		Integer actualSales = 2000;
		Integer antechEndingInventory = totalAvailable - actualSales;

		Double antechDaysOnHand =
				(antechEndingInventory.doubleValue() / ((productSalesForS1400June2019.getGeneralInformation()
						.getInMarketSales() + productSalesForS1400July2019.getGeneralInformation()
						.getInMarketSales() + productSalesForS1400May2019.getGeneralInformation()
						.getInMarketSales()) / 3)) * 30;
		Long antechDaysOnHandInLong = Math.round(antechDaysOnHand);
		Integer antechDaysOnHandInInteger = antechDaysOnHandInLong.intValue();

		InventoryAtAntechZPC inventoryAtAntechZPC = InventoryAtAntechZPC.Builder.buildInventoryAtAntechZPC()
				.beginningInventory(antechBeginningInventory)
				.shipmentsReceived(shipmentsReceived)
				.totalAvailableForSaleInPhilippines(totalAvailable)
				.actualSales(actualSales)
				.endingInventory(antechEndingInventory)
				.daysOnHand(antechDaysOnHandInInteger)
				.build();

		Integer beginningInventory = productSalesForS1400July2019.getInventoryAtTrade()
				.getTotalEndingInventory();
		Integer totalEndingInventory =
				beginningInventory + inventoryAtAntechZPC.getActualSales() - generalInformation.getOffTake();

		Double daysOnHandInDouble = totalEndingInventory.doubleValue() / generalInformation.getOffTake() * 30;
		Long daysOnHandInLong = Math.round(daysOnHandInDouble);
		Integer daysOnHand = daysOnHandInLong.intValue();

		InventoryAtTrade inventoryAtTrade = InventoryAtTrade.Builder.buildInventoryAtTrade()
				.beginningInventory(beginningInventory)
				.totalEndingInventory(totalEndingInventory)
				.daysOnHand(daysOnHand)
				.build();

		ProductSales productSalesForS1400August2019 = ProductSales.Builder.buildProduct()
				.product(product)
				.month(Month.AUGUST)
				.year(Year.of(2019))
				.generalInformation(generalInformation)
				.inventoryAtSource(inventoryAtSource)
				.inventoryAtAntechZPC(inventoryAtAntechZPC)
				.inventoryAtTrade(inventoryAtTrade)
				.build();
		checkIfProductSalesAreAccurate(productSalesForS1400August2019);
	}

	@Test
	public void createProductSalesForS1400August2019_usingDetailsAbove_shouldBeSuccessful() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1400)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();
		ProductSalesDetails productSalesDetails = ProductSalesDetails.Builder.buildProductSalesDetails()
				.plan(895)
				.inMarketSales(2000)
				.production(5660)
				.loading(0)
				.shipmentReceived(3812)
				.actualSales(2000)
				.build();

		ProductSales productSalesForS1400August2019 = new ProductSales(product, productSalesForS1400July2019,
				productSalesForS1400June2019, productSalesForS1400May2019, productSalesDetails);
		checkIfProductSalesAreAccurate(productSalesForS1400August2019);
	}

	private void checkIfProductSalesAreAccurate(ProductSales productSales) {
		// For GeneralInformation
		Assert.assertEquals(895, productSales.getGeneralInformation()
				.getPlan()
				.longValue());
		Assert.assertEquals(2000, productSales.getGeneralInformation()
				.getInMarketSales()
				.longValue());
		Assert.assertEquals(733, productSales.getGeneralInformation()
				.getAverageInMarketSales()
				.longValue());
		Assert.assertEquals(1384, productSales.getGeneralInformation()
				.getOffTake()
				.longValue());

		// For InventoryAtSource
		Assert.assertEquals(5660, productSales.getInventoryAtSource()
				.getProduction()
				.longValue());
		Assert.assertEquals(5660, productSales.getInventoryAtSource()
				.getTotalGoodsAvailable()
				.longValue());
		Assert.assertEquals(0, productSales.getInventoryAtSource()
				.getLoading()
				.longValue());
		Assert.assertEquals(5660, productSales.getInventoryAtSource()
				.getHippEndingInvetory()
				.longValue());
		Assert.assertEquals(227, productSales.getInventoryAtSource()
				.getHippDaysOnHand()
				.longValue());

		// For InventoryAtAntechZPC
		Assert.assertEquals(-3, productSales.getInventoryAtAntechZPC()
				.getBeginningInventory()
				.longValue());
		Assert.assertEquals(3812, productSales.getInventoryAtAntechZPC()
				.getShipmentsReceived()
				.longValue());
		Assert.assertEquals(3809, productSales.getInventoryAtAntechZPC()
				.getTotalAvailableForSaleInPhilippines()
				.longValue());
		Assert.assertEquals(2000, productSales.getInventoryAtAntechZPC()
				.getActualSales()
				.longValue());
		Assert.assertEquals(1809, productSales.getInventoryAtAntechZPC()
				.getEndingInventory()
				.longValue());
		Assert.assertEquals(74, productSales.getInventoryAtAntechZPC()
				.getDaysOnHand()
				.longValue());

		// For InvetoryAtTrade
		Assert.assertEquals(2338, productSales.getInventoryAtTrade()
				.getBeginningInventory()
				.longValue());
		Assert.assertEquals(2954, productSales.getInventoryAtTrade()
				.getTotalEndingInventory()
				.longValue());
		Assert.assertEquals(64, productSales.getInventoryAtTrade()
				.getDaysOnHand()
				.longValue());
	}

	@Test(expected = DifferentProductException.class)
	public void createProductSalesForAugust_withDifferentProduct_shouldThrowDifferentProductException() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1800)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();
		ProductSalesDetails productSalesDetails = ProductSalesDetails.Builder.buildProductSalesDetails()
				.plan(895)
				.inMarketSales(2000)
				.production(5660)
				.loading(0)
				.shipmentReceived(3812)
				.actualSales(2000)
				.build();

		ProductSales productSalesForS1400August2019 = new ProductSales(product, productSalesForS1400July2019,
				productSalesForS1400June2019, productSalesForS1400May2019, productSalesDetails);
	}

	@Test(expected = DifferentProductException.class)
	public void editProductSalesForMay_withDifferentProduct_shouldThrowDifferentProductException() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1400)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();
		ProductSalesDetails productSalesDetails = ProductSalesDetails.Builder.buildProductSalesDetails()
				.plan(895)
				.inMarketSales(2000)
				.production(5660)
				.loading(0)
				.shipmentReceived(3812)
				.actualSales(2000)
				.build();

		Product productForProductSalesForMay2019 = Product.Builder.buildProduct()
				.productType(ProductType.S1800)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();
		productSalesForS1400May2019.setProduct(productForProductSalesForMay2019);

		ProductSales productSalesForS1400August2019 = new ProductSales(product, productSalesForS1400July2019,
				productSalesForS1400June2019, productSalesForS1400May2019, productSalesDetails);
	}

	@Test(expected = DifferentProductException.class)
	public void editProductSalesForJune_withDifferentProduct_shouldThrowDifferentProductException() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1400)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();
		ProductSalesDetails productSalesDetails = ProductSalesDetails.Builder.buildProductSalesDetails()
				.plan(895)
				.inMarketSales(2000)
				.production(5660)
				.loading(0)
				.shipmentReceived(3812)
				.actualSales(2000)
				.build();

		Product productForProductSalesJune2019 = Product.Builder.buildProduct()
				.productType(ProductType.S1800)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();
		productSalesForS1400June2019.setProduct(productForProductSalesJune2019);

		ProductSales productSalesForS1400August2019 = new ProductSales(product, productSalesForS1400July2019,
				productSalesForS1400June2019, productSalesForS1400May2019, productSalesDetails);
	}

	@Test(expected = DifferentProductException.class)
	public void editProductSalesForJuly_withDifferentProduct_shouldThrowDifferentProductException() {
		Product product = Product.Builder.buildProduct()
				.productType(ProductType.S1400)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();
		ProductSalesDetails productSalesDetails = ProductSalesDetails.Builder.buildProductSalesDetails()
				.plan(895)
				.inMarketSales(2000)
				.production(5660)
				.loading(0)
				.shipmentReceived(3812)
				.actualSales(2000)
				.build();

		Product productForProductSalesJuly2019 = Product.Builder.buildProduct()
				.productType(ProductType.S1800)
				.price(BigDecimal.TEN)
				.description("S1400 description")
				.build();
		productSalesForS1400July2019.setProduct(productForProductSalesJuly2019);

		ProductSales productSalesForS1400August2019 = new ProductSales(product, productSalesForS1400July2019,
				productSalesForS1400June2019, productSalesForS1400May2019, productSalesDetails);
	}

}
