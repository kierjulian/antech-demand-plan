package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolPerDoorsDAO;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public class ZolPerDoorsDAOImpl implements ZolPerDoorsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ZolPerDoors create(ZolPerDoors zolPerDoors) {
        entityManager.persist(zolPerDoors);
        entityManager.flush();
        return zolPerDoors;
    }

    @Override
    public List<ZolPerDoors> findByDate(LocalDate date) {
        TypedQuery<ZolPerDoors> query = entityManager.createNamedQuery("findByDate", ZolPerDoors.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    @Override
    public void remove(Integer id) {

    }

}
