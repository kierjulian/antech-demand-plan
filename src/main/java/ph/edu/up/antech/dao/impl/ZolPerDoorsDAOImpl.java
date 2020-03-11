package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolPerDoorsDAO;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ZolPerDoorsDAOImpl implements ZolPerDoorsDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public ZolPerDoors saveZolPerDoors(ZolPerDoors zolPerDoors) {
        em.persist(zolPerDoors);
        em.flush();
        return zolPerDoors;
    }

    @Override
    public List<ZolPerDoors> findZolPerDoorsByDate(LocalDate date) {
        TypedQuery<ZolPerDoors> query = em.createNamedQuery("findZolPerDoorsByDate", ZolPerDoors.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    @Override
    public void removeZolPerDoors(Integer id) {
        ZolPerDoors zolPerDoors = em.find(ZolPerDoors.class, id);
        em.remove(zolPerDoors);
    }

    @Override
    public List<String> findDistinctZolPerDoorsKamReferenceNameByLocalDate(LocalDate localDate) {
        TypedQuery<String> query = em.createNamedQuery(
                "findDistinctZolPerDoorsKamReferenceNameByLocalDate", String.class);
        query.setParameter("localDate", localDate);
        return query.getResultList();
    }

    @Override
    public List<String> findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(LocalDate localDate) {
        TypedQuery<String> query = em.createNamedQuery(
                "findDistinctZolPerDoorsAntechProductDescriptionByLocalDate", String.class);
        query.setParameter("localDate", localDate);
        return query.getResultList();
    }

    @Override
    public List<ZolPerDoors> findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(
            LocalDate localDate, String kamReferenceName, String antechProductDescription) {
        TypedQuery<ZolPerDoors> query = em.createNamedQuery("findZolPerDoorsByKamReferenceNameAndProductDescriptionAndLocalDate",
                ZolPerDoors.class);
        query.setParameter("localDate", localDate);
        query.setParameter("kamReferenceName", kamReferenceName);
        query.setParameter("antechProductDescription", antechProductDescription);
        return query.getResultList();
    }

    @Override
    public List<String> findDistinctZolPerDoorsAccountByLocalDate(LocalDate localDate) {
        TypedQuery<String> query = em.createNamedQuery("findDistinctZolPerDoorsAccountByLocalDate",
                String.class);
        query.setParameter("localDate", localDate);
        return query.getResultList();
    }

    @Override
    public void removeZolPerDoorsByLocalDate(LocalDate localDate) {
        Query query = em.createNamedQuery("deleteZolPerDoorsByLocalDate");
        query.setParameter("localDate", localDate);
        query.executeUpdate();
    }

    @Override
    public void saveZolPerDoorsByBatch(List<ZolPerDoors> zolPerDoorsList) {
        for (int i = 0; i < zolPerDoorsList.size(); i++) {
            if (i % 50 == 0) {
                em.flush();
                em.clear();
            }

            em.persist(zolPerDoorsList.get(i));
        }
    }

    @Override
    public List<ZolPerDoors> findZolPerDoorsBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        TypedQuery<ZolPerDoors> query = em.createNamedQuery("findZolPerDoorsBetweenTwoDate",
                ZolPerDoors.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    @Override
    public ZolPerDoors findZolPerDoorsById(Integer id) {
        TypedQuery<ZolPerDoors> query = em.createNamedQuery("findZolPerDoorsById", ZolPerDoors.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public ZolPerDoors updateZolPerDoors(ZolPerDoors zolPerDoors) {
        return em.merge(zolPerDoors);
    }

    @Override
    public List<ZolPerDoors> findZolPerDoorsSalesAmountAndUnitBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        Query query = em.createNamedQuery("findZolPerDoorsSalesAmountAndUnitBetweenTwoDates");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<ZolPerDoors> zolPerDoorsList = query.getResultList();
        return zolPerDoorsList;
    }

}
