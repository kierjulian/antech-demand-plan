package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteOtherInformationDAO;
import ph.edu.up.antech.dao.pagination.NetsuiteOtherInformationPaginationDAO;
import ph.edu.up.antech.domain.master.config.NetsuiteOtherInformation;
import ph.edu.up.antech.service.NetsuiteOtherInformationService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NetsuiteOtherInformationServiceImpl implements NetsuiteOtherInformationService {

    @Autowired
    private NetsuiteOtherInformationDAO netsuiteOtherInformationDAO;

    @Autowired
    private NetsuiteOtherInformationPaginationDAO netsuiteOtherInformationPaginationDAO;

    @Override
    public NetsuiteOtherInformation saveNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation) {
        return netsuiteOtherInformationDAO.saveNetsuiteOtherInformation(netsuiteOtherInformation);
    }

    @Override
    public List<NetsuiteOtherInformation> findAllNetsuiteOtherInformation() {
        return netsuiteOtherInformationDAO.findAllNetsuiteOtherInformation();
    }

    @Override
    public NetsuiteOtherInformation findNetsuiteOtherInformationById(Integer id) {
        return netsuiteOtherInformationDAO.findNetsuiteOtherInformationById(id);
    }

    @Override
    public NetsuiteOtherInformation updateNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation) {
        return netsuiteOtherInformationDAO.updateNetsuiteOtherInformation(netsuiteOtherInformation);
    }

    @Override
    public void removeNetsuiteOtherInformation(Integer id) {
        netsuiteOtherInformationDAO.removeNetsuiteOtherInformation(id);
    }

    @Override
    public Page<NetsuiteOtherInformation> findAll(Pageable pageable) {
        return netsuiteOtherInformationPaginationDAO.findAll(pageable);
    }

    @Override
    public Page<NetsuiteOtherInformation> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return netsuiteOtherInformationPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
