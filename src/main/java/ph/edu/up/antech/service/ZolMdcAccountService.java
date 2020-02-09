package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.ZolMdcAccount;

import java.util.List;

public interface ZolMdcAccountService {

    public ZolMdcAccount createZolMdcAccount(ZolMdcAccount zolMdcAccount);

    public ZolMdcAccount findZolMdcAccountByShpcn(String shpcn);

    public ZolMdcAccount findZolMdcAccountByBranchName(String branchName);

    public List<ZolMdcAccount> findAllZolMdcAccount();

    public ZolMdcAccount findZolMdcAccountById(Integer id);

    public ZolMdcAccount updateZolMdcAccount(ZolMdcAccount zolMdcAccount);

    public void removeZolMdcAccount(Integer id);

}
