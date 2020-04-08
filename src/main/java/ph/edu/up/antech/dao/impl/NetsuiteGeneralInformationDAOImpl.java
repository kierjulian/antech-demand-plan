package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteGeneralInformationDAO;
import ph.edu.up.antech.domain.master.config.NetsuiteGeneralInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public NetsuiteGeneralInformation findNetsuiteGeneralInformationById(Integer id) {
        TypedQuery<NetsuiteGeneralInformation> query = em.createNamedQuery("findNetsuiteGeneralInformationById",
                NetsuiteGeneralInformation.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public NetsuiteGeneralInformation updateNetsuiteGeneralInformation(NetsuiteGeneralInformation netsuiteGeneralInformation) {
        return em.merge(netsuiteGeneralInformation);
    }

    @Override
    public void removeNetsuiteGeneralInformation(Integer id) {
        NetsuiteGeneralInformation netsuiteGeneralInformation = em.find(NetsuiteGeneralInformation.class, id);
        em.remove(netsuiteGeneralInformation);
    }

}
