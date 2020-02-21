package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteTransferCat;

import java.util.List;

public interface NetsuiteTransferCatDAO {

    public NetsuiteTransferCat saveNetsuiteTransferCat(NetsuiteTransferCat netsuiteTransferCat);

    public NetsuiteTransferCat updateNetsuiteTransferCat(NetsuiteTransferCat netsuiteTransferCat);

    public NetsuiteTransferCat findNetsuiteTransferCatById(Integer id);

    public void removeNetsuiteTransferCat(Integer id);

    public List<NetsuiteTransferCat> findAllNetsuiteTransferCat();

}