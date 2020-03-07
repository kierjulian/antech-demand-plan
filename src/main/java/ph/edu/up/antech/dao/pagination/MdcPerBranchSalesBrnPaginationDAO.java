package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.sales.master.converter.MdcPerBranchSalesBrn;

public interface MdcPerBranchSalesBrnPaginationDAO extends PagingAndSortingRepository<MdcPerBranchSalesBrn, Integer> {

    @Query("select o from MdcPerBranchSalesBrn o where o.shpcn like %?1% or " +
            "o.customerName like %?1% or o.branchName like %?1% or o.cadd1 like %?1% or " +
            "o.cadd2 like %?1% or o.na like %?1%")
    public Page<MdcPerBranchSalesBrn> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
