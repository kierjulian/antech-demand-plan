package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.ZolMtPerBranchDAO;
import ph.edu.up.antech.domain.sales.master.ZolMtPerBranch;
import ph.edu.up.antech.service.ZolMtPerBranchService;

import java.time.LocalDate;
import java.util.List;

@Service
public class ZolMtPerBranchServiceImpl implements ZolMtPerBranchService {

    @Autowired
    private ZolMtPerBranchDAO zolMtPerBranchDAO;

    @Override
    public ZolMtPerBranch createZolMtPerBranch(ZolMtPerBranch zolMtPerBranch) {
        return zolMtPerBranchDAO.createZolMtPerBranch(zolMtPerBranch);
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

}
