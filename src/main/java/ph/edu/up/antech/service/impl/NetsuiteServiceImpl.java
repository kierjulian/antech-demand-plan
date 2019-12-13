package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteDAO;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.service.NetsuiteService;

import java.time.LocalDate;
import java.util.List;

@Service
public class NetsuiteServiceImpl implements NetsuiteService {

    @Autowired
    private NetsuiteDAO netsuiteDAO;

    @Override
    public Netsuite createNetsuite(Netsuite netsuite) {
        return netsuiteDAO.createNetsuite(netsuite);
    }

    @Override
    public List<Netsuite> findNetsuiteByItemDate(LocalDate localDate) {
        return netsuiteDAO.findNetsuiteByItemDate(localDate);
    }

    @Override
    public void removeNetsuite(Integer id) {
        netsuiteDAO.removeNetsuite(id);
    }

}
