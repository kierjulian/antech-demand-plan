package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteBbjTaggingDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBbjTagging;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class NetsuiteBbjTaggingDAOImpl implements NetsuiteBbjTaggingDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public NetsuiteBbjTagging createNetsuiteBbjTagging(NetsuiteBbjTagging netsuiteBbjTagging) {
        em.persist(netsuiteBbjTagging);
        em.flush();
        return netsuiteBbjTagging;
    }

    @Override
    public List<NetsuiteBbjTagging> findAllNetsuiteBbjTagging() {
        TypedQuery<NetsuiteBbjTagging> query = em.createNamedQuery("findAllNetsuiteBbjTagging",
                NetsuiteBbjTagging.class);
        return query.getResultList();
    }

    @Override
    public NetsuiteBbjTagging findNetsuiteBbjTaggingById(Integer id) {
        TypedQuery<NetsuiteBbjTagging> query = em.createNamedQuery("findNetsuiteBbjTaggingById",
                NetsuiteBbjTagging.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public NetsuiteBbjTagging updateNetsuiteBbjTagging(NetsuiteBbjTagging netsuiteBbjTagging) {
        return em.merge(netsuiteBbjTagging);
    }

    @Override
    public void removeNetsuiteBbjTagging(Integer id) {
        NetsuiteBbjTagging netsuiteBbjTagging = em.find(NetsuiteBbjTagging.class, id);
        em.remove(netsuiteBbjTagging);
    }

}
