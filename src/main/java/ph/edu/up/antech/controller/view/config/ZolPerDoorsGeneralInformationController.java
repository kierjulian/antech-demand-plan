package ph.edu.up.antech.controller.view.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;
import ph.edu.up.antech.service.ZolPerDoorsGeneralInformationService;

import java.util.List;

@Controller
@RequestMapping("/master/zol-doors/config/gen-info")
public class ZolPerDoorsGeneralInformationController {

    private static final Logger LOGGER = Logger.getLogger(ZolPerDoorsGeneralInformationController.class);

    @Autowired
    private ZolPerDoorsGeneralInformationService zolPerDoorsGeneralInformationService;

    @GetMapping("")
    public String loadZolPerDoorsGeneralInformation(Model model) {
        List<ZolPerDoorsGeneralInformation> zolPerDoorsGeneralInformationList =
                zolPerDoorsGeneralInformationService.findAllZolPerDoorsGeneralInformation();
        model.addAttribute("zolPerDoorsGeneralInformationList", zolPerDoorsGeneralInformationList);
        return "zol-gen-info";
    }

    @GetMapping("/view/{id}")
    public String viewZolPerDoorsGeneralInformation(Model model, @PathVariable Integer id) {
        ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = zolPerDoorsGeneralInformationService
                .findZolPerDoorsGeneralInformationById(id);
        model.addAttribute("zolPerDoorsGeneralInformation", zolPerDoorsGeneralInformation);
        return "zol-gen-info-view";
    }

    @GetMapping("/edit/{id}")
    public String editZolPerDoorsGeneralInformation(Model model, @PathVariable Integer id) {
        ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = zolPerDoorsGeneralInformationService
                .findZolPerDoorsGeneralInformationById(id);
        model.addAttribute("zolPerDoorsGeneralInformation", zolPerDoorsGeneralInformation);
        return "zol-gen-info-edit";
    }

    @PostMapping("/update")
    public String updateZolPerDoorsGeneralInformation(RedirectAttributes redirectAttributes,
                                                      @ModelAttribute(value = "zolPerDoorsGeneralInformation")
                                                              ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation) {
        try {
            zolPerDoorsGeneralInformationService.updateZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL General Information was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/zol-doors/config/gen-info/view/" + zolPerDoorsGeneralInformation.getId();
    }

    @GetMapping("/add")
    public String addZolPerDoorsGeneralInformation(Model model) {
        ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = new ZolPerDoorsGeneralInformation();
        model.addAttribute("zolPerDoorsGeneralInformation", zolPerDoorsGeneralInformation);
        return "zol-gen-info-add";
    }

    @PostMapping("/create")
    public String createZolPerDoorsGeneralInformation(RedirectAttributes redirectAttributes,
                                                      @ModelAttribute(value = "zolPerDoorsGeneralInformation")
                                                              ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation) {
        try {
            zolPerDoorsGeneralInformation = zolPerDoorsGeneralInformationService.createZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL General Information was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/zol-doors/config/gen-info/view/" + zolPerDoorsGeneralInformation.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteZolPerDoorsGeneralInformation(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            zolPerDoorsGeneralInformationService.removeZolPerDoorsGeneralInformation(id);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL General Information was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/zol-doors/config/gen-info";
    }

}
