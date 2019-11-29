package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;

import java.util.List;

public interface ZolPerDoorsPerAcctDAO {

    public ZolPerDoorsPerAcct create(ZolPerDoorsPerAcct zolPerDoorsPerAcct);

    public List<ZolPerDoorsPerAcct> findByCustomerCode(String customerCode);

}
