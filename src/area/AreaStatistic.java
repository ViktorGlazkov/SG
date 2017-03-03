package area;

import fighter.Fighter;

public class AreaStatistic {
    private static final String RED = "\033[31m";
    private static final String WHITE = "\033[37m";
    private static final String YELLOW = "\033[33m";

    public static void criticalDamage(Fighter fighter, int damage) {
        fighter.getBattleArea().addStatistic(fighter + RED + " got a critical blow on " + damage + " hp" + WHITE + "\n");
    }

    public static void damage(Fighter fighter, int damage) {
        fighter.getBattleArea().addStatistic(fighter + WHITE + " got damage on " + RED + damage + "hp" + WHITE + "\n");
    }

    public static void dodge(Fighter fighter) {
        fighter.getBattleArea().addStatistic(fighter + YELLOW + " dodged" + WHITE + "\n");
    }

    public static void hit(Fighter fighter, int damage) {
        fighter.getBattleArea().addStatistic(fighter + RED + " hits on "  + damage + "hp" + WHITE + "\n");
    }

    public static void battle(Fighter first, Fighter second) {
        first.getBattleArea().addStatistic(first + RED + " vs " + second + WHITE + "\n");
    }

    public static void winner(Fighter fighter) {
        fighter.getBattleArea().addStatistic(fighter + " is WINNER" + WHITE + "\n");
    }

    public static void area(Area area, int worriers) {
        area.addStatistic("new area.area on " + worriers + " worriers" + "\n");
    }
}
