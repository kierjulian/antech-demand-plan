package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteProductListDeDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListDe;
import ph.edu.up.antech.service.NetsuiteProductListDeService;

import java.util.List;

@Service
public class NetsuiteProductListDeServiceImpl implements NetsuiteProductListDeService {

    @Autowired
    private NetsuiteProductListDeDAO netsuiteProductListDeDAO;

    @Override
    public NetsuiteProductListDe saveNetsuiteProductListDe(NetsuiteProductListDe netsuiteProductListDe) {
        return netsuiteProductListDeDAO.saveNetsuiteProductListDe(netsuiteProductListDe);
    }

    @Override
    public List<NetsuiteProductListDe> findAllNetsuiteProductListDe() {
        return netsuiteProductListDeDAO.findAllNetsuiteProductListDe();
    }

}
