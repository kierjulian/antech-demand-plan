package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteProductListDeDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListDe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class NetsuiteProductListDeDAOImpl implements NetsuiteProductListDeDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public NetsuiteProductListDe saveNetsuiteProductListDe(NetsuiteProductListDe netsuiteProductListDe) {
        em.persist(netsuiteProductListDe);
        em.flush();
        return netsuiteProductListDe;
    }

    @Override
    public List<NetsuiteProductListDe> findAllNetsuiteProductListDe() {
        TypedQuery<NetsuiteProductListDe> query = em.createNamedQuery("findAllNetsuiteProductListDe",
                NetsuiteProductListDe.class);
        return query.getResultList();
    }

}
