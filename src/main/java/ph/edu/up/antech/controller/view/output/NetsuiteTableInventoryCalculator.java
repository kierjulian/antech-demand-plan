package ph.edu.up.antech.controller.view.output;

import ph.edu.up.antech.domain.sales.master.Netsuite;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NetsuiteTableInventoryCalculator {

    private List<Netsuite> netsuiteList;

    public NetsuiteTableInventoryCalculator(List<Netsuite> netsuiteList, List<String> productList) {
        this.netsuiteList = netsuiteList.stream()
                .filter(netsuite -> Objects.nonNull(netsuite.getKamRefName1()))
                .filter(netsuite -> Objects.nonNull(netsuite.getBrand()))
                .filter(netsuite -> Objects.nonNull(netsuite.getRevenueConverted()))
                .filter(netsuite -> Objects.nonNull(netsuite.getQuantity()))
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .collect(Collectors.toList());
    }

    public Integer calculateSalesAmountByKamReferenceNameAndProductCode(String kamReferenceName, String brand) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().equals(brand))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateMilkSalesAmountByKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("S") || netsuite.getBrand().startsWith("CS"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateJarSalesAmountByKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateWaterSalesAmountByKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateSalesUnitByKamReferenceNameAndProductCode(String kamReferenceName, String brand) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().equals(brand))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateMilkSalesUnitByKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateJarSalesUnitByKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateWaterSalesUnitByKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

}
