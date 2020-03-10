package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.sales.master.converter.ZolMdcAccount;

import java.util.List;

public interface ZolMdcAccountService {

    public ZolMdcAccount saveZolMdcAccount(ZolMdcAccount zolMdcAccount);

    public ZolMdcAccount findZolMdcAccountByShpcn(String shpcn);

    public ZolMdcAccount findZolMdcAccountByBranchName(String branchName);

    public List<ZolMdcAccount> findAllZolMdcAccount();

    public ZolMdcAccount findZolMdcAccountById(Integer id);

    public ZolMdcAccount updateZolMdcAccount(ZolMdcAccount zolMdcAccount);

    public void removeZolMdcAccount(Integer id);

    public Page<ZolMdcAccount> findAll(Pageable pageable);

    public Page<ZolMdcAccount> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
