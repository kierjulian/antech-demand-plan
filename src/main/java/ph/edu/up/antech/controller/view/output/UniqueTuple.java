package ph.edu.up.antech.controller.view.output;

import java.util.Objects;

public class UniqueTuple {

    String mgmt;
    String region;

    public UniqueTuple(String mgmt, String region) {
        this.mgmt = mgmt;
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniqueTuple that = (UniqueTuple) o;
        return mgmt.equals(that.mgmt) &&
                region.equals(that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mgmt, region);
    }

}
