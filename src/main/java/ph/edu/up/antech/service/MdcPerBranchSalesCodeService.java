package ph.edu.up.antech.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesCode;

import java.util.List;

public interface MdcPerBranchSalesCodeService {

    public MdcPerBranchSalesCode saveMdcPerBranchSalesCoverage(MdcPerBranchSalesCode mdcPerBranchSalesCode);

    public List<MdcPerBranchSalesCode> findAllMdcPerBranchSalesCode();

    public MdcPerBranchSalesCode findMdcPerBranchSalesCodeById(Integer id);

    public MdcPerBranchSalesCode updateMdcPerBranchSalesCode(MdcPerBranchSalesCode mdcPerBranchSalesCode);

    public void removeMdcPerBranchSalesCode(Integer id);

    public Page<MdcPerBranchSalesCode> findAll(Pageable pageable);

    public Page<MdcPerBranchSalesCode> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
