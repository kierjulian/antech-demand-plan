package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;

public interface ZolMtAccountDAO {

    public ZolMtAccount createZolMdcAccount(ZolMtAccount mdcAccount);

    public ZolMtAccount findZolMtAccountByShpcn(String shpcn);

    public ZolMtAccount findZolMtAccountByBranchName(String branchName);

}
