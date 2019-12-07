package ph.edu.up.antech.domain.sales.output;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.sales.master.ZolPerDoors;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.ZolPerDoorsService;
import ph.edu.up.antech.service.impl.ZolPerDoorsServiceImpl;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        ZolPerDoorsServiceImpl.class
})
public class GenerateDsrZolFromZolPerDoorsTest {

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @Test
    public void queryDistinctZolPerDoorsKamRefName_andPrintContents_shouldBeSuccessful() {
        List<String> kamReferenceNameList = zolPerDoorsService
                .findDistinctZolPerDoorsKamReferenceNameByLocalDate(LocalDate.of(2019, 12, 7));
        kamReferenceNameList.forEach(kamReferenceName -> {
            System.out.println(kamReferenceName);
        });
    }

    @Test
    public void queryDistinctZolPerDoorsAntechProductDescription_andPrintContents_shouldBeSuccessful() {
        List<String> antechProductDescriptionList = zolPerDoorsService
                .findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(LocalDate.of(2019, 12, 7));
        antechProductDescriptionList.forEach(antechProductDescription -> {
            System.out.println(antechProductDescription);
        });
    }

    @Test
    public void queryZolPerDoors_byDateAndKamRefNameAndAntechProductDesc_andPrintContents_shouldBeSuccessful() {
        List<ZolPerDoors> zolPerDoorsList = zolPerDoorsService
                .findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(LocalDate.of(2019, 12, 7),
                        "A. Errol Ramirez", "S2 800 BIB");
        zolPerDoorsList.forEach(zolPerDoors -> {
            System.out.println(zolPerDoors.getItemCode());
        });
    }

}
