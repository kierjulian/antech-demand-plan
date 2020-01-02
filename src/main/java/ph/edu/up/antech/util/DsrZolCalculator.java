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
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateTotalUnitsPerAccountPerProduct(
            String kamReferenceName, String antechProductDescription) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateTotalAmountPerProduct(String antechProductDescription) {
        return dsrZolList.stream()
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateTotalUnitsPerProduct(String antechProductDescription) {
        return dsrZolList.stream()
                .filter(dsrZol -> antechProductDescription.equals(dsrZol.getAntechProductDescription()))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateTotalAmountPerAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateTotalUnitsPerAccount(String kamReferenceName) {
        return dsrZolList.stream()
                .filter(dsrZol -> kamReferenceName.equals(dsrZol.getKamReferenceName()))
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }

    public Integer calculateTotalAmount() {
        return dsrZolList.stream()
                .mapToInt(dsrZol -> dsrZol.getAmount())
                .sum();
    }

    public Integer calculateTotalUnits() {
        return dsrZolList.stream()
                .mapToInt(dsrZol -> dsrZol.getSalesUnit())
                .sum();
    }


}
