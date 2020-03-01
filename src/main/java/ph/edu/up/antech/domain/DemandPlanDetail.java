package ph.edu.up.antech.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.YearMonth;

public class DemandPlanDetail implements Serializable {

    private Integer id;
    private DemandPlan demandPlan;
    private YearMonth yearMonth;

    private BigDecimal plan = BigDecimal.ZERO;
    private BigDecimal inMarket = BigDecimal.ZERO;
    private BigDecimal averageInMarketSales = BigDecimal.ZERO;
    private BigDecimal totalOffTake = BigDecimal.ZERO;

    private BigDecimal production = BigDecimal.ZERO;
    private BigDecimal totalGoodsAvailable = BigDecimal.ZERO;
    private BigDecimal loading = BigDecimal.ZERO;
    private BigDecimal hippEndingInventory = BigDecimal.ZERO;
    private BigDecimal hippDaysOnHand = BigDecimal.ZERO;

    private BigDecimal antechBeginningInventory = BigDecimal.ZERO;
    private BigDecimal shipmentsReceivedAtAntech = BigDecimal.ZERO;
    private BigDecimal totalAvailableForSalePhils = BigDecimal.ZERO;
    private BigDecimal actualSales = BigDecimal.ZERO;
    private BigDecimal daysOnHand = BigDecimal.ZERO;

    private BigDecimal beginningInventoryTrade = BigDecimal.ZERO;
    private BigDecimal totalEndingInventoryTrade = BigDecimal.ZERO;
    private BigDecimal daysOnHandTrade = BigDecimal.ZERO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DemandPlan getDemandPlan() {
        return demandPlan;
    }

    public void setDemandPlan(DemandPlan demandPlan) {
        this.demandPlan = demandPlan;
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
