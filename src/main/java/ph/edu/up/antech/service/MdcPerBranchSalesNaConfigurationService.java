package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesNaConfiguration;

import java.util.List;

public interface MdcPerBranchSalesNaConfigurationService {

    public MdcPerBranchSalesNaConfiguration saveMdcPerBranchSalesNaConfiguration(
            MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration);

    public List<MdcPerBranchSalesNaConfiguration> findAllMdcPerBranchSalesNaConfiguration();

}