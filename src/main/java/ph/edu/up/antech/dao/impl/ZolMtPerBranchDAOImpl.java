package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolMtPerBranchDAO;
import ph.edu.up.antech.domain.sales.master.ZolMtPerBranch;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ZolMtPerBranchDAOImpl implements ZolMtPerBranchDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public ZolMtPerBranch createZolMtPerBranch(ZolMtPerBranch zolMtPerBranch) {
        em.persist(zolMtPerBranch);
        em.merge(zolMtPerBranch);
        return zolMtPerBranch;
    }

    @Override
    public List<ZolMtPerBranch> findZolMtPerBranchByLocalDate(LocalDate localDate) {
        TypedQuery<ZolMtPerBranch> query = em.createNamedQuery("findZolMtPerBranchByLocalDate",
                ZolMtPerBranch.class);
        query.setParameter("localDate", localDate);
        return query.getResultList();
    }

    @Override
    public void removeZolMtPerBranchById(Integer id) {
        ZolMtPerBranch zolMdcPerBranch = em.find(ZolMtPerBranch.class, id);
        em.remove(zolMdcPerBranch);
    }

    @Override
    public void removeZolMtPerBranchByLocalDate(LocalDate localDate) {
        Query query = em.createNamedQuery("deleteZolMtPerBranchByLocalDate");
        query.setParameter("localDate", localDate);
        query.executeUpdate();
    }

    @Override
    public void saveZolMtPerBranchByBatch(List<ZolMtPerBranch> zolMtPerBranchList) {
        for (int i = 0; i < zolMtPerBranchList.size(); i++) {
            if (i % 50 == 0) {
                em.flush();
                em.clear();
            }

            em.persist(zolMtPerBranchList.get(i));
        }
    }

    @Override
    public List<ZolMtPerBranch> findZolMtPerBranchBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        TypedQuery<ZolMtPerBranch> query = em.createNamedQuery("findZolMtPerBranchBetweenTwoDates", ZolMtPerBranch.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

}
