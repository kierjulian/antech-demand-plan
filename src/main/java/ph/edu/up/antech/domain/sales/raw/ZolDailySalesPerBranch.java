package ph.edu.up.antech.domain.sales.raw;

import com.opencsv.bean.CsvBindByName;
import ph.edu.up.antech.util.StringUtils;

import java.math.BigDecimal;

public class ZolDailySalesPerBranch {

    @CsvBindByName(column = "CONO")
    private String cono;

    @CsvBindByName(column = "REC")
    private String rec;

    @CsvBindByName(column = "BRAN")
    private String bran;

    @CsvBindByName(column = "SATBRN")
    private String satbrn;

    @CsvBindByName(column = "CUSNO")
    private String cusno;

    @CsvBindByName(column = "SHPCN")
    private String shpcn;

    @CsvBindByName(column = "CUSTNM")
    private String custnm;

    @CsvBindByName(column = "CADD1")
    private String cadd1;

    @CsvBindByName(column = "CADD2")
    private String cadd2;

    @CsvBindByName(column = "CLASS")
    private String clazz;

    @CsvBindByName(column = "ZIPCD")
    private String zipcd;

    @CsvBindByName(column = "SMAN")
    private String sman;

    @CsvBindByName(column = "PRIN")
    private String prin;

    @CsvBindByName(column = "SUBPR")
    private String subpr;

    @CsvBindByName(column = "REFCD")
    private Integer refcd;

    @CsvBindByName(column = "TAG")
    private Integer tag;

    @CsvBindByName(column = "NET VALUE")
    private String netValueInString;

    private BigDecimal netValue;

    @CsvBindByName(column = "Final Net Vat")
    private String finalNetVatInString;

    private BigDecimal finalNetVat;

    @CsvBindByName(column = "UNITS")
    private Integer units;

    @CsvBindByName(column = "REFDT")
    private String refdt;

    @CsvBindByName(column = "REFNO")
    private String refno;

    @CsvBindByName(column = "XREFNO")
    private String xrefno;

    @CsvBindByName(column = "REASN")
    private String reasn;

    @CsvBindByName(column = "PRODCD")
    private String prodcd;

    @CsvBindByName(column = "ZAP CODE")
    private String zapCode;

    @CsvBindByName(column = "Item Description")
    private String itemDescription;

    @CsvBindByName(column = "QTYOR")
    private Integer qtyor;

    @CsvBindByName(column = "QTYSH")
    private Integer qtysh;

    @CsvBindByName(column = "UM")
    private String um;

    @CsvBindByName(column = "VLAMT")
    private BigDecimal vlamt;

    @CsvBindByName(column = "SELLPR")
    private BigDecimal sellPr;

    @CsvBindByName(column = "PDS")
    private BigDecimal pds;

    @CsvBindByName(column = "EXPDTE")
    private String expdte;

    @CsvBindByName(column = "LOTNO")
    private String lotno;

    @CsvBindByName(column = "BARCDE")
    private String barcode;

    @CsvBindByName(column = "PDCODE")
    private String pdcode;

    @CsvBindByName(column = "DMAN")
    private String dman;

    @CsvBindByName(column = "FINDSC")
    private String findscInString;

    private BigDecimal findsc;

    @CsvBindByName(column = "FRTAMT")
    private String frtamt;

    @CsvBindByName(column = "SLSYR")
    private Integer slsyr;

    @CsvBindByName(column = "SLSMO")
    private Integer slsmo;

    @CsvBindByName(column = "SLSWK")
    private Integer slswk;

    @CsvBindByName(column = "APPNUM")
    private String appnum;

    @CsvBindByName(column = "PONUM")
    private String ponum;

    @CsvBindByName(column = "GUARTRAN")
    private String guartran;

    @CsvBindByName(column = "NETSALES")
    private BigDecimal netsales;

    @CsvBindByName(column = "DEBTORCODE")
    private String debtorCode;

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

    public String getFinalNetVatInString() {
        return finalNetVatInString;
    }

    public void setFinalNetVatInString(String finalNetVatInString) {
        this.finalNetVatInString = finalNetVatInString;
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

    public String getFindscInString() {
        return findscInString;
    }

    public void setFindscInString(String findscInString) {
        this.findscInString = findscInString;
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

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public BigDecimal getFinalNetVat() {
        return finalNetVat;
    }

    public void setFinalNetVat(BigDecimal finalNetVat) {
        this.finalNetVat = finalNetVat;
    }

    public void convertStringValuesToCorrectTypes() {
        convertNetValueInStringToBigDecimal();
        convertFinalNetVatInStringToBigDecimal();
        convertFindscInStringToBigDecimal();
    }

    private void convertNetValueInStringToBigDecimal() {
        if (!StringUtils.isTrimmedValueNullOrEmpty(netValueInString)
                && !netValueInString.contains("#")) {
            String netValueInString1 = org.apache.commons.lang3.StringUtils.trim(netValueInString);
            String netValueInString2 = org.apache.commons.lang3.StringUtils.stripEnd(netValueInString1, "-");
            netValue = new BigDecimal(
                    netValueInString2.replaceAll(",", "").trim());
        }
    }

    private void convertFinalNetVatInStringToBigDecimal() {
        if (!StringUtils.isTrimmedValueNullOrEmpty(finalNetVatInString)
                && !finalNetVatInString.contains("#")) {
            String finalNetVatInString1 = org.apache.commons.lang3.StringUtils.trim(finalNetVatInString);
            String finalNetVatInString2 = org.apache.commons.lang3.StringUtils.stripEnd(finalNetVatInString1, "-");
            finalNetVat = new BigDecimal(finalNetVatInString2.replaceAll(",", "").trim());
        }
    }

    private void convertFindscInStringToBigDecimal() {
        if (!StringUtils.isTrimmedValueNullOrEmpty(findscInString)) {
            findscInString = org.apache.commons.lang3.StringUtils.stripEnd(findscInString, "-");
            findsc = new BigDecimal(findscInString.replaceAll(",", "").trim());
        }
    }

}

