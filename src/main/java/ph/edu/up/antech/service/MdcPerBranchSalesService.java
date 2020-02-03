package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.MdcPerBranchSales;

import java.time.LocalDate;
import java.util.List;

public interface MdcPerBranchSalesService {

    public void saveMdcPerBranchSalesByBatch(List<MdcPerBranchSales> mdcPerBranchSalesList);

    public void removeMdcPerBranchSalesByDate(LocalDate date);

}
