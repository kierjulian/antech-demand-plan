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
    public ZolPerDoors create(ZolPerDoors zolPerDoors) {
        return zolPerDoorsDAO.create(zolPerDoors);
    }

    @Override
    public List<ZolPerDoors> findByDate(LocalDate date) {
        return zolPerDoorsDAO.findByDate(date);
    }

    @Override
    public void remove(Integer id) {

    }

}