package ph.edu.up.antech.domain;

import java.math.BigDecimal;
import java.time.YearMonth;

public class DemandPlan {

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

}
