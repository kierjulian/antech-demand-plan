package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolPerDoorsGeneralInformationDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ZolPerDoorsGeneralInformationDAOImpl implements ZolPerDoorsGeneralInformationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ZolPerDoorsGeneralInformation create(ZolPerDoorsGeneralInformation zolPerDoorsGeneralInformation) {
        entityManager.persist(zolPerDoorsGeneralInformation);
        entityManager.flush();
        return zolPerDoorsGeneralInformation;
    }

}
