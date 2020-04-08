package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesCoverage;

import java.util.List;

public interface MdcPerBranchSalesCoverageDAO {

    public MdcPerBranchSalesCoverage saveMdcPerBranchSalesCoverage(MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage);

    public List<MdcPerBranchSalesCoverage> findAllMdcPerBranchSalesCoverage();

    public MdcPerBranchSalesCoverage findMdcPerBranchSalesCoverageById(Integer id);

    public MdcPerBranchSalesCoverage updateMdcPerBranchSalesCoverage(MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage);

    public void removeMdcPerBranchSalesCoverage(Integer id);

}
