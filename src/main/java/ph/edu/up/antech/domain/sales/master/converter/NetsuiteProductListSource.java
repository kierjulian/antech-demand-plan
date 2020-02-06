package ph.edu.up.antech.domain.sales.master.converter;

import com.opencsv.bean.CsvBindByName;

public class NetsuiteProductListSource {

    @CsvBindByName(column = "SOURCE")
    private String source;

    @CsvBindByName(column = "FROM")
    private String from;

    @CsvBindByName(column = "TO")
    private String to;

    @CsvBindByName(column = "DESC")
    private String description;

    @CsvBindByName(column = "In PCS")
    private Integer inPcs;

    @CsvBindByName(column = "Prod")
    private String product;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getInPcs() {
        return inPcs;
    }

    public void setInPcs(Integer inPcs) {
        this.inPcs = inPcs;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

}
