package ph.edu.up.antech.domain.sales.master;

import ph.edu.up.antech.domain.sales.master.converter.*;
import ph.edu.up.antech.domain.sales.raw.DailySalesDataDetail;
import ph.edu.up.antech.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class MdcPerBranchSales {

    private Integer id;
    private LocalDate date;
    private String cono;
    private String rec;
    private String bran;
    private String satbrn;
    private String customerNo;
    private String shpcn;
    private String customerName;
    private String cadd1;
    private String cadd2;
    private String clazz;
    private String zipcd;
    private String sman;
    private String prin;
    private String subpr;
    private Integer refcd;
    private Integer refcd1;
    private Integer netQuantity;
    private BigDecimal netValue;
    private BigDecimal netValue2;
    private String sku;
    private String category;
    private BigDecimal grossValue;
    private Month month;
    private Year year;
    private LocalDate referenceDate;
    private String referenceNo;
    private String xreferenceNo;
    private String reasn;
    private String prodcd;
    private Integer quantityQr;
    private Integer quantitySh;
    private String um;
    private BigDecimal vlamt;
    private BigDecimal sellpr;
    private BigDecimal pds;
    private LocalDate expirationDate;
    private String lotNo;
    private String barcode;
    private String pdcode;
    private String dman;
    private BigDecimal findsc;
    private String framt;
    private Integer slsyr;
    private Integer slsmo;
    private Integer slswk;
    private String appNum;
    private String poNum;
    private String guartran;
    private BigDecimal netSales;
    private String debtorCode;
    private String strCode;
    private String coverage;
    private String reason;
    private String branchNo;
    private String naName;
    private String dsmName;
    private String coordinator;
    private String region;

    public MdcPerBranchSales(DailySalesDataDetail dailySalesDataDetail) {
        this.cono = dailySalesDataDetail.getCono();
        this.rec = dailySalesDataDetail.getRec();
        this.bran = dailySalesDataDetail.getBran();
        this.satbrn = dailySalesDataDetail.getSatbrn();
        this.customerNo = dailySalesDataDetail.getCustomerNo();
        this.shpcn = dailySalesDataDetail.getShpcn();
        this.cadd1 = dailySalesDataDetail.getCadd1();
        this.cadd2 = dailySalesDataDetail.getCadd2();
        this.clazz = dailySalesDataDetail.getClazz();
        this.zipcd = dailySalesDataDetail.getZipcd();
        this.sman = dailySalesDataDetail.getSman();
        this.prin = dailySalesDataDetail.getPrin();
        this.subpr = dailySalesDataDetail.getSubpr();
        this.referenceDate = dailySalesDataDetail.getReferenceDate();
        this.referenceNo = dailySalesDataDetail.getRefno();
        this.xreferenceNo = dailySalesDataDetail.getXrefno();
        this.reasn = dailySalesDataDetail.getReasn();
        this.prodcd = dailySalesDataDetail.getProdcd();
        this.quantityQr = dailySalesDataDetail.getQuantityOr();
        this.quantitySh = dailySalesDataDetail.getQuantitySh();
        this.um = dailySalesDataDetail.getUm();
        this.vlamt = dailySalesDataDetail.getVlamt();
        this.sellpr = dailySalesDataDetail.getSellpr();
        this.pds = dailySalesDataDetail.getPds();
        this.expirationDate = dailySalesDataDetail.getExpiryDate();
        this.lotNo = dailySalesDataDetail.getLotNo();
        this.barcode = dailySalesDataDetail.getBarcode();
        this.pdcode = dailySalesDataDetail.getPdcode();
        this.dman = dailySalesDataDetail.getDman();
        this.findsc = dailySalesDataDetail.getFindsc();
        this.appNum = dailySalesDataDetail.getAppnum();
        this.poNum = dailySalesDataDetail.getPonum();
        this.guartran = dailySalesDataDetail.getGuartran();
        this.netSales = dailySalesDataDetail.getNetSales();
        this.debtorCode = dailySalesDataDetail.getDebtorCode();
    }

    public MdcPerBranchSales(ZolMtRaw zolMtRaw) {
        this.cono = zolMtRaw.getCono();
        this.rec = zolMtRaw.getRec();
        this.bran = zolMtRaw.getBran();
        this.satbrn = zolMtRaw.getSatbrn();
        this.customerNo = zolMtRaw.getCusno();
        this.shpcn = zolMtRaw.getShpcn();
        this.customerName = zolMtRaw.getCustnm();
        this.cadd1 = zolMtRaw.getCadd1();
        this.cadd2 = zolMtRaw.getCadd2();
        this.clazz = zolMtRaw.getClazz();
        this.zipcd = zolMtRaw.getZipcd();
        this.sman = zolMtRaw.getSman();
        this.prin = zolMtRaw.getPrin();
        this.subpr = zolMtRaw.getSubpr();
        this.refcd = zolMtRaw.getRefcd();
        this.referenceDate = convertStringToLocalDate(zolMtRaw.getRefdt());
        this.referenceNo = zolMtRaw.getRefno();
        this.xreferenceNo = zolMtRaw.getXrefno();
        this.reasn = zolMtRaw.getReasn();
        this.prodcd = zolMtRaw.getProdcd();
        this.quantityQr = zolMtRaw.getQtyor();
        this.quantitySh = zolMtRaw.getQtysh();
        this.um = zolMtRaw.getUm();
        this.vlamt = zolMtRaw.getVlamt();
        this.sellpr = zolMtRaw.getSellPr();
        this.pds = zolMtRaw.getPds();
        //this.expirationDate = zolMtRaw.getExpdte();
        this.lotNo = zolMtRaw.getLotno();
        this.barcode = zolMtRaw.getBarcode();
        this.pdcode = zolMtRaw.getPdcode();
        this.dman = zolMtRaw.getDman();
        this.findsc = zolMtRaw.getFindsc();
        this.framt = zolMtRaw.getFrtamt();
        this.slsyr = zolMtRaw.getSlsyr();
        this.slsmo = zolMtRaw.getSlsmo();
        this.slswk = zolMtRaw.getSlswk();
        this.appNum = zolMtRaw.getAppnum();
        this.poNum = zolMtRaw.getPonum();
        this.guartran = zolMtRaw.getGuartran();
        this.netSales = zolMtRaw.getNetsales();
        this.debtorCode = zolMtRaw.getDebtorCode();
    }

    public MdcPerBranchSales(ZolMdcRaw zolMdcRaw) {
        this.cono = zolMdcRaw.getCono();
        this.rec = zolMdcRaw.getRec();
        this.bran = zolMdcRaw.getBran();
        this.satbrn = zolMdcRaw.getSatbrn();
        this.customerNo = zolMdcRaw.getCusno();
        this.shpcn = zolMdcRaw.getShpcn();
        this.customerName = zolMdcRaw.getCustnm();
        this.cadd1 = zolMdcRaw.getCadd1();
        this.cadd2 = zolMdcRaw.getCadd2();
        this.clazz = zolMdcRaw.getClazz();
        this.zipcd = zolMdcRaw.getZipcd();
        this.sman = zolMdcRaw.getSman();
        this.prin = zolMdcRaw.getPrin();
        this.subpr = zolMdcRaw.getSubpr();
        this.refcd = zolMdcRaw.getRefcd();
        this.referenceDate = convertStringToLocalDate(zolMdcRaw.getRefdt());
        this.referenceNo = zolMdcRaw.getRefno();
        this.xreferenceNo = zolMdcRaw.getXrefno();
        this.reasn = zolMdcRaw.getReasn();
        this.prodcd = zolMdcRaw.getProdcd();
        this.quantityQr = zolMdcRaw.getQtyor();
        this.quantitySh = zolMdcRaw.getQtysh();
        this.um = zolMdcRaw.getUm();
        this.vlamt = zolMdcRaw.getVlamt();
        this.sellpr = zolMdcRaw.getSellPr();
        this.pds = zolMdcRaw.getPds();
        this.expirationDate = convertStringToLocalDate(zolMdcRaw.getExpdte());
        this.lotNo = zolMdcRaw.getLotno();
        this.barcode = zolMdcRaw.getBarcode();
        this.pdcode = zolMdcRaw.getPdcode();
        this.dman = zolMdcRaw.getDman();
        this.findsc = zolMdcRaw.getFindsc();
        this.framt = zolMdcRaw.getFrtamt();
        this.slsyr = zolMdcRaw.getSlsyr();
        this.slsmo = zolMdcRaw.getSlsmo();
        this.slswk = zolMdcRaw.getSlswk();
        this.appNum = zolMdcRaw.getAppnum();
        this.poNum = zolMdcRaw.getPonum();
        this.guartran = zolMdcRaw.getGuartran();
        this.netSales = zolMdcRaw.getNetsales();
        this.debtorCode = zolMdcRaw.getDebtorCode();
    }

    public MdcPerBranchSales() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCono() {
        return cono;
    }

    public void setCono(String cono) {
        this.cono = cono;
    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public String getBran() {
        return bran;
    }

    public void setBran(String bran) {
        this.bran = bran;
    }

    public String getSatbrn() {
        return satbrn;
    }

    public void setSatbrn(String satbrn) {
        this.satbrn = satbrn;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getShpcn() {
        return shpcn;
    }

    public void setShpcn(String shpcn) {
        this.shpcn = shpcn;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCadd1() {
        return cadd1;
    }

    public void setCadd1(String cadd1) {
        this.cadd1 = cadd1;
    }

    public String getCadd2() {
        return cadd2;
    }

    public void setCadd2(String cadd2) {
        this.cadd2 = cadd2;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getZipcd() {
        return zipcd;
    }

    public void setZipcd(String zipcd) {
        this.zipcd = zipcd;
    }

    public String getSman() {
        return sman;
    }

    public void setSman(String sman) {
        this.sman = sman;
    }

    public String getPrin() {
        return prin;
    }

    public void setPrin(String prin) {
        this.prin = prin;
    }

    public String getSubpr() {
        return subpr;
    }

    public void setSubpr(String subpr) {
        this.subpr = subpr;
    }

    public Integer getRefcd() {
        return refcd;
    }

    public void setRefcd(Integer refcd) {
        this.refcd = refcd;
    }

    public Integer getRefcd1() {
        return refcd1;
    }

    public void setRefcd1(Integer refcd1) {
        this.refcd1 = refcd1;
    }

    public Integer getNetQuantity() {
        return netQuantity;
    }

    public void setNetQuantity(Integer netQuantity) {
        this.netQuantity = netQuantity;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public BigDecimal getNetValue2() {
        return netValue2;
    }

    public void setNetValue2(BigDecimal netValue2) {
        this.netValue2 = netValue2;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(BigDecimal grossValue) {
        this.grossValue = grossValue;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public LocalDate getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(LocalDate referenceDate) {
        this.referenceDate = referenceDate;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getXreferenceNo() {
        return xreferenceNo;
    }

    public void setXreferenceNo(String xreferenceNo) {
        this.xreferenceNo = xreferenceNo;
    }

    public String getReasn() {
        return reasn;
    }

    public void setReasn(String reasn) {
        this.reasn = reasn;
    }

    public String getProdcd() {
        return prodcd;
    }

    public void setProdcd(String prodcd) {
        this.prodcd = prodcd;
    }

    public Integer getQuantityQr() {
        return quantityQr;
    }

    public void setQuantityQr(Integer quantityQr) {
        this.quantityQr = quantityQr;
    }

    public Integer getQuantitySh() {
        return quantitySh;
    }

    public void setQuantitySh(Integer quantitySh) {
        this.quantitySh = quantitySh;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

    public BigDecimal getVlamt() {
        return vlamt;
    }

    public void setVlamt(BigDecimal vlamt) {
        this.vlamt = vlamt;
    }

    public BigDecimal getSellpr() {
        return sellpr;
    }

    public void setSellpr(BigDecimal sellpr) {
        this.sellpr = sellpr;
    }

    public BigDecimal getPds() {
        return pds;
    }

    public void setPds(BigDecimal pds) {
        this.pds = pds;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPdcode() {
        return pdcode;
    }

    public void setPdcode(String pdcode) {
        this.pdcode = pdcode;
    }

    public String getDman() {
        return dman;
    }

    public void setDman(String dman) {
        this.dman = dman;
    }

    public BigDecimal getFindsc() {
        return findsc;
    }

    public void setFindsc(BigDecimal findsc) {
        this.findsc = findsc;
    }

    public String getFramt() {
        return framt;
    }

    public void setFramt(String framt) {
        this.framt = framt;
    }

    public Integer getSlsyr() {
        return slsyr;
    }

    public void setSlsyr(Integer slsyr) {
        this.slsyr = slsyr;
    }

    public Integer getSlsmo() {
        return slsmo;
    }

    public void setSlsmo(Integer slsmo) {
        this.slsmo = slsmo;
    }

    public Integer getSlswk() {
        return slswk;
    }

    public void setSlswk(Integer slswk) {
        this.slswk = slswk;
    }

    public String getAppNum() {
        return appNum;
    }

    public void setAppNum(String appNum) {
        this.appNum = appNum;
    }

    public String getPoNum() {
        return poNum;
    }

    public void setPoNum(String poNum) {
        this.poNum = poNum;
    }

    public String getGuartran() {
        return guartran;
    }

    public void setGuartran(String guartran) {
        this.guartran = guartran;
    }

    public BigDecimal getNetSales() {
        return netSales;
    }

    public void setNetSales(BigDecimal netSales) {
        this.netSales = netSales;
    }

    public String getDebtorCode() {
        return debtorCode;
    }

    public void setDebtorCode(String debtorCode) {
        this.debtorCode = debtorCode;
    }

    public String getStrCode() {
        return strCode;
    }

    public void setStrCode(String strCode) {
        this.strCode = strCode;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }

    public String getNaName() {
        return naName;
    }

    public void setNaName(String naName) {
        this.naName = naName;
    }

    public String getDsmName() {
        return dsmName;
    }

    public void setDsmName(String dsmName) {
        this.dsmName = dsmName;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setOtherDetails() {
        computeRefcd1();
        computeNetQty();
        computeNetValue();
        computeNetValue2();
        computeGrossValue();
    }

    private void computeRefcd1() {
        if (refcd == 0) {
            refcd1 = 1;
        } else {
            refcd1 = -1;
        }
    }

    private void computeNetQty() {
        netQuantity = refcd1 * quantitySh;
    }

    private void computeNetValue() {
        if (vlamt != null) {
            netValue = BigDecimal.valueOf(refcd1)
                    .multiply(vlamt.divide(BigDecimal.valueOf(1.12), 2, RoundingMode.HALF_UP));
        }
    }

    private void computeNetValue2() {
        if (netValue != null) {
            netValue2 = netValue.multiply(BigDecimal.valueOf(0.91127))
                    .divide(BigDecimal.valueOf(1000), 2, RoundingMode.HALF_UP);
        }
    }

    private void computeGrossValue() {
        if (vlamt != null) {
            grossValue = vlamt.divide(BigDecimal.valueOf(1.12), 2, RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(0.91127))
                    .divide(BigDecimal.valueOf(1000), 2, RoundingMode.HALF_UP);
        }
    }

    public void generateValuesBasedOnMdcPerBranchSalesInformation(MdcPerBranchSalesInformation information) {
        if (information != null) {
            this.sku = information.getItemCode();
            this.category = information.getItemType();
        }
    }

    public void generateValuesBasedOnMdcPerBranchSalesAccount(MdcPerBranchSalesAccount account) {
        if (account != null) {
            this.strCode = account.getStrCode();
        }
    }

    public void generateValuesBasedOnMdcPerBranchSalesCoverage(MdcPerBranchSalesCoverage coverage) {
        if (coverage != null) {
            this.coverage = coverage.getNewCoverage();
            this.coordinator = coverage.getCoordinator();
            this.region = coverage.getRegion();
        }
    }

    public void generateValuesBasedOnMdcPerBranchSalesBrn(MdcPerBranchSalesBrn brn) {
        if (brn != null) {
            this.branchNo = brn.getBranchName();
            this.naName = brn.getNa();
        }
    }

    public void generateValuesBasedOnMdcPerBranchSalesNaConfiguration(MdcPerBranchSalesNaConfiguration configuration) {
        if (configuration != null) {
            this.dsmName = configuration.getDsm();
        }
    }

    public void generateValuesBasedOnMdcPerBranchSalesCode(MdcPerBranchSalesCode mdcPerBranchSalesCode) {
        if (mdcPerBranchSalesCode != null) {
            this.reason = mdcPerBranchSalesCode.getDescription();
        }
    }

    private LocalDate convertStringToLocalDate(String dateInString) {
        if (!StringUtils.isNullOrEmpty(dateInString)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            return LocalDate.parse(dateInString, formatter);
        }

        return null;
    }

}
