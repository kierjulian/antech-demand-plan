package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolPerDoorsDAO;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.service.ZolPerDoorsService;

import java.time.LocalDate;

@Service
public class ZolPerDoorsServiceImpl implements ZolPerDoorsService {

    @Autowired
    private ZolPerDoorsDAO zolPerDoorsDAO;

    @Override
    public ZolPerDoors create(ZolPerDoors zolPerDoors) {
        return zolPerDoorsDAO.create(zolPerDoors);
    }

    @Override
    public ZolPerDoors findByDate(LocalDate date) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

}
