package ph.edu.up.antech.util;

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

    public Integer getSalesAmountByYearMonthAndProductCode(YearMonth yearMonth, String productCode) {
        return netsuiteZpcDirectCalculator.getTotalAmountByYearMonthByProduct(yearMonth, productCode)
                + netsuiteDispensingDistributorCalculator.getTotalAmountByYearMonthByProduct(yearMonth, productCode)
                + netsuiteToMarketBbjCalculator.getTotalAmountByYearMonthByProduct(yearMonth, productCode)
                + netsuiteDirectAcctCalculator.getTotalAmountByYearMonthByProduct(yearMonth, productCode)
                + netsuiteLazadaCalculator.getTotalAmountByYearMonthByProduct(yearMonth, productCode);
    }

    public Integer getSalesAmountByYearMonth(YearMonth yearMonth) {
        return netsuiteZpcDirectCalculator.getTotalAmountByYearMonth(yearMonth)
                + netsuiteDispensingDistributorCalculator.getTotalAmountByYearMonth(yearMonth)
                + netsuiteToMarketBbjCalculator.getTotalAmountByYearMonth(yearMonth)
                + netsuiteDirectAcctCalculator.getTotalAmountByYearMonth(yearMonth)
                + netsuiteLazadaCalculator.getTotalAmountByYearMonth(yearMonth);
    }

    public Integer getSalesUnitsByYearMonthAndProductCode(YearMonth yearMonth, String productCode) {
        return netsuiteZpcDirectCalculator.getTotalUnitsByYearMonthByProduct(yearMonth, productCode)
                + netsuiteDispensingDistributorCalculator.getTotalUnitsByYearMonthByProduct(yearMonth, productCode)
                + netsuiteToMarketBbjCalculator.getTotalUnitsByYearMonthByProduct(yearMonth, productCode)
                + netsuiteDirectAcctCalculator.getTotalUnitsByYearMonthByProduct(yearMonth, productCode)
                + netsuiteLazadaCalculator.getTotalUnitsByYearMonthByProduct(yearMonth, productCode);
    }

    public Integer getSalesUnitsByYearMonth(YearMonth yearMonth) {
        return netsuiteZpcDirectCalculator.getTotalUnitsByYearMonth(yearMonth)
                + netsuiteDispensingDistributorCalculator.getTotalUnitsByYearMonth(yearMonth)
                + netsuiteToMarketBbjCalculator.getTotalUnitsByYearMonth(yearMonth)
                + netsuiteDirectAcctCalculator.getTotalUnitsByYearMonth(yearMonth)
                + netsuiteLazadaCalculator.getTotalUnitsByYearMonth(yearMonth);
    }

}
