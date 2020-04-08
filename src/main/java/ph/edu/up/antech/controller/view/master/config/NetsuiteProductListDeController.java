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
import ph.edu.up.antech.domain.master.config.NetsuiteProductListDe;
import ph.edu.up.antech.service.NetsuiteProductListDeService;
import ph.edu.up.antech.util.StringUtils;

@Controller
@RequestMapping("/master/netsuite/config/product-list/de")
public class NetsuiteProductListDeController {

    private static final Logger LOGGER = Logger.getLogger(NetsuiteProductListDeController.class);

    @Autowired
    private NetsuiteProductListDeService netsuiteProductListDeService;

    @GetMapping("")
    public String loadNetsuiteProductListDePage(Model model, @PageableDefault Pageable pageable,
                                                @RequestParam(required = false) String filter) {
        Page<NetsuiteProductListDe> page = StringUtils.isNullOrEmpty(filter)
                ? netsuiteProductListDeService.findAll(pageable)
                : netsuiteProductListDeService.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
        return "master/config/netsuite-prod-list-de";
    }

    @GetMapping("/view/{id}")
    public String viewNetsuiteProductListDe(Model model, @PathVariable Integer id) {
        NetsuiteProductListDe netsuiteProductListDe = netsuiteProductListDeService
                .findNetsuiteProductListDeById(id);
        model.addAttribute("netsuiteProductListDe", netsuiteProductListDe);
        return "master/config/netsuite-prod-list-de-view";
    }

    @GetMapping("/edit/{id}")
    public String editNetsuiteProductListDe(Model model, @PathVariable Integer id) {
        NetsuiteProductListDe netsuiteProductListDe = netsuiteProductListDeService
                .findNetsuiteProductListDeById(id);
        model.addAttribute("netsuiteProductListDe", netsuiteProductListDe);
        return "master/config/netsuite-prod-list-de-edit";
    }

    @PostMapping("/update")
    public String updateNetsuiteProductListDe(RedirectAttributes redirectAttributes,
                                              @ModelAttribute(value = "netsuiteProductListDe")
                                                      NetsuiteProductListDe netsuiteProductListDe) {
        try {
            netsuiteProductListDeService.updateNetsuiteProductListDe(netsuiteProductListDe);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Product List DE was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while updating Netsuite Product List DE.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/netsuite/config/product-list/de/view/" + netsuiteProductListDe.getId();
    }

    @GetMapping("/add")
    public String addNetsuiteProductListDe(Model model) {
        NetsuiteProductListDe netsuiteProductListDe = new NetsuiteProductListDe();
        model.addAttribute("netsuiteProductListDe", netsuiteProductListDe);
        return "master/config/netsuite-prod-list-de-add";
    }

    @PostMapping("/create")
    public String createNetsuiteProductListDe(RedirectAttributes redirectAttributes,
                                              @ModelAttribute(value = "netsuiteProductListDe")
                                                      NetsuiteProductListDe netsuiteProductListDe) {
        try {
            netsuiteProductListDe = netsuiteProductListDeService.saveNetsuiteProductListDe(netsuiteProductListDe);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Product List DE was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while saving Netsuite Product List DE.");
            LOGGER.error(e.getMessage(), e);
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
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while deleting Netsuite Product List DE.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/netsuite/config/product-list/de";
    }

}
