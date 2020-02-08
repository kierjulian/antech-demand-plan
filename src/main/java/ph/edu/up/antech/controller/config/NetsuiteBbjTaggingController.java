package ph.edu.up.antech.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBbjTagging;
import ph.edu.up.antech.service.NetsuiteBbjTaggingService;

import java.util.List;

@Controller
@RequestMapping("/config/netsuite-bbj")
public class NetsuiteBbjTaggingController {

    @Autowired
    private NetsuiteBbjTaggingService netsuiteBbjTaggingService;

    @GetMapping("")
    public String loadNetsuiteBbjTaggingPage(Model model) {
        List<NetsuiteBbjTagging> netsuiteBbjTaggingList = netsuiteBbjTaggingService.findAllNetsuiteBbjTagging();
        model.addAttribute("netsuiteBbjTaggingList", netsuiteBbjTaggingList);
        return "netsuite-bbj-tagging";
    }

}
