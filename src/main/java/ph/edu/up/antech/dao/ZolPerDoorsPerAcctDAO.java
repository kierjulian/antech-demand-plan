package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;

public interface ZolPerDoorsPerAcctDAO {

    public ZolPerDoorsPerAcct create(ZolPerDoorsPerAcct zolPerDoorsPerAcct);

    public ZolPerDoorsPerAcct findByZol(String zol);

}
