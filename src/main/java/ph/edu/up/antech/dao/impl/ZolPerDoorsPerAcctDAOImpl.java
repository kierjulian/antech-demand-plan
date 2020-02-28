package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolPerDoorsPerAcctDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ZolPerDoorsPerAcctDAOImpl implements ZolPerDoorsPerAcctDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public ZolPerDoorsPerAcct saveZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct) {
        em.persist(zolPerDoorsPerAcct);
        em.flush();
        return zolPerDoorsPerAcct;
    }

    @Override
    public ZolPerDoorsPerAcct findZolPerDoorsPerAcctByZol(String zol) {
        TypedQuery<ZolPerDoorsPerAcct> query = em
                .createNamedQuery("findZolPerDoorsPerAcctByZol", ZolPerDoorsPerAcct.class);
        query.setParameter("zol", zol);

        List<ZolPerDoorsPerAcct> zolPerDoorsPerAcctList = query.getResultList();
        if (zolPerDoorsPerAcctList != null && !zolPerDoorsPerAcctList.isEmpty()) {
            return zolPerDoorsPerAcctList.get(0);
        }

        return null;
    }

    @Override
    public List<ZolPerDoorsPerAcct> findAllZolPerDoorsPerAcct() {
        TypedQuery<ZolPerDoorsPerAcct> query = em
                .createNamedQuery("findAllZolPerDoorsPerAcct", ZolPerDoorsPerAcct.class);
        return query.getResultList();
    }

    @Override
    public ZolPerDoorsPerAcct findZolPerDoorsPerAcctById(Integer id) {
        TypedQuery<ZolPerDoorsPerAcct> query = em.createNamedQuery("findZolPerDoorsPerAcctById",
                ZolPerDoorsPerAcct.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public ZolPerDoorsPerAcct updateZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct) {
        return em.merge(zolPerDoorsPerAcct);
    }

    @Override
    public void removeZolPerDoorsPerAcct(Integer id) {
        ZolPerDoorsPerAcct zolPerDoorsPerAcct = em.find(ZolPerDoorsPerAcct.class, id);
        em.remove(zolPerDoorsPerAcct);
    }

}
