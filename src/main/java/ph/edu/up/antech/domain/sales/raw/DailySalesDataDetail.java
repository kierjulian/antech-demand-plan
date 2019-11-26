package ph.edu.up.antech.domain.sales.raw;

import com.opencsv.bean.CsvBindByName;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailySalesDataDetail {

    @CsvBindByName(column = "CONO")
    private String cono;

    @CsvBindByName(column = "REC")
    private String rec;

    @CsvBindByName(column = "BRAN")
    private String bran;

    @CsvBindByName(column = "SATBRN")
    private String satbrn;

    @CsvBindByName(column = "CUSNO")
    private String customerNo;

    @CsvBindByName(column = "FILLER1")
    private String filler1;

    @CsvBindByName(column = "SHPCN")
    private String shpcn;

    @CsvBindByName(column = "CUSTNM")
    private String customerName;

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

    @CsvBindByName(column = "FILLER2")
    private String filler2;

    @CsvBindByName(column = "PRIN")
    private String prin;

    @CsvBindByName(column = "SUBPR")
    private String subpr;

    @CsvBindByName(column = "REFCD")
    private String refcd;

    @CsvBindByName(column = "REFDT")
    private String refdt;

    private LocalDate referenceDate;

    @CsvBindByName(column = "REFNO")
    private String refno;

    @CsvBindByName(column = "XREFNO")
    private String xrefno;

    @CsvBindByName(column = "REASN")
    private String reasn;

    @CsvBindByName(column = "PRODCD")
    private String prodcd;

    @CsvBindByName(column = "QTYOR")
    private Integer quantityOr;

    @CsvBindByName(column = "QTYSH")
    private Integer quantitySh;

    @CsvBindByName(column = "UM")
    private String um;

    @CsvBindByName(column = "VLAMT")
    private String vlamtInString;

    private BigDecimal vlamt;

    @CsvBindByName(column = "SELLPR")
    private String sellprInString;

    private BigDecimal sellpr;

    @CsvBindByName(column = "PDS")
    private String pdsInString;

    private BigDecimal pds;

    @CsvBindByName(column = "EXPDTE")
    private String expiryDateInString;

    private LocalDate expiryDate;

    @CsvBindByName(column = "LOTNO")
    private String lotNo;

    @CsvBindByName(column = "BARCDE")
    private String barcode;

    @CsvBindByName(column = "PDCODE")
    private String pdcode;

    @CsvBindByName(column = "DMAN")
    private String dman;

    @CsvBindByName(column = "FILLER3")
    private String filler3;

    @CsvBindByName(column = "FINDSC")
    private String findscInString;

    private BigDecimal findsc;

    @CsvBindByName(column = "FRTAMT")
    private String frtamt;

    @CsvBindByName(column = "SLSYR")
    private String slsyr;

    @CsvBindByName(column = "SLSMO")
    private String slsmo;

    @CsvBindByName(column = "SLSWK")
    private String slswk;

    @CsvBindByName(column = "APPNUM")
    private String appnum;

    @CsvBindByName(column = "PONUM")
    private String ponum;

    @CsvBindByName(column = "GUARTRAN")
    private String guartran;

    @CsvBindByName(column = "FILLER4")
    private String filler4;

    @CsvBindByName(column = "NETSALES")
    private String netSalesInString;

    private BigDecimal netSales;

    @CsvBindByName(column = "FILLER5")
    private String filler5;

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

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getFiller1() {
        return filler1;
    }

    public void setFiller1(String filler1) {
        this.filler1 = filler1;
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

    public String getFiller2() {
        return filler2;
    }

    public void setFiller2(String filler2) {
        this.filler2 = filler2;
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

    public String getRefdt() {
        return refdt;
    }

    public void setRefdt(String refdt) {
        this.refdt = refdt;
    }

    public LocalDate getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(LocalDate referenceDate) {
        this.referenceDate = referenceDate;
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

    public Integer getQuantityOr() {
        return quantityOr;
    }

    public void setQuantityOr(Integer quantityOr) {
        this.quantityOr = quantityOr;
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

    public String getVlamtInString() {
        return vlamtInString;
    }

    public void setVlamtInString(String vlamtInString) {
        this.vlamtInString = vlamtInString;
    }

    public BigDecimal getVlamt() {
        return vlamt;
    }

    public void setVlamt(BigDecimal vlamt) {
        this.vlamt = vlamt;
    }

    public String getSellprInString() {
        return sellprInString;
    }

    public void setSellprInString(String sellprInString) {
        this.sellprInString = sellprInString;
    }

    public BigDecimal getSellpr() {
        return sellpr;
    }

    public void setSellpr(BigDecimal sellpr) {
        this.sellpr = sellpr;
    }

    public String getPdsInString() {
        return pdsInString;
    }

    public void setPdsInString(String pdsInString) {
        this.pdsInString = pdsInString;
    }

    public BigDecimal getPds() {
        return pds;
    }

    public void setPds(BigDecimal pds) {
        this.pds = pds;
    }

    public String getExpiryDateInString() {
        return expiryDateInString;
    }

    public void setExpiryDateInString(String expiryDateInString) {
        this.expiryDateInString = expiryDateInString;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
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

    public String getFiller3() {
        return filler3;
    }

    public void setFiller3(String filler3) {
        this.filler3 = filler3;
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

    public String getFiller4() {
        return filler4;
    }

    public void setFiller4(String filler4) {
        this.filler4 = filler4;
    }

    public String getNetSalesInString() {
        return netSalesInString;
    }

    public void setNetSalesInString(String netSalesInString) {
        this.netSalesInString = netSalesInString;
    }

    public BigDecimal getNetSales() {
        return netSales;
    }

    public void setNetSales(BigDecimal netSales) {
        this.netSales = netSales;
    }

    public String getFiller5() {
        return filler5;
    }

    public void setFiller5(String filler5) {
        this.filler5 = filler5;
    }

    public String getDebtorCode() {
        return debtorCode;
    }

    public void setDebtorCode(String debtorCode) {
        this.debtorCode = debtorCode;
    }

    public void convertAllStringFieldsToProperType() {
        convertVlamtFromStringToBigDecimal();
        convertSellprFromStringToBigDecimal();
        convertPdsFromStringToBigDecimal();
        convertFindscFromStringToBigDecimal();
        convertNetSalesFromStringToBigDecimal();
        convertExpiryDateFromStringToLocalDate();
        convertRefdtToReferenceDate();
    }

    private void convertVlamtFromStringToBigDecimal() {
        if (vlamtInString != null && !vlamtInString.trim().isEmpty()) {
            vlamt = new BigDecimal(vlamtInString.trim());
        }
    }

    private void convertSellprFromStringToBigDecimal() {
        if (sellprInString != null && !sellprInString.trim().isEmpty()) {
            sellpr = new BigDecimal(sellprInString.trim());
        }
    }

    private void convertPdsFromStringToBigDecimal() {
        if (pdsInString != null && !pdsInString.trim().isEmpty()) {
            pds = new BigDecimal(pdsInString.trim());
        }
    }

    private void convertFindscFromStringToBigDecimal() {
        if (findscInString != null && !findscInString.trim().isEmpty()) {
            findsc = new BigDecimal(findscInString.trim());
        }
    }

    private void convertNetSalesFromStringToBigDecimal() {
        if (netSalesInString != null && !netSalesInString.trim().isEmpty()) {
            netSales = new BigDecimal(netSalesInString.trim());
        }
    }

    private void convertExpiryDateFromStringToLocalDate() {
        if (expiryDateInString != null && !expiryDateInString.trim().isEmpty()) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            expiryDate = LocalDate.parse(expiryDateInString, dateTimeFormatter);
        }
    }

    private void convertRefdtToReferenceDate() {
        if (refdt != null && !refdt.trim().isEmpty()) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            referenceDate = LocalDate.parse(refdt, dateTimeFormatter);
        }
    }

}
