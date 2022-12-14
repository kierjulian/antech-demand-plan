package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.master.config.ZolMdcAccount;

import java.util.List;

public interface ZolMdcAccountDAO {

    public ZolMdcAccount saveZolMdcAccount(ZolMdcAccount mdcAccount);

    public ZolMdcAccount findZolMdcAccountByShpcn(String shpcn);

    public ZolMdcAccount findZolMdcAccountByBranchName(String branchName);

    public List<ZolMdcAccount> findAllZOlMdcAccount();

    public ZolMdcAccount findZolMdcAccountById(Integer id);

    public ZolMdcAccount updateZolMdcAccount(ZolMdcAccount zolMdcAccount);

    public void removeZolMdcAccount(Integer id);

}
