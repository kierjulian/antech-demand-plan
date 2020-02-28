package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;

import java.util.List;

public interface ZolPerDoorsPerAcctDAO {

    public ZolPerDoorsPerAcct saveZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct);

    public ZolPerDoorsPerAcct findZolPerDoorsPerAcctByZol(String zol);

    public List<ZolPerDoorsPerAcct> findAllZolPerDoorsPerAcct();

}
