package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteProductListDeDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListDe;
import ph.edu.up.antech.service.NetsuiteProductListDeService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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

    @Override
    public NetsuiteProductListDe findNetsuiteProductListDeById(Integer id) {
        return netsuiteProductListDeDAO.findNetsuiteProductListDeById(id);
    }

    @Override
    public NetsuiteProductListDe updateNetsuiteProductListDe(NetsuiteProductListDe netsuiteProductListDe) {
        return netsuiteProductListDeDAO.updateNetsuiteProductListDe(netsuiteProductListDe);
    }

    @Override
    public void removeNetsuiteProductListDe(Integer id) {
        netsuiteProductListDeDAO.removeNetsuiteProductListDe(id);
    }

}
