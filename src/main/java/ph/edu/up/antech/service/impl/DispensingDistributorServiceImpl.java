package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.DispensingDistributorDAO;
import ph.edu.up.antech.domain.raw.DispensingDistributor;
import ph.edu.up.antech.service.DispensingDistributorService;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class DispensingDistributorServiceImpl implements DispensingDistributorService {

    @Autowired
    private DispensingDistributorDAO dispensingDistributorDAO;

    @Override
    public DispensingDistributor saveDispensingDistributor(DispensingDistributor dispensingDistributor) {
        return dispensingDistributorDAO.saveDispensingDistributor(dispensingDistributor);
    }

    @Override
    public List<DispensingDistributor> findDispensingDistributorByDate(LocalDate localDate) {
        return dispensingDistributorDAO.findDispensingDistributorByDate(localDate);
    }

    @Override
    public void removeDispensingDistributor(Integer id) {
        dispensingDistributorDAO.removeDispensingDistributor(id);
    }

    @Override
    public void saveDispensingDistributorByBatch(List<DispensingDistributor> dispensingDistributorList) {
        dispensingDistributorDAO.saveDispensingDistributorByBatch(dispensingDistributorList);
    }

    @Override
    public void removeDispensingDistributorByLocalDate(LocalDate localDate) {
        dispensingDistributorDAO.removeDispensingDistributorByLocalDate(localDate);
    }

    @Override
    public DispensingDistributor findDispensingDistributorById(Integer id) {
        return dispensingDistributorDAO.findDispensingDistributorById(id);
    }

    @Override
    public DispensingDistributor updateDispensingDistributor(DispensingDistributor dispensingDistributor) {
        return dispensingDistributorDAO.updateDispensingDistributor(dispensingDistributor);
    }

    @Override
    public List<DispensingDistributor> findDispensingDistributorBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        return dispensingDistributorDAO.findDispensingDistributorBetweenTwoDates(startDate, endDate);
    }

    @Override
    public List<DispensingDistributor> findDispensingDistributorSalesAmountAndUnitBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        return dispensingDistributorDAO.findDispensingDistributorSalesAmountAndUnitBetweenTwoDates(startDate, endDate);
    }

}
