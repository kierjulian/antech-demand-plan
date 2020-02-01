package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.MdcPerBranchSalesCoverageDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesCoverage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
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

}
