package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.MdcPerBranchSalesBrnDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesBrn;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MdcPerBranchSalesBrnDAOImpl implements MdcPerBranchSalesBrnDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public MdcPerBranchSalesBrn saveMdcPerBranchSalesBrn(MdcPerBranchSalesBrn mdcPerBranchSalesBrn) {
        em.persist(mdcPerBranchSalesBrn);
        em.flush();
        return mdcPerBranchSalesBrn;
    }

    @Override
    public List<MdcPerBranchSalesBrn> findAllMdcPerBranchSalesBrn() {
        TypedQuery<MdcPerBranchSalesBrn> query = em.createNamedQuery("findAllMdcPerBranchSalesBrn",
                MdcPerBranchSalesBrn.class);
        return query.getResultList();
    }

}
