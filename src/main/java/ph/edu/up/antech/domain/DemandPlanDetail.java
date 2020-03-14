package ph.edu.up.antech.domain;

import ph.edu.up.antech.util.YearMonthDateAttributeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.YearMonth;

@Entity
@Table(name = "demand_plan_detail")
public class DemandPlanDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demand_plan_id")
    private DemandPlan demandPlan;

    @Convert(converter = YearMonthDateAttributeConverter.class)
    @Column(name = "year_month_demand")
    private YearMonth yearMonth;

    @Column(name = "plan")
    private BigDecimal plan = BigDecimal.ZERO;

    @Column(name = "in_market")
    private BigDecimal inMarket = BigDecimal.ZERO;

    @Column(name = "average_in_market")
    private BigDecimal averageInMarketSales = BigDecimal.ZERO;

    @Column(name = "total_off_take")
    private BigDecimal totalOffTake = BigDecimal.ZERO;

    @Column(name = "source_production")
    private BigDecimal sourceProduction = BigDecimal.ZERO;

    @Column(name = "source_total_goods_available")
    private BigDecimal sourceTotalGoodsAvailable = BigDecimal.ZERO;

    @Column(name = "source_loading")
    private BigDecimal sourceLoading = BigDecimal.ZERO;

    @Column(name = "source_hipp_ending_inventory")
    private BigDecimal sourceHippEndingInventory = BigDecimal.ZERO;

    @Column(name = "source_hipp_days_on_hand")
    private BigDecimal sourceHippDaysOnHand = BigDecimal.ZERO;

    @Column(name = "antech_beginning_inventory")
    private BigDecimal antechBeginningInventory = BigDecimal.ZERO;

    @Column(name = "antech_shipments_received")
    private BigDecimal antechShipmentsReceived = BigDecimal.ZERO;

    @Column(name = "antech_total_available_sales_ph")
    private BigDecimal antechTotalAvailableForSalePhils = BigDecimal.ZERO;

    @Column(name = "antech_actual_sales")
    private BigDecimal antechActualSales = BigDecimal.ZERO;

    @Column(name = "antech_ending_inventory")
    private BigDecimal antechEndingInventory = BigDecimal.ZERO;

    @Column(name = "antech_days_on_hand")
    private BigDecimal antechDaysOnHand = BigDecimal.ZERO;

    @Column(name = "trade_beginning_inventory")
    private BigDecimal tradeBeginningInventory = BigDecimal.ZERO;

    @Column(name = "trade_total_ending_inventory")
    private BigDecimal tradeTotalEndingInventory = BigDecimal.ZERO;

    @Column(name = "trade_days_on_hand")
    private BigDecimal tradeDaysOnHand = BigDecimal.ZERO;

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
        return plan.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setPlan(BigDecimal plan) {
        this.plan = plan;
    }

    public BigDecimal getInMarket() {
        return inMarket.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setInMarket(BigDecimal inMarket) {
        this.inMarket = inMarket;
    }

    public BigDecimal getAverageInMarketSales() {
        return averageInMarketSales.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setAverageInMarketSales(BigDecimal averageInMarketSales) {
        this.averageInMarketSales = averageInMarketSales;
    }

    public BigDecimal getTotalOffTake() {
        return totalOffTake.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setTotalOffTake(BigDecimal totalOffTake) {
        this.totalOffTake = totalOffTake;
    }

    public BigDecimal getSourceProduction() {
        return sourceProduction.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setSourceProduction(BigDecimal sourceProduction) {
        this.sourceProduction = sourceProduction;
    }

    public BigDecimal getSourceTotalGoodsAvailable() {
        return sourceTotalGoodsAvailable.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setSourceTotalGoodsAvailable(BigDecimal sourceTotalGoodsAvailable) {
        this.sourceTotalGoodsAvailable = sourceTotalGoodsAvailable;
    }

    public BigDecimal getSourceLoading() {
        return sourceLoading.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setSourceLoading(BigDecimal sourceLoading) {
        this.sourceLoading = sourceLoading;
    }

    public BigDecimal getSourceHippEndingInventory() {
        return sourceHippEndingInventory.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setSourceHippEndingInventory(BigDecimal sourceHippEndingInventory) {
        this.sourceHippEndingInventory = sourceHippEndingInventory;
    }

    public BigDecimal getSourceHippDaysOnHand() {
        return sourceHippDaysOnHand.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setSourceHippDaysOnHand(BigDecimal sourceHippDaysOnHand) {
        this.sourceHippDaysOnHand = sourceHippDaysOnHand;
    }

    public BigDecimal getAntechBeginningInventory() {
        return antechBeginningInventory.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setAntechBeginningInventory(BigDecimal antechBeginningInventory) {
        this.antechBeginningInventory = antechBeginningInventory;
    }

    public BigDecimal getAntechShipmentsReceived() {
        return antechShipmentsReceived.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setAntechShipmentsReceived(BigDecimal antechShipmentsReceived) {
        this.antechShipmentsReceived = antechShipmentsReceived;
    }

    public BigDecimal getAntechTotalAvailableForSalePhils() {
        return antechTotalAvailableForSalePhils.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setAntechTotalAvailableForSalePhils(BigDecimal antechTotalAvailableForSalePhils) {
        this.antechTotalAvailableForSalePhils = antechTotalAvailableForSalePhils;
    }

    public BigDecimal getAntechActualSales() {
        return antechActualSales.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setAntechActualSales(BigDecimal antechActualSales) {
        this.antechActualSales = antechActualSales;
    }

    public BigDecimal getAntechEndingInventory() {
        return antechEndingInventory.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setAntechEndingInventory(BigDecimal antechEndingInventory) {
        this.antechEndingInventory = antechEndingInventory;
    }

    public BigDecimal getAntechDaysOnHand() {
        return antechDaysOnHand.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setAntechDaysOnHand(BigDecimal antechDaysOnHand) {
        this.antechDaysOnHand = antechDaysOnHand;
    }

    public BigDecimal getTradeBeginningInventory() {
        return tradeBeginningInventory.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setTradeBeginningInventory(BigDecimal tradeBeginningInventory) {
        this.tradeBeginningInventory = tradeBeginningInventory;
    }

    public BigDecimal getTradeTotalEndingInventory() {
        return tradeTotalEndingInventory.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setTradeTotalEndingInventory(BigDecimal tradeTotalEndingInventory) {
        this.tradeTotalEndingInventory = tradeTotalEndingInventory;
    }

    public BigDecimal getTradeDaysOnHand() {
        return tradeDaysOnHand.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public void setTradeDaysOnHand(BigDecimal tradeDaysOnHand) {
        this.tradeDaysOnHand = tradeDaysOnHand;
    }

}
