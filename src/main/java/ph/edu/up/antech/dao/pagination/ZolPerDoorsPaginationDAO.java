package ph.edu.up.antech.dao.pagination;

import org.springframework.data.repository.PagingAndSortingRepository;
import ph.edu.up.antech.domain.master.ZolPerDoors;

public interface ZolPerDoorsPaginationDAO extends PagingAndSortingRepository<ZolPerDoors, Integer> {
}
