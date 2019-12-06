package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolPerDoorsGeneralInformationDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;
import ph.edu.up.antech.service.ZolPerDoorsGeneralInformationService;

@Service
public class ZolPerDoorsGeneralInformationServiceImpl implements ZolPerDoorsGeneralInformationService {

    @Autowired
    private ZolPerDoorsGeneralInformationDAO zolPerDoorsGeneralInformationDAO;

    @Override
    public ZolPerDoorsGeneralInformation create(ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation) {
        return zolPerDoorsGeneralInformationDAO.create(zolPerDoorsGeneralInformation);
    }

    @Override
    public ZolPerDoorsGeneralInformation findByItemCode(String itemCode) {
        return zolPerDoorsGeneralInformationDAO.findByItemCode(itemCode);
    }

    @Override
    public ZolPerDoorsGeneralInformation findByZpcItemCode(String zpcItemCode) {
        return zolPerDoorsGeneralInformationDAO.findByZpcItemCode(zpcItemCode);
    }

}
