package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolMdcAccountDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolMdcAccount;
import ph.edu.up.antech.service.ZolMdcAccountService;

import java.util.List;

@Service
public class ZolMdcAccountServiceImpl implements ZolMdcAccountService {

    @Autowired
    private ZolMdcAccountDAO zolMdcAccountDAO;

    @Override
    public ZolMdcAccount createZolMdcAccount(ZolMdcAccount zolMdcAccount) {
        return zolMdcAccountDAO.createZolMdcAccount(zolMdcAccount);
    }

    @Override
    public ZolMdcAccount findZolMdcAccountByShpcn(String shpcn) {
        return zolMdcAccountDAO.findZolMdcAccountByShpcn(shpcn);
    }

    @Override
    public ZolMdcAccount findZolMdcAccountByBranchName(String branchName) {
        return zolMdcAccountDAO.findZolMdcAccountByBranchName(branchName);
    }

    @Override
    public List<ZolMdcAccount> findAllZolMdcAccount() {
        return zolMdcAccountDAO.findAllZOlMdcAccount();
    }

    @Override
    public ZolMdcAccount findZolMdcAccountById(Integer id) {
        return zolMdcAccountDAO.findZolMdcAccountById(id);
    }

    @Override
    public ZolMdcAccount updateZolMdcAccount(ZolMdcAccount zolMdcAccount) {
        return zolMdcAccountDAO.updateZolMdcAccount(zolMdcAccount);
    }

    @Override
    public void removeZolMdcAccount(Integer id) {
        zolMdcAccountDAO.removeZolMdcAccount(id);
    }

}
