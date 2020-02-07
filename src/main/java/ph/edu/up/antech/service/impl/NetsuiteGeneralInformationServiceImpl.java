package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteGeneralInformationDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteGeneralInformation;
import ph.edu.up.antech.service.NetsuiteGeneralInformationService;

import java.util.List;

@Service
public class NetsuiteGeneralInformationServiceImpl implements NetsuiteGeneralInformationService {

    @Autowired
    private NetsuiteGeneralInformationDAO netsuiteGeneralInformationDAO;

    @Override
    public NetsuiteGeneralInformation saveNetsuiteGeneralInformation(NetsuiteGeneralInformation netsuiteGeneralInformation) {
        return netsuiteGeneralInformationDAO.saveNetsuiteGeneralInformation(netsuiteGeneralInformation);
    }

    @Override
    public List<NetsuiteGeneralInformation> findAllNetsuiteGeneralInformation() {
        return netsuiteGeneralInformationDAO.findAllNetsuiteGeneralInformation();
    }

}
