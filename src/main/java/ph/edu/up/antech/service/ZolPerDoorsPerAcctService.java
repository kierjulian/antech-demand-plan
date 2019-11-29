package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;

public interface ZolPerDoorsPerAcctService {

    public ZolPerDoorsPerAcct create(ZolPerDoorsPerAcct zolPerDoorsPerAcct);

    public ZolPerDoorsPerAcct findByZol(String customerCode);

}
