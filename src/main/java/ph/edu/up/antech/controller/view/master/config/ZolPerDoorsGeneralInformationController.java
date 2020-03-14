package ph.edu.up.antech.controller.view.master.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;
import ph.edu.up.antech.service.ZolPerDoorsGeneralInformationService;
import ph.edu.up.antech.util.StringUtils;

@Controller
@RequestMapping("/master/zol-doors/config/gen-info")
public class ZolPerDoorsGeneralInformationController {

    private static final Logger LOGGER = Logger.getLogger(ZolPerDoorsGeneralInformationController.class);

    @Autowired
    private ZolPerDoorsGeneralInformationService zolPerDoorsGeneralInformationService;

    @GetMapping("")
    public String loadZolPerDoorsGeneralInformation(Model model, @PageableDefault Pageable pageable,
                                                    @RequestParam(required = false) String filter) {
        Page<ZolPerDoorsGeneralInformation> page = StringUtils.isNullOrEmpty(filter)
                ? zolPerDoorsGeneralInformationService.findAll(pageable)
                : zolPerDoorsGeneralInformationService.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);

        return "master/config/zol-gen-info";
    }

    @GetMapping("/view/{id}")
    public String viewZolPerDoorsGeneralInformation(Model model, @PathVariable Integer id) {
        ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = zolPerDoorsGeneralInformationService
                .findZolPerDoorsGeneralInformationById(id);
        model.addAttribute("zolPerDoorsGeneralInformation", zolPerDoorsGeneralInformation);
        return "master/config/zol-gen-info-view";
    }

    @GetMapping("/edit/{id}")
    public String editZolPerDoorsGeneralInformation(Model model, @PathVariable Integer id) {
        ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = zolPerDoorsGeneralInformationService
                .findZolPerDoorsGeneralInformationById(id);
        model.addAttribute("zolPerDoorsGeneralInformation", zolPerDoorsGeneralInformation);
        return "master/config/zol-gen-info-edit";
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
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-doors/config/gen-info/view/" + zolPerDoorsGeneralInformation.getId();
    }

    @GetMapping("/add")
    public String addZolPerDoorsGeneralInformation(Model model) {
        ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = new ZolPerDoorsGeneralInformation();
        model.addAttribute("zolPerDoorsGeneralInformation", zolPerDoorsGeneralInformation);
        return "master/config/zol-gen-info-add";
    }

    @PostMapping("/create")
    public String createZolPerDoorsGeneralInformation(RedirectAttributes redirectAttributes,
                                                      @ModelAttribute(value = "zolPerDoorsGeneralInformation")
                                                              ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation) {
        try {
            zolPerDoorsGeneralInformation = zolPerDoorsGeneralInformationService.saveZolPerDoorsGeneralInformation(zolPerDoorsGeneralInformation);
            redirectAttributes.addFlashAttribute("successMessage", "ZOL General Information was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage(), e);
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
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/zol-doors/config/gen-info";
    }

}
