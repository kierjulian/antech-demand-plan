package ph.edu.up.antech.service;

import ph.edu.up.antech.domain.DemandPlan;

import java.time.Year;

public interface DemandPlanService {

    public DemandPlan saveDemandPlan(DemandPlan demandPlan);

    public DemandPlan updateDemandPlan(DemandPlan demandPlan);

    public DemandPlan findDemandPlanByProductIdAndYear(Integer productId, Year year);

    public DemandPlan findDemandPlanById(Integer id);

    public Integer findOldestDemandPlanId();

    public void removeDemandPlan(Integer id);

}
