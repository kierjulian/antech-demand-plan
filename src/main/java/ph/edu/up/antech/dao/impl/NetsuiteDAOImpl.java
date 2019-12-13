package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteDAO;
import ph.edu.up.antech.domain.sales.master.Netsuite;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public class NetsuiteDAOImpl implements NetsuiteDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Netsuite createNetsuite(Netsuite netsuite) {
        entityManager.persist(netsuite);
        entityManager.merge(netsuite);
        return netsuite;
    }

    @Override
    public List<Netsuite> findNetsuiteByItemDate(LocalDate localDate) {
        TypedQuery<Netsuite> query = entityManager.createNamedQuery("findNetsuiteByItemDate",
                Netsuite.class);
        query.setParameter("itemDate", localDate);
        return query.getResultList();
    }

    @Override
    public void removeNetsuite(Integer id) {
        Netsuite netsuite = entityManager.find(Netsuite.class, id);
        entityManager.remove(netsuite);
    }

}
