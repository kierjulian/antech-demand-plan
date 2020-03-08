package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteTransferCat;

public interface NetsuiteTransfersCatPaginationDAO extends PagingAndSortingRepository<NetsuiteTransferCat, Integer> {

    @Query("select o from NetsuiteTransferCat o where o.name like %?1% or " +
            "o.code like %?1% or o.recode like %?1%")
    public Page<NetsuiteTransferCat> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
