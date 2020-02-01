package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesNaConfiguration;

import java.util.List;

public interface MdcPerBranchSalesNaConfigurationDAO {

    public MdcPerBranchSalesNaConfiguration saveMdcPerBranchSalesNaConfiguration(
            MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration);

    public List<MdcPerBranchSalesNaConfiguration> findAllMdcPerBranchSalesNaConfiguration();

}
