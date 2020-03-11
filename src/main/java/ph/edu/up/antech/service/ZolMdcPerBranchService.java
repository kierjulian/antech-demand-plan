package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.ZolMdcPerBranch;

import java.time.LocalDate;
import java.util.List;

public interface ZolMdcPerBranchService {

    public ZolMdcPerBranch saveZolMdcPerBranch(ZolMdcPerBranch zolMdcPerBranch);

    public List<ZolMdcPerBranch> findZolMdcPerBranchByLocalDate(LocalDate localDate);

    public void removeZolMdcPerBranchById(Integer id);

    public void removeZolMdcPerBranchByLocalDate(LocalDate localDate);

    public void saveZolMdcPerBranchByBatch(List<ZolMdcPerBranch> zolMdcPerBranchList);

    public List<ZolMdcPerBranch> findZolMdcPerBranchBetweenTwoDates(LocalDate startDate, LocalDate endDate);

    public ZolMdcPerBranch findZolMdcPerBranch(Integer id);

    public ZolMdcPerBranch updateZolMdcPerBranch(ZolMdcPerBranch zolMdcPerBranch);

    public List<ZolMdcPerBranch> findZolMdcPerBranchSalesAmountAndUnitBetweenTwoDates(LocalDate startDate, LocalDate endDate);

}
