package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolPerDoorsDAO;
import ph.edu.up.antech.dao.pagination.ZolPerDoorsPaginationDAO;
import ph.edu.up.antech.domain.master.ZolPerDoors;
import ph.edu.up.antech.service.ZolPerDoorsService;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ZolPerDoorsServiceImpl implements ZolPerDoorsService {

    @Autowired
    private ZolPerDoorsDAO zolPerDoorsDAO;

    @Autowired
    private ZolPerDoorsPaginationDAO zolPerDoorsPaginationDAO;

    @Override
    public ZolPerDoors saveZolPerDoors(ZolPerDoors zolPerDoors) {
        return zolPerDoorsDAO.saveZolPerDoors(zolPerDoors);
    }

    @Override
    public List<ZolPerDoors> findZolPerDoorsByDate(LocalDate date) {
        return zolPerDoorsDAO.findZolPerDoorsByDate(date);
    }

    @Override
    public void removeZolPerDoors(Integer id) {
        zolPerDoorsDAO.removeZolPerDoors(id);
    }

    @Override
    public List<String> findDistinctZolPerDoorsKamReferenceNameByLocalDate(LocalDate localDate) {
        return zolPerDoorsDAO.findDistinctZolPerDoorsKamReferenceNameByLocalDate(localDate);
    }

    @Override
    public List<String> findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(LocalDate localDate) {
        return zolPerDoorsDAO.findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(localDate);
    }

    @Override
    public List<ZolPerDoors> findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(
            LocalDate localDate, String kamReferenceName, String antechProductDescription) {
        return zolPerDoorsDAO.findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(
                localDate, kamReferenceName, antechProductDescription);
    }

    @Override
    public List<String> findDistinctZolPerDoorsAccountByLocalDate(LocalDate localDate) {
        return zolPerDoorsDAO.findDistinctZolPerDoorsAccountByLocalDate(localDate);
    }

    @Override
    public void removeZolPerDoorsByLocalDate(LocalDate localDate) {
        zolPerDoorsDAO.removeZolPerDoorsByLocalDate(localDate);
    }

    @Override
    public void saveZolPerDoorsByBatch(List<ZolPerDoors> zolPerDoorsList) {
        zolPerDoorsDAO.saveZolPerDoorsByBatch(zolPerDoorsList);
    }

    @Override
    public List<ZolPerDoors> findZolPerDoorsBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        return zolPerDoorsDAO.findZolPerDoorsBetweenTwoDates(startDate, endDate);
    }

    @Override
    public ZolPerDoors findZolPerDoorsById(Integer id) {
        return zolPerDoorsDAO.findZolPerDoorsById(id);
    }

    @Override
    public ZolPerDoors updateZolPerDoors(ZolPerDoors zolPerDoors) {
        return zolPerDoorsDAO.updateZolPerDoors(zolPerDoors);
    }

    @Override
    public List<ZolPerDoors> findZolPerDoorsSalesAmountAndUnitBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        return zolPerDoorsDAO.findZolPerDoorsSalesAmountAndUnitBetweenTwoDates(startDate, endDate);
    }

    @Override
    public Page<ZolPerDoors> findAll(Pageable pageable) {
        return zolPerDoorsPaginationDAO.findAll(pageable);
    }

}
