package ph.edu.up.antech.controller.view.output;

import ph.edu.up.antech.domain.master.Netsuite;

import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NetsuiteTableInventoryCalculator {

    private List<Netsuite> netsuiteList;

    public NetsuiteTableInventoryCalculator(List<Netsuite> netsuiteList, List<String> productList) {
        this.netsuiteList = netsuiteList.stream()
                .filter(netsuite -> Objects.nonNull(netsuite.getMgmt()))
                .filter(netsuite -> Objects.nonNull(netsuite.getRegion()))
                .filter(netsuite -> Objects.nonNull(netsuite.getKamRefName1()))
                .filter(netsuite -> Objects.nonNull(netsuite.getBrand()))
                .filter(netsuite -> Objects.nonNull(netsuite.getRevenueConverted()))
                .filter(netsuite -> Objects.nonNull(netsuite.getConvUnits()))
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .collect(Collectors.toList());
    }

    public Integer calculateSalesAmountByMgmtAndProductCode(String mgmt, String productCode) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getBrand().equals(productCode))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateMilkSalesAmountByMgmt(String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateJarSalesAmountByMgmt(String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateWaterSalesAmountByMgmt(String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateSalesAmountByMgmtAndRegionAndProductCode(String mgmt, String region, String productCode) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getRegion().equals(region))
                .filter(netsuite -> netsuite.getBrand().equals(productCode))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateMilkSalesAmountByMgmtAndRegion(String mgmt, String region) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getRegion().equals(region))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateJarSalesAmountByMgmtAndRegion(String mgmt, String region) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getRegion().equals(region))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateWaterSalesAmountByMgmtAndRegion(String mgmt, String region) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getRegion().equals(region))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateSalesUnitByMgmtAndProductCode(String mgmt, String productCode) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getBrand().equals(productCode))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateMilkSalesUnitByMgmt(String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateJarSalesUnitByMgmt(String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateWaterSalesUnitByMgmt(String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateSalesUnitByMgmtAndRegionAndProductCode(String mgmt, String region, String productCode) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getRegion().equals(region))
                .filter(netsuite -> netsuite.getBrand().equals(productCode))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateMilkSalesUnitByMgmtAndRegion(String mgmt, String region) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getRegion().equals(region))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateJarSalesUnitByMgmtAndRegion(String mgmt, String region) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getRegion().equals(region))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateWaterSalesUnitByMgmtAndRegion(String mgmt, String region) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getMgmt().equals(mgmt))
                .filter(netsuite -> netsuite.getRegion().equals(region))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

}
