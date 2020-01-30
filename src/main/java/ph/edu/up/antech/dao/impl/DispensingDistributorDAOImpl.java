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
@Transactional
public class DispensingDistributorDAOImpl implements DispensingDistributorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DispensingDistributor createDispensingDistributor(DispensingDistributor dispensingDistributor) {
        entityManager.persist(dispensingDistributor);
        entityManager.flush();
        return dispensingDistributor;
    }

    @Override
    public List<DispensingDistributor> findDispensingDistributorByDate(LocalDate localDate) {
        TypedQuery<DispensingDistributor> query = entityManager.createNamedQuery("findDispensingDistributorByDate",
                DispensingDistributor.class);
        query.setParameter("date", localDate);
        return query.getResultList();
    }

    @Override
    public void removeDispensingDistributor(Integer id) {
        DispensingDistributor dispensingDistributor = entityManager.find(DispensingDistributor.class, id);
        entityManager.remove(dispensingDistributor);
    }

    @Override
    public void saveDispensingDistributorByBatch(List<DispensingDistributor> dispensingDistributorList) {
        for (int i = 0; i < dispensingDistributorList.size(); i++) {
            if (i % 50 == 0) {
                entityManager.flush();
                entityManager.clear();
            }

            entityManager.persist(dispensingDistributorList.get(i));
        }
    }

    @Override
    public void removeDispensingDistributorByLocalDate(LocalDate localDate) {
        Query query = entityManager.createNamedQuery("deleteDispensingDistributorByLocalDate");
        query.setParameter("localDate", localDate);
        query.executeUpdate();
    }

}
