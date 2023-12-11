package first.main.prot;

import java.util.Comparator;

public class DevComparator implements Comparator<Dev> {
    @Override
    public int compare(Dev o1, Dev o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}