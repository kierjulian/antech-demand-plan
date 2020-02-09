package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListSource;

import java.util.List;

public interface NetsuiteProductListSourceDAO {

    public NetsuiteProductListSource saveNetsuiteProductListSource(
            NetsuiteProductListSource netsuiteProductListSource);

    public List<NetsuiteProductListSource> findAllNetsuiteProductListSource();

    public NetsuiteProductListSource findNetsuiteProductListSourceById(Integer id);

    public NetsuiteProductListSource updateNetsuiteProductListSource(NetsuiteProductListSource netsuiteProductListSource);

    public void removeNetsuiteProductListSource(Integer id);

}
