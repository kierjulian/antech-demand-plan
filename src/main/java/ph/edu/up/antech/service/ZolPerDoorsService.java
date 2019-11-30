package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.ZolPerDoors;

import java.time.LocalDate;

public interface ZolPerDoorsService {

    public ZolPerDoors create(ZolPerDoors zolPerDoors);

    public ZolPerDoors findByDate(LocalDate date);

    public void remove(Integer id);

}
