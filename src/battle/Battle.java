package battle;

import area.AreaStatistic;
import fighter.Fighter;

import java.util.Random;

public class Battle {
    private static StringBuilder statistic = new StringBuilder();

    public static Fighter battle(Fighter firstFighter, Fighter secondFighter) {
        Random random = new Random();
        Fighter first;
        Fighter second;
        Fighter winner;
        Fighter loser;

        if (random.nextBoolean()) {
            first = firstFighter;
            second = secondFighter;

        } else {
            second = firstFighter;
            first = secondFighter;
        }

        AreaStatistic.battle(first, second);

        while (true) {
            first.hit(second);
            if (second.getHp() < 1) {
                winner = first;
                loser = second;
                break;
            }

            second.hit(first);
            if (first.getHp() < 1) {
                winner = second;
                loser = first;
                break;
            }
        }

        AreaStatistic.winner(winner);
        statistic.append("\033[32m")
                .append(winner.getName())
                .append("\033[37m vs \033[31m")
                .append(loser.getName())
                .append("\n");
        return winner;
    }

    public static void endGroup() {
        Battle.statistic.append("\n");
    }

    public static StringBuilder getStatistic() {
        return statistic;
    }
}
