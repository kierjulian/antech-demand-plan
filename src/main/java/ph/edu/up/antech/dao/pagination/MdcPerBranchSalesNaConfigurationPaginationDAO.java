package ph.edu.up.antech.dao.pagination;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.master.config.MdcPerBranchSalesNaConfiguration;

public interface MdcPerBranchSalesNaConfigurationPaginationDAO extends PagingAndSortingRepository<MdcPerBranchSalesNaConfiguration, Integer> {

    @Query("select o from MdcPerBranchSalesNaConfiguration o where o.naName like %?1% or " +
            "o.dsm like %?1% or o.region like %?1%")
    public Page<MdcPerBranchSalesNaConfiguration> findAllByAnyColumnContaining(String filter, Pageable pageable);

}
