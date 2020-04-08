package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesCode;

import java.util.List;

public interface MdcPerBranchSalesCodeDAO {

    public MdcPerBranchSalesCode saveMdcPerBranchSalesCode(MdcPerBranchSalesCode mdcPerBranchSalesCode);

    public List<MdcPerBranchSalesCode> findAllMdcPerBranchSalesCode();

    public MdcPerBranchSalesCode findMdcPerBranchSalesCodeById(Integer id);

    public MdcPerBranchSalesCode updateMdcPerBranchSalesCode(MdcPerBranchSalesCode mdcPerBranchSalesCode);

    public void removeMdcPerBranchSalesCode(Integer id);

}
