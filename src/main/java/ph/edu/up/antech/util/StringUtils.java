package ph.edu.up.antech.util;

import java.util.List;

public class StringUtils {

    private StringUtils() {
    }

    public static Boolean isNullOrEmpty(String toCheck) {
        return toCheck == null || toCheck.isEmpty();
    }

    public static Boolean isTrimmedValueNullOrEmpty(String toCheck) {
        return toCheck == null || toCheck.trim().isEmpty();
    }

    public static Boolean isNullOrEmpty(List toCheck) {
        return toCheck == null || toCheck.isEmpty();
    }

}
