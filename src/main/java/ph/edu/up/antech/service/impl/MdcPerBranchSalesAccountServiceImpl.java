package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.MdcPerBranchSalesAccountDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesAccount;
import ph.edu.up.antech.service.MdcPerBranchSalesAccountService;

import java.util.List;

@Service
public class MdcPerBranchSalesAccountServiceImpl implements MdcPerBranchSalesAccountService {

    @Autowired
    private MdcPerBranchSalesAccountDAO mdcPerBranchSalesAccountDAO;

    @Override
    public MdcPerBranchSalesAccount saveMdcPerBranchSalesAccount(MdcPerBranchSalesAccount mdcPerBranchSalesAccount) {
        return mdcPerBranchSalesAccountDAO.saveMdcPerBranchSalesAccount(mdcPerBranchSalesAccount);
    }

    @Override
    public List<MdcPerBranchSalesAccount> findAllMdcPerBranchSalesAccount() {
        return mdcPerBranchSalesAccountDAO.findAllMdcPerBranchSalesAccount();
    }

}
