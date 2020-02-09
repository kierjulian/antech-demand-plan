package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteProductListSourceDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListSource;
import ph.edu.up.antech.service.NetsuiteProductListSourceService;

import java.util.List;

@Service
public class NetsuiteProductListSourceServiceImpl implements NetsuiteProductListSourceService {

    @Autowired
    private NetsuiteProductListSourceDAO netsuiteProductListSourceDAO;

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

}
