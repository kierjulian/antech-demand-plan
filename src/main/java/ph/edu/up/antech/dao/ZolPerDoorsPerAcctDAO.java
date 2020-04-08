package ph.edu.up.antech.dao;

import ph.edu.up.antech.domain.master.config.ZolPerDoorsPerAcct;

import java.util.List;

public interface ZolPerDoorsPerAcctDAO {

    public ZolPerDoorsPerAcct saveZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct);

    public ZolPerDoorsPerAcct findZolPerDoorsPerAcctByZol(String zol);

    public List<ZolPerDoorsPerAcct> findAllZolPerDoorsPerAcct();

    public ZolPerDoorsPerAcct findZolPerDoorsPerAcctById(Integer id);

    public ZolPerDoorsPerAcct updateZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct);

    public void removeZolPerDoorsPerAcct(Integer id);

}
