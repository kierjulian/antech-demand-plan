package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.Customer;

public interface CustomerPaginationDAO extends PagingAndSortingRepository<Customer, Integer> {

    @Query("select o from Customer o where o.customerCode like %?1% or " +
            "o.customerName like %?1% or o.zolCustomerCode like %?1% or o.zolCustomerName like %?1% or " +
            "o.materialCode like %?1% or o.zolMaterialCode like %?1% " +
            "or o.materialDescription like %?1%")
    public Page<Customer> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
