package ph.edu.up.antech.util;

public class StringUtils {

    private StringUtils() {
    }

    public static Boolean isNullOrEmpty(String toCheck) {
        return toCheck == null || toCheck.isEmpty();
    }

    public static Boolean isTrimmedValueNullOrEmpty(String toCheck) {
        return toCheck == null || toCheck.trim().isEmpty();
    }

}
