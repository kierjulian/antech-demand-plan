package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.ZolMtPerBranch;

import java.time.LocalDate;
import java.util.List;

public interface ZolMtPerBranchDAO {

    public ZolMtPerBranch createZolMtPerBranch(ZolMtPerBranch zolMtPerBranch);

    public List<ZolMtPerBranch> findZolMtPerBranchByLocalDate(LocalDate localDate);

    public void removeZolMtPerBranchById(Integer id);

}
