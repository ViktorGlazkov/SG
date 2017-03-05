package unit;

import java.util.Random;

import static utils.Const.HUNDRED;
import static utils.Const.ONE;

public abstract class Unit {
    protected int lifetime;

    public Unit() {
        Random random = new Random();
        lifetime = random.nextInt(HUNDRED) + ONE;
    }

    public int getLifetime() {
        return lifetime;
    }
}
