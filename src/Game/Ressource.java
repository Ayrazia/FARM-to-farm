package Game;

public class Ressource {
    private int wheat;
    private int milk;
    private int egg;
    private int carrot;
    private int potatoes;
    public static int money;

    public Ressource(int wheat, int milk, int egg, int carrot, int potatoes, int money) {
        this.wheat = wheat;
        this.milk = milk;
        this.egg = egg;
        this.carrot = carrot;
        this.potatoes = potatoes;
        Ressource.money = money;
    }

    public int getWheat() {
        return wheat;
    }

    public void setWheat(int wheat) {
        this.wheat = wheat;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getEgg() {
        return egg;
    }

    public void setEgg(int egg) {
        this.egg = egg;
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

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Ressource.money = money;
    }


}
