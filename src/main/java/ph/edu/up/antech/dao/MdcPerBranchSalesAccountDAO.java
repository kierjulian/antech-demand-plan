package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesAccount;

import java.util.List;

public interface MdcPerBranchSalesAccountDAO {

    public MdcPerBranchSalesAccount saveMdcPerBranchSalesAccount(MdcPerBranchSalesAccount mdcPerBranchSalesAccount);

    public List<MdcPerBranchSalesAccount> findAllMdcPerBranchSalesAccount();

    public MdcPerBranchSalesAccount findMdcPerBranchSalesAccount(Integer id);

    public MdcPerBranchSalesAccount updateMdcPerBranchSalesAccount(MdcPerBranchSalesAccount mdcPerBranchSalesAccount);

    public void removeMdcPerBranchSalesAccount(Integer id);

}
