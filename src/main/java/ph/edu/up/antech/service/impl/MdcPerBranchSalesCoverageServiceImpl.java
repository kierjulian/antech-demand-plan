package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.MdcPerBranchSalesCoverageDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesCoverage;
import ph.edu.up.antech.service.MdcPerBranchSalesCoverageService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MdcPerBranchSalesCoverageServiceImpl implements MdcPerBranchSalesCoverageService {

    @Autowired
    private MdcPerBranchSalesCoverageDAO mdcPerBranchSalesCoverageDAO;

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

}
