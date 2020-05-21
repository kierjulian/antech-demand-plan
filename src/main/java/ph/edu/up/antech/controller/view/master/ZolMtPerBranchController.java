package ph.edu.up.antech.controller.view.master;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.master.ZolMtPerBranch;
import ph.edu.up.antech.service.ZolMtPerBranchService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Controller()
@RequestMapping("/master/zol-mt")
public class ZolMtPerBranchController {

    private static final Logger LOGGER = Logger.getLogger(ZolMtPerBranchController.class);

    @Autowired
    private ZolMtPerBranchService zolMtPerBranchService;

    @GetMapping("")
    public String loadZolMtPerBranch(Model model, @RequestParam(required = false) String startDate,
                                     @RequestParam(required = false) String endDate) {
        LocalDate start = !StringUtils.isNullOrEmpty(startDate) ? LocalDate.parse(startDate) : LocalDate.now();
        LocalDate end = !StringUtils.isNullOrEmpty(endDate) ? LocalDate.parse(endDate) : LocalDate.now();
        List<ZolMtPerBranch> zolMtPerBranchList = zolMtPerBranchService.findZolMtPerBranchBetweenTwoDates(start, end);

        model.addAttribute("zolMtPerBranchList", zolMtPerBranchList);
        model.addAttribute("searchedStartDate", start);
        model.addAttribute("searchedEndDate", end);
        model.addAttribute("zolMtPerBranchCalculator", new ZolMtPerBranchCalculator(zolMtPerBranchList));
        return "master/zol-mt";
    }

    @GetMapping("/view/{id}")
    public String viewZolMtPerBranch(Model model, @PathVariable Integer id) {
        ZolMtPerBranch zolMtPerBranch = zolMtPerBranchService.findZolMtPerBranchById(id);
        model.addAttribute("zolMtPerBranch", zolMtPerBranch);
        return "master/zol-mt-view";
    }

    @GetMapping("/edit/{id}")
    public String editZolMtPerBranch(Model model, @PathVariable Integer id) {
        ZolMtPerBranch zolMtPerBranch = zolMtPerBranchService.findZolMtPerBranchById(id);
        model.addAttribute("zolMtPerBranch", zolMtPerBranch);
        return "master/zol-mt-edit";
    }

    @PostMapping("/update")
    public String updateZolMtPerBranch(RedirectAttributes redirectAttributes,
                                       @ModelAttribute(value = "zolMtPerBranch") ZolMtPerBranch zolMtPerBranch) {
        try {
            zolMtPerBranchService.updateZolMtPerBranch(zolMtPerBranch);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MT Per Branch was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while updating ZOL MT Per Branch.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-mt/view/" + zolMtPerBranch.getId();
    }

    @GetMapping("/add")
    public String addZolMdcPerBranch(Model model) {
        ZolMtPerBranch zolMtPerBranch = new ZolMtPerBranch();
        model.addAttribute("zolMtPerBranch", zolMtPerBranch);
        return "master/zol-mt-add";
    }

    @PostMapping("/create")
    public String createZolMtPerBranch(RedirectAttributes redirectAttributes,
                                       @ModelAttribute(value = "zolMtPerBranch") ZolMtPerBranch zolMtPerBranch) {
        try {
            zolMtPerBranch = zolMtPerBranchService.saveZolMtPerBranch(zolMtPerBranch);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MT Per Branch was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while saving ZOL MT Per Branch.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-mt/view/" + zolMtPerBranch.getId();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteZolMtPerBranch(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            zolMtPerBranchService.removeZolMtPerBranchById(id);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL MT Per Branch was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while deleting ZOL MT Per Branch.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-mt";
    }

}
