package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.master.config.NetsuiteTransfersCat;

public interface NetsuiteTransfersCatPaginationDAO extends PagingAndSortingRepository<NetsuiteTransfersCat, Integer> {

    @Query("select o from NetsuiteTransfersCat o where o.name like %?1% or " +
            "o.code like %?1% or o.recode like %?1%")
    public Page<NetsuiteTransfersCat> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
