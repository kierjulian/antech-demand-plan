package ph.edu.up.antech.domain.sales.master.converter;

import ph.edu.up.antech.domain.sales.raw.ZolDailySalesPerBranch;

import java.math.BigDecimal;

public class ZolMtRaw {

    private String cono;
    private String rec;
    private String bran;
    private String satbrn;
    private String cusno;
    private String shpcn;
    private String custnm;
    private String trim;
    private String accountName;
    private String cadd1;
    private String cadd2;
    private String clazz;
    private String zipcd;
    private String sman;
    private String prin;
    private String subpr;
    private Integer refcd;
    private Integer tag;
    private String netValueInString;
    private BigDecimal netValue;
    private String finalNetVatInString;
    private BigDecimal finalNetVat;
    private Integer units;
    private String refdt;
    private String refno;
    private String xrefno;
    private String reasn;
    private String prodcd;
    private String zapCode;
    private String itemDescription;
    private Integer qtyor;
    private Integer qtysh;
    private String um;
    private BigDecimal vlamt;
    private BigDecimal sellPr;
    private BigDecimal pds;
    private String expdte;
    private String lotno;
    private String barcode;
    private String pdcode;
    private String dman;
    private BigDecimal findsc;
    private String frtamt;
    private Integer slsyr;
    private Integer slsmo;
    private Integer slswk;
    private String appnum;
    private String ponum;
    private String guartran;
    private BigDecimal netsales;
    private String debtorCode;

    public ZolMtRaw() {
    }

    public ZolMtRaw(ZolDailySalesPerBranch zolDailySalesPerBranch) {
        this.cono = zolDailySalesPerBranch.getCono();
        this.rec = zolDailySalesPerBranch.getRec();
        this.bran = zolDailySalesPerBranch.getBran();
        this.satbrn = zolDailySalesPerBranch.getSatbrn();
        this.cusno = zolDailySalesPerBranch.getCusno();
        this.shpcn = zolDailySalesPerBranch.getShpcn();
        this.custnm = zolDailySalesPerBranch.getCustnm();
        this.cadd1 = zolDailySalesPerBranch.getCadd1();
        this.cadd2 = zolDailySalesPerBranch.getCadd2();
        this.clazz = zolDailySalesPerBranch.getClazz();
        this.zipcd = zolDailySalesPerBranch.getZipcd();
        this.sman = zolDailySalesPerBranch.getSman();
        this.prin = zolDailySalesPerBranch.getPrin();
        this.subpr = zolDailySalesPerBranch.getSubpr();
        this.refcd = zolDailySalesPerBranch.getRefcd();
        this.tag = zolDailySalesPerBranch.getTag();
        this.netValue = zolDailySalesPerBranch.getNetValue();
        this.finalNetVat = zolDailySalesPerBranch.getFinalNetVat();
        this.units = zolDailySalesPerBranch.getUnits();
        this.refdt = zolDailySalesPerBranch.getRefdt();
        this.refno = zolDailySalesPerBranch.getRefno();
        this.xrefno = zolDailySalesPerBranch.getXrefno();
        this.reasn = zolDailySalesPerBranch.getReasn();
        this.prodcd = zolDailySalesPerBranch.getProdcd();
        this.zapCode = zolDailySalesPerBranch.getZapCode();
        this.itemDescription = zolDailySalesPerBranch.getItemDescription();
        this.qtyor = zolDailySalesPerBranch.getQtyor();
        this.qtysh = zolDailySalesPerBranch.getQtysh();
        this.um = zolDailySalesPerBranch.getUm();
        this.vlamt = zolDailySalesPerBranch.getVlamt();
        this.sellPr = zolDailySalesPerBranch.getSellPr();
        this.pds = zolDailySalesPerBranch.getPds();
        this.expdte = zolDailySalesPerBranch.getExpdte();
        this.lotno = zolDailySalesPerBranch.getLotno();
        this.barcode = zolDailySalesPerBranch.getBarcode();
        this.pdcode = zolDailySalesPerBranch.getPdcode();
        this.dman = zolDailySalesPerBranch.getDman();
        this.findsc = zolDailySalesPerBranch.getFindsc();
        this.frtamt = zolDailySalesPerBranch.getFrtamt();
        this.slsyr = zolDailySalesPerBranch.getSlsyr();
        this.slsmo = zolDailySalesPerBranch.getSlsmo();
        this.slswk = zolDailySalesPerBranch.getSlswk();
        this.appnum = zolDailySalesPerBranch.getAppnum();
        this.ponum = zolDailySalesPerBranch.getPonum();
        this.guartran = zolDailySalesPerBranch.getGuartran();
        this.netsales = zolDailySalesPerBranch.getNetsales();
        this.debtorCode = zolDailySalesPerBranch.getDebtorCode();
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

    public String getCusno() {
        return cusno;
    }

    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    public String getShpcn() {
        return shpcn;
    }

    public void setShpcn(String shpcn) {
        this.shpcn = shpcn;
    }

    public String getCustnm() {
        return custnm;
    }

    public void setCustnm(String custnm) {
        this.custnm = custnm;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getNetValueInString() {
        return netValueInString;
    }

    public void setNetValueInString(String netValueInString) {
        this.netValueInString = netValueInString;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public String getFinalNetVatInString() {
        return finalNetVatInString;
    }

    public void setFinalNetVatInString(String finalNetVatInString) {
        this.finalNetVatInString = finalNetVatInString;
    }

    public BigDecimal getFinalNetVat() {
        return finalNetVat;
    }

    public void setFinalNetVat(BigDecimal finalNetVat) {
        this.finalNetVat = finalNetVat;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public String getRefdt() {
        return refdt;
    }

    public void setRefdt(String refdt) {
        this.refdt = refdt;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public String getXrefno() {
        return xrefno;
    }

    public void setXrefno(String xrefno) {
        this.xrefno = xrefno;
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

    public String getZapCode() {
        return zapCode;
    }

    public void setZapCode(String zapCode) {
        this.zapCode = zapCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Integer getQtyor() {
        return qtyor;
    }

    public void setQtyor(Integer qtyor) {
        this.qtyor = qtyor;
    }

    public Integer getQtysh() {
        return qtysh;
    }

    public void setQtysh(Integer qtysh) {
        this.qtysh = qtysh;
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

    public BigDecimal getSellPr() {
        return sellPr;
    }

    public void setSellPr(BigDecimal sellPr) {
        this.sellPr = sellPr;
    }

    public BigDecimal getPds() {
        return pds;
    }

    public void setPds(BigDecimal pds) {
        this.pds = pds;
    }

    public String getExpdte() {
        return expdte;
    }

    public void setExpdte(String expdte) {
        this.expdte = expdte;
    }

    public String getLotno() {
        return lotno;
    }

    public void setLotno(String lotno) {
        this.lotno = lotno;
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

    public String getFrtamt() {
        return frtamt;
    }

    public void setFrtamt(String frtamt) {
        this.frtamt = frtamt;
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

    public String getAppnum() {
        return appnum;
    }

    public void setAppnum(String appnum) {
        this.appnum = appnum;
    }

    public String getPonum() {
        return ponum;
    }

    public void setPonum(String ponum) {
        this.ponum = ponum;
    }

    public String getGuartran() {
        return guartran;
    }

    public void setGuartran(String guartran) {
        this.guartran = guartran;
    }

    public BigDecimal getNetsales() {
        return netsales;
    }

    public void setNetsales(BigDecimal netsales) {
        this.netsales = netsales;
    }

    public String getDebtorCode() {
        return debtorCode;
    }

    public void setDebtorCode(String debtorCode) {
        this.debtorCode = debtorCode;
    }

}
