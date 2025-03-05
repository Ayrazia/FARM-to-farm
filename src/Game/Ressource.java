package Game;

public class Ressource {
    private static int wheat;
    private static int carrot;
    private static int potatoes;
    private static int money;

    public static int getWheat() {
        return wheat;
    }

    public static void setWheat(int wheat) {
        Ressource.wheat = wheat;
    }

    public static int getCarrot() {
        return carrot;
    }

    public static void setCarrot(int carrot) {
        Ressource.carrot = carrot;
    }

    public static int getPotatoes() {
        return potatoes;
    }

    public static void setPotatoes(int potatoes) {
        Ressource.potatoes = potatoes;
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Ressource.money = money;
    }
}
