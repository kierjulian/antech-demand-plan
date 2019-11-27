package ph.edu.up.antech.domain.generator;

import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;

public class ZolPerDoorsGeneralInformationGenerator {

    public static ZolPerDoorsGeneralInformation generateSampleZolPerDoorsGeneralInformation() {
        ZolPerDoorsGeneralInformation generalInformation = new ZolPerDoorsGeneralInformation();
        generalInformation.setZpcItemCode("000000000021172943");
        generalInformation.setItemCode("21172943");
        generalInformation.setAntechProductDescription("HIPP ORGANIC MILK SUPP 6-12MOS 800G BIB");
        generalInformation.setBrand("S2 800 BIB");
        return generalInformation;
    }

}
