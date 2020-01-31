package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesAccount;

import java.util.List;

public interface MdcPerBranchSalesAccountDAO {

    public MdcPerBranchSalesAccount saveMdcPerBranchSalesAccount(MdcPerBranchSalesAccount mdcPerBranchSalesAccount);

    public List<MdcPerBranchSalesAccount> findAllMdcPerBranchSalesAccount();

}
