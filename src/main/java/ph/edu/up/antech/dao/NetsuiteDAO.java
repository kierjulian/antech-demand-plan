package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.Netsuite;

import java.time.LocalDate;
import java.util.List;

public interface NetsuiteDAO {

    public Netsuite createNetsuite(Netsuite netsuite);

    public List<Netsuite> findNetsuiteByItemDate(LocalDate localDate);

    public void removeNetsuite(Integer id);

    public void removeNetsuiteByDate(LocalDate localDate);

    public void saveNetsuiteByBatch(List<Netsuite> netsuiteList);

}
