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
    public DispensingDistributor create(DispensingDistributor dispensingDistributor) {
        return dispensingDistributorDAO.create(dispensingDistributor);
    }

    @Override
    public List<DispensingDistributor> findByDate(LocalDate localDate) {
        return dispensingDistributorDAO.findByDate(localDate);
    }

    @Override
    public void remove(Integer id) {
        dispensingDistributorDAO.remove(id);
    }

}
