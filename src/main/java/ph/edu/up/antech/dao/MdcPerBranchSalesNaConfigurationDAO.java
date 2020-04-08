package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesNaConfiguration;

import java.util.List;

public interface MdcPerBranchSalesNaConfigurationDAO {

    public MdcPerBranchSalesNaConfiguration saveMdcPerBranchSalesNaConfiguration(
            MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration);

    public List<MdcPerBranchSalesNaConfiguration> findAllMdcPerBranchSalesNaConfiguration();

    public MdcPerBranchSalesNaConfiguration findMdcPerBranchSalesNaConfigurationById(Integer id);

    public MdcPerBranchSalesNaConfiguration updateMdcPerBranchSalesNaConfiguration(
            MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration);

    public void removeMdcPerBranchSalesNaConfiguration(Integer id);

}
