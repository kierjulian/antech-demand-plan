package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteTransferCatDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteTransferCat;
import ph.edu.up.antech.service.NetsuiteTransferCatService;

import java.util.List;

@Service
public class NetsuiteTransferCatServiceImpl implements NetsuiteTransferCatService {

    @Autowired
    private NetsuiteTransferCatDAO netsuiteTransferCatDAO;

    @Override
    public NetsuiteTransferCat saveNetsuiteTransferCat(NetsuiteTransferCat netsuiteTransferCat) {
        return netsuiteTransferCatDAO.saveNetsuiteTransferCat(netsuiteTransferCat);
    }

    @Override
    public NetsuiteTransferCat updateNetsuiteTransferCat(NetsuiteTransferCat netsuiteTransferCat) {
        return netsuiteTransferCatDAO.updateNetsuiteTransferCat(netsuiteTransferCat);
    }

    @Override
    public NetsuiteTransferCat findNetsuiteTransferCatById(Integer id) {
        return netsuiteTransferCatDAO.findNetsuiteTransferCatById(id);
    }

    @Override
    public void removeNetsuiteTransferCat(Integer id) {
        netsuiteTransferCatDAO.removeNetsuiteTransferCat(id);
    }

    @Override
    public List<NetsuiteTransferCat> findAllNetsuiteTransferCat() {
        return netsuiteTransferCatDAO.findAllNetsuiteTransferCat();
    }

}
