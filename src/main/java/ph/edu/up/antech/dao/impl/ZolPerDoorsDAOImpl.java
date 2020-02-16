package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolPerDoorsDAO;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ZolPerDoorsDAOImpl implements ZolPerDoorsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ZolPerDoors createZolPerDoors(ZolPerDoors zolPerDoors) {
        entityManager.persist(zolPerDoors);
        entityManager.flush();
        return zolPerDoors;
    }

    @Override
    public List<ZolPerDoors> findZolPerDoorsByDate(LocalDate date) {
        TypedQuery<ZolPerDoors> query = entityManager.createNamedQuery("findZolPerDoorsByDate", ZolPerDoors.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    @Override
    public void removeZolPerDoors(Integer id) {
        ZolPerDoors zolPerDoors = entityManager.find(ZolPerDoors.class, id);
        entityManager.remove(zolPerDoors);
    }

    @Override
    public List<String> findDistinctZolPerDoorsKamReferenceNameByLocalDate(LocalDate localDate) {
        TypedQuery<String> query = entityManager.createNamedQuery(
                "findDistinctZolPerDoorsKamReferenceNameByLocalDate", String.class);
        query.setParameter("localDate", localDate);
        return query.getResultList();
    }

    @Override
    public List<String> findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(LocalDate localDate) {
        TypedQuery<String> query = entityManager.createNamedQuery(
                "findDistinctZolPerDoorsAntechProductDescriptionByLocalDate", String.class);
        query.setParameter("localDate", localDate);
        return query.getResultList();
    }

    @Override
    public List<ZolPerDoors> findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(
            LocalDate localDate, String kamReferenceName, String antechProductDescription) {
        TypedQuery<ZolPerDoors> query = entityManager.createNamedQuery("findZolPerDoorsByKamReferenceNameAndProductDescriptionAndLocalDate",
                ZolPerDoors.class);
        query.setParameter("localDate", localDate);
        query.setParameter("kamReferenceName", kamReferenceName);
        query.setParameter("antechProductDescription", antechProductDescription);
        return query.getResultList();
    }

    @Override
    public List<String> findDistinctZolPerDoorsAccountByLocalDate(LocalDate localDate) {
        TypedQuery<String> query = entityManager.createNamedQuery("findDistinctZolPerDoorsAccountByLocalDate",
                String.class);
        query.setParameter("localDate", localDate);
        return query.getResultList();
    }

    @Override
    public void removeZolPerDoorsByLocalDate(LocalDate localDate) {
        Query query = entityManager.createNamedQuery("deleteZolPerDoorsByLocalDate");
        query.setParameter("localDate", localDate);
        query.executeUpdate();
    }

    @Override
    public void saveZolPerDoorsByBatch(List<ZolPerDoors> zolPerDoorsList) {
        for (int i = 0; i < zolPerDoorsList.size(); i++) {
            if (i % 50 == 0) {
                entityManager.flush();
                entityManager.clear();
            }

            entityManager.persist(zolPerDoorsList.get(i));
        }
    }

}
