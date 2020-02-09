package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolPerDoorsGeneralInformationDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ZolPerDoorsGeneralInformationDAOImpl implements ZolPerDoorsGeneralInformationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ZolPerDoorsGeneralInformation createZolPerDoorsGeneralInformation(ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation) {
        entityManager.persist(zolPerDoorsGeneralInformation);
        entityManager.flush();
        return zolPerDoorsGeneralInformation;
    }

    @Override
    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationByItemCode(String itemCode) {
        TypedQuery<ZolPerDoorsGeneralInformation> query = entityManager.createNamedQuery(
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
        TypedQuery<ZolPerDoorsGeneralInformation> query = entityManager.createNamedQuery(
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
        return entityManager.createNamedQuery("findAllZolPerDoorsGeneralInformation").getResultList();
    }

    @Override
    public ZolPerDoorsGeneralInformation findZolPerDoorsGeneralInformationById(Integer id) {
        TypedQuery<ZolPerDoorsGeneralInformation> query = entityManager
                .createNamedQuery("findZolPerDoorsGeneralInformationById", ZolPerDoorsGeneralInformation.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public ZolPerDoorsGeneralInformation updateZolPerDoorsGeneralInformation(ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation) {
        return entityManager.merge(zolPerDoorsGeneralInformation);
    }

    @Override
    public void removeZolPerDoorsGeneralInformation(Integer id) {
        ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation = entityManager.find(
                ZolPerDoorsGeneralInformation.class, id);
        entityManager.remove(zolPerDoorsGeneralInformation);
    }

}
