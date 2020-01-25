package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolMdcAccountDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolMdcAccount;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

}
