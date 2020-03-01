package ph.edu.up.antech.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ph.edu.up.antech.dao.DemandPlanDAO;
import ph.edu.up.antech.domain.DemandPlan;
import ph.edu.up.antech.service.DemandPlanService;

import javax.transaction.Transactional;
import java.time.Year;

@Service
@Transactional
public class DemandPlanServiceImpl implements DemandPlanService {

    @Autowired
    private DemandPlanDAO demandPlanDAO;

    @Override
    public DemandPlan saveDemandPlan(DemandPlan demandPlan) {
        return demandPlanDAO.saveDemandPlan(demandPlan);
    }

    @Override
    public DemandPlan updateDemandPlan(DemandPlan demandPlan) {
        return demandPlanDAO.updateDemandPlan(demandPlan);
    }

    @Override
    public DemandPlan findDemandPlanByProductIdAndYear(Integer productId, Year year) {
        return demandPlanDAO.findDemandPlanByProductIdAndYear(productId, year);
    }

}
