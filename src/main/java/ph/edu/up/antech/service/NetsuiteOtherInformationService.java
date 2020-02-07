package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteOtherInformation;

import java.util.List;

public interface NetsuiteOtherInformationService {

    public NetsuiteOtherInformation saveNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation);

    public List<NetsuiteOtherInformation> findAllNetsuiteOtherInformation();

}
