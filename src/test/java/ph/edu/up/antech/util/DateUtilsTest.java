package ph.edu.up.antech.util;

import org.junit.Assert;
import org.junit.Test;

import java.time.YearMonth;
import java.util.List;

public class DateUtilsTest {

    @Test
    public void generateAllMonthYearBetweenTwoDates_shouldBeSuccessful() {
        String startDate = "2020-02";
        String endDate = "2020-05";

        YearMonth start = YearMonth.parse(startDate);
        YearMonth end = YearMonth.parse(endDate);

        List<YearMonth> yearMonthList = DateUtils.generateListOfYearMonthBetweenTwoYearMonths(
                start, end);
        Assert.assertEquals(4, yearMonthList.size());
    }

    @Test
    public void generateAllMonthYearBetweenTwoDates_acrossYears_shouldBeSuccessful() {
        String startDate = "2020-02";
        String endDate = "2021-05";

        YearMonth start = YearMonth.parse(startDate);
        YearMonth end = YearMonth.parse(endDate);

        List<YearMonth> yearMonthList = DateUtils.generateListOfYearMonthBetweenTwoYearMonths(
                start, end);
        Assert.assertEquals(16, yearMonthList.size());
    }

}
