package ph.edu.up.antech.domain.sales.master;

import ph.edu.up.antech.domain.sales.master.converter.ZolMtRaw;
import ph.edu.up.antech.domain.sales.raw.DailySalesDataDetail;
import ph.edu.up.antech.domain.sales.raw.ZolDailySalesPerBranch;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class MdcPerBranchSales {

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
    private String refcd;
    private String refcd1;
    private String netQuantity;
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
    private String slsyr;
    private String slsmo;
    private String slswk;
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
        this.refcd = dailySalesDataDetail.getRefcd();
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
        this.slsyr = dailySalesDataDetail.getSlsyr();
        this.slsmo = dailySalesDataDetail.getSlsmo();
        this.slswk = dailySalesDataDetail.getSlswk();
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
        //this.referenceDate = zolMtRaw.getRefdt();
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
        //this.slsyr = zolMtRaw.getSlsyr();
        //this.slsmo = zolMtRaw.getSlsmo();
        //this.slswk = zolMtRaw.getSlswk();
        this.appNum = zolMtRaw.getAppnum();
        this.poNum = zolMtRaw.getPonum();
        this.guartran = zolMtRaw.getGuartran();
        this.netSales = zolMtRaw.getNetsales();
        this.debtorCode = zolMtRaw.getDebtorCode();
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

    public String getRefcd() {
        return refcd;
    }

    public void setRefcd(String refcd) {
        this.refcd = refcd;
    }

    public String getRefcd1() {
        return refcd1;
    }

    public void setRefcd1(String refcd1) {
        this.refcd1 = refcd1;
    }

    public String getNetQuantity() {
        return netQuantity;
    }

    public void setNetQuantity(String netQuantity) {
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

    public String getSlsyr() {
        return slsyr;
    }

    public void setSlsyr(String slsyr) {
        this.slsyr = slsyr;
    }

    public String getSlsmo() {
        return slsmo;
    }

    public void setSlsmo(String slsmo) {
        this.slsmo = slsmo;
    }

    public String getSlswk() {
        return slswk;
    }

    public void setSlswk(String slswk) {
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

}
