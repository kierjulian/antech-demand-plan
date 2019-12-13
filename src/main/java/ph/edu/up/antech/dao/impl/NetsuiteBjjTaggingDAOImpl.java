package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteBjjTaggingDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBjjTagging;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

}
