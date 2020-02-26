package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.NetsuiteDAO;
import ph.edu.up.antech.domain.sales.master.Netsuite;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class NetsuiteDAOImpl implements NetsuiteDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Netsuite createNetsuite(Netsuite netsuite) {
        em.persist(netsuite);
        em.merge(netsuite);
        return netsuite;
    }

    @Override
    public List<Netsuite> findNetsuiteByItemDate(LocalDate localDate) {
        TypedQuery<Netsuite> query = em.createNamedQuery("findNetsuiteByItemDate",
                Netsuite.class);
        query.setParameter("itemDate", localDate);
        return query.getResultList();
    }

    @Override
    public void removeNetsuite(Integer id) {
        Netsuite netsuite = em.find(Netsuite.class, id);
        em.remove(netsuite);
    }

    @Override
    public void removeNetsuiteByDate(LocalDate localDate) {
        Query query = em.createNamedQuery("removeNetsuiteByDate");
        query.setParameter("itemDate", localDate);
        query.executeUpdate();
    }

    @Override
    public void saveNetsuiteByBatch(List<Netsuite> netsuiteList) {
        for (int i = 0; i < netsuiteList.size(); i++) {
            if (i % 50 == 0) {
                em.flush();
                em.clear();
            }

            em.persist(netsuiteList.get(i));
        }
    }

}
