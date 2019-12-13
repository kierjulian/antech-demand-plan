package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.Netsuite;

import java.time.LocalDate;
import java.util.List;

public interface NetsuiteService {

    public Netsuite createNetsuite(Netsuite netsuite);

    public List<Netsuite> findNetsuiteByItemDate(LocalDate localDate);

    public void removeNetsuite(Integer id);

}
