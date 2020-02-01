package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesBrn;

import java.util.List;

public interface MdcPerBranchSalesBrnDAO {

    public MdcPerBranchSalesBrn saveMdcPerBranchSalesBrn(MdcPerBranchSalesBrn mdcPerBranchSalesBrn);

    public List<MdcPerBranchSalesBrn> findAllMdcPerBranchSalesBrn();

}
