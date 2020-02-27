package ph.edu.up.antech.controller.view.demand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.service.ProductService;
import ph.edu.up.antech.util.ChannelUtils;
import ph.edu.up.antech.util.DateUtils;
import ph.edu.up.antech.util.StringUtils;

import java.time.Year;
import java.time.YearMonth;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/demand/master")
public class HippToMarketSalesAmountController {

    @Autowired
    private ProductService productService;

    @GetMapping("/hipp/to-market/amount")
    public String loadHippInMarketSalesUnitsPage(Model model,
                                                 @RequestParam(required = false) String startDate,
                                                 @RequestParam(required = false) String endDate) {
        YearMonth yearMonthStart = !StringUtils.isNullOrEmpty(startDate)
                ? YearMonth.parse(startDate) : YearMonth.of(Year.now().getValue(), 1);
        YearMonth yearMonthEnd = !StringUtils.isNullOrEmpty(endDate)
                ? YearMonth.parse(endDate) : YearMonth.of(Year.now().getValue(), 12);

        List<YearMonth> yearMonthList = DateUtils.generateListOfYearMonthBetweenTwoYearMonths(yearMonthStart, yearMonthEnd);
        List<Product> productList = productService.findAllProducts();
        Collections.sort(productList);

        model.addAttribute("yearMonthList", yearMonthList);
        model.addAttribute("products", productList);
        model.addAttribute("channels", ChannelUtils.getChannels());
        return "hipp-to-market-sales-amount";
    }

}
