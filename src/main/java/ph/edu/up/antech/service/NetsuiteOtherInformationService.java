package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.master.config.NetsuiteOtherInformation;

import java.util.List;

public interface NetsuiteOtherInformationService {

    public NetsuiteOtherInformation saveNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation);

    public List<NetsuiteOtherInformation> findAllNetsuiteOtherInformation();

    public NetsuiteOtherInformation findNetsuiteOtherInformationById(Integer id);

    public NetsuiteOtherInformation updateNetsuiteOtherInformation(NetsuiteOtherInformation netsuiteOtherInformation);

    public void removeNetsuiteOtherInformation(Integer id);

    public Page<NetsuiteOtherInformation> findAll(Pageable pageable);

    public Page<NetsuiteOtherInformation> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
