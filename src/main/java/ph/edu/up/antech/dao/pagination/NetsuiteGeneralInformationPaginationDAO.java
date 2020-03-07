package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteGeneralInformation;

public interface NetsuiteGeneralInformationPaginationDAO extends PagingAndSortingRepository<NetsuiteGeneralInformation, Integer> {

    @Query("select o from NetsuiteGeneralInformation o where o.customerJob like %?1% or " +
            "o.account like %?1% or o.name like %?1% or o.naNumber like %?1% or " +
            "o.kamReferenceName like %?1% or o.location like %?1%")
    public Page<NetsuiteGeneralInformation> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
