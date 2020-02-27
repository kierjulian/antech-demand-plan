package ph.edu.up.antech.controller.view.master;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.service.ZolPerDoorsService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/master/zol-doors")
public class ZolPerDoorsController {

    private static final Logger LOGGER = Logger.getLogger(ZolPerDoorsController.class);

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @GetMapping("")
    public String loadZolPerDoorsMasterFile(Model model, @RequestParam(required = false) String startDate,
                                            @RequestParam(required = false) String endDate) {
        LocalDate start = !StringUtils.isNullOrEmpty(startDate) ? LocalDate.parse(startDate) : LocalDate.now();
        LocalDate end = !StringUtils.isNullOrEmpty(endDate) ? LocalDate.parse(endDate) : LocalDate.now();

        List<ZolPerDoors> zolPerDoorsList = zolPerDoorsService.findZolPerDoorsBetweenTwoDates(start, end);
        model.addAttribute("zolPerDoorsList", zolPerDoorsList);
        model.addAttribute("searchedStartDate", start);
        model.addAttribute("searchedEndDate", end);
        return "zol-per-doors";
    }

    @GetMapping("/view/{id}")
    public String viewZolPerDoors(Model model, @PathVariable Integer id) {
        ZolPerDoors zolPerDoors = zolPerDoorsService.findZolPerDoorsById(id);
        model.addAttribute("zolPerDoors", zolPerDoors);
        return "zol-per-doors-view";
    }

    @GetMapping("/edit/{id}")
    public String editZolPerDoors(Model model, @PathVariable Integer id) {
        ZolPerDoors zolPerDoors = zolPerDoorsService.findZolPerDoorsById(id);
        model.addAttribute("zolPerDoors", zolPerDoors);
        return "zol-per-doors-edit";
    }

    @PostMapping("/update")
    public String updateZolPerDoors(RedirectAttributes redirectAttributes,
                                    @ModelAttribute(value = "zolPerDoors") ZolPerDoors zolPerDoors) {
        try {
            zolPerDoorsService.updateZolPerDoors(zolPerDoors);
            redirectAttributes.addFlashAttribute("successMessage", "Zol Per Doors was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/zol-doors/view/" + zolPerDoors.getId();
    }

    @GetMapping("/add")
    public String addZolPerDoors(Model model) {
        ZolPerDoors zolPerDoors = new ZolPerDoors();
        model.addAttribute("zolPerDoors", zolPerDoors);
        return "zol-per-doors-add";
    }

    @PostMapping("/create")
    public String createZolPerDoors(RedirectAttributes redirectAttributes,
                                    @ModelAttribute(value = "zolPerDoors") ZolPerDoors zolPerDoors) {
        try {
            zolPerDoors = zolPerDoorsService.createZolPerDoors(zolPerDoors);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL Per Doors was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/zol-doors/view/" + zolPerDoors.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteZolPerDoors(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            zolPerDoorsService.removeZolPerDoors(id);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL Per Doors was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/zol-doors";
    }

}
