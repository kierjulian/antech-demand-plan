package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesCoverage;

public interface MdcPerBranchSalesCoveragePaginationDAO extends PagingAndSortingRepository<MdcPerBranchSalesCoverage, Integer> {

    @Query("select o from MdcPerBranchSalesCoverage o where o.branchCode like %?1% or " +
            "o.branchName like %?1% or o.newCoverage like %?1% or o.oldCoverage like %?1% or " +
            "o.coordinator like %?1% or o.region like %?1%")
    public Page<MdcPerBranchSalesCoverage> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
