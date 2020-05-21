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
import ph.edu.up.antech.domain.master.config.NetsuiteTransfersCat;
import ph.edu.up.antech.service.NetsuiteTransfersCatService;
import ph.edu.up.antech.util.StringUtils;

@Controller
@RequestMapping("/master/netsuite/config/transfers-cat")
public class NetsuiteTransfersCatController {

    private static final Logger LOGGER = Logger.getLogger(NetsuiteTransfersCatController.class);

    @Autowired
    private NetsuiteTransfersCatService netsuiteTransfersCatService;

    @GetMapping("")
    public String loadNetsuiteTransfersCat(Model model, @PageableDefault Pageable pageable,
                                          @RequestParam(required = false) String filter) {
        Page<NetsuiteTransfersCat> page = StringUtils.isNullOrEmpty(filter)
                ? netsuiteTransfersCatService.findAll(pageable)
                : netsuiteTransfersCatService.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
        return "master/config/netsuite-transfers-cat";
    }

    @GetMapping("/view/{id}")
    public String viewNetsuiteTransfersCat(Model model, @PathVariable Integer id) {
        NetsuiteTransfersCat netsuiteTransfersCat = netsuiteTransfersCatService
                .findNetsuiteTransfersCatById(id);
        model.addAttribute("netsuiteTransfersCat", netsuiteTransfersCat);
        return "master/config/netsuite-transfers-cat-view";
    }

    @GetMapping("/edit/{id}")
    public String editNetsuiteTransfersCat(Model model, @PathVariable Integer id) {
        NetsuiteTransfersCat netsuiteTransfersCat = netsuiteTransfersCatService
                .findNetsuiteTransfersCatById(id);
        model.addAttribute("netsuiteTransfersCat", netsuiteTransfersCat);
        return "master/config/netsuite-transfers-cat-edit";
    }

    @PostMapping("/update")
    public String updateNetsuiteTransfersCat(RedirectAttributes redirectAttributes,
                                            @ModelAttribute(value = "netsuiteTransfersCat")
                                                    NetsuiteTransfersCat netsuiteTransfersCat) {
        try {
            netsuiteTransfersCatService.updateNetsuiteTransfersCat(netsuiteTransfersCat);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Transfers Cat was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while updating Netsuite Transfers Cat.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/netsuite/config/transfers-cat/view/" + netsuiteTransfersCat.getId();
    }

    @GetMapping("/add")
    public String addNetsuiteTransfersCat(Model model) {
        NetsuiteTransfersCat netsuiteTransfersCat = new NetsuiteTransfersCat();
        model.addAttribute("netsuiteTransfersCat", netsuiteTransfersCat);
        return "master/config/netsuite-transfers-cat-add";
    }

    @PostMapping("/create")
    public String createNetsuiteTransfersCat(RedirectAttributes redirectAttributes,
                                            @ModelAttribute(value = "netsuiteTransferCat")
                                                    NetsuiteTransfersCat netsuiteTransfersCat) {
        try {
            netsuiteTransfersCat = netsuiteTransfersCatService.saveNetsuiteTransfersCat(netsuiteTransfersCat);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Transfers Cat was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while saving Netsuite Transfers Cat.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/netsuite/config/transfers-cat/view/" + netsuiteTransfersCat.getId();
    }

    @DeleteMapping("/delete/{id}")
    public String removeNetsuiteTransfersCat(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            netsuiteTransfersCatService.removeNetsuiteTransfersCat(id);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Transfers Cat was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred deleting Netsuite Transfers Cat.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/netsuite/config/transfers-cat";
    }

}
