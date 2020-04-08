package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.MdcPerBranchSalesAccountDAO;
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesAccount;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MdcPerBranchSalesAccountDAOImpl implements MdcPerBranchSalesAccountDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public MdcPerBranchSalesAccount saveMdcPerBranchSalesAccount(MdcPerBranchSalesAccount mdcPerBranchSalesAccount) {
        em.persist(mdcPerBranchSalesAccount);
        em.flush();
        return mdcPerBranchSalesAccount;
    }

    @Override
    public List<MdcPerBranchSalesAccount> findAllMdcPerBranchSalesAccount() {
        TypedQuery<MdcPerBranchSalesAccount> query = em.createNamedQuery("findAllMdcPerBranchSalesAccount",
                MdcPerBranchSalesAccount.class);
        return query.getResultList();
    }

    @Override
    public MdcPerBranchSalesAccount findMdcPerBranchSalesAccount(Integer id) {
        TypedQuery<MdcPerBranchSalesAccount> query = em.createNamedQuery("findMdcPerBranchSalesAccountById",
                MdcPerBranchSalesAccount.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public MdcPerBranchSalesAccount updateMdcPerBranchSalesAccount(MdcPerBranchSalesAccount mdcPerBranchSalesAccount) {
        return em.merge(mdcPerBranchSalesAccount);
    }

    @Override
    public void removeMdcPerBranchSalesAccount(Integer id) {
        MdcPerBranchSalesAccount mdcPerBranchSalesAccount = em.find(MdcPerBranchSalesAccount.class, id);
        em.remove(mdcPerBranchSalesAccount);
    }

}
