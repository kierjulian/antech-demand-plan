package ph.edu.up.antech.util;

import ph.edu.up.antech.domain.sales.output.DsrZol;

import java.util.List;

public class DsrZolCalculator {

    private List<DsrZol> dsrZolList;

    public DsrZolCalculator(List<DsrZol> dsrZolList) {
        this.dsrZolList = dsrZolList;
    }

    public Integer calculateTotalAmountPerAccountPerProduct(
            String kamReferenceName, String antechProductDescription) {
        Integer amount = dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
        return amount;
    }

    public Integer calculateTotalUnitsPerAccountPerProduct(
            String kamReferenceName, String antechProductDescription) {
        Integer amount = dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
        return amount;
    }

    public Integer calculateTotalAmountPerProduct(String antechProductDescription) {
        Integer amount = dsrZolList.stream()
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
        return amount;
    }

    public Integer calculateTotalUnitsPerProduct(String antechProductDescription) {
        Integer amount = dsrZolList.stream()
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
        return amount;
    }

    public Integer calculateTotalAmountPerAccount(String kamReferenceName) {
        Integer amount = dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
        return amount;
    }

    public Integer calculateTotalUnitsPerAccount(String kamReferenceName) {
        Integer amount = dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
        return amount;
    }

    public Integer calculateTotalAmount() {
        Integer amount = dsrZolList.stream()
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
        return amount;
    }

    public Integer calculateTotalUnits() {
        Integer amount = dsrZolList.stream()
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
        return amount;
    }


}
