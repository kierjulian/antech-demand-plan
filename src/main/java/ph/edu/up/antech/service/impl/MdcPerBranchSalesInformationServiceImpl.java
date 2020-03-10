package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.MdcPerBranchSalesInformationDAO;
import ph.edu.up.antech.dao.pagination.MdcPerBranchSalesInformationPaginationDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesInformation;
import ph.edu.up.antech.service.MdcPerBranchSalesInformationService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MdcPerBranchSalesInformationServiceImpl implements MdcPerBranchSalesInformationService {

    @Autowired
    private MdcPerBranchSalesInformationDAO mdcPerBranchSalesInformationDAO;

    @Autowired
    private MdcPerBranchSalesInformationPaginationDAO mdcPerBranchSalesInformationPaginationDAO;

    @Override
    public MdcPerBranchSalesInformation saveMdcPerBranchSalesInformation(MdcPerBranchSalesInformation mdcPerBranchSalesInformation) {
        return mdcPerBranchSalesInformationDAO.saveMdcPerBranchSalesInformation(mdcPerBranchSalesInformation);
    }

    @Override
    public List<MdcPerBranchSalesInformation> findAllMdcPerBranchSalesInformation() {
        return mdcPerBranchSalesInformationDAO.findAllMdcPerBranchSalesInformation();
    }

    @Override
    public MdcPerBranchSalesInformation findMdcPerBranchSalesInformation(Integer id) {
        return mdcPerBranchSalesInformationDAO.findMdcPerBranchSalesInformation(id);
    }

    @Override
    public MdcPerBranchSalesInformation updateMdcPerBranchSalesInformation(MdcPerBranchSalesInformation mdcPerBranchSalesInformation) {
        return mdcPerBranchSalesInformationDAO.updateMdcPerBranchSalesInformation(mdcPerBranchSalesInformation);
    }

    @Override
    public void removeMdcPerBranchSalesInformation(Integer id) {
        mdcPerBranchSalesInformationDAO.removeMdcPerBranchSalesInformation(id);
    }

    @Override
    public Page<MdcPerBranchSalesInformation> findAll(Pageable pageable) {
        return mdcPerBranchSalesInformationPaginationDAO.findAll(pageable);
    }

    @Override
    public Page<MdcPerBranchSalesInformation> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return mdcPerBranchSalesInformationPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
