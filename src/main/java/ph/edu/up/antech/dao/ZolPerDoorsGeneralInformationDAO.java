package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;

public interface ZolPerDoorsGeneralInformationDAO {

    public ZolPerDoorsGeneralInformation create(ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation);

    public ZolPerDoorsGeneralInformation findByItemCode(String itemCode);

}
