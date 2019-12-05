package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.raw.DispensingDistributor;

import java.time.LocalDate;
import java.util.List;

public interface DispensingDistributorDAO {

    public DispensingDistributor create(DispensingDistributor dispensingDistributor);

    public List<DispensingDistributor> findByDate(LocalDate localDate);

    public void remove(Integer id);

}
