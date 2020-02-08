package ph.edu.up.antech.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListDe;
import ph.edu.up.antech.service.NetsuiteProductListDeService;

import java.util.List;

@Controller
@RequestMapping("/config/netsuite-product-list-de")
public class NetsuiteProductListDeController {

    @Autowired
    private NetsuiteProductListDeService netsuiteProductListDeService;

    @GetMapping("")
    public String loadNetsuiteProductListDePage(Model model) {
        List<NetsuiteProductListDe> netsuiteProductListDeList =
                netsuiteProductListDeService.findAllNetsuiteProductListDe();
        model.addAttribute("netsuiteProductListDeList", netsuiteProductListDeList);
        return "netsuite-prod-list-de";
    }

}
