package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteTransferCatDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteTransferCat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class NetsuiteTransferCatDAOImpl implements NetsuiteTransferCatDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public NetsuiteTransferCat saveNetsuiteTransferCat(NetsuiteTransferCat netsuiteTransferCat) {
        em.persist(netsuiteTransferCat);
        em.flush();
        return netsuiteTransferCat;
    }

    @Override
    public NetsuiteTransferCat updateNetsuiteTransferCat(NetsuiteTransferCat netsuiteTransferCat) {
        return em.merge(netsuiteTransferCat);
    }

    @Override
    public NetsuiteTransferCat findNetsuiteTransferCatById(Integer id) {
        TypedQuery<NetsuiteTransferCat> query = em.createNamedQuery("findNetsuiteTransferCatById",
                NetsuiteTransferCat.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void removeNetsuiteTransferCat(Integer id) {
        NetsuiteTransferCat netsuiteTransferCat = em.find(NetsuiteTransferCat.class, id);
        em.remove(netsuiteTransferCat);
    }

    @Override
    public List<NetsuiteTransferCat> findAllNetsuiteTransferCat() {
        TypedQuery<NetsuiteTransferCat> query = em.createNamedQuery("findNetsuiteTransferCat",
                NetsuiteTransferCat.class);
        return query.getResultList();
    }

}
