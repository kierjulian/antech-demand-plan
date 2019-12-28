package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolPerDoorsDAO;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.service.ZolPerDoorsService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ZolPerDoorsServiceImpl implements ZolPerDoorsService {

    @Autowired
    private ZolPerDoorsDAO zolPerDoorsDAO;

    @Override
    public ZolPerDoors createZolPerDoors(ZolPerDoors zolPerDoors) {
        return zolPerDoorsDAO.createZolPerDoors(zolPerDoors);
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

}
