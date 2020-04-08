package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolPerDoorsGeneralInformationDAO;
import ph.edu.up.antech.domain.master.config.ZolPerDoorsGeneralInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ZolPerDoorsGeneralInformationDAOImpl implements ZolPerDoorsGeneralInformationDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public ZolPerDoorsGeneralInformation saveZolPerDoorsGeneralInformation(ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation) {
        em.persist(zolPerDoorsGeneralInformation);
        em.flush();
        return zolPerDoorsGeneralInformation;
    }

    @Override
    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationByItemCode(String itemCode) {
        TypedQuery<ZolPerDoorsGeneralInformation> query = em.createNamedQuery(
                "findZolPerDoorsGeneralInformationByItemCode", ZolPerDoorsGeneralInformation.class);
        query.setParameter("itemCode", itemCode);
        List<ZolPerDoorsGeneralInformation> zolPerDoorsGeneralInformationList = query.getResultList();

        if (zolPerDoorsGeneralInformationList != null && !zolPerDoorsGeneralInformationList.isEmpty()) {
            return zolPerDoorsGeneralInformationList.get(0);
        }

        return null;
    }

    @Override
    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationByZpcItemCode(String zpcItemCode) {
        TypedQuery<ZolPerDoorsGeneralInformation> query = em.createNamedQuery(
                "findZolPerDoorsGeneralInformationByZpcItemCode", ZolPerDoorsGeneralInformation.class);
        query.setParameter("zpcItemCode", zpcItemCode);
        List<ZolPerDoorsGeneralInformation> zolPerDoorsGeneralInformationList = query.getResultList();

        if (zolPerDoorsGeneralInformationList != null && !zolPerDoorsGeneralInformationList.isEmpty()) {
            return zolPerDoorsGeneralInformationList.get(0);
        }

        return null;
    }

    @Override
    public List<ZolPerDoorsGeneralInformation> findAllZolPerDoorsGeneralInformation() {
        return em.createNamedQuery("findAllZolPerDoorsGeneralInformation").getResultList();
    }

    @Override
    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationById(Integer id) {
        TypedQuery<ZolPerDoorsGeneralInformation> query = em
                .createNamedQuery("findZolPerDoorsGeneralInformationById", ZolPerDoorsGeneralInformation.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public ZolPerDoorsGeneralInformation updateZolPerDoorsGeneralInformation(ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation) {
        return em.merge(zolPerDoorsGeneralInformation);
    }

    @Override
    public void removeZolPerDoorsGeneralInformation(Integer id) {
        ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = em.find(
                ZolPerDoorsGeneralInformation.class, id);
        em.remove(zolPerDoorsGeneralInformation);
    }

}
