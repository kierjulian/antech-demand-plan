package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolPerDoorsPerAcctDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;
import ph.edu.up.antech.service.ZolPerDoorsPerAcctService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ZolPerDoorsPerAcctServiceImpl implements ZolPerDoorsPerAcctService {

    @Autowired
    private ZolPerDoorsPerAcctDAO zolPerDoorsPerAcctDAO;

    @Override
    public ZolPerDoorsPerAcct createZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct) {
        return zolPerDoorsPerAcctDAO.saveZolPerDoorsPerAcct(zolPerDoorsPerAcct);
    }

    @Override
    public ZolPerDoorsPerAcct findZolPerDoorsPerAcctByZol(String customerCode) {
        return zolPerDoorsPerAcctDAO.findZolPerDoorsPerAcctByZol(customerCode);
    }

    @Override
    public List<ZolPerDoorsPerAcct> findAllZolPerDoorsPerAcct() {
        return zolPerDoorsPerAcctDAO.findAllZolPerDoorsPerAcct();
    }

}
