package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.MdcPerBranchSalesInformationDAO;
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public MdcPerBranchSalesInformation findMdcPerBranchSalesInformation(Integer id) {
        TypedQuery<MdcPerBranchSalesInformation> query = em.createNamedQuery("findMdcPerBranchSalesInformationById",
                MdcPerBranchSalesInformation.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public MdcPerBranchSalesInformation updateMdcPerBranchSalesInformation(MdcPerBranchSalesInformation mdcPerBranchSalesInformation) {
        return em.merge(mdcPerBranchSalesInformation);
    }

    @Override
    public void removeMdcPerBranchSalesInformation(Integer id) {
        MdcPerBranchSalesInformation mdcPerBranchSalesInformation = em.find(MdcPerBranchSalesInformation.class, id);
        em.remove(mdcPerBranchSalesInformation);
    }

}
