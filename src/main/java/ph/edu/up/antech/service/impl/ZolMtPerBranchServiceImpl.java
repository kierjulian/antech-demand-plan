package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolMtPerBranchDAO;
import ph.edu.up.antech.domain.master.ZolMtPerBranch;
import ph.edu.up.antech.service.ZolMtPerBranchService;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ZolMtPerBranchServiceImpl implements ZolMtPerBranchService {

    @Autowired
    private ZolMtPerBranchDAO zolMtPerBranchDAO;

    @Override
    public ZolMtPerBranch saveZolMtPerBranch(ZolMtPerBranch zolMtPerBranch) {
        return zolMtPerBranchDAO.saveZolMtPerBranch(zolMtPerBranch);
    }

    @Override
    public List<ZolMtPerBranch> findZolMtPerBranchByLocalDate(LocalDate localDate) {
        return zolMtPerBranchDAO.findZolMtPerBranchByLocalDate(localDate);
    }

    @Override
    public void removeZolMtPerBranchById(Integer id) {
        zolMtPerBranchDAO.removeZolMtPerBranchById(id);
    }

    @Override
    public void removeZolMtPerBranchByLocalDate(LocalDate localDate) {
        zolMtPerBranchDAO.removeZolMtPerBranchByLocalDate(localDate);
    }

    @Override
    public void saveZolMtPerBranchByBatch(List<ZolMtPerBranch> zolMtPerBranchList) {
        zolMtPerBranchDAO.saveZolMtPerBranchByBatch(zolMtPerBranchList);
    }

    @Override
    public List<ZolMtPerBranch> findZolMtPerBranchBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        return zolMtPerBranchDAO.findZolMtPerBranchBetweenTwoDates(startDate, endDate);
    }

    @Override
    public ZolMtPerBranch findZolMtPerBranchById(Integer id) {
        return zolMtPerBranchDAO.findZolMtPerBranchById(id);
    }

    @Override
    public ZolMtPerBranch updateZolMtPerBranch(ZolMtPerBranch zolMtPerBranch) {
        return zolMtPerBranchDAO.updateZolMtPerBranch(zolMtPerBranch);
    }

}
