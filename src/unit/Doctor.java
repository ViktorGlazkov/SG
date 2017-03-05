package unit;

import java.util.Random;

import static utils.Const.ONE;
import static utils.Const.TWO_HUNDRED;

public class Doctor extends Unit {

    public Doctor() {
        super();
        Random random = new Random();
        super.lifetime = random.nextInt(TWO_HUNDRED) + ONE;
    }
}
