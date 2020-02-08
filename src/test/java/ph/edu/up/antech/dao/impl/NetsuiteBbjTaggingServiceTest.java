package ph.edu.up.antech.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.sales.master.converter.NetsuiteBbjTagging;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.NetsuiteBbjTaggingService;
import ph.edu.up.antech.service.impl.NetsuiteBbjTaggingServiceImpl;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        NetsuiteBbjTaggingServiceImpl.class
})
public class NetsuiteBbjTaggingServiceTest {

    @Autowired
    private NetsuiteBbjTaggingService netsuiteBbjTaggingService;

    @Test
    public void queryFindAllNetsuiteBbjTagging_shouldBeSuccessful() {
        List<NetsuiteBbjTagging> netsuiteBbjTaggingList = netsuiteBbjTaggingService.findAllNetsuiteBbjTagging();
        netsuiteBbjTaggingList.forEach(netsuiteBbjTagging -> {
            System.out.println(netsuiteBbjTagging.getId());
        });
    }

}
