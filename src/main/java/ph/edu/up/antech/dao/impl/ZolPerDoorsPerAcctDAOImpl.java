package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolPerDoorsPerAcctDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ZolPerDoorsPerAcctDAOImpl implements ZolPerDoorsPerAcctDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ZolPerDoorsPerAcct createZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct) {
        entityManager.persist(zolPerDoorsPerAcct);
        entityManager.flush();
        return zolPerDoorsPerAcct;
    }

    @Override
    public ZolPerDoorsPerAcct findZolPerDoorsPerAcctByZol(String zol) {
        TypedQuery<ZolPerDoorsPerAcct> query = entityManager
                .createNamedQuery("findZolPerDoorsPerAcctByZol", ZolPerDoorsPerAcct.class);
        query.setParameter("zol", zol);

        List<ZolPerDoorsPerAcct> zolPerDoorsPerAcctList = query.getResultList();
        if (zolPerDoorsPerAcctList != null && !zolPerDoorsPerAcctList.isEmpty()) {
            return zolPerDoorsPerAcctList.get(0);
        }

        return null;
    }

}
