package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolPerDoorsPerAcctDAO;
import ph.edu.up.antech.dao.pagination.ZolPerDoorsPerAcctPaginationDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;
import ph.edu.up.antech.service.ZolPerDoorsPerAcctService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ZolPerDoorsPerAcctServiceImpl implements ZolPerDoorsPerAcctService {

    @Autowired
    private ZolPerDoorsPerAcctDAO zolPerDoorsPerAcctDAO;

    @Autowired
    private ZolPerDoorsPerAcctPaginationDAO zolPerDoorsPerAcctPaginationDAO;

    @Override
    public ZolPerDoorsPerAcct saveZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct) {
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

    @Override
    public ZolPerDoorsPerAcct findZolPerDoorsPerAcctById(Integer id) {
        return zolPerDoorsPerAcctDAO.findZolPerDoorsPerAcctById(id);
    }

    @Override
    public ZolPerDoorsPerAcct updateZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct) {
        return zolPerDoorsPerAcctDAO.updateZolPerDoorsPerAcct(zolPerDoorsPerAcct);
    }

    @Override
    public void removeZolPerDoorsPerAcct(Integer id) {
        zolPerDoorsPerAcctDAO.removeZolPerDoorsPerAcct(id);
    }

    @Override
    public Page<ZolPerDoorsPerAcct> findAll(Pageable pageable) {
        return zolPerDoorsPerAcctPaginationDAO.findAll(pageable);
    }

    @Override
    public Page<ZolPerDoorsPerAcct> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return zolPerDoorsPerAcctPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
