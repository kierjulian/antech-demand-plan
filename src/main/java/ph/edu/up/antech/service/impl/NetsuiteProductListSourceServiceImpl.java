package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteProductListSourceDAO;
import ph.edu.up.antech.dao.pagination.NetsuiteProductListSourcePaginationDAO;
import ph.edu.up.antech.domain.master.config.NetsuiteProductListSource;
import ph.edu.up.antech.service.NetsuiteProductListSourceService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NetsuiteProductListSourceServiceImpl implements NetsuiteProductListSourceService {

    @Autowired
    private NetsuiteProductListSourceDAO netsuiteProductListSourceDAO;

    @Autowired
    private NetsuiteProductListSourcePaginationDAO netsuiteProductListSourcePaginationDAO;

    @Override
    public NetsuiteProductListSource saveNetsuiteProductListSource(NetsuiteProductListSource netsuiteProductListSource) {
        return netsuiteProductListSourceDAO.saveNetsuiteProductListSource(netsuiteProductListSource);
    }

    @Override
    public List<NetsuiteProductListSource> findAllNetsuiteProductListSource() {
        return netsuiteProductListSourceDAO.findAllNetsuiteProductListSource();
    }

    @Override
    public NetsuiteProductListSource findNetsuiteProductListSourceById(Integer id) {
        return netsuiteProductListSourceDAO.findNetsuiteProductListSourceById(id);
    }

    @Override
    public NetsuiteProductListSource updateNetsuiteProductListSource(NetsuiteProductListSource netsuiteProductListSource) {
        return netsuiteProductListSourceDAO.updateNetsuiteProductListSource(netsuiteProductListSource);
    }

    @Override
    public void removeNetsuiteProductListSource(Integer id) {
        netsuiteProductListSourceDAO.removeNetsuiteProductListSource(id);
    }

    @Override
    public Page<NetsuiteProductListSource> findAll(Pageable pageable) {
        return netsuiteProductListSourcePaginationDAO.findAll(pageable);
    }

    @Override
    public Page<NetsuiteProductListSource> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return netsuiteProductListSourcePaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
