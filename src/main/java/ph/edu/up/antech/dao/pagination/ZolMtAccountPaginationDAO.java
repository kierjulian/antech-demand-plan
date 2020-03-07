package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.sales.master.converter.ZolMtAccount;

public interface ZolMtAccountPaginationDAO extends PagingAndSortingRepository<ZolMtAccount, Integer> {

    @Query("select o from ZolMtAccount o where o.shpcn like %?1% or " +
            "o.customerName like %?1% or o.branchName like %?1% or o.cadd1 like %?1% or " +
            "o.cadd2 like %?1% or o.na like %?1%")
    public Page<ZolMtAccount> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
