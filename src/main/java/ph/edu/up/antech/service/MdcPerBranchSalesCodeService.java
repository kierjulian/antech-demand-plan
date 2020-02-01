package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesCode;

import java.util.List;

public interface MdcPerBranchSalesCodeService {

    public MdcPerBranchSalesCode saveMdcPerBranchSalesCoverage(MdcPerBranchSalesCode mdcPerBranchSalesCode);

    public List<MdcPerBranchSalesCode> findAllMdcPerBranchSalesCode();

}
