package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolMdcPerBranchDAO;
import ph.edu.up.antech.domain.sales.master.ZolMdcPerBranch;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ZolMdcPerBranchDAOImpl implements ZolMdcPerBranchDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public ZolMdcPerBranch createZolMdcPerBranch(ZolMdcPerBranch zolMdcPerBranch) {
        em.persist(zolMdcPerBranch);
        em.merge(zolMdcPerBranch);
        return zolMdcPerBranch;
    }

    @Override
    public List<ZolMdcPerBranch> findZolMdcPerBranchByLocalDate(LocalDate localDate) {
        TypedQuery<ZolMdcPerBranch> query = em.createNamedQuery("findZolMdcPerBranchByLocalDate",
                ZolMdcPerBranch.class);
        query.setParameter("localDate", localDate);
        return query.getResultList();
    }

    @Override
    public void removeZolMdcPerBranchById(Integer id) {
        ZolMdcPerBranch zolMdcPerBranch = em.find(ZolMdcPerBranch.class, id);
        em.remove(zolMdcPerBranch);
    }

    @Override
    public void removeZolMdcPerBranchByLocalDate(LocalDate localDate) {
        Query query = em.createNamedQuery("deleteZolMdcPerBranchByLocalDate");
        query.setParameter("localDate", localDate);
        query.executeUpdate();
    }

    @Override
    public void saveZolMdcPerBranchByBatch(List<ZolMdcPerBranch> zolMdcPerBranchList) {
        for (int i = 0; i < zolMdcPerBranchList.size(); i++) {
            if (i % 50 == 0) {
                em.flush();
                em.clear();
            }

            em.persist(zolMdcPerBranchList.get(i));
        }
    }

}
