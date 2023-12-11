package first.main.utils;

import first.main.prot.DevComparator;
import first.main.prot.Dev;
import java.util.Collections;
import java.util.List;

public class DeviceUtils {
    public static void sortDevices(List<Dev> devices) {
        Collections.sort(devices, new DevComparator());
    }
}
