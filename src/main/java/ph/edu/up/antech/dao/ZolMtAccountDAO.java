package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;

import java.util.List;

public interface ZolMtAccountDAO {

    public ZolMtAccount createZolMdcAccount(ZolMtAccount mdcAccount);

    public ZolMtAccount findZolMtAccountByShpcn(String shpcn);

    public ZolMtAccount findZolMtAccountByBranchName(String branchName);

    public List<ZolMtAccount> findAllZolMtAccount();

}
