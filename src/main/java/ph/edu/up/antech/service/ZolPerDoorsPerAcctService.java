package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;

public interface ZolPerDoorsPerAcctService {

    public ZolPerDoorsPerAcct createZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct);

    public ZolPerDoorsPerAcct findZolPerDoorsPerAcctByZol(String zol);

}
