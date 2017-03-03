package area;

import battle.Battle;
import fighter.Fighter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AreaService {
    private List<Area> areaList;
    private List<Fighter> fighterList;
    private List<Fighter> champions;
    private ExecutorService es;

    public AreaService(List<Fighter> fighterList, List<Area> areaList) {
        this.fighterList = fighterList;
        this.areaList = areaList;
    }

    public void startFight() {
        champions = fight();
        while (champions.size() > 1) {
            setFighterList(champions);
            champions = fight();
        }
    }

    private void setFighterList(List<Fighter> fighterList) {
        this.fighterList = fighterList;
    }

    private List<Fighter> fight() {
        es = Executors.newCachedThreadPool();
        champions = Collections.synchronizedList(new LinkedList<Fighter>());

        int worriers = getWorriersAmount();

        int start = 0;
        int finish = worriers;

        for (Area area : areaList) {
            System.out.println("new area.area on " + worriers + " worriers");
            AreaStatistic.area(area, worriers);

            fight(start, finish, area);

            start += worriers;
            finish += worriers;

            if (finish >= fighterList.size()) break;
        }

        es.shutdown();
        waitTerminating();
        Battle.endGroup();

        return champions;
    }

    private int getWorriersAmount() {
        int worriers = fighterList.size() / areaList.size();

        if (isLittleWorriersAmount()) {
            worriers = 2;
        }
        return worriers;
    }

    private boolean isLittleWorriersAmount() {
        return fighterList.size() <= areaList.size() * 2;
    }

    private void fight(int start, int finish, Area area) {
        if (!isEndOfList(finish)) {
            fight(fighterList.subList(start, finish), area);

        } else {
            fight(fighterList.subList(start, fighterList.size() - 1), area);
        }
    }

    private void waitTerminating() {
        while (!es.isTerminated()) {
        }
    }

    private boolean isEndOfList(int finish) {
        return fighterList.size() < finish;
    }

    private void fight(List<Fighter> fighters, Area area) {
        es.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < fighters.size() - 1; i += 2) {
                    area.setFirstFighter(fighters.get(i));
                    area.setSecondFighter(fighters.get(i + 1));
                    champions.add(area.fight().regenerate());
                }
            }
        });
    }
}