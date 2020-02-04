package ph.edu.up.antech.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;
import ph.edu.up.antech.service.ZolPerDoorsGeneralInformationService;

import java.util.List;

@Controller
@RequestMapping("/zol-gen-info")
public class ZolPerDoorsGeneralInformationController {

    @Autowired
    private ZolPerDoorsGeneralInformationService zolPerDoorsGeneralInformationService;

    @GetMapping("")
    public String loadZolPerDoorsGeneralInformation(Model model) {
        List<ZolPerDoorsGeneralInformation> zolPerDoorsGeneralInformationList =
                zolPerDoorsGeneralInformationService.findAllZolPerDoorsGeneralInformation();
        model.addAttribute("zolPerDoorsGeneralInformationList", zolPerDoorsGeneralInformationList);
        return "zol-gen-info";
    }


}
