package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.DispensingDistributorDAO;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public DispensingDistributor create(DispensingDistributor dispensingDistributor) {
        entityManager.persist(dispensingDistributor);
        entityManager.flush();
        return dispensingDistributor;
    }

    @Override
    public List<DispensingDistributor> findByDate(LocalDate localDate) {
        TypedQuery<DispensingDistributor> query = entityManager.createNamedQuery("findDispensingDistributorByDate",
                DispensingDistributor.class);
        query.setParameter("date", localDate);
        return query.getResultList();
    }

    @Override
    public void remove(Integer id) {
        DispensingDistributor dispensingDistributor = entityManager.find(DispensingDistributor.class, id);
        entityManager.remove(dispensingDistributor);
    }

}
