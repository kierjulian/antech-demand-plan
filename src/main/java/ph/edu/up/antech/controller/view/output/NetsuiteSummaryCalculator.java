package ph.edu.up.antech.controller.view.output;

import ph.edu.up.antech.domain.sales.master.Netsuite;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NetsuiteSummaryCalculator {

    private List<Netsuite> netsuiteList;

    public NetsuiteSummaryCalculator(List<Netsuite> netsuiteList, List<String> productList) {
        this.netsuiteList = netsuiteList.stream()
                .filter(netsuite -> Objects.nonNull(netsuite.getKamRefName1()))
                .filter(netsuite -> Objects.nonNull(netsuite.getBrand()))
                .filter(netsuite -> Objects.nonNull(netsuite.getRevenueConverted()))
                .filter(netsuite -> Objects.nonNull(netsuite.getQuantity()))
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .collect(Collectors.toList());
    }

    public Integer calculateSalesAmountByProductCode(String product) {
        return netsuiteList.stream()
                .filter(netsuite -> product.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateMilkSalesAmount() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateJarSalesAmount() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateWaterSalesAmount() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateSalesAmount() {
        return netsuiteList.stream()
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateSalesUnitByProductCode(String product) {
        return netsuiteList.stream()
                .filter(netsuite -> product.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateMilkSalesUnit() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("CS"))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateJarSalesUnit() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateWaterSalesUnit() {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalUnit() {
        return netsuiteList.stream()
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateSalesAmountByTransferCatRecodeAndProductCode(
            String transfersCatRecode, String antechProductDescription) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> antechProductDescription.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateSalesUnitByTransfersCatRecodeAndProductCode(
            String transfersCatRecode, String antechProductDescription) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> antechProductDescription.equals(netsuite.getBrand()))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateMilkSalesAmountByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateJarSalesAmountByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateWaterSalesAmountByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateSalesAmountByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateMilkSalesUnitByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateJarSalesUnitByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateWaterSalesUnitByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateSalesUnitByTransfersCatRecode(String transfersCatRecode) {
        return netsuiteList.stream()
                .filter(netsuite -> transfersCatRecode.equals(netsuite.getTransfersCatRecode()))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

}
