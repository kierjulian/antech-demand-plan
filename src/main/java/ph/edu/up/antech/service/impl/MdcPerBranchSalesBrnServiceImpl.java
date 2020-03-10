package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.MdcPerBranchSalesBrnDAO;
import ph.edu.up.antech.dao.pagination.MdcPerBranchSalesBrnPaginationDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesBrn;
import ph.edu.up.antech.service.MdcPerBranchSalesBrnService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MdcPerBranchSalesBrnServiceImpl implements MdcPerBranchSalesBrnService {

    @Autowired
    private MdcPerBranchSalesBrnDAO mdcPerBranchSalesBrnDAO;

    @Autowired
    private MdcPerBranchSalesBrnPaginationDAO mdcPerBranchSalesBrnPaginationDAO;

    @Override
    public MdcPerBranchSalesBrn saveMdcPerBranchSalesBrn(MdcPerBranchSalesBrn mdcPerBranchSalesBrn) {
        return mdcPerBranchSalesBrnDAO.saveMdcPerBranchSalesBrn(mdcPerBranchSalesBrn);
    }

    @Override
    public List<MdcPerBranchSalesBrn> findAllMdcPerBranchSalesBrn() {
        return mdcPerBranchSalesBrnDAO.findAllMdcPerBranchSalesBrn();
    }

    @Override
    public MdcPerBranchSalesBrn findMdcPerBranchSalesBrnById(Integer id) {
        return mdcPerBranchSalesBrnDAO.findMdcPerBranchSalesBrnById(id);
    }

    @Override
    public MdcPerBranchSalesBrn updateMdcPerBranchSalesBrn(MdcPerBranchSalesBrn mdcPerBranchSalesBrn) {
        return mdcPerBranchSalesBrnDAO.updateMdcPerBranchSalesBrn(mdcPerBranchSalesBrn);
    }

    @Override
    public void removeMdcPerBranchSalesBrn(Integer id) {
        mdcPerBranchSalesBrnDAO.removeMdcPerBranchSalesBrn(id);
    }

    @Override
    public Page<MdcPerBranchSalesBrn> findAll(Pageable pageable) {
        return mdcPerBranchSalesBrnPaginationDAO.findAll(pageable);
    }

    @Override
    public Page<MdcPerBranchSalesBrn> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return mdcPerBranchSalesBrnPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
