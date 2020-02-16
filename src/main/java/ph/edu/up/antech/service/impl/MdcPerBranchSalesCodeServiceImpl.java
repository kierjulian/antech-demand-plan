package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.MdcPerBranchSalesCodeDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesCode;
import ph.edu.up.antech.service.MdcPerBranchSalesCodeService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MdcPerBranchSalesCodeServiceImpl implements MdcPerBranchSalesCodeService {

    @Autowired
    private MdcPerBranchSalesCodeDAO mdcPerBranchSalesCodeDAO;

    @Override
    public MdcPerBranchSalesCode saveMdcPerBranchSalesCoverage(MdcPerBranchSalesCode mdcPerBranchSalesCode) {
        return mdcPerBranchSalesCodeDAO.saveMdcPerBranchSalesCode(mdcPerBranchSalesCode);
    }

    @Override
    public List<MdcPerBranchSalesCode> findAllMdcPerBranchSalesCode() {
        return mdcPerBranchSalesCodeDAO.findAllMdcPerBranchSalesCode();
    }

    @Override
    public MdcPerBranchSalesCode findMdcPerBranchSalesCodeById(Integer id) {
        return mdcPerBranchSalesCodeDAO.findMdcPerBranchSalesCodeById(id);
    }

    @Override
    public MdcPerBranchSalesCode updateMdcPerBranchSalesCode(MdcPerBranchSalesCode mdcPerBranchSalesCode) {
        return mdcPerBranchSalesCodeDAO.updateMdcPerBranchSalesCode(mdcPerBranchSalesCode);
    }

    @Override
    public void removeMdcPerBranchSalesCode(Integer id) {
        mdcPerBranchSalesCodeDAO.removeMdcPerBranchSalesCode(id);
    }

}
