package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.DispensingDistributorDAO;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public class DispensingDistributorDAOImpl implements DispensingDistributorDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public DispensingDistributor createDispensingDistributor(DispensingDistributor dispensingDistributor) {
        em.persist(dispensingDistributor);
        em.flush();
        return dispensingDistributor;
    }

    @Override
    public List<DispensingDistributor> findDispensingDistributorByDate(LocalDate localDate) {
        TypedQuery<DispensingDistributor> query = em.createNamedQuery("findDispensingDistributorByDate",
                DispensingDistributor.class);
        query.setParameter("date", localDate);
        return query.getResultList();
    }

    @Override
    public void removeDispensingDistributor(Integer id) {
        DispensingDistributor dispensingDistributor = em.find(DispensingDistributor.class, id);
        em.remove(dispensingDistributor);
    }

    @Override
    public void saveDispensingDistributorByBatch(List<DispensingDistributor> dispensingDistributorList) {
        for (int i = 0; i < dispensingDistributorList.size(); i++) {
            if (i % 50 == 0) {
                em.flush();
                em.clear();
            }

            em.persist(dispensingDistributorList.get(i));
        }
    }

    @Override
    public void removeDispensingDistributorByLocalDate(LocalDate localDate) {
        Query query = em.createNamedQuery("deleteDispensingDistributorByLocalDate");
        query.setParameter("localDate", localDate);
        query.executeUpdate();
    }

    @Override
    public DispensingDistributor findDispensingDistributorById(Integer id) {
        TypedQuery<DispensingDistributor> query = em.createNamedQuery("findDispensingDistributorById",
                DispensingDistributor.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public DispensingDistributor updateDispensingDistributor(DispensingDistributor dispensingDistributor) {
        return em.merge(dispensingDistributor);
    }

    @Override
    public List<DispensingDistributor> findDispensingDistributorBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        TypedQuery<DispensingDistributor> query = em.createNamedQuery("findDispensingDistributorBetweenTwoDates",
                DispensingDistributor.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

}
