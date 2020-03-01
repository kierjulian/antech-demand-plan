package ph.edu.up.antech.domain;

import ph.edu.up.antech.util.DateUtils;
import ph.edu.up.antech.util.YearIntegerAttributeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "demand_plan")
@NamedQueries({

})
public class DemandPlan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Convert(converter = YearIntegerAttributeConverter.class)
    @Column(name = "year")
    private Year year;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "demandPlan", cascade = CascadeType.ALL)
    private List<DemandPlanDetail> demandPlanDetailList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public List<DemandPlanDetail> getDemandPlanDetailList() {
        if (demandPlanDetailList == null) {
            demandPlanDetailList = new ArrayList<>();
        }

        return demandPlanDetailList;
    }

    public void setDemandPlanDetailList(List<DemandPlanDetail> demandPlanDetailList) {
        this.demandPlanDetailList = demandPlanDetailList;
    }

    public void generateDemandPlanDetails() {
        if (year != null) {
            List<YearMonth> yearMonthList = DateUtils.generateListOfYearMonthBetweenTwoYears(year, year);
            yearMonthList.forEach(yearMonth -> {
                DemandPlanDetail demandPlanDetail = new DemandPlanDetail();
                demandPlanDetail.setYearMonth(yearMonth);
                demandPlanDetail.setDemandPlan(this);
                getDemandPlanDetailList().add(demandPlanDetail);
            });
        }
    }

}
