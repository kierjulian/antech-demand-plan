package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteDAO;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.service.NetsuiteService;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class NetsuiteServiceImpl implements NetsuiteService {

    @Autowired
    private NetsuiteDAO netsuiteDAO;

    @Override
    public Netsuite saveNetsuite(Netsuite netsuite) {
        return netsuiteDAO.saveNetsuite(netsuite);
    }

    @Override
    public List<Netsuite> findNetsuiteByItemDate(LocalDate localDate) {
        return netsuiteDAO.findNetsuiteByItemDate(localDate);
    }

    @Override
    public void removeNetsuite(Integer id) {
        netsuiteDAO.removeNetsuite(id);
    }

    @Override
    public void removeNetsuiteByDate(LocalDate localDate) {
        netsuiteDAO.removeNetsuiteByDate(localDate);
    }

    @Override
    public void saveNetsuiteByBatch(List<Netsuite> netsuiteList) {
        netsuiteDAO.saveNetsuiteByBatch(netsuiteList);
    }

    @Override
    public Netsuite findNetsuiteById(Integer id) {
        return netsuiteDAO.findNetsuiteById(id);
    }

    @Override
    public Netsuite updateNetsuite(Netsuite netsuite) {
        return netsuiteDAO.updateNetsuite(netsuite);
    }

    @Override
    public List<Netsuite> findNetsuiteBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        return netsuiteDAO.findNetsuiteBetweenTwoDates(startDate, endDate);
    }

    @Override
    public List<Netsuite> findNetsuiteSalesAmountAndUnitBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        return netsuiteDAO.findNetsuiteSalesAmountAndUnitBetweenTwoDates(startDate, endDate);
    }

}
