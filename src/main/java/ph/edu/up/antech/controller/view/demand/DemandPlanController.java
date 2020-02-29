package ph.edu.up.antech.controller.view.demand;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.DemandPlan;
import ph.edu.up.antech.util.DateUtils;
import ph.edu.up.antech.util.StringUtils;

import java.time.Year;
import java.time.YearMonth;
import java.util.List;

@Controller
@RequestMapping("/demand/plan")
public class DemandPlanController {

    private static final Logger LOGGER = Logger.getLogger(DemandPlanController.class);

    @GetMapping("")
    public String loadDemandPlanPage(Model model,
                                     @RequestParam(required = false) String startYear,
                                     @RequestParam(required = false) String endYear) {
        Year start = !StringUtils.isNullOrEmpty(startYear)
                ? Year.parse(startYear) : Year.now();
        Year end = !StringUtils.isNullOrEmpty(endYear)
                ? Year.parse(endYear) : Year.now();

        List<YearMonth> yearMonthList = DateUtils.generateListOfYearMonthBetweenTwoYears(start, end);
        model.addAttribute("yearMonthList", yearMonthList);
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        return "demand-plan";
    }

    @GetMapping("/view/{id}")
    public String viewDemandPlan(Model model, @PathVariable Integer id) {
        return "demand-plan-view";
    }

    @GetMapping("/edit/{id}")
    public String editDemandPlan(Model model, @PathVariable Integer id) {
        return "demand-plan-edit";
    }

    @PostMapping("/update")
    public String updateDemandPlan(RedirectAttributes redirectAttributes,
                                   @ModelAttribute(value = "demandPlan") DemandPlan demandPlan) {
        try {
            redirectAttributes.addFlashAttribute("successMessage", "Demand Plan was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/demand/plan/view/";
    }

    @GetMapping("/add")
    public String addDemandPlan(Model model) {
        return "demand-plan-add";
    }

    @PostMapping("/create")
    public String createDemandPlan(RedirectAttributes redirectAttributes,
                                   @ModelAttribute(value = "demandPlan") DemandPlan demandPlan) {
        try {
            redirectAttributes.addFlashAttribute("successMessage", "Demand Plan was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/demand/plan/view/";
    }

}
