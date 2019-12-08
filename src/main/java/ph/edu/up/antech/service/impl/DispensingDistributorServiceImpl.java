package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.DispensingDistributorDAO;
import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;
import ph.edu.up.antech.service.DispensingDistributorService;

import java.time.LocalDate;
import java.util.List;

@Service
public class DispensingDistributorServiceImpl implements DispensingDistributorService {

    @Autowired
    private DispensingDistributorDAO dispensingDistributorDAO;

    @Override
    public DispensingDistributor createDispensingDistributor(DispensingDistributor dispensingDistributor) {
        return dispensingDistributorDAO.createDispensingDistributor(dispensingDistributor);
    }

    @Override
    public List<DispensingDistributor> findDispensingDistributorByDate(LocalDate localDate) {
        return dispensingDistributorDAO.findDispensingDistributorByDate(localDate);
    }

    @Override
    public void removeDispensingDistributor(Integer id) {
        dispensingDistributorDAO.removeDispensingDistributor(id);
    }

}
