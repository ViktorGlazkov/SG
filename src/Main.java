import area.Area;
import area.AreaFactory;
import area.AreaService;
import fighter.Fighter;
import fighter.FighterFactory;
import printer.Printer;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Fighter> fighterList = Collections.synchronizedList(FighterFactory.getFighterList(100));
        List<Area> areas = AreaFactory.getAreas(10);

        AreaService areaService = new AreaService(fighterList, areas);
        areaService.startFight();

        Printer.printAreasStatistic(areas);
        Printer.printBattleStatistic();
    }
}