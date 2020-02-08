package ph.edu.up.antech.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListSource;
import ph.edu.up.antech.service.NetsuiteProductListSourceService;

import java.util.List;

@Controller
@RequestMapping("/config/netsuite-product-list-source")
public class NetsuiteProductListSourceController {

    @Autowired
    private NetsuiteProductListSourceService netsuiteProductListSourceService;

    @GetMapping("")
    public String loadNetsuiteProductListSourcePage(Model model) {
        List<NetsuiteProductListSource> netsuiteProductListSourceList =
                netsuiteProductListSourceService.findAllNetsuiteProductListSource();
        model.addAttribute("netsuiteProductListSourceList", netsuiteProductListSourceList);
        return "netsuite-prod-list-source";
    }

}
