package ph.edu.up.antech.util;

import java.util.Arrays;
import java.util.List;

public class ChannelUtils {

    private ChannelUtils() {
    }

    public static List<String> getChannels() {
        return Arrays.asList("MDC", "ZPC MT", "ZPC VIS", "ZPC MIN", "DISP",
                "BBJ", "DIRECT ACCT", "LAZADA");
    }

}
