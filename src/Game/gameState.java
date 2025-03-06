package Game;

import java.io.Serializable;
import java.util.List;

public class gameState implements Serializable {
    private List<Terrain> terrains;
    private int money;
    private int wheat;
    private int carrot;
    private int potatoes;
    private int wheatSeed;
    private int carrotSeed;
    private int potatoesSeed;

    public gameState(List<Terrain> terrains, int money, int wheat, int carrot, int potatoes, int wheatSeed, int carrotSeed, int potatoesSeed) {
        this.terrains = terrains;
        this.money = money;
        this.wheat = wheat;
        this.carrot = carrot;
        this.potatoes = potatoes;
        this.wheatSeed = wheatSeed;
        this.carrotSeed = carrotSeed;
        this.potatoesSeed = potatoesSeed;
    }

    // Getters and setters for all attributes
    public List<Terrain> getTerrains() {
        return terrains;
    }

    public void setTerrains(List<Terrain> terrains) {
        this.terrains = terrains;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getWheat() {
        return wheat;
    }

    public void setWheat(int wheat) {
        this.wheat = wheat;
    }

    public int getCarrot() {
        return carrot;
    }

    public void setCarrot(int carrot) {
        this.carrot = carrot;
    }

    public int getPotatoes() {
        return potatoes;
    }

    public void setPotatoes(int potatoes) {
        this.potatoes = potatoes;
    }

    public int getWheatSeed() {
        return wheatSeed;
    }

    public void setWheatSeed(int wheatSeed) {
        this.wheatSeed = wheatSeed;
    }

    public int getCarrotSeed() {
        return carrotSeed;
    }

    public void setCarrotSeed(int carrotSeed) {
        this.carrotSeed = carrotSeed;
    }

    public int getPotatoesSeed() {
        return potatoesSeed;
    }

    public void setPotatoesSeed(int potatoesSeed) {
        this.potatoesSeed = potatoesSeed;
    }
}
