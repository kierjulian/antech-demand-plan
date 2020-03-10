package ph.edu.up.antech.controller.view.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ph.edu.up.antech.dao.pagination.NetsuiteBbjTaggingPaginationDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBbjTagging;
import ph.edu.up.antech.service.NetsuiteBbjTaggingService;
import ph.edu.up.antech.util.StringUtils;

@Controller
@RequestMapping("/master/netsuite/config/bbj")
public class NetsuiteBbjTaggingController {

    private static final Logger LOGGER = Logger.getLogger(NetsuiteBbjTaggingController.class);

    @Autowired
    private NetsuiteBbjTaggingService netsuiteBbjTaggingService;

    @Autowired
    private NetsuiteBbjTaggingPaginationDAO netsuiteBbjTaggingPaginationDAO;

    @GetMapping("")
    public String loadNetsuiteBbjTaggingPage(Model model, @PageableDefault Pageable pageable,
                                             @RequestParam(required = false) String filter) {
        Page<NetsuiteBbjTagging> page = StringUtils.isNullOrEmpty(filter)
                ? netsuiteBbjTaggingPaginationDAO.findAll(pageable)
                : netsuiteBbjTaggingPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
        model.addAttribute("page", page);
        model.addAttribute("filter", filter);
        return "master/config/netsuite-bbj-tagging";
    }

    @GetMapping("/view/{id}")
    public String viewNetsuiteBbjTagging(Model model, @PathVariable Integer id) {
        NetsuiteBbjTagging netsuiteBbjTagging = netsuiteBbjTaggingService
                .findNetsuiteBbjTaggingById(id);
        model.addAttribute("netsuiteBbjTagging", netsuiteBbjTagging);
        return "master/config/netsuite-bbj-tagging-view";
    }

    @GetMapping("/edit/{id}")
    public String editNetsuiteBbjTagging(Model model, @PathVariable Integer id) {
        NetsuiteBbjTagging netsuiteBbjTagging = netsuiteBbjTaggingService
                .findNetsuiteBbjTaggingById(id);
        model.addAttribute("netsuiteBbjTagging", netsuiteBbjTagging);
        return "netsuite-bbj-tagging-edit";
    }

    @PostMapping("/update")
    public String updateNetsuiteBbjTagging(RedirectAttributes redirectAttributes,
                                           @ModelAttribute(value = "netsuiteBbjTagging")
                                                   NetsuiteBbjTagging netsuiteBbjTagging) {
        try {
            netsuiteBbjTaggingService.updateNetsuiteBbjTagging(netsuiteBbjTagging);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite BBJ Tagging was successfully updated.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/netsuite/config/bbj/view/" + netsuiteBbjTagging.getId();
    }

    @GetMapping("/add")
    public String addNetsuiteBbjTagging(Model model) {
        NetsuiteBbjTagging netsuiteBbjTagging = new NetsuiteBbjTagging();
        model.addAttribute("netsuiteBbjTagging", netsuiteBbjTagging);
        return "master/config/netsuite-bbj-tagging-add";
    }

    @PostMapping("/create")
    public String createNetsuiteBbjTagging(RedirectAttributes redirectAttributes,
                                           @ModelAttribute(value = "netsuiteBbjTagging")
                                                   NetsuiteBbjTagging netsuiteBbjTagging) {
        try {
            netsuiteBbjTagging = netsuiteBbjTaggingService.saveNetsuiteBbjTagging(netsuiteBbjTagging);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite BBJ Tagging was successfully created.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/netsuite/config/bbj/view/" + netsuiteBbjTagging.getId();
    }

    @GetMapping("/delete/{id}")
    public String removeNetsuiteBbjTagging(
            RedirectAttributes redirectAttributes, @PathVariable Integer id) {
        try {
            netsuiteBbjTaggingService.removeNetsuiteBbjTagging(id);
            redirectAttributes.addFlashAttribute("successMessage", "Netsuite BBJ Tagging was successfully deleted.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred: " + e.getMessage());
            LOGGER.error(e.getMessage());
        }

        return "redirect:/master/netsuite/config/bbj";
    }

}
