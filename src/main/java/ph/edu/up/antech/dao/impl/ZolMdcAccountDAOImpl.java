package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolMdcAccountDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolMdcAccount;
import ph.edu.up.antech.service.ZolMdcAccountService;
import ph.edu.up.antech.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ZolMdcAccountDAOImpl implements ZolMdcAccountDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public ZolMdcAccount createZolMdcAccount(ZolMdcAccount mdcAccount) {
        em.persist(mdcAccount);
        em.merge(mdcAccount);
        return mdcAccount;
    }

    @Override
    public ZolMdcAccount findZolMdcAccountByShpcn(String shpcn) {
        TypedQuery<ZolMdcAccount> query = em.createNamedQuery("findZolMdcAccountByShpcn", ZolMdcAccount.class);
        query.setParameter("shpcn", shpcn);

        List<ZolMdcAccount> zolMdcAccountList = query.getResultList();
        return !StringUtils.isNullOrEmpty(zolMdcAccountList) ? zolMdcAccountList.get(0) : null;
    }

}
