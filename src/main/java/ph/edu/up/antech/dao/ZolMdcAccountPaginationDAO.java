package ph.edu.up.antech.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.sales.master.converter.ZolMdcAccount;

public interface ZolMdcAccountPaginationDAO extends PagingAndSortingRepository<ZolMdcAccount, Integer> {
}
