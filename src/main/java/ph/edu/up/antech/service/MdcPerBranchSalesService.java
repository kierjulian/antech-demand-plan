package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.master.MdcPerBranchSales;

import java.time.LocalDate;
import java.util.List;

public interface MdcPerBranchSalesService {

    public void saveMdcPerBranchSalesByBatch(List<MdcPerBranchSales> mdcPerBranchSalesList);

    public void removeMdcPerBranchSalesByDate(LocalDate date);

    public List<MdcPerBranchSales> findMdcPerBranchSalesByDate(LocalDate date);

    public MdcPerBranchSales findMdcPerBranchSalesById(Integer id);

    public MdcPerBranchSales saveMdcPerBranchSales(MdcPerBranchSales mdcPerBranchSales);

    public MdcPerBranchSales updateMdcPerBranchSales(MdcPerBranchSales mdcPerBranchSales);

    public void removeMdcPerBranchSales(Integer id);

    public List<MdcPerBranchSales> findMdcPerBranchSalesBetweenTwoDates(LocalDate startDate, LocalDate endDate);

}
