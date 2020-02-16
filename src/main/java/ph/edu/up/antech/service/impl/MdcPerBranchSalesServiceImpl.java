package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.MdcPerBranchSalesDAO;
import ph.edu.up.antech.domain.sales.master.MdcPerBranchSales;
import ph.edu.up.antech.service.MdcPerBranchSalesService;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class MdcPerBranchSalesServiceImpl implements MdcPerBranchSalesService {

    @Autowired
    private MdcPerBranchSalesDAO mdcPerBranchSalesDAO;

    @Override
    public void saveMdcPerBranchSalesByBatch(List<MdcPerBranchSales> mdcPerBranchSalesList) {
        mdcPerBranchSalesDAO.saveMdcPerBranchSalesByBatch(mdcPerBranchSalesList);
    }

    @Override
    public void removeMdcPerBranchSalesByDate(LocalDate date) {
        mdcPerBranchSalesDAO.removeMdcPerBranchSalesByDate(date);
    }

    @Override
    public List<MdcPerBranchSales> findMdcPerBranchSalesByDate(LocalDate date) {
        return mdcPerBranchSalesDAO.findMdcPerBranchSalesByDate(date);
    }

}
