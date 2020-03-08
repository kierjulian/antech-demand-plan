package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListSource;

public interface NetsuiteProductListSourcePaginationDAO extends PagingAndSortingRepository<NetsuiteProductListSource, Integer> {

    @Query("select o from NetsuiteProductListSource o where o.source like %?1% or " +
            "o.origin like %?1% or o.description like %?1% or o.destination like %?1% or " +
            "o.inPcs like %?1% or o.product like %?1%")
    public Page<NetsuiteProductListSource> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
