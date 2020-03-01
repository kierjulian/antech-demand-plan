package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.DemandPlanDAO;
import ph.edu.up.antech.domain.DemandPlan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Year;

@Repository
public class DemandPlanDAOImpl implements DemandPlanDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public DemandPlan saveDemandPlan(DemandPlan demandPlan) {
        em.persist(demandPlan);
        em.flush();
        return demandPlan;
    }

    @Override
    public DemandPlan updateDemandPlan(DemandPlan demandPlan) {
        return null;
    }

    @Override
    public DemandPlan findDemandPlanByProductIdAndYear(Integer productId, Year year) {
        return null;
    }

}
