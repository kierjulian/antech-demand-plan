package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.ZolPerDoors;

import java.time.LocalDate;
import java.util.List;

public interface ZolPerDoorsDAO {

    public ZolPerDoors createZolPerDoors(ZolPerDoors zolPerDoors);

    public List<ZolPerDoors> findZolPerDoorsByDate(LocalDate date);

    public void removeZolPerDoors(Integer id);

    public List<String> findDistinctZolPerDoorsKamReferenceNameByLocalDate(LocalDate localDate);

    public List<String> findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(LocalDate localDate);

    public List<ZolPerDoors> findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(
            LocalDate localDate, String kamReferenceName, String antechProductDescription);

    public List<String> findDistinctZolPerDoorsAccountByLocalDate(LocalDate localDate);

    public void removeZolPerDoorsByLocalDate(LocalDate localDate);

    public void saveZolPerDoorsByBatch(List<ZolPerDoors> zolPerDoorsList);

}
