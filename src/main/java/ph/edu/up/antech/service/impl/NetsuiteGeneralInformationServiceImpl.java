package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteGeneralInformationDAO;
import ph.edu.up.antech.dao.pagination.NetsuiteGeneralInformationPaginationDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteGeneralInformation;
import ph.edu.up.antech.service.NetsuiteGeneralInformationService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NetsuiteGeneralInformationServiceImpl implements NetsuiteGeneralInformationService {

    @Autowired
    private NetsuiteGeneralInformationDAO netsuiteGeneralInformationDAO;

    @Autowired
    private NetsuiteGeneralInformationPaginationDAO netsuiteGeneralInformationPaginationDAO;

    @Override
    public NetsuiteGeneralInformation saveNetsuiteGeneralInformation(NetsuiteGeneralInformation netsuiteGeneralInformation) {
        return netsuiteGeneralInformationDAO.saveNetsuiteGeneralInformation(netsuiteGeneralInformation);
    }

    @Override
    public List<NetsuiteGeneralInformation> findAllNetsuiteGeneralInformation() {
        return netsuiteGeneralInformationDAO.findAllNetsuiteGeneralInformation();
    }

    @Override
    public NetsuiteGeneralInformation findNetsuiteGeneralInformationById(Integer id) {
        return netsuiteGeneralInformationDAO.findNetsuiteGeneralInformationById(id);
    }

    @Override
    public NetsuiteGeneralInformation updateNetsuiteGeneralInformation(NetsuiteGeneralInformation netsuiteGeneralInformation) {
        return netsuiteGeneralInformationDAO.updateNetsuiteGeneralInformation(netsuiteGeneralInformation);
    }

    @Override
    public void removeNetsuiteGeneralInformation(Integer id) {
        netsuiteGeneralInformationDAO.removeNetsuiteGeneralInformation(id);
    }

    @Override
    public Page<NetsuiteGeneralInformation> findAll(Pageable pageable) {
        return netsuiteGeneralInformationPaginationDAO.findAll(pageable);
    }

    @Override
    public Page<NetsuiteGeneralInformation> findAllByAnyColumnContaining(String filter, Pageable pageable) {
        return netsuiteGeneralInformationPaginationDAO.findAllByAnyColumnContaining(filter, pageable);
    }

}
