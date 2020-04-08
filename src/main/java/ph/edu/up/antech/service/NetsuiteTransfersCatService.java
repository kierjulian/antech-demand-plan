package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.master.config.NetsuiteTransfersCat;

import java.util.List;

public interface NetsuiteTransfersCatService {

    public NetsuiteTransfersCat saveNetsuiteTransfersCat(NetsuiteTransfersCat netsuiteTransfersCat);

    public NetsuiteTransfersCat updateNetsuiteTransfersCat(NetsuiteTransfersCat netsuiteTransfersCat);

    public NetsuiteTransfersCat findNetsuiteTransfersCatById(Integer id);

    public void removeNetsuiteTransfersCat(Integer id);

    public List<NetsuiteTransfersCat> findAllNetsuiteTransfersCat();

    public Page<NetsuiteTransfersCat> findAll(Pageable pageable);

    public Page<NetsuiteTransfersCat> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
