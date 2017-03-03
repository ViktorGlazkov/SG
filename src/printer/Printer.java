package printer;

import area.Area;
import battle.Battle;

import java.util.List;

public class Printer {
    public static void printAreasStatistic(List<Area> areaList) {
        for(Area area : areaList) {
            System.out.println(area.getStatistic());
        }
    }

    public static void printBattleStatistic() {
        System.out.println(Battle.getStatistic());
    }
}
