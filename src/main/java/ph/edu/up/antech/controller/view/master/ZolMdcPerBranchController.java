package ph.edu.up.antech.controller.view.master;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.ZolMdcPerBranch;
import ph.edu.up.antech.service.ZolMdcPerBranchService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/master/zol-mdc")
public class ZolMdcPerBranchController {

    private static final Logger LOGGER = Logger.getLogger(ZolMdcPerBranchController.class);

    @Autowired
    private ZolMdcPerBranchService zolMdcPerBranchService;

    @GetMapping("")
    public String loadZolMdcPerBranch(Model model, @RequestParam(required = false) String startDate,
                                      @RequestParam(required = false) String endDate) {
        LocalDate start = !StringUtils.isNullOrEmpty(startDate) ? LocalDate.parse(startDate) : LocalDate.now();
        LocalDate end = !StringUtils.isNullOrEmpty(endDate) ? LocalDate.parse(endDate) : LocalDate.now();
        List<ZolMdcPerBranch> zolMdcPerBranchList = zolMdcPerBranchService.findZolMdcPerBranchBetweenTwoDates(start, end);

        model.addAttribute("zolMdcPerBranchList", zolMdcPerBranchList);
        model.addAttribute("searchedStartDate", start);
        model.addAttribute("searchedEndDate", end);
        return "master/zol-mdc";
    }

    @GetMapping("/view/{id}")
    public String viewZolMdcPerBranch(Model model, @PathVariable Integer id) {
        ZolMdcPerBranch zolMdcPerBranch = zolMdcPerBranchService.findZolMdcPerBranch(id);
        model.addAttribute("zolMdcPerBranch", zolMdcPerBranch);
        return "master/zol-mdc-view";
    }

    @GetMapping("/edit/{id}")
    public String editZolMdcPerBranch(Model model, @PathVariable Integer id) {
        ZolMdcPerBranch zolMdcPerBranch = zolMdcPerBranchService.findZolMdcPerBranch(id);
        model.addAttribute("zolMdcPerBranch", zolMdcPerBranch);
        return "master/zol-mdc-edit";
    }

    @PostMapping("/update")
    public String updateZolMdcPerBranch(RedirectAttributes redirectAttributes,
                                        @ModelAttribute(value = "zolMdcPerBranch") ZolMdcPerBranch zolMdcPerBranch) {
        try {
            zolMdcPerBranchService.updateZolMdcPerBranch(zolMdcPerBranch);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MDC Per Branch was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while updating ZOL MDC Per Branch.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-mdc/view/" + zolMdcPerBranch.getId();
    }

    @GetMapping("/add")
    public String addZolMdcPerBranch(Model model) {
        ZolMdcPerBranch zolMdcPerBranch = new ZolMdcPerBranch();
        model.addAttribute("zolMdcPerBranch", zolMdcPerBranch);
        return "master/zol-mdc-add";
    }

    @PostMapping("/create")
    public String createZolMdcPerBranch(RedirectAttributes redirectAttributes,
                                        @ModelAttribute(value = "zolMdcPerBranch") ZolMdcPerBranch zolMdcPerBranch) {
        try {
            zolMdcPerBranch = zolMdcPerBranchService.saveZolMdcPerBranch(zolMdcPerBranch);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MDC Per Branch was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while saving ZOL MDC Per Branch.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-mdc/view/" + zolMdcPerBranch.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteZolMdcPerBranch(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            zolMdcPerBranchService.removeZolMdcPerBranchById(id);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MDC Per Branch was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while deleting ZOL MDC Per Branch.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-mdc";
    }

}
