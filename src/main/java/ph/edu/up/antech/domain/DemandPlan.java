package ph.edu.up.antech.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.YearMonth;

public class DemandPlan implements Serializable {

    private Integer id;
    private Product product;
    private YearMonth yearMonth;

    private BigDecimal plan;
    private BigDecimal inMarket;
    private BigDecimal averageInMarketSales;
    private BigDecimal totalOffTake;

    private BigDecimal production;
    private BigDecimal totalGoodsAvailable;
    private BigDecimal loading;
    private BigDecimal hippEndingInventory;
    private BigDecimal hippDaysOnHand;

    private BigDecimal antechBeginningInventory;
    private BigDecimal shipmentsReceivedAtAntech;
    private BigDecimal totalAvailableForSalePhils;
    private BigDecimal actualSales;
    private BigDecimal daysOnHand;

    private BigDecimal beginningInventoryTrade;
    private BigDecimal totalEndingInventoryTrade;
    private BigDecimal daysOnHandTrade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    public BigDecimal getPlan() {
        return plan;
    }

    public void setPlan(BigDecimal plan) {
        this.plan = plan;
    }

    public BigDecimal getInMarket() {
        return inMarket;
    }

    public void setInMarket(BigDecimal inMarket) {
        this.inMarket = inMarket;
    }

    public BigDecimal getAverageInMarketSales() {
        return averageInMarketSales;
    }

    public void setAverageInMarketSales(BigDecimal averageInMarketSales) {
        this.averageInMarketSales = averageInMarketSales;
    }

    public BigDecimal getTotalOffTake() {
        return totalOffTake;
    }

    public void setTotalOffTake(BigDecimal totalOffTake) {
        this.totalOffTake = totalOffTake;
    }

    public BigDecimal getProduction() {
        return production;
    }

    public void setProduction(BigDecimal production) {
        this.production = production;
    }

    public BigDecimal getTotalGoodsAvailable() {
        return totalGoodsAvailable;
    }

    public void setTotalGoodsAvailable(BigDecimal totalGoodsAvailable) {
        this.totalGoodsAvailable = totalGoodsAvailable;
    }

    public BigDecimal getLoading() {
        return loading;
    }

    public void setLoading(BigDecimal loading) {
        this.loading = loading;
    }

    public BigDecimal getHippEndingInventory() {
        return hippEndingInventory;
    }

    public void setHippEndingInventory(BigDecimal hippEndingInventory) {
        this.hippEndingInventory = hippEndingInventory;
    }

    public BigDecimal getHippDaysOnHand() {
        return hippDaysOnHand;
    }

    public void setHippDaysOnHand(BigDecimal hippDaysOnHand) {
        this.hippDaysOnHand = hippDaysOnHand;
    }

    public BigDecimal getAntechBeginningInventory() {
        return antechBeginningInventory;
    }

    public void setAntechBeginningInventory(BigDecimal antechBeginningInventory) {
        this.antechBeginningInventory = antechBeginningInventory;
    }

    public BigDecimal getShipmentsReceivedAtAntech() {
        return shipmentsReceivedAtAntech;
    }

    public void setShipmentsReceivedAtAntech(BigDecimal shipmentsReceivedAtAntech) {
        this.shipmentsReceivedAtAntech = shipmentsReceivedAtAntech;
    }

    public BigDecimal getTotalAvailableForSalePhils() {
        return totalAvailableForSalePhils;
    }

    public void setTotalAvailableForSalePhils(BigDecimal totalAvailableForSalePhils) {
        this.totalAvailableForSalePhils = totalAvailableForSalePhils;
    }

    public BigDecimal getActualSales() {
        return actualSales;
    }

    public void setActualSales(BigDecimal actualSales) {
        this.actualSales = actualSales;
    }

    public BigDecimal getDaysOnHand() {
        return daysOnHand;
    }

    public void setDaysOnHand(BigDecimal daysOnHand) {
        this.daysOnHand = daysOnHand;
    }

    public BigDecimal getBeginningInventoryTrade() {
        return beginningInventoryTrade;
    }

    public void setBeginningInventoryTrade(BigDecimal beginningInventoryTrade) {
        this.beginningInventoryTrade = beginningInventoryTrade;
    }

    public BigDecimal getTotalEndingInventoryTrade() {
        return totalEndingInventoryTrade;
    }

    public void setTotalEndingInventoryTrade(BigDecimal totalEndingInventoryTrade) {
        this.totalEndingInventoryTrade = totalEndingInventoryTrade;
    }

    public BigDecimal getDaysOnHandTrade() {
        return daysOnHandTrade;
    }

    public void setDaysOnHandTrade(BigDecimal daysOnHandTrade) {
        this.daysOnHandTrade = daysOnHandTrade;
    }

}
