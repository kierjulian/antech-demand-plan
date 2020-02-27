package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.Netsuite;

import java.time.LocalDate;
import java.util.List;

public interface NetsuiteService {

    public Netsuite createNetsuite(Netsuite netsuite);

    public List<Netsuite> findNetsuiteByItemDate(LocalDate localDate);

    public void removeNetsuite(Integer id);

    public void removeNetsuiteByDate(LocalDate localDate);

    public void saveNetsuiteByBatch(List<Netsuite> netsuiteList);

    public Netsuite findNetsuiteById(Integer id);

    public Netsuite updateNetsuite(Netsuite netsuite);

    public List<Netsuite> findNetsuiteBetweenTwoDates(LocalDate startDate, LocalDate endDate);

}
