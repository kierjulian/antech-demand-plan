package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.MdcPerBranchSalesCodeDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesCode;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MdcPerBranchSalesCodeDAOImpl implements MdcPerBranchSalesCodeDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public MdcPerBranchSalesCode saveMdcPerBranchSalesCode(MdcPerBranchSalesCode mdcPerBranchSalesCode) {
        em.persist(mdcPerBranchSalesCode);
        em.flush();
        return mdcPerBranchSalesCode;
    }

    @Override
    public List<MdcPerBranchSalesCode> findAllMdcPerBranchSalesCode() {
        TypedQuery<MdcPerBranchSalesCode> query = em.createNamedQuery("findAllMdcPerBranchSalesCode", MdcPerBranchSalesCode.class);
        return query.getResultList();
    }

    @Override
    public MdcPerBranchSalesCode findMdcPerBranchSalesCodeById(Integer id) {
        TypedQuery<MdcPerBranchSalesCode> query = em.createNamedQuery("findMdcPerBranchSalesCodeById",
                MdcPerBranchSalesCode.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public MdcPerBranchSalesCode updateMdcPerBranchSalesCode(MdcPerBranchSalesCode mdcPerBranchSalesCode) {
        return em.merge(mdcPerBranchSalesCode);
    }

    @Override
    public void removeMdcPerBranchSalesCode(Integer id) {
        MdcPerBranchSalesCode mdcPerBranchSalesCode = em.find(MdcPerBranchSalesCode.class, id);
        em.remove(mdcPerBranchSalesCode);
    }

}
