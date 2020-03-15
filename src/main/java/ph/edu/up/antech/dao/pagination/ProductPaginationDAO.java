package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.Product;

public interface ProductPaginationDAO extends PagingAndSortingRepository<Product, Integer> {

    @Query("select o from Product o where o.code like %?1% or " +
            "o.name like %?1% or o.itemBarcode like %?1% or o.caseBarcode like %?1% or " +
            "o.certificateOfProductRegistrationNo like %?1% or o.confirmationDate like %?1% " +
            "or o.confirmedBy like %?1% or o.completionDate like %?1% or o.completedBy like %?1%")
    public Page<Product> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
