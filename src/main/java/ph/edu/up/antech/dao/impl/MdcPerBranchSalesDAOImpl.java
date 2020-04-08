package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.MdcPerBranchSalesDAO;
import ph.edu.up.antech.domain.master.MdcPerBranchSales;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class MdcPerBranchSalesDAOImpl implements MdcPerBranchSalesDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveMdcPerBranchSalesByBatch(List<MdcPerBranchSales> mdcPerBranchSalesList) {
        for (int i = 0; i < mdcPerBranchSalesList.size(); i++) {
            if (i % 50 == 0) {
                em.flush();
                em.clear();
            }

            em.persist(mdcPerBranchSalesList.get(i));
        }
    }

    @Override
    public void removeMdcPerBranchSalesByDate(LocalDate date) {
        Query query = em.createNamedQuery("deleteMdcPerBranchSalesByDate");
        query.setParameter("date", date);
        query.executeUpdate();
    }

    @Override
    public List<MdcPerBranchSales> findMdcPerBranchSalesByDate(LocalDate date) {
        TypedQuery<MdcPerBranchSales> query = em.createNamedQuery("findMdcPerBranchSalesByDate",
                MdcPerBranchSales.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    @Override
    public MdcPerBranchSales findMdcPerBranchSalesById(Integer id) {
        TypedQuery<MdcPerBranchSales> query = em.createNamedQuery("findMdcPerBranchSalesById",
                MdcPerBranchSales.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public MdcPerBranchSales saveMdcPerBranchSales(MdcPerBranchSales mdcPerBranchSales) {
        em.persist(mdcPerBranchSales);
        em.flush();
        return mdcPerBranchSales;
    }

    @Override
    public MdcPerBranchSales updateMdcPerBranchSales(MdcPerBranchSales mdcPerBranchSales) {
        return em.merge(mdcPerBranchSales);
    }

    @Override
    public void removeMdcPerBranchSales(Integer id) {
        MdcPerBranchSales mdcPerBranchSales = em.find(MdcPerBranchSales.class, id);
        em.remove(mdcPerBranchSales);
    }

    @Override
    public List<MdcPerBranchSales> findMdcPerBranchSalesBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        TypedQuery<MdcPerBranchSales> query = em.createNamedQuery("findMdcPerBranchSalesBetweenTwoDates",
                MdcPerBranchSales.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

}
