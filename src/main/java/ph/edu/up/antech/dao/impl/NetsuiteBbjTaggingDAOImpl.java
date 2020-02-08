package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteBbjTaggingDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBbjTagging;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class NetsuiteBbjTaggingDAOImpl implements NetsuiteBbjTaggingDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public NetsuiteBbjTagging createNetsuiteBbjTagging(NetsuiteBbjTagging netsuiteBbjTagging) {
        entityManager.persist(netsuiteBbjTagging);
        entityManager.flush();
        return netsuiteBbjTagging;
    }

    @Override
    public List<NetsuiteBbjTagging> findAllNetsuiteBbjTagging() {
        TypedQuery<NetsuiteBbjTagging> query = entityManager.createNamedQuery("findAllNetsuiteBbjTagging",
                NetsuiteBbjTagging.class);
        return query.getResultList();
    }

}
