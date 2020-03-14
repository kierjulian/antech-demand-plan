package ph.edu.up.antech.controller.view.demand;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.DemandPlan;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.service.DemandPlanService;
import ph.edu.up.antech.service.ProductService;
import ph.edu.up.antech.util.DateUtils;
import ph.edu.up.antech.util.StringUtils;

import java.time.Year;
import java.time.YearMonth;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/demand/plan")
public class DemandPlanController {

    private static final Logger LOGGER = Logger.getLogger(DemandPlanController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private DemandPlanService demandPlanService;

    @GetMapping("")
    public String loadDemandPlanPage(Model model, RedirectAttributes redirectAttributes,
                                     @RequestParam(required = false) String startYear,
                                     @RequestParam(required = false) String product) {
        Year start = !StringUtils.isNullOrEmpty(startYear)
                ? Year.parse(startYear) : Year.now();

        List<YearMonth> yearMonthList = DateUtils.generateListOfYearMonthBetweenTwoYears(start, start);
        Product selectedProduct = !StringUtils.isNullOrEmpty(product) ?
                productService.findProductById(Integer.parseInt(product)) : getAllProducts().get(0);

        DemandPlan demandPlan = demandPlanService.findDemandPlanByProductIdAndYear(selectedProduct.getId(),
                start);
        if (demandPlan == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "The selected Demand Plan is not yet created.");
            return "redirect:/demand/plan/view/1";
        }

        model.addAttribute("productList", getAllProducts());
        model.addAttribute("start", start);
        model.addAttribute("yearMonthList", yearMonthList);
        model.addAttribute("selectedProduct", selectedProduct);
        model.addAttribute("demandPlan", demandPlan);

        return "redirect:/demand/plan/view/" + demandPlan.getId();
    }

    @GetMapping("/view/{id}")
    public String viewDemandPlan(Model model, @PathVariable Integer id) {
        DemandPlan demandPlan = demandPlanService.findDemandPlanById(id);
        List<YearMonth> yearMonthList = DateUtils.generateListOfYearMonthBetweenTwoYears(
                demandPlan.getYear(), demandPlan.getYear());

        model.addAttribute("productList", getAllProducts());
        model.addAttribute("start", demandPlan.getYear());
        model.addAttribute("yearMonthList", yearMonthList);
        model.addAttribute("selectedProduct", demandPlan.getProduct());
        model.addAttribute("demandPlan", demandPlan);

        return "demand/demand-plan";
    }

    @GetMapping("/edit/{id}")
    public String editDemandPlan(Model model, @PathVariable Integer id) {
        DemandPlan demandPlan = demandPlanService.findDemandPlanById(id);
        List<YearMonth> yearMonthList = DateUtils.generateListOfYearMonthBetweenTwoYears(demandPlan.getYear(), demandPlan.getYear());

        model.addAttribute("demandPlan", demandPlan);
        model.addAttribute("yearMonthList", yearMonthList);
        return "demand/demand-plan-edit";
    }

    @PostMapping("/update")
    public String updateDemandPlan(RedirectAttributes redirectAttributes,
                                   @ModelAttribute(value = "demandPlan") DemandPlan demandPlan) {
        try {
            demandPlanService.updateDemandPlan(demandPlan);
            redirectAttributes.addFlashAttribute("successMessage", "Demand Plan was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/demand/plan/view/" + demandPlan.getId();
    }

    @GetMapping("/add")
    public String addDemandPlan(Model model) {
        DemandPlan demandPlan = new DemandPlan();
        model.addAttribute("demandPlan", demandPlan);
        model.addAttribute("productList", getAllProducts());
        return "demand/demand-plan-add";
    }

    @PostMapping("/create")
    public String createDemandPlan(RedirectAttributes redirectAttributes,
                                   @ModelAttribute(value = "demandPlan") DemandPlan demandPlan) {
        try {
            DemandPlan savedDemandPlan = demandPlanService.findDemandPlanByProductIdAndYear(demandPlan.getProduct().getId(),
                    demandPlan.getYear());
            if (savedDemandPlan != null) {
                throw new RuntimeException("Demand plan for chosen product and year already exists.");
            }

            Product product = productService.findProductById(demandPlan.getProduct().getId());
            demandPlan.setProduct(product);
            demandPlan.generateDemandPlanDetails();
            demandPlanService.saveDemandPlan(demandPlan);

            redirectAttributes.addFlashAttribute("successMessage", "Demand Plan was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage(), e);
            return "redirect:/demand/plan/view/1";
        }

        return "redirect:/demand/plan/view/" + demandPlan.getId();
    }

    private List<Product> getAllProducts() {
        List<Product> productList = productService.findAllProducts();
        Collections.sort(productList);
        return productList;
    }

}
