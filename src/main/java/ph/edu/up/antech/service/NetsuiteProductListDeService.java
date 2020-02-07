package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListDe;

import java.util.List;

public interface NetsuiteProductListDeService {

    public NetsuiteProductListDe saveNetsuiteProductListDe(NetsuiteProductListDe netsuiteProductListDe);

    public List<NetsuiteProductListDe> findAllNetsuiteProductListDe();

}
