package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteOtherInformation;

import java.util.List;

public interface NetsuiteOtherInformationDAO {

    public NetsuiteOtherInformation saveNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation);

    public List<NetsuiteOtherInformation> findAllNetsuiteOtherInformation();

}
