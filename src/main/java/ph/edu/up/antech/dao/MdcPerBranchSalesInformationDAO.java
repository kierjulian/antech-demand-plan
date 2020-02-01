package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesInformation;

import java.util.List;

public interface MdcPerBranchSalesInformationDAO {

    public MdcPerBranchSalesInformation saveMdcPerBranchSalesInformation(MdcPerBranchSalesInformation mdcPerBranchSalesInformation);

    public List<MdcPerBranchSalesInformation> findAllMdcPerBranchSalesInformation();

}
