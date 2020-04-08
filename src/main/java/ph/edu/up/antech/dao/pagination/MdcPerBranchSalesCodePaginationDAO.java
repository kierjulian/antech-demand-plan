package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesCode;

public interface MdcPerBranchSalesCodePaginationDAO extends PagingAndSortingRepository<MdcPerBranchSalesCode, Integer> {

    @Query("select o from MdcPerBranchSalesCode o where o.code like %?1% or o.description like %?1%")
    public Page<MdcPerBranchSalesCode> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
