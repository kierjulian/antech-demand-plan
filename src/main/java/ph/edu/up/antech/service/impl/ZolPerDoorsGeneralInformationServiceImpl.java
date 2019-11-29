package ph.edu.up.antech.service.impl;

import org.springframework.stereotype.Service;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;
import ph.edu.up.antech.service.ZolPerDoorsGeneralInformationService;

import java.math.BigDecimal;

@Service
public class ZolPerDoorsGeneralInformationServiceImpl implements ZolPerDoorsGeneralInformationService {

    @Override
    public ZolPerDoorsGeneralInformation findByItemCode(String itemCode) {
        if (itemCode.equals("21172943")) {
            ZolPerDoorsGeneralInformation generalInformation = new ZolPerDoorsGeneralInformation();
            generalInformation.setZpcItemCode("000000000021172943");
            generalInformation.setItemCode("21172943");
            generalInformation.setAntechProductDescription("HIPP ORGANIC MILK SUPP 6-12MOS 800G BIB");
            generalInformation.setBrand("S2 800 BIB");
            generalInformation.setNewPrice(new BigDecimal("449.09"));
            generalInformation.setStage("Stage 2");
            return generalInformation;
        }

        return new ZolPerDoorsGeneralInformation();
    }

}
