package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.NetsuiteOtherInformationDAO;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteOtherInformation;
import ph.edu.up.antech.service.NetsuiteOtherInformationService;

import java.util.List;

@Service
public class NetsuiteOtherInformationServiceImpl implements NetsuiteOtherInformationService {

    @Autowired
    private NetsuiteOtherInformationDAO netsuiteOtherInformationDAO;

    @Override
    public NetsuiteOtherInformation saveNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation) {
        return netsuiteOtherInformationDAO.saveNetsuiteOtherInformation(netsuiteOtherInformation);
    }

    @Override
    public List<NetsuiteOtherInformation> findAllNetsuiteOtherInformation() {
        return netsuiteOtherInformationDAO.findAllNetsuiteOtherInformation();
    }

}
