package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolMdcPerBranchDAO;
import ph.edu.up.antech.domain.sales.master.ZolMdcPerBranch;
import ph.edu.up.antech.service.ZolMdcPerBranchService;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ZolMdcPerBranchServiceImpl implements ZolMdcPerBranchService {

    @Autowired
    private ZolMdcPerBranchDAO zolMdcPerBranchDAO;

    @Override
    public ZolMdcPerBranch createZolMdcPerBranch(ZolMdcPerBranch zolMdcPerBranch) {
        return zolMdcPerBranchDAO.createZolMdcPerBranch(zolMdcPerBranch);
    }

    @Override
    public List<ZolMdcPerBranch> findZolMdcPerBranchByLocalDate(LocalDate localDate) {
        return zolMdcPerBranchDAO.findZolMdcPerBranchByLocalDate(localDate);
    }

    @Override
    public void removeZolMdcPerBranchById(Integer id) {
        zolMdcPerBranchDAO.removeZolMdcPerBranchById(id);
    }

    @Override
    public void removeZolMdcPerBranchByLocalDate(LocalDate localDate) {
        zolMdcPerBranchDAO.removeZolMdcPerBranchByLocalDate(localDate);
    }

    @Override
    public void saveZolMdcPerBranchByBatch(List<ZolMdcPerBranch> zolMdcPerBranchList) {
        zolMdcPerBranchDAO.saveZolMdcPerBranchByBatch(zolMdcPerBranchList);
    }

    @Override
    public List<ZolMdcPerBranch> findZolMdcPerBranchBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        return zolMdcPerBranchDAO.findZolMdcPerBranchBetweenTwoDates(startDate, endDate);
    }

}
