package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolMdcPerBranchDAO;
import ph.edu.up.antech.domain.sales.master.ZolMdcPerBranch;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
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

}
