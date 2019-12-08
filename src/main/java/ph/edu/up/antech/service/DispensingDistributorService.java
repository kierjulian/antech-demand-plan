package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;

import java.time.LocalDate;
import java.util.List;

public interface DispensingDistributorService {

    public DispensingDistributor createDispensingDistributor(DispensingDistributor dispensingDistributor);

    public List<DispensingDistributor> findDispensingDistributorByDate(LocalDate localDate);

    public void removeDispensingDistributor(Integer id);

}
