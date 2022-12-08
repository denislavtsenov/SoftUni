package JavaOOP.inheritance.lab.randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private Random rnd;

    public Object getRandomElement() {
        int index = this.rnd.nextInt(super.size());
        Object object = super.get(index);
        super.remove(index);

        return object;

    }
}
