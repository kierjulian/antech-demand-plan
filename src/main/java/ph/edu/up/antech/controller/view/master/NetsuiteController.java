package ph.edu.up.antech.controller.view.master;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.domain.master.Netsuite;
import ph.edu.up.antech.service.NetsuiteService;
import ph.edu.up.antech.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/master/netsuite")
public class NetsuiteController {

    private static final Logger LOGGER = Logger.getLogger(NetsuiteController.class);

    @Autowired
    private NetsuiteService netsuiteService;

    @GetMapping("")
    public String loadNetsuiteMasterFile(Model model, @RequestParam(required = false) String startDate,
                                         @RequestParam(required = false) String endDate) {
        LocalDate start = !StringUtils.isNullOrEmpty(startDate) ? LocalDate.parse(startDate) : LocalDate.now();
        LocalDate end = !StringUtils.isNullOrEmpty(endDate) ? LocalDate.parse(endDate) : LocalDate.now();
        List<Netsuite> netsuiteList = netsuiteService.findNetsuiteBetweenTwoDates(start, end);

        model.addAttribute("searchedStartDate", start);
        model.addAttribute("searchedEndDate", end);
        model.addAttribute("netsuiteList", netsuiteList);
        model.addAttribute("netsuiteCalculator", new NetsuiteCalculator(netsuiteList));
        return "master/netsuite";
    }

    @GetMapping("/view/{id}")
    public String viewNetsuite(Model model, @PathVariable Integer id) {
        Netsuite netsuite = netsuiteService.findNetsuiteById(id);
        model.addAttribute("netsuite", netsuite);
        return "master/netsuite-view";
    }

    @GetMapping("/edit/{id}")
    public String editNetsuite(Model model, @PathVariable Integer id) {
        Netsuite netsuite = netsuiteService.findNetsuiteById(id);
        model.addAttribute("netsuite", netsuite);
        return "master/netsuite-edit";
    }

    @PostMapping("/update")
    public String updateNetsuite(RedirectAttributes redirectAttributes,
                                 @ModelAttribute(value = "netsuite") Netsuite netsuite) {
        try {
            netsuiteService.updateNetsuite(netsuite);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while updating Netsuite.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/netsuite/view/" + netsuite.getId();
    }

    @GetMapping("/add")
    public String addNetsuite(Model model) {
        Netsuite netsuite = new Netsuite();
        model.addAttribute("netsuite", netsuite);
        return "master/netsuite-add";
    }

    @PostMapping("/create")
    public String createNetsuite(RedirectAttributes redirectAttributes,
                                 @ModelAttribute(value = "netsuite") Netsuite netsuite) {
        try {
            netsuite = netsuiteService.saveNetsuite(netsuite);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while saving Netsuite.");
            LOGGER.error(e.getMessage(), e);
            return "redirect:/master/netsuite";
        }

        return "redirect:/master/netsuite/view/" + netsuite.getId();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNetsuite(RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            netsuiteService.removeNetsuite(id);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while deleting Netsuite.");
            LOGGER.error(e.getMessage(), e);
        }

        return "redirect:/master/netsuite";
    }

}
