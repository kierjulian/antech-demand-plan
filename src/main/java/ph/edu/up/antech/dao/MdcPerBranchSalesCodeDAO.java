package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesCode;

import java.util.List;

public interface MdcPerBranchSalesCodeDAO {

    public MdcPerBranchSalesCode saveMdcPerBranchSalesCode(MdcPerBranchSalesCode mdcPerBranchSalesCode);

    public List<MdcPerBranchSalesCode> findAllMdcPerBranchSalesCode();

}
