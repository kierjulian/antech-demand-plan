package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteGeneralInformation;

import java.util.List;

public interface NetsuiteGeneralInformationDAO {

    public NetsuiteGeneralInformation saveNetsuiteGeneralInformation(NetsuiteGeneralInformation netsuiteGeneralInformation);

    public List<NetsuiteGeneralInformation> findAllNetsuiteGeneralInformation();

}
