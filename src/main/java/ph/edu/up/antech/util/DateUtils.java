package ph.edu.up.antech.util;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class DateUtils {

    private DateUtils() {
    }

    public static List<YearMonth> generateListOfYearMonthBetweenTwoYearMonths(YearMonth startYearMonth,
                                                                              YearMonth endYearMonth) {
        LocalDate startDate = LocalDate.from(startYearMonth.atDay(1));
        LocalDate endDate = LocalDate.from(endYearMonth.atEndOfMonth());

        List<YearMonth> yearMonthList = new ArrayList<>();
        while (startDate.isBefore(endDate)) {
            yearMonthList.add(YearMonth.from(startDate));
            startDate = startDate.plusMonths(1);
        }

        return yearMonthList;
    }

    public static LocalDate generateStartLocalDateFromYearMonth(YearMonth yearMonth) {
        return LocalDate.from(yearMonth.atDay(1));
    }

    public static LocalDate generateEndLocalDateFromYearMonth(YearMonth yearMonth) {
        return LocalDate.from(yearMonth.atEndOfMonth());
    }

}
