package ph.edu.up.antech.util;

import java.time.YearMonth;

public class TotalProductCalculator {

    private ZolPerDoorsCalculator zolPerDoorsMercuryDrugCalculator;
    private ZolPerDoorsCalculator zolPerDoorsGmaCalculator;
    private ZolPerDoorsCalculator zolPerDoorsVisayasCalculator;
    private ZolPerDoorsCalculator zolPerDoorsMindanaoCalculator;

    private NetsuiteCalculator netsuiteDispensingDistributor;
    private NetsuiteCalculator netsuiteBbjCalculator;
    private NetsuiteCalculator netsuiteDirectAcctCalculator;
    private NetsuiteCalculator netsuiteLazadaCalculator;

    public TotalProductCalculator(ZolPerDoorsCalculator zolPerDoorsMercuryDrugCalculator,
                                  ZolPerDoorsCalculator zolPerDoorsGmaCalculator,
                                  ZolPerDoorsCalculator zolPerDoorsVisayasCalculator,
                                  ZolPerDoorsCalculator zolPerDoorsMindanaoCalculator,
                                  NetsuiteCalculator netsuiteDispensingDistributor,
                                  NetsuiteCalculator netsuiteBbjCalculator,
                                  NetsuiteCalculator netsuiteDirectAcctCalculator,
                                  NetsuiteCalculator netsuiteLazadaCalculator) {
        this.zolPerDoorsMercuryDrugCalculator = zolPerDoorsMercuryDrugCalculator;
        this.zolPerDoorsGmaCalculator = zolPerDoorsGmaCalculator;
        this.zolPerDoorsVisayasCalculator = zolPerDoorsVisayasCalculator;
        this.zolPerDoorsMindanaoCalculator = zolPerDoorsMindanaoCalculator;
        this.netsuiteDispensingDistributor = netsuiteDispensingDistributor;
        this.netsuiteBbjCalculator = netsuiteBbjCalculator;
        this.netsuiteDirectAcctCalculator = netsuiteDirectAcctCalculator;
        this.netsuiteLazadaCalculator = netsuiteLazadaCalculator;
    }

    public Integer getTotalSalesAmountPerYearMonthPerProduct(YearMonth yearMonth, String productCode) {
        return zolPerDoorsMercuryDrugCalculator.getSalesAmountByYearMonthAndProduct(yearMonth, productCode)
                + zolPerDoorsGmaCalculator.getSalesAmountByYearMonthAndProduct(yearMonth, productCode)
                + zolPerDoorsVisayasCalculator.getSalesAmountByYearMonthAndProduct(yearMonth, productCode)
                + zolPerDoorsMindanaoCalculator.getSalesAmountByYearMonthAndProduct(yearMonth, productCode)
                + netsuiteDispensingDistributor.getTotalAmountByYearMonthByProduct(yearMonth, productCode)
                + netsuiteBbjCalculator.getTotalAmountByYearMonthByProduct(yearMonth, productCode)
                + netsuiteDirectAcctCalculator.getTotalAmountByYearMonthByProduct(yearMonth, productCode)
                + netsuiteLazadaCalculator.getTotalAmountByYearMonthByProduct(yearMonth, productCode);
    }

    public Integer getTotalSalesAmountPerYearMonth(YearMonth yearMonth) {
        return zolPerDoorsMercuryDrugCalculator.getSalesAmountByYearMonth(yearMonth)
                + zolPerDoorsGmaCalculator.getSalesAmountByYearMonth(yearMonth)
                + zolPerDoorsVisayasCalculator.getSalesAmountByYearMonth(yearMonth)
                + zolPerDoorsMindanaoCalculator.getSalesAmountByYearMonth(yearMonth)
                + netsuiteDispensingDistributor.getTotalAmountByYearMonth(yearMonth)
                + netsuiteBbjCalculator.getTotalAmountByYearMonth(yearMonth)
                + netsuiteDirectAcctCalculator.getTotalAmountByYearMonth(yearMonth)
                + netsuiteLazadaCalculator.getTotalAmountByYearMonth(yearMonth);
    }

}
