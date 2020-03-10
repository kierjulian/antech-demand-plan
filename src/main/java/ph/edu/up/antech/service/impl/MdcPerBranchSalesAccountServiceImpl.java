package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.MdcPerBranchSalesAccountDAO;
import ph.edu.up.antech.dao.pagination.MdcPerBranchSalesAccountPaginationDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesAccount;
import ph.edu.up.antech.service.MdcPerBranchSalesAccountService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MdcPerBranchSalesAccountServiceImpl implements MdcPerBranchSalesAccountService {

    @Autowired
    private MdcPerBranchSalesAccountDAO mdcPerBranchSalesAccountDAO;

    @Autowired
    private MdcPerBranchSalesAccountPaginationDAO mdcPerBranchSalesAccountPaginationDAO;

    @Override
    public MdcPerBranchSalesAccount saveMdcPerBranchSalesAccount(MdcPerBranchSalesAccount mdcPerBranchSalesAccount) {
        return mdcPerBranchSalesAccountDAO.saveMdcPerBranchSalesAccount(mdcPerBranchSalesAccount);
    }

    @Override
    public List<MdcPerBranchSalesAccount> findAllMdcPerBranchSalesAccount() {
        return mdcPerBranchSalesAccountDAO.findAllMdcPerBranchSalesAccount();
    }

    @Override
    public MdcPerBranchSalesAccount findMdcPerBranchSalesAccount(Integer id) {
        return mdcPerBranchSalesAccountDAO.findMdcPerBranchSalesAccount(id);
    }

    @Override
    public MdcPerBranchSalesAccount updateMdcPerBranchSalesAccount(MdcPerBranchSalesAccount mdcPerBranchSalesAccount) {
        return mdcPerBranchSalesAccountDAO.updateMdcPerBranchSalesAccount(mdcPerBranchSalesAccount);
    }

    @Override
    public void removeMdcPerBranchSalesAccount(Integer id) {
        mdcPerBranchSalesAccountDAO.removeMdcPerBranchSalesAccount(id);
    }

    @Override
    public Page<MdcPerBranchSalesAccount> findAll(Pageable pageable) {
        return mdcPerBranchSalesAccountPaginationDAO.findAll(pageable);
    }

    @Override
    public Page<MdcPerBranchSalesAccount> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return mdcPerBranchSalesAccountPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
