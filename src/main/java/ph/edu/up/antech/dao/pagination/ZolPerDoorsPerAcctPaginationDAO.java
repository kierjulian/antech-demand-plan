package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.master.config.ZolPerDoorsPerAcct;

public interface ZolPerDoorsPerAcctPaginationDAO extends PagingAndSortingRepository<ZolPerDoorsPerAcct, Integer> {

    @Query("select o from ZolPerDoorsPerAcct o where o.location like %?1% or " +
            "o.id like %?1% or o.sap like %?1% or o.zol like %?1% or " +
            "o.branch like %?1% or o.account like %?1% or o.kam like %?1% or o.tm like %?1% " +
            "or o.share like %?1% or o.kamReferenceName like %?1% or o.naName like %?1%")
    public Page<ZolPerDoorsPerAcct> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
