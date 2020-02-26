package ph.edu.up.antech.controller.view.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListDe;
import ph.edu.up.antech.service.NetsuiteProductListDeService;

import java.util.List;

@Controller
@RequestMapping("/master/netsuite/config/product-list/de")
public class NetsuiteProductListDeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NetsuiteProductListDeController.class);

    @Autowired
    private NetsuiteProductListDeService netsuiteProductListDeService;

    @GetMapping("")
    public String loadNetsuiteProductListDePage(Model model) {
        List<NetsuiteProductListDe> netsuiteProductListDeList =
                netsuiteProductListDeService.findAllNetsuiteProductListDe();
        model.addAttribute("netsuiteProductListDeList", netsuiteProductListDeList);
        return "netsuite-prod-list-de";
    }

    @GetMapping("/view/{id}")
    public String viewNetsuiteProductListDe(Model model, @PathVariable Integer id) {
        NetsuiteProductListDe netsuiteProductListDe = netsuiteProductListDeService
                .findNetsuiteProductListDeById(id);
        model.addAttribute("netsuiteProductListDe", netsuiteProductListDe);
        return "netsuite-prod-list-de-view";
    }

    @GetMapping("/edit/{id}")
    public String editNetsuiteProductListDe(Model model, @PathVariable Integer id) {
        NetsuiteProductListDe netsuiteProductListDe = netsuiteProductListDeService
                .findNetsuiteProductListDeById(id);
        model.addAttribute("netsuiteProductListDe", netsuiteProductListDe);
        return "netsuite-prod-list-de-edit";
    }

    @PostMapping("/update")
    public String updateNetsuiteProductListDe(RedirectAttributes redirectAttributes,
                                              @ModelAttribute(value = "netsuiteProductListDe")
                                                      NetsuiteProductListDe netsuiteProductListDe) {
        try {
            netsuiteProductListDeService.updateNetsuiteProductListDe(netsuiteProductListDe);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Product List DE was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/netsuite/config/product-list/de/view/" + netsuiteProductListDe.getId();
    }

    @GetMapping("/add")
    public String addNetsuiteProductListDe(Model model) {
        NetsuiteProductListDe netsuiteProductListDe = new NetsuiteProductListDe();
        model.addAttribute("netsuiteProductListDe", netsuiteProductListDe);
        return "netsuite-prod-list-de-add";
    }

    @PostMapping("/create")
    public String createNetsuiteProductListDe(RedirectAttributes redirectAttributes,
                                              @ModelAttribute(value = "netsuiteProductListDe")
                                                      NetsuiteProductListDe netsuiteProductListDe) {
        try {
            netsuiteProductListDe = netsuiteProductListDeService.saveNetsuiteProductListDe(netsuiteProductListDe);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Product List DE was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/netsuite/config/product-list/de/view/" + netsuiteProductListDe.getId();
    }

    @GetMapping("/delete/{id}")
    public String removeNetsuiteProductListDe(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            netsuiteProductListDeService.removeNetsuiteProductListDe(id);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Product List DE was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/netsuite/config/product-list/de";
    }

}
