package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListSource;

import java.util.List;

public interface NetsuiteProductListSourceService {

    public NetsuiteProductListSource saveNetsuiteProductListSource(
            NetsuiteProductListSource netsuiteProductListSource);

    public List<NetsuiteProductListSource> findAllNetsuiteProductListSource();

    public NetsuiteProductListSource findNetsuiteProductListSourceById(Integer id);

    public NetsuiteProductListSource updateNetsuiteProductListSource(NetsuiteProductListSource netsuiteProductListSource);

    public void removeNetsuiteProductListSource(Integer id);

    public Page<NetsuiteProductListSource> findAll(Pageable pageable);

    public Page<NetsuiteProductListSource> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
