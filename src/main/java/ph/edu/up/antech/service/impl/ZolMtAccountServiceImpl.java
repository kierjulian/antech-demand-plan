package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolMtAccountDAO;
import ph.edu.up.antech.dao.pagination.ZolMtAccountPaginationDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;
import ph.edu.up.antech.service.ZolMtAccountService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ZolMtAccountServiceImpl implements ZolMtAccountService {

    @Autowired
    private ZolMtAccountDAO zolMtAccountDAO;

    @Autowired
    private ZolMtAccountPaginationDAO zolMtAccountPaginationDAO;

    @Override
    public ZolMtAccount saveZolMtAccount(ZolMtAccount zolMtAccount) {
        return zolMtAccountDAO.saveZolMtAccount(zolMtAccount);
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

    @Override
    public ZolMtAccount findZolMtAccountById(Integer id) {
        return zolMtAccountDAO.findZolMtAccountById(id);
    }

    @Override
    public ZolMtAccount updateZolMtAccount(ZolMtAccount zolMtAccount) {
        return zolMtAccountDAO.updateZolMtAccount(zolMtAccount);
    }

    @Override
    public void removeZolMtAccount(Integer id) {
        zolMtAccountDAO.removeZolMtAccount(id);
    }

    @Override
    public Page<ZolMtAccount> findAll(Pageable pageable) {
        return zolMtAccountPaginationDAO.findAll(pageable);
    }

    @Override
    public Page<ZolMtAccount> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return zolMtAccountPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
