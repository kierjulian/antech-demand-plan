package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.MdcPerBranchSalesNaConfigurationDAO;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesNaConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MdcPerBranchSalesNaConfigurationDAOImpl implements MdcPerBranchSalesNaConfigurationDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public MdcPerBranchSalesNaConfiguration saveMdcPerBranchSalesNaConfiguration(
            MdcPerBranchSalesNaConfiguration mdcPerBranchSalesNaConfiguration) {
        em.persist(mdcPerBranchSalesNaConfiguration);
        em.flush();
        return mdcPerBranchSalesNaConfiguration;
    }

    @Override
    public List<MdcPerBranchSalesNaConfiguration> findAllMdcPerBranchSalesNaConfiguration() {
        TypedQuery<MdcPerBranchSalesNaConfiguration> query = em.createNamedQuery(
                "findAllMdcPerBranchSalesNaConfiguration", MdcPerBranchSalesNaConfiguration.class);
        return query.getResultList();
    }

}