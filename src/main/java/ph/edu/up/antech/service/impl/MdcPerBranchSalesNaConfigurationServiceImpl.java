package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.MdcPerBranchSalesNaConfigurationDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesNaConfiguration;
import ph.edu.up.antech.service.MdcPerBranchSalesNaConfigurationService;

import java.util.List;

@Service
public class MdcPerBranchSalesNaConfigurationServiceImpl implements MdcPerBranchSalesNaConfigurationService {

    @Autowired
    private MdcPerBranchSalesNaConfigurationDAO mdcPerBranchSalesNaConfigurationDAO;

    @Override
    public MdcPerBranchSalesNaConfiguration saveMdcPerBranchSalesNaConfiguration(MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration) {
        return mdcPerBranchSalesNaConfigurationDAO.saveMdcPerBranchSalesNaConfiguration(mdcPerBranchSalesNaConfiguration);
    }

    @Override
    public List<MdcPerBranchSalesNaConfiguration> findAllMdcPerBranchSalesNaConfiguration() {
        return mdcPerBranchSalesNaConfigurationDAO.findAllMdcPerBranchSalesNaConfiguration();
    }

    @Override
    public MdcPerBranchSalesNaConfiguration findMdcPerBranchSalesNaConfigurationById(Integer id) {
        return mdcPerBranchSalesNaConfigurationDAO.findMdcPerBranchSalesNaConfigurationById(id);
    }

    @Override
    public MdcPerBranchSalesNaConfiguration updateMdcPerBranchSalesNaConfiguration(MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration) {
        return mdcPerBranchSalesNaConfigurationDAO.updateMdcPerBranchSalesNaConfiguration(mdcPerBranchSalesNaConfiguration);
    }

    @Override
    public void removeMdcPerBranchSalesNaConfiguration(Integer id) {
        mdcPerBranchSalesNaConfigurationDAO.removeMdcPerBranchSalesNaConfiguration(id);
    }

}
