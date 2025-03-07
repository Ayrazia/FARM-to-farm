package Game;

import java.io.*;
import java.util.List;

public class gameSaveLoad {

    public static void saveGame(List<Terrain> terrains, int money, int wheat, int carrot, int potatoes, int wheatSeeds, int carrotSeeds, int potatoSeeds, int expenses, int sales) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("gameSave.dat"))) {
            gameState state = new gameState(terrains, money, wheat, carrot, potatoes, wheatSeeds, carrotSeeds, potatoSeeds, expenses, sales);
            oos.writeObject(state);
            System.out.println("Jeu sauvegardé avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadGame() throws IOException, ClassNotFoundException {
        File saveFile = new File("gameSave.dat");
        if (saveFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile))) {
                gameState state = (gameState) ois.readObject();

                Ressource.setMoney(state.getMoney());
                Ressource.setWheat(state.getWheat());
                Ressource.setCarrot(state.getCarrot());
                Ressource.setPotatoes(state.getPotatoes());
                Production.setWheatSeed(state.getWheatSeed());
                Production.setCarrotSeed(state.getCarrotSeed());
                Production.setPotatoesSeed(state.getPotatoesSeed());
                Ressource.setExpenses(state.getExpenses());
                Ressource.setSales(state.getSales());

                List<Terrain> terrains = state.getTerrains();

                System.out.println("Jeu chargé avec succès.");
            }
        } else {
            System.out.println("Aucune sauvegarde trouvée.");
        }
    }
}