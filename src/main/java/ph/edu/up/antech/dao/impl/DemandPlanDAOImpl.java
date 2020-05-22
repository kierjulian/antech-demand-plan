package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.DemandPlanDAO;
import ph.edu.up.antech.domain.DemandPlan;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
        return em.merge(demandPlan);
    }

    @Override
    public DemandPlan findDemandPlanByProductIdAndYear(Integer productId, Year year) {
        TypedQuery<DemandPlan> query = em.createNamedQuery("findDemandPlanByProductIdAndYear",
                DemandPlan.class);
        query.setParameter("productId", productId);
        query.setParameter("year", year);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public DemandPlan findDemandPlanById(Integer id) {
        TypedQuery<DemandPlan> query = em.createNamedQuery("findDemandPlanById", DemandPlan.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Integer findOldestDemandPlanId() {
        try {
            return ((Number) em.createNativeQuery("select min(id) from demand_plan")
                    .getSingleResult()).intValue();
        } catch (Exception e) {
            return null;
        }
    }

}
