package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.MdcPerBranchSalesInformationDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class MdcPerBranchSalesInformationDAOImpl implements MdcPerBranchSalesInformationDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public MdcPerBranchSalesInformation saveMdcPerBranchSalesInformation(MdcPerBranchSalesInformation mdcPerBranchSalesInformation) {
        em.persist(mdcPerBranchSalesInformation);
        em.flush();
        return mdcPerBranchSalesInformation;
    }

    @Override
    public List<MdcPerBranchSalesInformation> findAllMdcPerBranchSalesInformation() {
        TypedQuery<MdcPerBranchSalesInformation> query = em.createNamedQuery(
                "findAllMdcPerBranchSalesInformation", MdcPerBranchSalesInformation.class);
        return query.getResultList();
    }

}
