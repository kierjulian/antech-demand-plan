package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;

import java.time.LocalDate;
import java.util.List;

public interface DispensingDistributorService {

    public DispensingDistributor saveDispensingDistributor(DispensingDistributor dispensingDistributor);

    public List<DispensingDistributor> findDispensingDistributorByDate(LocalDate localDate);

    public void removeDispensingDistributor(Integer id);

    public void saveDispensingDistributorByBatch(List<DispensingDistributor> dispensingDistributorList);

    public void removeDispensingDistributorByLocalDate(LocalDate localDate);

    public DispensingDistributor findDispensingDistributorById(Integer id);

    public DispensingDistributor updateDispensingDistributor(DispensingDistributor dispensingDistributor);

    public List<DispensingDistributor> findDispensingDistributorBetweenTwoDates(LocalDate startDate, LocalDate endDate);


}
