package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.ZolPerDoors;

import java.time.LocalDate;
import java.util.List;

public interface ZolPerDoorsService {

    public ZolPerDoors create(ZolPerDoors zolPerDoors);

    public List<ZolPerDoors> findByDate(LocalDate date);

    public void remove(Integer id);

    public List<String> findDistinctZolPerDoorsKamReferenceNameByLocalDate(LocalDate localDate);

    public List<String> findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(LocalDate localDate);

    public List<ZolPerDoors> findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(
            LocalDate localDate, String kamReferenceName, String antechProductDescription);

}
