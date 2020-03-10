package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteGeneralInformation;

import java.util.List;

public interface NetsuiteGeneralInformationService {

    public NetsuiteGeneralInformation saveNetsuiteGeneralInformation(NetsuiteGeneralInformation netsuiteGeneralInformation);

    public List<NetsuiteGeneralInformation> findAllNetsuiteGeneralInformation();

    public NetsuiteGeneralInformation findNetsuiteGeneralInformationById(Integer id);

    public NetsuiteGeneralInformation updateNetsuiteGeneralInformation(NetsuiteGeneralInformation netsuiteGeneralInformation);

    public void removeNetsuiteGeneralInformation(Integer id);

    public Page<NetsuiteGeneralInformation> findAll(Pageable pageable);

    public Page<NetsuiteGeneralInformation> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
