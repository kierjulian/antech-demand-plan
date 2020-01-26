package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;

public interface ZolMtAccountService {

    public ZolMtAccount createZolMtAccount(ZolMtAccount zolMtAccount);

    public ZolMtAccount findZolMtAccountByShpcn(String shpcn);

    public ZolMtAccount findZolMtAccountByBranchName(String branchName);

}
