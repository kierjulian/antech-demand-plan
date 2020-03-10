package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;

import java.util.List;

public interface ZolMtAccountService {

    public ZolMtAccount saveZolMtAccount(ZolMtAccount zolMtAccount);

    public ZolMtAccount findZolMtAccountByShpcn(String shpcn);

    public ZolMtAccount findZolMtAccountByBranchName(String branchName);

    public List<ZolMtAccount> findAllZolMtAccount();

    public ZolMtAccount findZolMtAccountById(Integer id);

    public ZolMtAccount updateZolMtAccount(ZolMtAccount zolMtAccount);

    public void removeZolMtAccount(Integer id);

    public Page<ZolMtAccount> findAll(Pageable pageable);

    public Page<ZolMtAccount> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
