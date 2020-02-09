package ph.edu.up.antech.controller.view.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteOtherInformation;
import ph.edu.up.antech.service.NetsuiteOtherInformationService;

import java.util.List;

@Controller
@RequestMapping("/config/netsuite-other-info")
public class NetsuiteOtherInformationController {

    @Autowired
    private NetsuiteOtherInformationService netsuiteOtherInformationService;

    @GetMapping("")
    public String loadNetsuiteOtherInformationPage(Model model) {
        List<NetsuiteOtherInformation> netsuiteOtherInformationList =
                netsuiteOtherInformationService.findAllNetsuiteOtherInformation();
        model.addAttribute("netsuiteOtherInformationList", netsuiteOtherInformationList);
        return "netsuite-other-info.html";
    }

}
