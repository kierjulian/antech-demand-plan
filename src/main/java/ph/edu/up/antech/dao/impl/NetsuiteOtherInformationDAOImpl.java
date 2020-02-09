package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteOtherInformationDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteOtherInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class NetsuiteOtherInformationDAOImpl implements NetsuiteOtherInformationDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public NetsuiteOtherInformation saveNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation) {
        em.persist(netsuiteOtherInformation);
        em.flush();
        return netsuiteOtherInformation;
    }

    @Override
    public List<NetsuiteOtherInformation> findAllNetsuiteOtherInformation() {
        TypedQuery<NetsuiteOtherInformation> query = em.createNamedQuery("findAllNetsuiteOtherInformation",
                NetsuiteOtherInformation.class);
        return query.getResultList();
    }

    @Override
    public NetsuiteOtherInformation findNetsuiteOtherInformationById(Integer id) {
        TypedQuery<NetsuiteOtherInformation> query = em.createNamedQuery("findNetsuiteOtherInformationById",
                NetsuiteOtherInformation.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public NetsuiteOtherInformation updateNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation) {
        return em.merge(netsuiteOtherInformation);
    }

    @Override
    public void removeNetsuiteOtherInformation(Integer id) {
        NetsuiteOtherInformation netsuiteOtherInformation = em.find(NetsuiteOtherInformation.class, id);
        em.remove(netsuiteOtherInformation);
    }

}
