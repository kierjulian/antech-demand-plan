package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolPerDoorsPerAcctDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;
import ph.edu.up.antech.service.ZolPerDoorsPerAcctService;

@Service
public class ZolPerDoorsPerAcctServiceImpl implements ZolPerDoorsPerAcctService {

    @Autowired
    private ZolPerDoorsPerAcctDAO zolPerDoorsPerAcctDAO;

    @Override
    public ZolPerDoorsPerAcct create(ZolPerDoorsPerAcct zolPerDoorsPerAcct) {
        return zolPerDoorsPerAcctDAO.create(zolPerDoorsPerAcct);
    }

    @Override
    public ZolPerDoorsPerAcct findByZol(String customerCode) {
        ZolPerDoorsPerAcct perAcct = new ZolPerDoorsPerAcct();
        perAcct.setAccount("LTS Supermarkets");
        perAcct.setKam("405");
        perAcct.setKamReferenceName("E. Rick Tilawan - Min");
        perAcct.setLocation2("Davao");
        return perAcct;
    }

}
