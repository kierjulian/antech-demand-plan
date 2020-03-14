package ph.edu.up.antech.domain;

import ph.edu.up.antech.util.DateUtils;
import ph.edu.up.antech.util.YearIntegerAttributeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "demand_plan")
@NamedQueries({
        @NamedQuery(name = "findDemandPlanByProductIdAndYear",
                query = "select o from DemandPlan o where o.product.id = :productId and o.year = :year"),
        @NamedQuery(name = "findDemandPlanById",
                query = "select o from DemandPlan o where o.id = :id")
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

    @Column(name = "comments")
    private String comments;

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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void populateDemandPlanDetailsFromPreviousDemandPlan(DemandPlan previousDemandPlan) {
        if (!previousDemandPlan.getYear().plusYears(1).equals(this.year) && !previousDemandPlan.getProduct().equals(previousDemandPlan.getProduct())) {
            throw new RuntimeException("Demand plan products must be the and year must be adjacent.");
        }

        DemandPlanDetail octoberDemandPlanDetail = previousDemandPlan.getDemandPlanDetailList().get(9);
        DemandPlanDetail novemberDemandPlanDetail = previousDemandPlan.getDemandPlanDetailList().get(10);
        DemandPlanDetail decemberDemandPlanDetail = previousDemandPlan.getDemandPlanDetailList().get(11);
        DemandPlanDetail januaryDemandPlanDetail = this.getDemandPlanDetailList().get(0);
        DemandPlanDetail febDemandPlanDetail = this.getDemandPlanDetailList().get(1);
        DemandPlanDetail marchDemandPlanDetail = this.getDemandPlanDetailList().get(2);

        this.getDemandPlanDetailList().set(0, generateDemandPlanDetailFromPreviousThreeMonths(januaryDemandPlanDetail,
                octoberDemandPlanDetail, novemberDemandPlanDetail, decemberDemandPlanDetail));
        this.getDemandPlanDetailList().set(1, generateDemandPlanDetailFromPreviousThreeMonths(febDemandPlanDetail,
                novemberDemandPlanDetail, decemberDemandPlanDetail, januaryDemandPlanDetail));
        this.getDemandPlanDetailList().set(2, generateDemandPlanDetailFromPreviousThreeMonths(marchDemandPlanDetail,
                decemberDemandPlanDetail, januaryDemandPlanDetail, febDemandPlanDetail));
    }

    public DemandPlanDetail generateDemandPlanDetailFromPreviousThreeMonths(DemandPlanDetail demandPlanDetail,
                                                                            DemandPlanDetail threeMonthsAgoDetail,
                                                                            DemandPlanDetail twoMonthsAgoDetail,
                                                                            DemandPlanDetail oneMonthAgoDetail) {
        BigDecimal aveInMarketSales = threeMonthsAgoDetail.getInMarket()
                .add(twoMonthsAgoDetail.getInMarket())
                .add(oneMonthAgoDetail.getInMarket())
                .divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP);
        demandPlanDetail.setAverageInMarketSales(aveInMarketSales);

        BigDecimal totalOffTake = threeMonthsAgoDetail.getTotalOffTake()
                .add(twoMonthsAgoDetail.getTotalOffTake())
                .add(oneMonthAgoDetail.getTotalOffTake())
                .divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP);
        demandPlanDetail.setTotalOffTake(totalOffTake);

        if (demandPlanDetail.getYearMonth().getMonth().equals(Month.JANUARY)) {
            BigDecimal totalGoodsAvailable = oneMonthAgoDetail.getSourceHippEndingInventory()
                    .add(demandPlanDetail.getSourceProduction());
            demandPlanDetail.setSourceTotalGoodsAvailable(totalGoodsAvailable);
        }

        return demandPlanDetail;
    }

}
