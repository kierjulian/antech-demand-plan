package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBbjTagging;

public interface NetsuiteBbjTaggingPaginationDAO extends PagingAndSortingRepository<NetsuiteBbjTagging, Integer> {

    @Query("select o from NetsuiteBbjTagging o where o.customerName like %?1% or " +
            "o.zone like %?1% or o.address like %?1% or o.newCsr like %?1% or " +
            "o.newTaggingOfCsr like %?1%")
    public Page<NetsuiteBbjTagging> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
