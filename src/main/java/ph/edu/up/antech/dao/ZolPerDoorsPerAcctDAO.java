package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;

import java.util.List;

public interface ZolPerDoorsPerAcctDAO {

    public ZolPerDoorsPerAcct createZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct);

    public ZolPerDoorsPerAcct findZolPerDoorsPerAcctByZol(String zol);

    public List<ZolPerDoorsPerAcct> findAllZolPerDoors();

}
