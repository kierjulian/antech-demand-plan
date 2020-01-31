package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.MdcPerBranchSalesAccountDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesAccount;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
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

}
