package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteTransfersCatDAO;
import ph.edu.up.antech.domain.master.config.NetsuiteTransfersCat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class NetsuiteTransfersCatDAOImpl implements NetsuiteTransfersCatDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public NetsuiteTransfersCat saveNetsuiteTransfersCat(NetsuiteTransfersCat netsuiteTransfersCat) {
        em.persist(netsuiteTransfersCat);
        em.flush();
        return netsuiteTransfersCat;
    }

    @Override
    public NetsuiteTransfersCat updateNetsuiteTransfersCat(NetsuiteTransfersCat netsuiteTransfersCat) {
        return em.merge(netsuiteTransfersCat);
    }

    @Override
    public NetsuiteTransfersCat findNetsuiteTransfersCatById(Integer id) {
        TypedQuery<NetsuiteTransfersCat> query = em.createNamedQuery("findNetsuiteTransfersCatById",
                NetsuiteTransfersCat.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void removeNetsuiteTransfersCat(Integer id) {
        NetsuiteTransfersCat netsuiteTransfersCat = em.find(NetsuiteTransfersCat.class, id);
        em.remove(netsuiteTransfersCat);
    }

    @Override
    public List<NetsuiteTransfersCat> findAllNetsuiteTransfersCat() {
        TypedQuery<NetsuiteTransfersCat> query = em.createNamedQuery("findAllNetsuiteTransfersCat",
                NetsuiteTransfersCat.class);
        return query.getResultList();
    }

}
