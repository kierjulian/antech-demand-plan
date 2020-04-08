package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.master.config.NetsuiteOtherInformation;

public interface NetsuiteOtherInformationPaginationDAO extends PagingAndSortingRepository<NetsuiteOtherInformation, Integer> {

    @Query("select o from NetsuiteOtherInformation o where o.type like %?1% or " +
            "o.description like %?1% or o.otherDescription like %?1%")
    public Page<NetsuiteOtherInformation> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
