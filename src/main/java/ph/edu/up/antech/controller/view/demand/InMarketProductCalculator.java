package ph.edu.up.antech.controller.view.demand;

import java.time.YearMonth;

public class InMarketProductCalculator {

    private ZolPerDoorsCalculator zolPerDoorsMercuryDrugCalculator;
    private ZolPerDoorsCalculator zolPerDoorsGmaCalculator;
    private ZolPerDoorsCalculator zolPerDoorsVisayasCalculator;
    private ZolPerDoorsCalculator zolPerDoorsMindanaoCalculator;

    private NetsuiteCalculator netsuiteDispensingDistributor;
    private NetsuiteCalculator netsuiteBbjCalculator;
    private NetsuiteCalculator netsuiteDirectAcctCalculator;
    private NetsuiteCalculator netsuiteLazadaCalculator;

    public InMarketProductCalculator(ZolPerDoorsCalculator zolPerDoorsMercuryDrugCalculator,
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

    public Integer calculateSalesAmountByYearMonthAndProductCode(YearMonth yearMonth, String productCode) {
        return zolPerDoorsMercuryDrugCalculator.calculateSalesAmountByYearMonthAndProductCode(yearMonth, productCode)
                + zolPerDoorsGmaCalculator.calculateSalesAmountByYearMonthAndProductCode(yearMonth, productCode)
                + zolPerDoorsVisayasCalculator.calculateSalesAmountByYearMonthAndProductCode(yearMonth, productCode)
                + zolPerDoorsMindanaoCalculator.calculateSalesAmountByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteDispensingDistributor.calculateSalesAmountByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteBbjCalculator.calculateSalesAmountByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteDirectAcctCalculator.calculateSalesAmountByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteLazadaCalculator.calculateSalesAmountByYearMonthAndProductCode(yearMonth, productCode);
    }

    public Integer calculateSalesAmountByYearMonth(YearMonth yearMonth) {
        return zolPerDoorsMercuryDrugCalculator.calculateSalesAmountByYearMonth(yearMonth)
                + zolPerDoorsGmaCalculator.calculateSalesAmountByYearMonth(yearMonth)
                + zolPerDoorsVisayasCalculator.calculateSalesAmountByYearMonth(yearMonth)
                + zolPerDoorsMindanaoCalculator.calculateSalesAmountByYearMonth(yearMonth)
                + netsuiteDispensingDistributor.calculateSalesAmountByYearMonth(yearMonth)
                + netsuiteBbjCalculator.calculateSalesAmountByYearMonth(yearMonth)
                + netsuiteDirectAcctCalculator.calculateSalesAmountByYearMonth(yearMonth)
                + netsuiteLazadaCalculator.calculateSalesAmountByYearMonth(yearMonth);
    }

    public Integer calculateSalesUnitByYearMonthAndProductCode(YearMonth yearMonth, String productCode) {
        return zolPerDoorsMercuryDrugCalculator.calculateSalesUnitByYearMonthAndProductCode(yearMonth, productCode)
                + zolPerDoorsGmaCalculator.calculateSalesUnitByYearMonthAndProductCode(yearMonth, productCode)
                + zolPerDoorsVisayasCalculator.calculateSalesUnitByYearMonthAndProductCode(yearMonth, productCode)
                + zolPerDoorsMindanaoCalculator.calculateSalesUnitByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteDispensingDistributor.calculateSalesUnitByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteBbjCalculator.calculateSalesUnitByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteDirectAcctCalculator.calculateSalesUnitByYearMonthAndProductCode(yearMonth, productCode)
                + netsuiteLazadaCalculator.calculateSalesUnitByYearMonthAndProductCode(yearMonth, productCode);
    }

    public Integer calculateSalesUnitByYearMonth(YearMonth yearMonth) {
        return zolPerDoorsMercuryDrugCalculator.calculateSalesUnitByYearMonth(yearMonth)
                + zolPerDoorsGmaCalculator.calculateSalesUnitByYearMonth(yearMonth)
                + zolPerDoorsVisayasCalculator.calculateSalesUnitByYearMonth(yearMonth)
                + zolPerDoorsMindanaoCalculator.calculateSalesUnitByYearMonth(yearMonth)
                + netsuiteDispensingDistributor.calculateSalesUnitByYearMonth(yearMonth)
                + netsuiteBbjCalculator.calculateSalesUnitByYearMonth(yearMonth)
                + netsuiteDirectAcctCalculator.calculateSalesUnitByYearMonth(yearMonth)
                + netsuiteLazadaCalculator.calculateSalesUnitByYearMonth(yearMonth);
    }

}
