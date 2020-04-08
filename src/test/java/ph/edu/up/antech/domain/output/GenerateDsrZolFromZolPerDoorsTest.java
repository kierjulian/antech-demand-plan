package ph.edu.up.antech.domain.output;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ph.edu.up.antech.domain.Product;
import ph.edu.up.antech.domain.master.ZolPerDoors;
import ph.edu.up.antech.runner.Application;
import ph.edu.up.antech.service.ProductService;
import ph.edu.up.antech.service.ZolPerDoorsService;
import ph.edu.up.antech.service.impl.ProductServiceImpl;
import ph.edu.up.antech.service.impl.ZolPerDoorsServiceImpl;
import ph.edu.up.antech.controller.view.output.DsrZolCalculator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {
        ZolPerDoorsServiceImpl.class, ProductServiceImpl.class
})
public class GenerateDsrZolFromZolPerDoorsTest {

    @Autowired
    private ZolPerDoorsService zolPerDoorsService;

    @Autowired
    private ProductService productService;

    @Test
    public void queryDistinctZolPerDoorsKamRefName_andPrintContents_shouldBeSuccessful() {
        List<String> kamReferenceNameList = zolPerDoorsService
                .findDistinctZolPerDoorsKamReferenceNameByLocalDate(LocalDate.of(2019, 12, 7));
        Assert.assertNotNull(kamReferenceNameList);
    }

    @Test
    public void queryDistinctZolPerDoorsAntechProductDescription_andPrintContents_shouldBeSuccessful() {
        List<String> antechProductDescriptionList = zolPerDoorsService
                .findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(LocalDate.of(2019, 12, 7));
        Assert.assertNotNull(antechProductDescriptionList);
    }

    @Test
    public void queryZolPerDoors_byDateAndKamRefNameAndAntechProductDesc_andPrintContents_shouldBeSuccessful() {
        List<ZolPerDoors> zolPerDoorsList = zolPerDoorsService
                .findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(LocalDate.of(2019, 12, 7),
                        "A. Errol Ramirez", "S2 800 BIB");
        Assert.assertNotNull(zolPerDoorsList);
    }

    @Test
    public void convertZolPerDoorsToDsrZol_andPrintContents_shouldBeSuccessful() {
        List<DsrZol> dsrZolList = new ArrayList<>();
        List<String> kamReferenceNameList = zolPerDoorsService
                .findDistinctZolPerDoorsKamReferenceNameByLocalDate(LocalDate.of(2019, 12, 7));
        List<String> antechProductDescriptionList = zolPerDoorsService
                .findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(LocalDate.of(2019, 12, 7));

        kamReferenceNameList.forEach(kamReferenceName -> {
            antechProductDescriptionList.forEach(antechProductDescription -> {
                List<ZolPerDoors> zolPerDoorsList = zolPerDoorsService
                        .findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(LocalDate.of(2019, 12, 7),
                                kamReferenceName, antechProductDescription);
                zolPerDoorsList.forEach(zolPerDoors -> {
                    DsrZol dsrZol = new DsrZol(zolPerDoors);
                    dsrZolList.add(dsrZol);
                });
            });
        });

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

        DsrZolCalculator dsrZolCalculator = new DsrZolCalculator(dsrZolList, productService.findAllProducts().stream()
                .map(Product::getCode)
                .collect(Collectors.toList()));
        Assert.assertEquals(Integer.valueOf(185), dsrZolCalculator.calculateSalesAmountByAccountAndProductCode("A. Errol Ramirez", "S3 800 BIB"));
        Assert.assertEquals(Integer.valueOf(205), dsrZolCalculator.calculateSalesUnitByAccountAndProductCode("A. Errol Ramirez", "S3 800 BIB"));
    }

    @Test
    public void convertListOfDsrZolToDsrZolCombinationList_andPrintContents_shouldBeSuccessful() {
        List<DsrZol> dsrZolList = new ArrayList<>();
        List<String> kamReferenceNameList = zolPerDoorsService
                .findDistinctZolPerDoorsKamReferenceNameByLocalDate(LocalDate.of(2019, 12, 7));
        List<String> antechProductDescriptionList = zolPerDoorsService
                .findDistinctZolPerDoorsAntechProductDescriptionByLocalDate(LocalDate.of(2019, 12, 7));

        kamReferenceNameList.forEach(kamReferenceName -> {
            antechProductDescriptionList.forEach(antechProductDescription -> {
                List<ZolPerDoors> zolPerDoorsList = zolPerDoorsService
                        .findZolPerDoorsByAccountsByProductDescriptionAndLocalDate(LocalDate.of(2019, 12, 7),
                                kamReferenceName, antechProductDescription);
                zolPerDoorsList.forEach(zolPerDoors -> {
                    DsrZol dsrZol = new DsrZol(zolPerDoors);
                    dsrZolList.add(dsrZol);
                });
            });
        });

        List<DsrZol> dsrZolListFiltered = dsrZolList.stream()
                .filter(dsrZol -> dsrZol.getKamReferenceName().equals("A. Errol Ramirez"))
                .filter(dsrZol -> dsrZol.getAccount().equals("ROBINSONS"))
                .collect(Collectors.toList());

        DsrZolCombination dsrZolCombination = new DsrZolCombination(dsrZolListFiltered);
        dsrZolCombination.getProductSalesAmountAndUnitList().forEach(productSalesAmountAndUnit -> {
            System.out.println(productSalesAmountAndUnit.getProduct());
            System.out.println(productSalesAmountAndUnit.getSalesAmount());
            System.out.println(productSalesAmountAndUnit.getSalesUnit());
            System.out.println();
        });

    }

}
