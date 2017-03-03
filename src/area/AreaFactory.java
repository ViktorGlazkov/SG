package area;

import java.util.ArrayList;
import java.util.List;

public class AreaFactory {
    public static List<Area> getAreas(int n) {
        List<Area> areas = new ArrayList<Area>();
        for (int i = 0; i < n; i++) {
            areas.add(new Area());
        }

        return areas;
    }
}