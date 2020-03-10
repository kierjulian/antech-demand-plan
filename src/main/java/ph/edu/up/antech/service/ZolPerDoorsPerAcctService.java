package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsPerAcct;

import java.util.List;

public interface ZolPerDoorsPerAcctService {

    public ZolPerDoorsPerAcct saveZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct);

    public ZolPerDoorsPerAcct findZolPerDoorsPerAcctByZol(String zol);

    public List<ZolPerDoorsPerAcct> findAllZolPerDoorsPerAcct();

    public ZolPerDoorsPerAcct findZolPerDoorsPerAcctById(Integer id);

    public ZolPerDoorsPerAcct updateZolPerDoorsPerAcct(ZolPerDoorsPerAcct zolPerDoorsPerAcct);

    public void removeZolPerDoorsPerAcct(Integer id);

    public Page<ZolPerDoorsPerAcct> findAll(Pageable pageable);

    public Page<ZolPerDoorsPerAcct> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
