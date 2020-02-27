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

    @Override
    public MdcPerBranchSales findMdcPerBranchSalesById(Integer id) {
        return mdcPerBranchSalesDAO.findMdcPerBranchSalesById(id);
    }

    @Override
    public MdcPerBranchSales saveMdcPerBranchSales(MdcPerBranchSales mdcPerBranchSales) {
        return mdcPerBranchSalesDAO.saveMdcPerBranchSales(mdcPerBranchSales);
    }

    @Override
    public MdcPerBranchSales updateMdcPerBranchSales(MdcPerBranchSales mdcPerBranchSales) {
        return mdcPerBranchSalesDAO.updateMdcPerBranchSales(mdcPerBranchSales);
    }

    @Override
    public void removeMdcPerBranchSales(Integer id) {
        mdcPerBranchSalesDAO.removeMdcPerBranchSales(id);
    }

    @Override
    public List<MdcPerBranchSales> findMdcPerBranchSalesBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        return mdcPerBranchSalesDAO.findMdcPerBranchSalesBetweenTwoDates(startDate, endDate);
    }

}
