package Game;

import java.io.Serializable;

public class Production implements Serializable {
    private static int wheatSeed = 0;
    private static int carrotSeed = 0;
    private static int potatoesSeed = 0;

    public static int getWheatSeed() {
        return wheatSeed;
    }

    public static void setWheatSeed(int wheatSeed) {
        Production.wheatSeed = wheatSeed;
    }

    public static int getCarrotSeed() {
        return carrotSeed;
    }

    public static void setCarrotSeed(int carrotSeed) {
        Production.carrotSeed = carrotSeed;
    }

    public static int getPotatoesSeed() {
        return potatoesSeed;
    }

    public static void setPotatoesSeed(int potatoesSeed) {
        Production.potatoesSeed = potatoesSeed;
    }
}
