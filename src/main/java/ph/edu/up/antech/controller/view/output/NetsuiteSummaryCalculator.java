package ph.edu.up.antech.controller.view.output;

import ph.edu.up.antech.domain.master.Netsuite;

import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NetsuiteSummaryCalculator {

    private List<Netsuite> netsuiteList;

    public NetsuiteSummaryCalculator(List<Netsuite> netsuiteList, List<String> productList) {
        this.netsuiteList = netsuiteList.stream()
                .filter(netsuite -> Objects.nonNull(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> Objects.nonNull(netsuite.getMgmt()))
                .filter(netsuite -> Objects.nonNull(netsuite.getRegion()))
                .filter(netsuite -> Objects.nonNull(netsuite.getKamRefName1()))
                .filter(netsuite -> Objects.nonNull(netsuite.getBrand()))
                .filter(netsuite -> Objects.nonNull(netsuite.getRevenueConverted()))
                .filter(netsuite -> Objects.nonNull(netsuite.getConvUnits()))
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .collect(Collectors.toList());
    }

    public Integer calculateSalesAmountByProductCode(String product) {
        return netsuiteList.stream()
                .filter(netsuite -> product.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateMilkSalesAmount() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateJarSalesAmount() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateWaterSalesAmount() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateSalesAmount() {
        return netsuiteList.stream()
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateSalesUnitByProductCode(String product) {
        return netsuiteList.stream()
                .filter(netsuite -> product.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateMilkSalesUnit() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateJarSalesUnit() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateWaterSalesUnit() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateTotalUnit() {
        return netsuiteList.stream()
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateSalesAmountByTransferCatRecodeAndProductCode(
            String transfersCatRecode, String antechProductDescription) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> antechProductDescription.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateSalesUnitByTransfersCatRecodeAndProductCode(
            String transfersCatRecode, String antechProductDescription) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> antechProductDescription.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateMilkSalesAmountByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateJarSalesAmountByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateWaterSalesAmountByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateSalesAmountByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateMilkSalesUnitByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateJarSalesUnitByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateWaterSalesUnitByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateSalesUnitByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .mapToInt(netsuite -> netsuite.getConvUnits())
                .sum();
    }

    public Integer calculateSalesAmountByTransfersCatRecodeAndMgmtAndProductCode(String transfersCatRecode, String mgmt,
                                                                                 String productCode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> productCode.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateMilkSalesAmountByTransfersCatRecodeAndMgmt(String transfersCatRecode, String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateJarSalesAmountByTransfersCatRecodeAndMgmt(String transfersCatRecode, String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateWaterSalesAmountByTransfersCatRecodeAndMgmt(String transfersCatRecode, String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateSalesAmountByTransfersCatRecodeAndMgmt(String transfersCatRecode, String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateSalesUnitByTransfersCatRecodeAndMgmtAndProductCode(String transfersCatRecode, String mgmt,
                                                                               String productCode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> productCode.equals(netsuite.getBrand()))
                .mapToInt(Netsuite::getConvUnits)
                .sum();
    }

    public Integer calculateMilkSalesUnitByTransfersCatRecodeAndMgmt(String transfersCatRecode, String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(Netsuite::getConvUnits)
                .sum();
    }

    public Integer calculateJarSalesUnitByTransfersCatRecodeAndMgmt(String transfersCatRecode, String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(Netsuite::getConvUnits)
                .sum();
    }

    public Integer calculateWaterSalesUnitByTransfersCatRecodeAndMgmt(String transfersCatRecode, String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(Netsuite::getConvUnits)
                .sum();
    }

    public Integer calculateSalesUnitByTransfersCatRecodeAndMgmt(String transfersCatRecode, String mgmt) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .mapToInt(Netsuite::getConvUnits)
                .sum();
    }

    public Integer calculateSalesAmountByTransfersCatRecodeAndMgmtAndRegionAndProductCode(String transfersCatRecode, String mgmt,
                                                                                          String region, String productCode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> region.equals(netsuite.getRegion()))
                .filter(netsuite -> productCode.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateMilkSalesAmountByTransfersCatRecodeAndMgmtAndRegion(String transfersCatRecode, String mgmt,
                                                                                String region) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> region.equals(netsuite.getRegion()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateJarSalesAmountByTransfersCatRecodeAndMgmtAndRegion(String transfersCatRecode, String mgmt,
                                                                               String region) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> region.equals(netsuite.getRegion()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateWaterSalesAmountByTransfersCatRecodeAndMgmtAndRegion(String transfersCatRecode, String mgmt,
                                                                                 String region) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> region.equals(netsuite.getRegion()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateSalesAmountByTransfersCatRecodeAndMgmtAndRegion(String transfersCatRecode, String mgmt, String region) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> region.equals(netsuite.getRegion()))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().setScale(0, RoundingMode.HALF_EVEN).intValue())
                .sum();
    }

    public Integer calculateSalesUnitByTransfersCatRecodeAndMgmtAndRegionAndProductCode(String transfersCatRecode, String mgmt,
                                                                               String region, String productCode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> region.equals(netsuite.getRegion()))
                .filter(netsuite -> productCode.equals(netsuite.getBrand()))
                .mapToInt(Netsuite::getConvUnits)
                .sum();
    }

    public Integer calculateMilkSalesUnitByTransfersCatRecodeAndMgmtAndRegion(String transfersCatRecode, String mgmt,
                                                                              String region) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> region.equals(netsuite.getRegion()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(Netsuite::getConvUnits)
                .sum();
    }

    public Integer calculateJarSalesUnitByTransfersCatRecodeAndMgmtAndRegion(String transfersCatRecode, String mgmt,
                                                                             String region) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> region.equals(netsuite.getRegion()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(Netsuite::getConvUnits)
                .sum();
    }

    public Integer calculateWaterSalesUnitByTransfersCatRecodeAndMgmtAndRegion(String transfersCatRecode, String mgmt,
                                                                               String region) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> region.equals(netsuite.getRegion()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(Netsuite::getConvUnits)
                .sum();
    }

    public Integer calculateSalesUnitByTransfersCatRecodeAndMgmtAndRegion(String transfersCatRecode, String mgmt,
                                                                          String region) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> mgmt.equals(netsuite.getMgmt()))
                .filter(netsuite -> region.equals(netsuite.getRegion()))
                .mapToInt(Netsuite::getConvUnits)
                .sum();
    }

}
