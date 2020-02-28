package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.ZolMtPerBranch;

import java.time.LocalDate;
import java.util.List;

public interface ZolMtPerBranchDAO {

    public ZolMtPerBranch saveZolMtPerBranch(ZolMtPerBranch zolMtPerBranch);

    public List<ZolMtPerBranch> findZolMtPerBranchByLocalDate(LocalDate localDate);

    public void removeZolMtPerBranchById(Integer id);

    public void removeZolMtPerBranchByLocalDate(LocalDate localDate);

    public void saveZolMtPerBranchByBatch(List<ZolMtPerBranch> zolMtPerBranchList);

    public List<ZolMtPerBranch> findZolMtPerBranchBetweenTwoDates(LocalDate startDate, LocalDate endDate);

    public ZolMtPerBranch findZolMtPerBranchById(Integer id);

    public ZolMtPerBranch updateZolMtPerBranch(ZolMtPerBranch zolMtPerBranch);

}
