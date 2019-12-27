package ph.edu.up.antech.domain.sales.output;

import org.junit.Assert;
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
import ph.edu.up.antech.util.DsrZolCalculator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void convertZolPerDoorsToDsrZol_andPrintContents_shouldBeSuccessful() {
        List<DsrZol> dsrZolList = new ArrayList<>();
        List<String> kamReferenceNameList = zolPerDoorsService
                .findDistinctZolPerDoorsKamReferenceNameByLocalDate(LocalDate.of(2019, 12, 7));
        List<String> antechProductDescriptionList = zolPerDoorsService
                .findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(LocalDate.of(2019, 12, 7));

        for (String kamReferenceName : kamReferenceNameList) {
            for (String antechProductDescription : antechProductDescriptionList) {
                List<ZolPerDoors> zolPerDoorsList = zolPerDoorsService
                        .findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(LocalDate.of(2019, 12, 7),
                                kamReferenceName, antechProductDescription);
                for (ZolPerDoors zolPerDoors : zolPerDoorsList) {
                    DsrZol dsrZol = new DsrZol(zolPerDoors);
                    dsrZolList.add(dsrZol);
                }
            }
        }

        dsrZolList.forEach(dsrZol -> {
            if (dsrZol.getAntechProductDescription().equals("S4 1600 BIB")) {
                System.out.println(dsrZol.getAntechProductDescription());
                System.out.println(dsrZol.getKamReferenceName());
                System.out.println(dsrZol.getAccount());
                System.out.println(dsrZol.getAmount());
                System.out.println(dsrZol.getSalesUnit());
                System.out.println();
            }
        });

        DsrZolCalculator dsrZolCalculator = new DsrZolCalculator(dsrZolList);
        Assert.assertEquals(Integer.valueOf(185), dsrZolCalculator.calculateTotalAmountPerAccountPerProduct("A. Errol Ramirez", "S3 800 BIB"));
        Assert.assertEquals(Integer.valueOf(205), dsrZolCalculator.calculateTotalUnitsPerAccountPerProduct("A. Errol Ramirez", "S3 800 BIB"));
    }

    @Test
    public void convertListOfDsrZolToDsrZolCombinationList_andPrintContents_shouldBeSuccessful() {
        List<DsrZol> dsrZolList = new ArrayList<>();
        List<String> kamReferenceNameList = zolPerDoorsService
                .findDistinctZolPerDoorsKamReferenceNameByLocalDate(LocalDate.of(2019, 12, 7));
        List<String> antechProductDescriptionList = zolPerDoorsService
                .findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(LocalDate.of(2019, 12, 7));

        for (String kamReferenceName : kamReferenceNameList) {
            for (String antechProductDescription : antechProductDescriptionList) {
                List<ZolPerDoors> zolPerDoorsList = zolPerDoorsService
                        .findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(LocalDate.of(2019, 12, 7),
                                kamReferenceName, antechProductDescription);
                for (ZolPerDoors zolPerDoors : zolPerDoorsList) {
                    DsrZol dsrZol = new DsrZol(zolPerDoors);
                    dsrZolList.add(dsrZol);
                }
            }
        }

        List<DsrZol> dsrZolListFiltered = dsrZolList.stream()
                .filter(dsrZol -> dsrZol.getKamReferenceName().equals("E. Rick Tilawan - Min"))
                .filter(dsrZol -> dsrZol.getAccount().equals("LTS SUPERMARKETS"))
                .collect(Collectors.toList());

        DsrZolCombination dsrZolCombination = new DsrZolCombination(dsrZolListFiltered);
        System.out.println(dsrZolCombination.getKamReferenceName());
        System.out.println(dsrZolCombination.getAccount());
        System.out.println();

        dsrZolCombination.getProductSalesAmountAndUnitList().forEach(productSalesAmountAndUnit -> {
            System.out.println(productSalesAmountAndUnit.getProduct());
            System.out.println(productSalesAmountAndUnit.getAmount());
            System.out.println(productSalesAmountAndUnit.getSalesUnit());
            System.out.println();
        });

    }

}
