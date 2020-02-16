package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteProductListDeDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListDe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public NetsuiteProductListDe findNetsuiteProductListDeById(Integer id) {
        TypedQuery<NetsuiteProductListDe> query = em.createNamedQuery("findNetsuiteProductListDeById",
                NetsuiteProductListDe.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public NetsuiteProductListDe updateNetsuiteProductListDe(NetsuiteProductListDe netsuiteProductListDe) {
        return em.merge(netsuiteProductListDe);
    }

    @Override
    public void removeNetsuiteProductListDe(Integer id) {
        NetsuiteProductListDe netsuiteProductListDe = em.find(NetsuiteProductListDe.class, id);
        em.remove(netsuiteProductListDe);
    }

}
