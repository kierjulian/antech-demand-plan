package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.master.config.NetsuiteTransfersCat;

import java.util.List;

public interface NetsuiteTransfersCatDAO {

    public NetsuiteTransfersCat saveNetsuiteTransfersCat(NetsuiteTransfersCat netsuiteTransfersCat);

    public NetsuiteTransfersCat updateNetsuiteTransfersCat(NetsuiteTransfersCat netsuiteTransfersCat);

    public NetsuiteTransfersCat findNetsuiteTransfersCatById(Integer id);

    public void removeNetsuiteTransfersCat(Integer id);

    public List<NetsuiteTransfersCat> findAllNetsuiteTransfersCat();

}
