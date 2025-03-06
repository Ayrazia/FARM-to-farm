package Game;

public class Production {

    private static int wheatSeed;
    private static int carrotSeed;
    private static int potatoesSeed;

    public Production() {
        this.wheatSeed = 0;
        this.carrotSeed = 0;
        this.potatoesSeed = 0;
    }

    public static int getWheatSeed() {
        return wheatSeed;
    }

    public void setWheatSeed(int wheatSeed) {
        this.wheatSeed = wheatSeed;
    }

    public static int getCarrotSeed() {
        return carrotSeed;
    }

    public void setCarrotSeed(int carrotSeed) {
        this.carrotSeed = carrotSeed;
    }

    public static int getPotatoesSeed() {
        return potatoesSeed;
    }

    public void setPotatoesSeed(int potatoesSeed) {
        this.potatoesSeed = potatoesSeed;
    }

}
