package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;

import java.util.List;

public interface ZolPerDoorsGeneralInformationDAO {

    public ZolPerDoorsGeneralInformation createZolPerDoorsGeneralInformation(
            ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation);

    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationByItemCode(String itemCode);

    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationByZpcItemCode(String zpcItemCode);

    public List<ZolPerDoorsGeneralInformation> findAllZolPerDoorsGeneralInformation();

}
