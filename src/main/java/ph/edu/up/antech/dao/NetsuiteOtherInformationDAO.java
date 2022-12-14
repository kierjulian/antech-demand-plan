package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.master.config.NetsuiteOtherInformation;

import java.util.List;

public interface NetsuiteOtherInformationDAO {

    public NetsuiteOtherInformation saveNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation);

    public List<NetsuiteOtherInformation> findAllNetsuiteOtherInformation();

    public NetsuiteOtherInformation findNetsuiteOtherInformationById(Integer id);

    public NetsuiteOtherInformation updateNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation);

    public void removeNetsuiteOtherInformation(Integer id);

}
