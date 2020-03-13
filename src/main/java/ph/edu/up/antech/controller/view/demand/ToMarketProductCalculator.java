package ph.edu.up.antech.controller.view.demand;

import ph.edu.up.antech.controller.view.demand.NetsuiteCalculator;

import java.time.YearMonth;

public class ToMarketProductCalculator {

    private NetsuiteCalculator netsuiteZpcDirectCalculator;
    private NetsuiteCalculator netsuiteDispensingDistributorCalculator;
    private NetsuiteCalculator netsuiteToMarketBbjCalculator;
    private NetsuiteCalculator netsuiteDirectAcctCalculator;
    private NetsuiteCalculator netsuiteLazadaCalculator;

    public ToMarketProductCalculator(NetsuiteCalculator netsuiteZpcDirectCalculator,
                                     NetsuiteCalculator netsuiteDispensingDistributorCalculator,
                                     NetsuiteCalculator netsuiteToMarketBbjCalculator,
                                     NetsuiteCalculator netsuiteDirectAcctCalculator,
                                     NetsuiteCalculator netsuiteLazadaCalculator) {
        this.netsuiteZpcDirectCalculator = netsuiteZpcDirectCalculator;
        this.netsuiteDispensingDistributorCalculator = netsuiteDispensingDistributorCalculator;
        this.netsuiteToMarketBbjCalculator = netsuiteToMarketBbjCalculator;
        this.netsuiteDirectAcctCalculator = netsuiteDirectAcctCalculator;
        this.netsuiteLazadaCalculator = netsuiteLazadaCalculator;
    }

    public Integer calculateSalesAmountByYearMonthAndProductCode(YearMonth yearMonth, String productCode) {
        return netsuiteZpcDirectCalculator.calculateSalesAmountByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteDispensingDistributorCalculator.calculateSalesAmountByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteToMarketBbjCalculator.calculateSalesAmountByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteDirectAcctCalculator.calculateSalesAmountByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteLazadaCalculator.calculateSalesAmountByYearMonthAndProductCode(yearMonth, productCode);
    }

    public Integer calculateSalesAmountByYearMonth(YearMonth yearMonth) {
        return netsuiteZpcDirectCalculator.calculateSalesAmountByYearMonth(yearMonth)
                + netsuiteDispensingDistributorCalculator.calculateSalesAmountByYearMonth(yearMonth)
                + netsuiteToMarketBbjCalculator.calculateSalesAmountByYearMonth(yearMonth)
                + netsuiteDirectAcctCalculator.calculateSalesAmountByYearMonth(yearMonth)
                + netsuiteLazadaCalculator.calculateSalesAmountByYearMonth(yearMonth);
    }

    public Integer calculateSalesUnitByYearMonthAndProductCode(YearMonth yearMonth, String productCode) {
        return netsuiteZpcDirectCalculator.calculateSalesUnitByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteDispensingDistributorCalculator.calculateSalesUnitByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteToMarketBbjCalculator.calculateSalesUnitByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteDirectAcctCalculator.calculateSalesUnitByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteLazadaCalculator.calculateSalesUnitByYearMonthAndProductCode(yearMonth, productCode);
    }

    public Integer calculateSalesUnitByYearMonth(YearMonth yearMonth) {
        return netsuiteZpcDirectCalculator.calculateSalesUnitByYearMonth(yearMonth)
                + netsuiteDispensingDistributorCalculator.calculateSalesUnitByYearMonth(yearMonth)
                + netsuiteToMarketBbjCalculator.calculateSalesUnitByYearMonth(yearMonth)
                + netsuiteDirectAcctCalculator.calculateSalesUnitByYearMonth(yearMonth)
                + netsuiteLazadaCalculator.calculateSalesUnitByYearMonth(yearMonth);
    }

}
