package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.master.ZolPerDoors;

import java.time.LocalDate;
import java.util.List;

public interface ZolPerDoorsService {

    public ZolPerDoors saveZolPerDoors(ZolPerDoors zolPerDoors);

    public List<ZolPerDoors> findZolPerDoorsByDate(LocalDate date);

    public void removeZolPerDoors(Integer id);

    public List<String> findDistinctZolPerDoorsKamReferenceNameByLocalDate(LocalDate localDate);

    public List<String> findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(LocalDate localDate);

    public List<ZolPerDoors> findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(
            LocalDate localDate, String kamReferenceName, String antechProductDescription);

    public List<String> findDistinctZolPerDoorsAccountByLocalDate(LocalDate localDate);

    public void removeZolPerDoorsByLocalDate(LocalDate localDate);

    public void saveZolPerDoorsByBatch(List<ZolPerDoors> zolPerDoorsList);

    public List<ZolPerDoors> findZolPerDoorsBetweenTwoDates(LocalDate startDate, LocalDate endDate);

    public ZolPerDoors findZolPerDoorsById(Integer id);

    public ZolPerDoors updateZolPerDoors(ZolPerDoors zolPerDoors);

    public List<ZolPerDoors> findZolPerDoorsSalesAmountAndUnitBetweenTwoDates(LocalDate startDate, LocalDate endDate);

    public Page<ZolPerDoors> findAll(Pageable pageable);

}
