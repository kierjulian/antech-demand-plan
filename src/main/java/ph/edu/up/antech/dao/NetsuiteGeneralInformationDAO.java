package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.master.config.NetsuiteGeneralInformation;

import java.util.List;

public interface NetsuiteGeneralInformationDAO {

    public NetsuiteGeneralInformation saveNetsuiteGeneralInformation(NetsuiteGeneralInformation netsuiteGeneralInformation);

    public List<NetsuiteGeneralInformation> findAllNetsuiteGeneralInformation();

    public NetsuiteGeneralInformation findNetsuiteGeneralInformationById(Integer id);

    public NetsuiteGeneralInformation updateNetsuiteGeneralInformation(NetsuiteGeneralInformation netsuiteGeneralInformation);

    public void removeNetsuiteGeneralInformation(Integer id);

}
