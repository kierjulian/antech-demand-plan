package ph.edu.up.antech.controller.view.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteOtherInformation;
import ph.edu.up.antech.service.NetsuiteOtherInformationService;

import java.util.List;

@Controller
@RequestMapping("/master/netsuite/config/other-info")
public class NetsuiteOtherInformationController {

    private static final Logger LOGGER = Logger.getLogger(NetsuiteOtherInformationController.class);

    @Autowired
    private NetsuiteOtherInformationService netsuiteOtherInformationService;

    @GetMapping("")
    public String loadNetsuiteOtherInformationPage(Model model) {
        List<NetsuiteOtherInformation> netsuiteOtherInformationList =
                netsuiteOtherInformationService.findAllNetsuiteOtherInformation();
        model.addAttribute("netsuiteOtherInformationList", netsuiteOtherInformationList);
        return "netsuite-other-info.html";
    }

    @GetMapping("/view/{id}")
    public String viewNetsuiteOtherInformation(Model model, @PathVariable Integer id) {
        NetsuiteOtherInformation netsuiteOtherInformation = netsuiteOtherInformationService
                .findNetsuiteOtherInformationById(id);
        model.addAttribute("netsuiteOtherInformation", netsuiteOtherInformation);
        return "netsuite-other-info-view";
    }

    @GetMapping("/edit/{id}")
    public String editNetsuiteOtherInformation(Model model, @PathVariable Integer id) {
        NetsuiteOtherInformation netsuiteOtherInformation = netsuiteOtherInformationService
                .findNetsuiteOtherInformationById(id);
        model.addAttribute("netsuiteOtherInformation", netsuiteOtherInformation);
        return "netsuite-other-info-edit";
    }

    @PostMapping("/update")
    public String updateNetsuiteOtherInformation(RedirectAttributes redirectAttributes,
                                                 @ModelAttribute(value = "netsuiteOtherInformation")
                                                         NetsuiteOtherInformation netsuiteOtherInformation) {
        try {
            netsuiteOtherInformationService.updateNetsuiteOtherInformation(netsuiteOtherInformation);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Other Information was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/netsuite/config/other-info/view/" + netsuiteOtherInformation.getId();
    }

    @GetMapping("/add")
    public String addNetsuiteOtherInformation(Model model) {
        NetsuiteOtherInformation netsuiteOtherInformation = new NetsuiteOtherInformation();
        model.addAttribute("netsuiteOtherInformation", netsuiteOtherInformation);
        return "netsuite-other-info-add";
    }

    @PostMapping("/create")
    public String createNetsuiteOtherInformation(RedirectAttributes redirectAttributes,
                                                 @ModelAttribute(value = "netsuiteOtherInformation")
                                                         NetsuiteOtherInformation netsuiteOtherInformation) {
        try {
            netsuiteOtherInformation = netsuiteOtherInformationService.saveNetsuiteOtherInformation(netsuiteOtherInformation);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Other Information was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/netsuite/config/other-info/view/" + netsuiteOtherInformation.getId();
    }

    @GetMapping("/delete/{id}")
    public String removeNetsuiteOtherInformation(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            netsuiteOtherInformationService.removeNetsuiteOtherInformation(id);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Other Information was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/netsuite/config/other-info";
    }

}
