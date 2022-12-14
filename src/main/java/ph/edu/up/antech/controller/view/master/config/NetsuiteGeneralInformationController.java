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
import ph.edu.up.antech.domain.master.config.NetsuiteGeneralInformation;
import ph.edu.up.antech.service.NetsuiteGeneralInformationService;
import ph.edu.up.antech.util.StringUtils;

@Controller
@RequestMapping("/master/netsuite/config/general-info")
public class NetsuiteGeneralInformationController {

    private static final Logger LOGGER = Logger.getLogger(NetsuiteGeneralInformationController.class);

    @Autowired
    private NetsuiteGeneralInformationService netsuiteGeneralInformationService;

    @GetMapping("")
    public String loadNetsuiteGeneralInformationPage(Model model, @PageableDefault Pageable pageable,
                                                     @RequestParam(required = false) String filter) {
        Page<NetsuiteGeneralInformation> page = StringUtils.isNullOrEmpty(filter)
                ? netsuiteGeneralInformationService.findAll(pageable)
                : netsuiteGeneralInformationService.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
        return "master/config/netsuite-gen-info";
    }

    @GetMapping("/view/{id}")
    public String viewNetsuiteGeneralInformation(Model model, @PathVariable Integer id) {
        NetsuiteGeneralInformation netsuiteGeneralInformation = netsuiteGeneralInformationService
                .findNetsuiteGeneralInformationById(id);
        model.addAttribute("netsuiteGeneralInformation", netsuiteGeneralInformation);
        return "master/config/netsuite-gen-info-view";
    }

    @GetMapping("/edit/{id}")
    public String editNetsuiteGeneralInformation(Model model, @PathVariable Integer id) {
        NetsuiteGeneralInformation netsuiteGeneralInformation = netsuiteGeneralInformationService
                .findNetsuiteGeneralInformationById(id);
        model.addAttribute("netsuiteGeneralInformation", netsuiteGeneralInformation);
        return "master/config/netsuite-gen-info-edit";
    }

    @PostMapping("/update")
    public String updateNetsuiteGeneralInformation(RedirectAttributes redirectAttributes,
                                                   @ModelAttribute(value = "netsuiteGeneralInformation")
                                                           NetsuiteGeneralInformation netsuiteGeneralInformation) {
        try {
            netsuiteGeneralInformationService.updateNetsuiteGeneralInformation(netsuiteGeneralInformation);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite General Information was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while updating Netsuite General Information.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/netsuite/config/general-info/view/" + netsuiteGeneralInformation.getId();
    }

    @GetMapping("/add")
    public String addNetsuiteGeneralInformation(Model model) {
        NetsuiteGeneralInformation netsuiteGeneralInformation = new NetsuiteGeneralInformation();
        model.addAttribute("netsuiteGeneralInformation", netsuiteGeneralInformation);
        return "master/config/netsuite-gen-info-add";
    }

    @PostMapping("/create")
    public String createNetsuiteGeneralInformation(RedirectAttributes redirectAttributes,
                                                   @ModelAttribute(value = "netsuiteGeneralInformation")
                                                           NetsuiteGeneralInformation netsuiteGeneralInformation) {
        try {
            netsuiteGeneralInformation = netsuiteGeneralInformationService.saveNetsuiteGeneralInformation(netsuiteGeneralInformation);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite General Information was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while saving Netsuite General Information.");
            LOGGER.error(e.getMessage(), e);
            return "redirect:/master/netsuite/config/general-info";
        }

        return "redirect:/master/netsuite/config/general-info/view/" + netsuiteGeneralInformation.getId();
    }

    @DeleteMapping("/delete/{id}")
    public String removeNetsuiteGeneralInformation(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            netsuiteGeneralInformationService.removeNetsuiteGeneralInformation(id);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite General Information was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while deleting Netsuite General Information.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/netsuite/config/general-info";
    }

}
