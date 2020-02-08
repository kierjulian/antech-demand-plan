package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteBjjTaggingDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBjjTagging;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class NetsuiteBjjTaggingDAOImpl implements NetsuiteBjjTaggingDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public NetsuiteBjjTagging createNetsuiteBjjTagging(NetsuiteBjjTagging netsuiteBjjTagging) {
        entityManager.persist(netsuiteBjjTagging);
        entityManager.flush();
        return netsuiteBjjTagging;
    }

    @Override
    public List<NetsuiteBjjTagging> findAllNetsuiteBjjTagging() {
        TypedQuery<NetsuiteBjjTagging> query = entityManager.createNamedQuery("findAllNetsuiteBbjTagging",
                NetsuiteBjjTagging.class);
        return query.getResultList();
    }

}
