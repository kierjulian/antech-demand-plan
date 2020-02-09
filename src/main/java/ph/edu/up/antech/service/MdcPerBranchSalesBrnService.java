package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesBrn;

import java.util.List;

public interface MdcPerBranchSalesBrnService {

    public MdcPerBranchSalesBrn saveMdcPerBranchSalesBrn(MdcPerBranchSalesBrn mdcPerBranchSalesBrn);

    public List<MdcPerBranchSalesBrn> findAllMdcPerBranchSalesBrn();

    public MdcPerBranchSalesBrn findMdcPerBranchSalesBrnById(Integer id);

    public MdcPerBranchSalesBrn updateMdcPerBranchSalesBrn(MdcPerBranchSalesBrn mdcPerBranchSalesBrn);

    public void removeMdcPerBranchSalesBrn(Integer id);

}
