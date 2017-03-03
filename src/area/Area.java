package area;

import battle.Battle;
import fighter.Fighter;

public class Area {
    private Fighter firstFighter;
    private Fighter secondFighter;
    private StringBuilder statistic = new StringBuilder();

    public void setFirstFighter(Fighter firstFighter) {
        this.firstFighter = firstFighter;
        this.firstFighter.setBattleArea(this);
    }

    public void setSecondFighter(Fighter secondFighter) {
        this.secondFighter = secondFighter;
        this.secondFighter.setBattleArea(this);
    }

    public Fighter fight() {
        return Battle.battle(firstFighter, secondFighter);
    }

    public StringBuilder getStatistic() {
        return statistic;
    }

    public void addStatistic(String statistic) {
        this.statistic.append(statistic);
    }
}