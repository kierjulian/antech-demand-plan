package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;

public interface ZolPerDoorsGeneralInformationService {

    public ZolPerDoorsGeneralInformation create(ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation);

    public ZolPerDoorsGeneralInformation findByItemCode(String itemCode);

}
