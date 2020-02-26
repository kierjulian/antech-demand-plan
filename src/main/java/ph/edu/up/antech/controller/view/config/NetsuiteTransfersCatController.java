package ph.edu.up.antech.controller.view.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteTransferCat;
import ph.edu.up.antech.service.NetsuiteTransferCatService;

import java.util.List;

@Controller
@RequestMapping("/master/netsuite/config/transfers-cat")
public class NetsuiteTransfersCatController {

    private static final Logger LOGGER = Logger.getLogger(NetsuiteTransfersCatController.class);

    @Autowired
    private NetsuiteTransferCatService netsuiteTransferCatService;

    @GetMapping("")
    public String loadNetsuiteTransferCat(Model model) {
        List<NetsuiteTransferCat> netsuiteTransferCatList =
                netsuiteTransferCatService.findAllNetsuiteTransferCat();
        model.addAttribute("netsuiteTransferCatList", netsuiteTransferCatList);
        return "netsuite-transfers-cat";
    }

    @GetMapping("/view/{id}")
    public String viewNetsuiteTransferCat(Model model, @PathVariable Integer id) {
        NetsuiteTransferCat netsuiteTransferCat = netsuiteTransferCatService
                .findNetsuiteTransferCatById(id);
        model.addAttribute("netsuiteTransferCat", netsuiteTransferCat);
        return "netsuite-transfers-cat-view";
    }

    @GetMapping("/edit/{id}")
    public String editNetsuiteTransferCat(Model model, @PathVariable Integer id) {
        NetsuiteTransferCat netsuiteTransferCat = netsuiteTransferCatService
                .findNetsuiteTransferCatById(id);
        model.addAttribute("netsuiteTransferCat", netsuiteTransferCat);
        return "netsuite-transfers-cat-edit";
    }

    @PostMapping("/update")
    public String updateNetsuiteTransferCat(RedirectAttributes redirectAttributes,
                                            @ModelAttribute(value = "netsuiteTransferCat")
                                                    NetsuiteTransferCat netsuiteTransferCat) {
        try {
            netsuiteTransferCatService.updateNetsuiteTransferCat(netsuiteTransferCat);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Transfers Cat was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/netsuite/config/transfers-cat/view/" + netsuiteTransferCat.getId();
    }

    @GetMapping("/add")
    public String addNetsuiteTransferCat(Model model) {
        NetsuiteTransferCat netsuiteTransferCat = new NetsuiteTransferCat();
        model.addAttribute("netsuiteTransferCat", netsuiteTransferCat);
        return "netsuite-transfers-cat-add";
    }

    @PostMapping("/create")
    public String createNetsuiteTransferCat(RedirectAttributes redirectAttributes,
                                            @ModelAttribute(value = "netsuiteTransferCat")
                                                    NetsuiteTransferCat netsuiteTransferCat) {
        try {
            netsuiteTransferCat = netsuiteTransferCatService.saveNetsuiteTransferCat(netsuiteTransferCat);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Transfers Cat was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/netsuite/config/transfers-cat/view/" + netsuiteTransferCat.getId();
    }

    @GetMapping("/delete/{id}")
    public String removeNetsuiteTransferCat(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            netsuiteTransferCatService.removeNetsuiteTransferCat(id);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite Transfers Cat was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/netsuite/config/transfers-cat";
    }

}
