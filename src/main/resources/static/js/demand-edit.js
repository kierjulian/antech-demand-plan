$(document).ready(function () {
    var doesPreviousDemandPlanExist = document.getElementById('doesPreviousDemandPlanExist').value;
    doesPreviousDemandPlanExist = (doesPreviousDemandPlanExist == 'true');

    var form = document.querySelector('form');
    form.addEventListener('change', function () {
        for (var i = 0; i < 12; i++) {
            if (doesPreviousDemandPlanExist == true) {
                computeDemandPlan(i);
                continue;
            }

            if (doesPreviousDemandPlanExist == false && i < 6) {
                continue;
            }

            computeDemandPlan(i);
        }
    })

    function computeDemandPlan(i) {
        // For Ave In Market Sales
        document.getElementById('averageInMarketSales' + i).value =
            Math.round((+document.getElementById('inMarket' + (i - 3)).value
                + +document.getElementById('inMarket' + (i - 2)).value
                + +document.getElementById('inMarket' + (i - 1)).value) / 3);

        // For Total Offtake
        document.getElementById('totalOffTake' + i).value =
            Math.round((+document.getElementById('totalOffTake' + (i - 3)).value
                + +document.getElementById('totalOffTake' + (i - 2)).value
                + +document.getElementById('totalOffTake' + (i - 1)).value) / 3);

        // Total Goods Available
        document.getElementById('sourceTotalGoodsAvailable' + i).value =
            +document.getElementById('sourceProduction' + i).value
            + +document.getElementById('sourceHippEndingInventory' + (i - 1)).value;

        // For hipp ending inventory
        document.getElementById('sourceHippEndingInventory' + i).value =
            +document.getElementById('sourceTotalGoodsAvailable' + i).value
            - +document.getElementById('sourceLoading' + i).value;

        // Hipp Days On Hand
        var inMarketAve = Math.round((+document.getElementById('inMarket' + (i - 3)).value
            + +document.getElementById('inMarket' + (i - 2)).value
            + +document.getElementById('inMarket' + (i - 1)).value) / 3);
        if (inMarketAve != 0) {
            document.getElementById('sourceHippDaysOnHand' + i).value =
                Math.round(+document.getElementById('sourceHippEndingInventory' + i).value / inMarketAve * 30);
        }

        // Antech Beginning Inventory
        document.getElementById('antechBeginningInventory' + i).value =
            +document.getElementById('antechEndingInventory' + (i - 1)).value;

        if (i >= 4) {
            // Shipments received at antech
            document.getElementById('antechShipmentsReceived' + i).value =
                (+document.getElementById('averageInMarketSales' + i).value * 2)
                - +document.getElementById('antechBeginningInventory' + i).value
                + +document.getElementById('inMarket' + i).value;
        }

        // TOTAL AVAILABLE FOR SALE PHILS
        document.getElementById('antechTotalAvailableForSalePhils' + i).value =
            +document.getElementById('antechBeginningInventory' + i).value
            + +document.getElementById('antechShipmentsReceived' + i).value;

        // ACTUAL/LBE SALES
        document.getElementById('antechActualSales' + i).value =
            +document.getElementById('inMarket' + i).value;

        // ENDING INVENTORY ANTECH (SUPPLY minus LBE)
        document.getElementById('antechEndingInventory' + i).value =
            +document.getElementById('antechTotalAvailableForSalePhils' + i).value
            - +document.getElementById('antechActualSales' + i).value;

        // Antech Days on Hand
        var daysOnHandAve = Math.round((+document.getElementById('inMarket' + (i - 3)).value
            + +document.getElementById('inMarket' + (i - 2)).value
            + +document.getElementById('inMarket' + (i - 1)).value) / 3);
        if (daysOnHandAve != 0) {
            document.getElementById('antechDaysOnHand' + i).value =
                Math.round(+document.getElementById('antechEndingInventory' + i).value / daysOnHandAve * 30);
        }

        // Beginning inventory trade
        document.getElementById('tradeBeginningInventory' + i).value =
            +document.getElementById('tradeTotalEndingInventory' + (i - 1)).value;

        // For Total Ending Inventory Trade
        document.getElementById('tradeTotalEndingInventory' + i).value =
            +document.getElementById('tradeBeginningInventory' + i).value
            + +document.getElementById('antechActualSales' + i).value
            - +document.getElementById('totalOffTake' + i).value;

        // For Days On Hand Trade
        if (+document.getElementById('totalOffTake' + i).value != 0) {
            document.getElementById('tradeDaysOnHand' + i).value =
                Math.round(+document.getElementById('tradeTotalEndingInventory' + i).value
                    / +document.getElementById('totalOffTake' + i).value
                    * +30);
        }
    }

    // For the color of the actual or predicted.
    /*$('#sourceProduction' + 0).change(function () {
        var bool = confirm("Is this actual or predicted? Click OK for actual, and cancel for predicted");
        $('#actual' + 0).attr('value', bool);
    })

    $('#sourceProduction' + 1).change(function () {
        var bool = confirm("Is this actual or predicted? Click OK for actual, and cancel for predicted");
        $('#actual' + 1).attr('value', bool);
    })

    $('#sourceProduction' + 2).change(function () {
        var bool = confirm("Is this actual or predicted? Click OK for actual, and cancel for predicted");
        $('#actual' + 2).attr('value', bool);
    })

    $('#sourceProduction' + 3).change(function () {
        var bool = confirm("Is this actual or predicted? Click OK for actual, and cancel for predicted");
        $('#actual' + 3).attr('value', bool);
    })

    $('#sourceProduction' + 4).change(function () {
        var bool = confirm("Is this actual or predicted? Click OK for actual, and cancel for predicted");
        $('#actual' + 4).attr('value', bool);
    })

    $('#sourceProduction' + 5).change(function () {
        var bool = confirm("Is this actual or predicted? Click OK for actual, and cancel for predicted");
        $('#actual' + 5).attr('value', bool);
    })

    $('#sourceProduction' + 6).change(function () {
        var bool = confirm("Is this actual or predicted? Click OK for actual, and cancel for predicted");
        $('#actual' + 6).attr('value', bool);
    })

    $('#sourceProduction' + 7).change(function () {
        var bool = confirm("Is this actual or predicted? Click OK for actual, and cancel for predicted");
        $('#actual' + 7).attr('value', bool);
    })

    $('#sourceProduction' + 8).change(function () {
        var bool = confirm("Is this actual or predicted? Click OK for actual, and cancel for predicted");
        $('#actual' + 8).attr('value', bool);
    })

    $('#sourceProduction' + 9).change(function () {
        var bool = confirm("Is this actual or predicted? Click OK for actual, and cancel for predicted");
        $('#actual' + 9).attr('value', bool);
    })

    $('#sourceProduction' + 10).change(function () {
        var bool = confirm("Is this actual or predicted? Click OK for actual, and cancel for predicted");
        $('#actual' + 10).attr('value', bool);
    })

    $('#sourceProduction' + 11).change(function () {
        var bool = confirm("Is this actual or predicted? Click OK for actual, and cancel for predicted");
        $('#actual' + 11).attr('value', bool);
    })*/
});