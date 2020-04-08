package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.MdcPerBranchSalesCoverageDAO;
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesCoverage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MdcPerBranchSalesCoverageDAOImpl implements MdcPerBranchSalesCoverageDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public MdcPerBranchSalesCoverage saveMdcPerBranchSalesCoverage(MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage) {
        em.persist(mdcPerBranchSalesCoverage);
        em.flush();
        return mdcPerBranchSalesCoverage;
    }

    @Override
    public List<MdcPerBranchSalesCoverage> findAllMdcPerBranchSalesCoverage() {
        TypedQuery<MdcPerBranchSalesCoverage> query = em.createNamedQuery("findAllMdcPerBranchSalesCoverage",
                MdcPerBranchSalesCoverage.class);
        return query.getResultList();
    }

    @Override
    public MdcPerBranchSalesCoverage findMdcPerBranchSalesCoverageById(Integer id) {
        TypedQuery<MdcPerBranchSalesCoverage> query = em.createNamedQuery("findMdcPerBranchSalesCoverageById",
                MdcPerBranchSalesCoverage.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public MdcPerBranchSalesCoverage updateMdcPerBranchSalesCoverage(MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage) {
        return em.merge(mdcPerBranchSalesCoverage);
    }

    @Override
    public void removeMdcPerBranchSalesCoverage(Integer id) {
        MdcPerBranchSalesCoverage mdcPerBranchSalesCoverage = em.find(MdcPerBranchSalesCoverage.class, id);
        em.remove(mdcPerBranchSalesCoverage);
    }

}
