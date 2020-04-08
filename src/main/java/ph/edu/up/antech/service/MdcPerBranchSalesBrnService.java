package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesBrn;

import java.util.List;

public interface MdcPerBranchSalesBrnService {

    public MdcPerBranchSalesBrn saveMdcPerBranchSalesBrn(MdcPerBranchSalesBrn mdcPerBranchSalesBrn);

    public List<MdcPerBranchSalesBrn> findAllMdcPerBranchSalesBrn();

    public MdcPerBranchSalesBrn findMdcPerBranchSalesBrnById(Integer id);

    public MdcPerBranchSalesBrn updateMdcPerBranchSalesBrn(MdcPerBranchSalesBrn mdcPerBranchSalesBrn);

    public void removeMdcPerBranchSalesBrn(Integer id);

    public Page<MdcPerBranchSalesBrn> findAll(Pageable pageable);

    public Page<MdcPerBranchSalesBrn> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
