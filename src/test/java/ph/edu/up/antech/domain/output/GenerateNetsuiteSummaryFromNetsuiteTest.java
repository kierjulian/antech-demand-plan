package ph.edu.up.antech.domain.output;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.master.Netsuite;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.NetsuiteService;
import ph.edu.up.antech.service.impl.NetsuiteServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        NetsuiteServiceImpl.class
})
public class GenerateNetsuiteSummaryFromNetsuiteTest {

    @Autowired
    private NetsuiteService netsuiteService;

    @Test
    public void printUniqueBrand_fromNetsuiteFeb122020_shouldBeSuccessful() {
        List<Netsuite> netsuiteList = netsuiteService.findNetsuiteByItemDate(LocalDate.of(2020, 2, 12));
        List<String> uniqueProductList = netsuiteList.stream()
                .map(netsuite -> netsuite.getBrand())
                .distinct()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        Assert.assertNotNull(uniqueProductList);
    }

}
