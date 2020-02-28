package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesInformation;

import java.util.List;

public interface MdcPerBranchSalesInformationService {

    public MdcPerBranchSalesInformation saveMdcPerBranchSalesInformation(MdcPerBranchSalesInformation mdcPerBranchSalesInformation);

    public List<MdcPerBranchSalesInformation> findAllMdcPerBranchSalesInformation();

    public MdcPerBranchSalesInformation findMdcPerBranchSalesInformation(Integer id);

    public MdcPerBranchSalesInformation updateMdcPerBranchSalesInformation(
            MdcPerBranchSalesInformation mdcPerBranchSalesInformation);

    public void removeMdcPerBranchSalesInformation(Integer id);

}
