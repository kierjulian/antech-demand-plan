package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteGeneralInformation;

import java.util.List;

public interface NetsuiteGeneralInformationService {

    public NetsuiteGeneralInformation saveNetsuiteGeneralInformation(NetsuiteGeneralInformation netsuiteGeneralInformation);

    public List<NetsuiteGeneralInformation> findAllNetsuiteGeneralInformation();

}