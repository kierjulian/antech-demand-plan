package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListSource;

import java.util.List;

public interface NetsuiteProductListSourceService {

    public NetsuiteProductListSource saveNetsuiteProductListSource(
            NetsuiteProductListSource netsuiteProductListSource);

    public List<NetsuiteProductListSource> findAllNetsuiteProductListSource();

}
