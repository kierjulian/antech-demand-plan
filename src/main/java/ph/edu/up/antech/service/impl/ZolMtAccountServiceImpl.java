package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolMtAccountDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;
import ph.edu.up.antech.service.ZolMtAccountService;

import java.util.List;

@Service
public class ZolMtAccountServiceImpl implements ZolMtAccountService {

    @Autowired
    private ZolMtAccountDAO zolMtAccountDAO;

    @Override
    public ZolMtAccount createZolMtAccount(ZolMtAccount zolMtAccount) {
        return zolMtAccountDAO.createZolMdcAccount(zolMtAccount);
    }

    @Override
    public ZolMtAccount findZolMtAccountByShpcn(String shpcn) {
        return zolMtAccountDAO.findZolMtAccountByShpcn(shpcn);
    }

    @Override
    public ZolMtAccount findZolMtAccountByBranchName(String branchName) {
        return zolMtAccountDAO.findZolMtAccountByBranchName(branchName);
    }

    @Override
    public List<ZolMtAccount> findAllZolMtAccount() {
        return zolMtAccountDAO.findAllZolMtAccount();
    }

}
