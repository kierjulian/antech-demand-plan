package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.MdcPerBranchSalesDAO;
import ph.edu.up.antech.domain.sales.master.MdcPerBranchSales;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
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

}
