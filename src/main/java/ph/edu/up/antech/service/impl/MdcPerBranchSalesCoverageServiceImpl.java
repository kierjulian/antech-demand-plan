package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.MdcPerBranchSalesCoverageDAO;
import ph.edu.up.antech.dao.pagination.MdcPerBranchSalesCoveragePaginationDAO;
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesCoverage;
import ph.edu.up.antech.service.MdcPerBranchSalesCoverageService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MdcPerBranchSalesCoverageServiceImpl implements MdcPerBranchSalesCoverageService {

    @Autowired
    private MdcPerBranchSalesCoverageDAO mdcPerBranchSalesCoverageDAO;

    @Autowired
    private MdcPerBranchSalesCoveragePaginationDAO mdcPerBranchSalesCoveragePaginationDAO;

    @Override
    public MdcPerBranchSalesCoverage saveMdcPerBranchSalesCoverage(MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage) {
        return mdcPerBranchSalesCoverageDAO.saveMdcPerBranchSalesCoverage(mdcPerBranchSalesCoverage);
    }

    @Override
    public List<MdcPerBranchSalesCoverage> findAllMdcPerBranchSalesCoverage() {
        return mdcPerBranchSalesCoverageDAO.findAllMdcPerBranchSalesCoverage();
    }

    @Override
    public MdcPerBranchSalesCoverage findMdcPerBranchSalesCoverageById(Integer id) {
        return mdcPerBranchSalesCoverageDAO.findMdcPerBranchSalesCoverageById(id);
    }

    @Override
    public MdcPerBranchSalesCoverage updateMdcPerBranchSalesCoverage(MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage) {
        return mdcPerBranchSalesCoverageDAO.updateMdcPerBranchSalesCoverage(mdcPerBranchSalesCoverage);
    }

    @Override
    public void removeMdcPerBranchSalesCoverage(Integer id) {
        mdcPerBranchSalesCoverageDAO.removeMdcPerBranchSalesCoverage(id);
    }

    @Override
    public Page<MdcPerBranchSalesCoverage> findAll(Pageable pageable) {
        return mdcPerBranchSalesCoveragePaginationDAO.findAll(pageable);
    }

    @Override
    public Page<MdcPerBranchSalesCoverage> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return mdcPerBranchSalesCoveragePaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
