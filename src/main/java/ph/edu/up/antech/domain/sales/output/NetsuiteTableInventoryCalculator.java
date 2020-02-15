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

    public Integer calculateTotalAmountPerKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
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

    public Integer calculateTotalUnitsPerKamReferenceName(String kamReferenceName) {
        return netsuiteList.stream()
                .filter(netsuite -> netsuite.getKamRefName1() != null)
                .filter(netsuite -> netsuite.getKamRefName1().equals(kamReferenceName))
                .mapToInt(netsuite -> netsuite.getQuantity())
                .sum();
    }

}
