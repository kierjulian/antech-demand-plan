package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesAccount;

import java.util.List;

public interface MdcPerBranchSalesAccountService {

    public MdcPerBranchSalesAccount saveMdcPerBranchSalesAccount(MdcPerBranchSalesAccount mdcPerBranchSalesAccount);

    public List<MdcPerBranchSalesAccount> findAllMdcPerBranchSalesAccount();

}
