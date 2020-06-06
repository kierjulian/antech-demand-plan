package ph.edu.up.antech.dao.impl;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.DemandPlan;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.DemandPlanService;
import ph.edu.up.antech.service.ProductService;
import ph.edu.up.antech.service.impl.DemandPlanServiceImpl;
import ph.edu.up.antech.service.impl.ProductServiceImpl;

import java.time.Year;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        ProductServiceImpl.class, DemandPlanServiceImpl.class
})
public class DemandPlanServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private DemandPlanService demandPlanService;

    @Ignore
    public void createAndPersistDemandPlan_shouldBeSuccessful() {
        DemandPlan demandPlan = new DemandPlan();
        demandPlan.setYear(Year.now());
        demandPlan.setProduct(productService.findProductById(16));
        demandPlan.generateDemandPlanDetails();
        //demandPlanService.saveDemandPlan(demandPlan);
    }

    @Test
    public void retrievePersistedDemandPlan_shouldBeSuccessful() {
        DemandPlan demandPlan = demandPlanService.findDemandPlanByProductIdAndYear(14, Year.of(2020));
        //Assert.assertNotNull(demandPlan);
    }

}
