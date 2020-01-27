package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.ZolMtPerBranch;

import java.time.LocalDate;
import java.util.List;

public interface ZolMtPerBranchService {

    public ZolMtPerBranch createZolMtPerBranch(ZolMtPerBranch zolMtPerBranch);

    public List<ZolMtPerBranch> findZolMtPerBranchByLocalDate(LocalDate localDate);

    public void removeZolMtPerBranchById(Integer id);

}
