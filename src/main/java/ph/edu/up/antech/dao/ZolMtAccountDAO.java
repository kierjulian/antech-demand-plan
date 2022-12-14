package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.master.config.ZolMtAccount;

import java.util.List;

public interface ZolMtAccountDAO {

    public ZolMtAccount saveZolMtAccount(ZolMtAccount mdcAccount);

    public ZolMtAccount findZolMtAccountByShpcn(String shpcn);

    public ZolMtAccount findZolMtAccountByBranchName(String branchName);

    public List<ZolMtAccount> findAllZolMtAccount();

    public ZolMtAccount findZolMtAccountById(Integer id);

    public ZolMtAccount updateZolMtAccount(ZolMtAccount zolMtAccount);

    public void removeZolMtAccount(Integer id);

}
