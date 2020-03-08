package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteProductListDe;

public interface NetsuiteProductListDePaginationDAO extends PagingAndSortingRepository<NetsuiteProductListDe, Integer> {

    @Query("select o from NetsuiteProductListDe o where o.description like %?1% or " +
            "o.stage like %?1% or o.productCode like %?1% or o.productType like %?1%")
    public Page<NetsuiteProductListDe> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
