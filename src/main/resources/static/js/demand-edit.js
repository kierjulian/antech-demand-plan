$(document).ready(function () {
    var form = document.querySelector('form');
    form.addEventListener('change', function () {
        for (var i = 0; i < 12; i++) {
            if (i >= 3) {
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
            }

            if (i >= 1) {
                // Total Goods Available
                document.getElementById('sourceTotalGoodsAvailable' + i).value =
                    +document.getElementById('sourceProduction' + i).value
                    + +document.getElementById('sourceHippEndingInventory' + (i - 1)).value;
            }

            // For hipp ending inventory
            document.getElementById('sourceHippEndingInventory' + i).value =
                +document.getElementById('sourceTotalGoodsAvailable' + i).value
                - +document.getElementById('sourceLoading' + i).value;

            if (i >= 3) {
                // Hipp Days On Hand
                var average = Math.round((+document.getElementById('inMarket' + (i - 3)).value
                    + +document.getElementById('inMarket' + (i - 2)).value
                    + +document.getElementById('inMarket' + (i - 1)).value) / 3);
                if (average != 0) {
                    document.getElementById('sourceHippDaysOnHand' + i).value =
                        Math.round(+document.getElementById('sourceHippEndingInventory' + i).value / average * 30);
                }
            }

            if (i >= 1) {
                // Antech Beginning Inventory
                document.getElementById('antechBeginningInventory' + i).value =
                    +document.getElementById('antechEndingInventory' + (i - 1)).value;
            }

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

            if (i >= 3) {
                // Antech Days on Hand
                var average = Math.round((+document.getElementById('inMarket' + (i - 3)).value
                    + +document.getElementById('inMarket' + (i - 2)).value
                    + +document.getElementById('inMarket' + (i - 1)).value) / 3);
                if (average != 0) {
                    document.getElementById('antechDaysOnHand' + i).value =
                        Math.round(+document.getElementById('antechEndingInventory' + i).value / average * 30);
                }
            }

            if (i >= 1) {
                // Beginning inventory trade
                document.getElementById('tradeBeginningInventory' + i).value =
                    +document.getElementById('tradeTotalEndingInventory' + (i - 1)).value;
            }

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
    })
});