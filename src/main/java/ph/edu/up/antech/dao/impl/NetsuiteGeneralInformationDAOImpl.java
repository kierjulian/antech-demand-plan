package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteGeneralInformationDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteGeneralInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class NetsuiteGeneralInformationDAOImpl implements NetsuiteGeneralInformationDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public NetsuiteGeneralInformation saveNetsuiteGeneralInformation(NetsuiteGeneralInformation netsuiteGeneralInformation) {
        em.persist(netsuiteGeneralInformation);
        em.flush();
        return netsuiteGeneralInformation;
    }

    @Override
    public List<NetsuiteGeneralInformation> findAllNetsuiteGeneralInformation() {
        TypedQuery<NetsuiteGeneralInformation> query = em.createNamedQuery("findAllNetsuiteGeneralInformation",
                NetsuiteGeneralInformation.class);
        return query.getResultList();
    }

}
