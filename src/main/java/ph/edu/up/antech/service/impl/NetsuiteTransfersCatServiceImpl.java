package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteTransfersCatDAO;
import ph.edu.up.antech.dao.pagination.NetsuiteTransfersCatPaginationDAO;
import ph.edu.up.antech.domain.master.config.NetsuiteTransfersCat;
import ph.edu.up.antech.service.NetsuiteTransfersCatService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NetsuiteTransfersCatServiceImpl implements NetsuiteTransfersCatService {

    @Autowired
    private NetsuiteTransfersCatDAO netsuiteTransfersCatDAO;

    @Autowired
    private NetsuiteTransfersCatPaginationDAO netsuiteTransfersCatPaginationDAO;

    @Override
    public NetsuiteTransfersCat saveNetsuiteTransfersCat(NetsuiteTransfersCat netsuiteTransfersCat) {
        return netsuiteTransfersCatDAO.saveNetsuiteTransfersCat(netsuiteTransfersCat);
    }

    @Override
    public NetsuiteTransfersCat updateNetsuiteTransfersCat(NetsuiteTransfersCat netsuiteTransfersCat) {
        return netsuiteTransfersCatDAO.updateNetsuiteTransfersCat(netsuiteTransfersCat);
    }

    @Override
    public NetsuiteTransfersCat findNetsuiteTransfersCatById(Integer id) {
        return netsuiteTransfersCatDAO.findNetsuiteTransfersCatById(id);
    }

    @Override
    public void removeNetsuiteTransfersCat(Integer id) {
        netsuiteTransfersCatDAO.removeNetsuiteTransfersCat(id);
    }

    @Override
    public List<NetsuiteTransfersCat> findAllNetsuiteTransfersCat() {
        return netsuiteTransfersCatDAO.findAllNetsuiteTransfersCat();
    }

    @Override
    public Page<NetsuiteTransfersCat> findAll(Pageable pageable) {
        return netsuiteTransfersCatPaginationDAO.findAll(pageable);
    }

    @Override
    public Page<NetsuiteTransfersCat> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return netsuiteTransfersCatPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
