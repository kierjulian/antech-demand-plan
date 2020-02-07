package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteProductListSourceDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListSource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
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

}
