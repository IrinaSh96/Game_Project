package util;

import java.util.Random;

public final class RandomUtils {

    public static final Random random = new Random();

    private RandomUtils() {
    }

    public static int getRandomValue() {

        return random.nextInt(1, 31);
    }

    public static int getRandomValue(int maxValue) {

        return random.nextInt(maxValue);
    }

    public static int getRandomValue(int minValue, int maxValue) {

        return random.nextInt(minValue, maxValue);
    }

}



   




    

