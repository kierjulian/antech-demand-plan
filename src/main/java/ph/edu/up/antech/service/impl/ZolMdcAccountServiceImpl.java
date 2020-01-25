package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolMdcAccountDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolMdcAccount;
import ph.edu.up.antech.service.ZolMdcAccountService;

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

}
