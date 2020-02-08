package ph.edu.up.antech.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteGeneralInformation;
import ph.edu.up.antech.service.NetsuiteGeneralInformationService;

import java.util.List;

@Controller
@RequestMapping("/config/netsuite-general-info")
public class NetsuiteGeneralInformationController {

    @Autowired
    private NetsuiteGeneralInformationService netsuiteGeneralInformationService;

    @GetMapping("")
    public String loadNetsuiteGeneralInformationPage(Model model) {
        List<NetsuiteGeneralInformation> netsuiteGeneralInformationList =
                netsuiteGeneralInformationService.findAllNetsuiteGeneralInformation();
        model.addAttribute("netsuiteGeneralInformationList", netsuiteGeneralInformationList);
        return "netsuite-gen-info";
    }

}
