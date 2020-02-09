package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteOtherInformation;

import java.util.List;

public interface NetsuiteOtherInformationService {

    public NetsuiteOtherInformation saveNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation);

    public List<NetsuiteOtherInformation> findAllNetsuiteOtherInformation();

    public NetsuiteOtherInformation findNetsuiteOtherInformationById(Integer id);

    public NetsuiteOtherInformation updateNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation);

    public void removeNetsuiteOtherInformation(Integer id);

}
