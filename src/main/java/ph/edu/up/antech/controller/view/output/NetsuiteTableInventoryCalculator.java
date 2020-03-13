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
                .filter(netsuite -> productList.contains(netsuite.getBrand()))
                .collect(Collectors.toList());
    }

    public Integer calculateTotalAmountPerKamReferenceNamePerBrand(String kamReferenceName, String brand) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().equals(brand))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalHippAmountPerKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("S") || netsuite.getBrand().startsWith("CS"))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalJarAmountPerKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalWaterAmountPerKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .filter(netsuite -> netsuite.getRevenueConverted() != null)
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalUnitsPerKamReferenceNamePerBrand(String kamReferenceName, String brand) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().equals(brand))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalHippUnitsPerKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalJarUnitsPerKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalWaterUnitsPerKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("Water"))
                .filter(netsuite -> netsuite.getQuantity() != null)
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

}
