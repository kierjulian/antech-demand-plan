package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;

import java.util.List;

public interface ZolPerDoorsGeneralInformationService {

    public ZolPerDoorsGeneralInformation createZolPerDoorsGeneralInformation(
            ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation);

    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationByItemCode(String itemCode);

    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationByZpcItemCode(String zpcItemCode);

    public List<ZolPerDoorsGeneralInformation> findAllZolPerDoorsGeneralInformation();

}
