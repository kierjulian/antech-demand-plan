package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolPerDoorsDAO;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;

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
    public ZolPerDoors findByDate(LocalDate date) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

}
