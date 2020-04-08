package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesInformation;

import java.util.List;

public interface MdcPerBranchSalesInformationDAO {

    public MdcPerBranchSalesInformation saveMdcPerBranchSalesInformation(MdcPerBranchSalesInformation mdcPerBranchSalesInformation);

    public List<MdcPerBranchSalesInformation> findAllMdcPerBranchSalesInformation();

    public MdcPerBranchSalesInformation findMdcPerBranchSalesInformation(Integer id);

    public MdcPerBranchSalesInformation updateMdcPerBranchSalesInformation(
            MdcPerBranchSalesInformation mdcPerBranchSalesInformation);

    public void removeMdcPerBranchSalesInformation(Integer id);

}
