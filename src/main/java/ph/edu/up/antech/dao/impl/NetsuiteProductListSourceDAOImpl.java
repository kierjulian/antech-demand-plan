package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteProductListSourceDAO;
import ph.edu.up.antech.domain.master.config.NetsuiteProductListSource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class NetsuiteProductListSourceDAOImpl implements NetsuiteProductListSourceDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public NetsuiteProductListSource saveNetsuiteProductListSource(NetsuiteProductListSource netsuiteProductListSource) {
        em.persist(netsuiteProductListSource);
        em.flush();
        return netsuiteProductListSource;
    }

    @Override
    public List<NetsuiteProductListSource> findAllNetsuiteProductListSource() {
        TypedQuery<NetsuiteProductListSource> query = em.createNamedQuery("findAllNetsuiteProductListSource",
                NetsuiteProductListSource.class);
        return query.getResultList();
    }

    @Override
    public NetsuiteProductListSource findNetsuiteProductListSourceById(Integer id) {
        TypedQuery<NetsuiteProductListSource> query = em.createNamedQuery("findNetsuiteProductListSourceById",
                NetsuiteProductListSource.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public NetsuiteProductListSource updateNetsuiteProductListSource(NetsuiteProductListSource netsuiteProductListSource) {
        return em.merge(netsuiteProductListSource);
    }

    @Override
    public void removeNetsuiteProductListSource(Integer id) {
        NetsuiteProductListSource netsuiteProductListSource = em.find(NetsuiteProductListSource.class, id);
        em.remove(netsuiteProductListSource);
    }

}
