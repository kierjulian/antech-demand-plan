package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListDe;

import java.util.List;

public interface NetsuiteProductListDeDAO {

    public NetsuiteProductListDe saveNetsuiteProductListDe(NetsuiteProductListDe netsuiteProductListDe);

    public List<NetsuiteProductListDe> findAllNetsuiteProductListDe();

}