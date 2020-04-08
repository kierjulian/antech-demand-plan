package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesNaConfiguration;

import java.util.List;

public interface MdcPerBranchSalesNaConfigurationService {

    public MdcPerBranchSalesNaConfiguration saveMdcPerBranchSalesNaConfiguration(
            MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration);

    public List<MdcPerBranchSalesNaConfiguration> findAllMdcPerBranchSalesNaConfiguration();

    public MdcPerBranchSalesNaConfiguration findMdcPerBranchSalesNaConfigurationById(Integer id);

    public MdcPerBranchSalesNaConfiguration updateMdcPerBranchSalesNaConfiguration(
            MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration);

    public void removeMdcPerBranchSalesNaConfiguration(Integer id);

    public Page<MdcPerBranchSalesNaConfiguration> findAll(Pageable pageable);

    public Page<MdcPerBranchSalesNaConfiguration> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
