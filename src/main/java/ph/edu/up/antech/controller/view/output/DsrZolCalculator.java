package ph.edu.up.antech.controller.view.output;

import ph.edu.up.antech.domain.sales.output.DsrZol;

import java.util.List;
import java.util.stream.Collectors;

public class DsrZolCalculator {

    private List<DsrZol> dsrZolList;

    public DsrZolCalculator(List<DsrZol> dsrZolList, List<String> productList) {
        this.dsrZolList = dsrZolList.stream()
                .filter(dsrZol -> productList.contains(dsrZol.getAntechProductDescription()))
                .collect(Collectors.toList());
    }

    public Integer calculateSalesAmountByAccountAndProductCode(
            String kamReferenceName, String antechProductDescription) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateSalesUnitByAccountAndProductCode(
            String kamReferenceName, String antechProductDescription) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateSalesAmountByProductCode(String antechProductDescription) {
        return dsrZolList.stream()
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateSalesUnitByProductCode(String antechProductDescription) {
        return dsrZolList.stream()
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateMilkSalesAmountByAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("C") || dsrZol.getAntechProductDescription().startsWith("S"))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateJarSalesAmountByAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("Jar"))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateWaterSalesAmountByAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("Water"))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateSalesAmountByAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateMilkSalesUnitByAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("C") || dsrZol.getAntechProductDescription().startsWith("S"))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateJarSalesUnitsByAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("Jar"))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateWaterSalesUnitByAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("Water"))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateSalesUnitByAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateMilkSalesAmount() {
        return dsrZolList.stream()
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("C") || dsrZol.getAntechProductDescription().startsWith("S"))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateJarSalesAmount() {
        return dsrZolList.stream()
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("Jar"))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateWaterSalesAmount() {
        return dsrZolList.stream()
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("Water"))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateTotalAmount() {
        return dsrZolList.stream()
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateMilkSalesUnit() {
        return dsrZolList.stream()
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("C") || dsrZol.getAntechProductDescription().startsWith("S"))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateJarSalesUnit() {
        return dsrZolList.stream()
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("Jar"))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateWaterSalesUnit() {
        return dsrZolList.stream()
                .filter(dsrZol -> dsrZol.getAntechProductDescription().startsWith("Water"))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateTotalUnit() {
        return dsrZolList.stream()
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }


}
