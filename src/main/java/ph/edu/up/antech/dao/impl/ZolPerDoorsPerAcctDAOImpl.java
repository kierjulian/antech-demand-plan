package ph.edu.up.antech.dao.impl;

import org.springframework.stereotype.Repository;
import ph.edu.up.antech.dao.ZolPerDoorsPerAcctDAO;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ZolPerDoorsPerAcctDAOImpl implements ZolPerDoorsPerAcctDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ZolPerDoorsPerAcct create(ZolPerDoorsPerAcct zolPerDoorsPerAcct) {
        entityManager.persist(zolPerDoorsPerAcct);
        entityManager.flush();
        return zolPerDoorsPerAcct;
    }

    @Override
    public List<ZolPerDoorsPerAcct> findByCustomerCode(String customerCode) {
        return null;
    }

}
