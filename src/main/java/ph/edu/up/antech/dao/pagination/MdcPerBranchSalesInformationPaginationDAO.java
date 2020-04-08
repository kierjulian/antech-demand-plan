package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesInformation;

public interface MdcPerBranchSalesInformationPaginationDAO extends PagingAndSortingRepository<MdcPerBranchSalesInformation, Integer> {

    @Query("select o from MdcPerBranchSalesInformation o where o.itemNumber like %?1% or " +
            "o.itemDescription like %?1% or o.itemShortDescription like %?1% or o.quantity like %?1% or " +
            "o.price like %?1% or o.total like %?1% or o.itemCode like %?1% or o.stage like %?1% or o.itemType like %?1%")
    public Page<MdcPerBranchSalesInformation> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
