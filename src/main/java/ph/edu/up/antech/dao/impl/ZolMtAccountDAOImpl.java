package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolMtAccountDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;
import ph.edu.up.antech.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ZolMtAccountDAOImpl implements ZolMtAccountDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public ZolMtAccount createZolMdcAccount(ZolMtAccount zolMtAccount) {
        em.persist(zolMtAccount);
        em.merge(zolMtAccount);
        return zolMtAccount;
    }

    @Override
    public ZolMtAccount findZolMtAccountByShpcn(String shpcn) {
        TypedQuery<ZolMtAccount> query =
                em.createNamedQuery("findZolMtAccountByShpcn", ZolMtAccount.class);
        query.setParameter("shpcn", shpcn);

        List<ZolMtAccount> zolMtAccounts = query.getResultList();
        return !StringUtils.isNullOrEmpty(zolMtAccounts) ? zolMtAccounts.get(0) : null;
    }

    @Override
    public ZolMtAccount findZolMtAccountByBranchName(String branchName) {
        TypedQuery<ZolMtAccount> query =
                em.createNamedQuery("findZolMtAccountByBranchName", ZolMtAccount.class);
        query.setParameter("branchName", branchName);

        List<ZolMtAccount> zolMtAccounts = query.getResultList();
        return !StringUtils.isNullOrEmpty(zolMtAccounts) ? zolMtAccounts.get(0) : null;
    }

    @Override
    public List<ZolMtAccount> findAllZolMtAccount() {
        TypedQuery<ZolMtAccount> query = em.createNamedQuery("findAllZolMtAccount",
                ZolMtAccount.class);
        return query.getResultList();
    }

    @Override
    public ZolMtAccount findZolMtAccountById(Integer id) {
        TypedQuery<ZolMtAccount> query = em.createNamedQuery("findZolMtAccountById", ZolMtAccount.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public ZolMtAccount updateZolMtAccount(ZolMtAccount zolMtAccount) {
        return em.merge(zolMtAccount);
    }

    @Override
    public void removeZolMtAccount(Integer id) {
        ZolMtAccount zolMtAccount = em.find(ZolMtAccount.class, id);
        em.remove(zolMtAccount);
    }

}
