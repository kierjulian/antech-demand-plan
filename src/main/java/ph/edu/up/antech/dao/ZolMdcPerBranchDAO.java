package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.ZolMdcPerBranch;

import java.time.LocalDate;
import java.util.List;

public interface ZolMdcPerBranchDAO {

    public ZolMdcPerBranch createZolMdcPerBranch(ZolMdcPerBranch zolMdcPerBranch);

    public List<ZolMdcPerBranch> findZolMdcPerBranchByLocalDate(LocalDate localDate);

}
