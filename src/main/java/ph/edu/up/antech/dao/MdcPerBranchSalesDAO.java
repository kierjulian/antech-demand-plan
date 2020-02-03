package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.MdcPerBranchSales;

import java.time.LocalDate;
import java.util.List;

public interface MdcPerBranchSalesDAO {

    public void saveMdcPerBranchSalesByBatch(List<MdcPerBranchSales> mdcPerBranchSalesList);

    public void removeMdcPerBranchSalesByDate(LocalDate date);

    public List<MdcPerBranchSales> findMdcPerBranchSalesByDate(LocalDate date);

}
