package ph.edu.up.antech.domain.sales.output;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.sales.master.Netsuite;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.NetsuiteService;
import ph.edu.up.antech.service.impl.NetsuiteServiceImpl;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        NetsuiteServiceImpl.class
})
public class GenerateNetsuiteTableInventoryFromNetsuiteTest {

    @Autowired
    private NetsuiteService netsuiteService;

    @Test
    public void generateUniqueProductNameFromNetsuiteList() {
        List<Netsuite> netsuiteList = netsuiteService.findNetsuiteByItemDate(LocalDate.of(2020, 02, 14));
        List<String> uniqueProductNameList = netsuiteList.stream()
                .map(Netsuite::getBrand)
                .distinct()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        Assert.assertNotNull(uniqueProductNameList);
    }

    @Test
    public void generateUniqueJarsProductNameFromNetsuiteList() {
        List<Netsuite> netsuiteList = netsuiteService.findNetsuiteByItemDate(LocalDate.of(2020, 02, 14));
        List<String> uniqueProductNameList = netsuiteList.stream()
                .map(Netsuite::getBrand)
                .distinct()
                .filter(Objects::nonNull)
                .filter(productName -> productName.startsWith("Jar"))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        Assert.assertNotNull(uniqueProductNameList);
    }

    @Test
    public void generateUniqueHippProductNameFromNetsuiteList() {
        List<Netsuite> netsuiteList = netsuiteService.findNetsuiteByItemDate(LocalDate.of(2020, 02, 14));
        List<String> uniqueProductNameList = netsuiteList.stream()
                .map(Netsuite::getBrand)
                .distinct()
                .filter(Objects::nonNull)
                .filter(productName -> productName.startsWith("CS") || productName.startsWith("S"))
                .collect(Collectors.toList());
        Assert.assertNotNull(uniqueProductNameList);
    }

    @Test
    public void generateUniqueKamReferenceNameFromNetsuiteList() {
        List<Netsuite> netsuiteList = netsuiteService.findNetsuiteByItemDate(LocalDate.of(2020, 02, 14));
        List<String> uniqueKamReferenceName = netsuiteList.stream()
                .map(Netsuite::getKamRefName1)
                .distinct()
                .filter(Objects::nonNull)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        Assert.assertNotNull(uniqueKamReferenceName);
    }

}
