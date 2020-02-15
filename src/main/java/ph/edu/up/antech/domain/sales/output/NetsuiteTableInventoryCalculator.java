package ph.edu.up.antech.domain.sales.output;

import ph.edu.up.antech.domain.sales.master.Netsuite;

import java.util.List;

public class NetsuiteTableInventoryCalculator {

    private List<Netsuite> netsuiteList;

    public NetsuiteTableInventoryCalculator(List<Netsuite> netsuiteList) {
        this.netsuiteList = netsuiteList;
    }

    public Integer calculateTotalAmountPerKamReferenceNamePerBrand(String kamReferenceName, String brand) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null
                        && netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().equals(brand))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalHippAmountPerKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("S") || netsuite.getBrand().startsWith("CS"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalJarAmountPerKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getRevenueConverted().intValue())
                .sum();
    }

    public Integer calculateTotalUnitsPerKamReferenceNamePerBrand(String kamReferenceName, String brand) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null
                        && netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().equals(brand))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalHippUnitsPerKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("CS") || netsuite.getBrand().startsWith("S"))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

    public Integer calculateTotalJarUnitsPerKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> netsuite.getBrand() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .filter(netsuite -> netsuite.getBrand().startsWith("Jar"))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

}
