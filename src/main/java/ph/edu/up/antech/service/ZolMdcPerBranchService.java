package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.ZolMdcPerBranch;

import java.time.LocalDate;
import java.util.List;

public interface ZolMdcPerBranchService {

    public ZolMdcPerBranch createZolMdcPerBranch(ZolMdcPerBranch zolMdcPerBranch);

    public List<ZolMdcPerBranch> findZolMdcPerBranchByLocalDate(LocalDate localDate);

    public void removeZolMdcPerBranchById(Integer id);

}
