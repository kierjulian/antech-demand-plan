package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesCoverage;

import java.util.List;

public interface MdcPerBranchSalesCoverageService {

    public MdcPerBranchSalesCoverage saveMdcPerBranchSalesCoverage(MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage);

    public List<MdcPerBranchSalesCoverage> findAllMdcPerBranchSalesCoverage();

    public MdcPerBranchSalesCoverage findMdcPerBranchSalesCoverageById(Integer id);

    public MdcPerBranchSalesCoverage updateMdcPerBranchSalesCoverage(MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage);

    public void removeMdcPerBranchSalesCoverage(Integer id);

}
