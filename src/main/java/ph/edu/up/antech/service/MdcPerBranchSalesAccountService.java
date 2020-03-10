package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesAccount;

import java.util.List;

public interface MdcPerBranchSalesAccountService {

    public MdcPerBranchSalesAccount saveMdcPerBranchSalesAccount(MdcPerBranchSalesAccount mdcPerBranchSalesAccount);

    public List<MdcPerBranchSalesAccount> findAllMdcPerBranchSalesAccount();

    public MdcPerBranchSalesAccount findMdcPerBranchSalesAccount(Integer id);

    public MdcPerBranchSalesAccount updateMdcPerBranchSalesAccount(MdcPerBranchSalesAccount mdcPerBranchSalesAccount);

    public void removeMdcPerBranchSalesAccount(Integer id);

    public Page<MdcPerBranchSalesAccount> findAll(Pageable pageable);

    public Page<MdcPerBranchSalesAccount> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
