package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.MdcPerBranchSalesNaConfigurationDAO;
import ph.edu.up.antech.dao.pagination.MdcPerBranchSalesNaConfigurationPaginationDAO;
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesNaConfiguration;
import ph.edu.up.antech.service.MdcPerBranchSalesNaConfigurationService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MdcPerBranchSalesNaConfigurationServiceImpl implements MdcPerBranchSalesNaConfigurationService {

    @Autowired
    private MdcPerBranchSalesNaConfigurationDAO mdcPerBranchSalesNaConfigurationDAO;

    @Autowired
    private MdcPerBranchSalesNaConfigurationPaginationDAO mdcPerBranchSalesNaConfigurationPaginationDAO;

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

    @Override
    public Page<MdcPerBranchSalesNaConfiguration> findAll(Pageable pageable) {
        return mdcPerBranchSalesNaConfigurationPaginationDAO.findAll(pageable);
    }

    @Override
    public Page<MdcPerBranchSalesNaConfiguration> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return mdcPerBranchSalesNaConfigurationPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
