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
import ph.edu.up.antech.domain.master.config.NetsuiteProductListSource;
import ph.edu.up.antech.service.NetsuiteProductListSourceService;
import ph.edu.up.antech.util.StringUtils;

@Controller
@RequestMapping("/master/netsuite/config/product-list/source")
public class NetsuiteProductListSourceController {

    private static final Logger LOGGER = Logger.getLogger(NetsuiteProductListSourceController.class);

    @Autowired
    private NetsuiteProductListSourceService netsuiteProductListSourceService;

    @GetMapping("")
    public String loadNetsuiteProductListSourcePage(Model model, @PageableDefault Pageable pageable,
                                                    @RequestParam(required = false) String filter) {
        Page<NetsuiteProductListSource> page = StringUtils.isNullOrEmpty(filter)
                ? netsuiteProductListSourceService.findAll(pageable)
                : netsuiteProductListSourceService.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
        return "master/config/netsuite-prod-list-source";
    }

    @GetMapping("/view/{id}")
    public String viewNetsuiteProductListSource(Model model, @PathVariable Integer id) {
        NetsuiteProductListSource netsuiteProductListSource = netsuiteProductListSourceService
                .findNetsuiteProductListSourceById(id);
        model.addAttribute("netsuiteProductListSource", netsuiteProductListSource);
        return "master/config/netsuite-prod-list-source-view";
    }

    @GetMapping("/edit/{id}")
    public String editNetsuiteProductListSource(Model model, @PathVariable Integer id) {
        NetsuiteProductListSource netsuiteProductListSource = netsuiteProductListSourceService
                .findNetsuiteProductListSourceById(id);
        model.addAttribute("netsuiteProductListSource", netsuiteProductListSource);
        return "master/config/netsuite-prod-list-source-edit";
    }

    @PostMapping("/update")
    public String updateNetsuiteProductListSource(RedirectAttributes redirectAttributes,
                                                  @ModelAttribute(value = "netsuiteProductListSource")
                                                          NetsuiteProductListSource netsuiteProductListSource) {
        try {
            netsuiteProductListSourceService.updateNetsuiteProductListSource(netsuiteProductListSource);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Product List Source was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while updating Netsuite Product List Source.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/netsuite/config/product-list/source/view/" + netsuiteProductListSource.getId();
    }

    @GetMapping("/add")
    public String addNetsuiteProductListSource(Model model) {
        NetsuiteProductListSource netsuiteProductListSource = new NetsuiteProductListSource();
        model.addAttribute("netsuiteProductListSource", netsuiteProductListSource);
        return "master/config/netsuite-prod-list-source-add";
    }

    @PostMapping("/create")
    public String createNetsuiteProductListSource(RedirectAttributes redirectAttributes,
                                                  @ModelAttribute(value = "netsuiteProductListSource")
                                                          NetsuiteProductListSource netsuiteProductListSource) {
        try {
            netsuiteProductListSource = netsuiteProductListSourceService.saveNetsuiteProductListSource(netsuiteProductListSource);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Product List Source was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while saving Netsuite Product List Source.");
            LOGGER.error(e.getMessage(), e);
            return "redirect:/master/netsuite/config/product-list/source";
        }

        return "redirect:/master/netsuite/config/product-list/source/view/" + netsuiteProductListSource.getId();
    }

    @DeleteMapping("/delete/{id}")
    public String removeNetsuiteProductListSource(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            netsuiteProductListSourceService.removeNetsuiteProductListSource(id);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Product List Source was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while deleting Netsuite Product List Source.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/netsuite/config/product-list/source";
    }

}
