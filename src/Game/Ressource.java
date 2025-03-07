package Game;

import java.io.Serializable;

public class Ressource implements Serializable {
    private static int wheat;
    private static int carrot;
    private static int potatoes;
    private static int money;
    private static int expenses;
    private static int sales;
    private static int wheatSales;
    private static int carrotSales;
    private static int potatoesSales;

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

    public static int getExpenses() {
        return expenses;
    }

    public static void addExpense(int amount) {
        Ressource.expenses += amount;
    }

    public static void setExpenses(int expenses) {
        Ressource.expenses = expenses;
    }

    public static int getSales() {
        return sales;
    }

    public static void addSale(int amount) {
        Ressource.sales += amount;
    }

    public static void setSales(int sales) {
        Ressource.sales = sales;
    }

    public static int getWheatSales() {
        return wheatSales;
    }

    public static void addWheatSale(int amount) {
        Ressource.wheatSales += amount;
    }

    public static int getCarrotSales() {
        return carrotSales;
    }

    public static void addCarrotSale(int amount) {
        Ressource.carrotSales += amount;
    }

    public static int getPotatoesSales() {
        return potatoesSales;
    }

    public static void addPotatoesSale(int amount) {
        Ressource.potatoesSales += amount;
    }
}