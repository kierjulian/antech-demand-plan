package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.sales.master.converter.ZolPerDoorsGeneralInformation;

public interface ZolPerDoorsGeneralInformationPaginationDAO extends PagingAndSortingRepository<ZolPerDoorsGeneralInformation, Integer> {

    @Query("select o from ZolPerDoorsGeneralInformation o where o.zpcItemCode like %?1% or " +
            "o.itemCode like %?1% or o.itemName like %?1% or o.antechProductDescription like %?1% or " +
            "o.pcsCs like %?1% or o.pcAmount like %?1% or o.pcAmount like %?1% or o.pcAmount like %?1% " +
            "or o.pcAmount like %?1% or o.oldPrice like %?1% or o.newPrice like %?1%")
    public Page<ZolPerDoorsGeneralInformation> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
