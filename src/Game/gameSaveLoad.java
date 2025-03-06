package Game;

import java.io.*;
import java.util.List;

public class gameSaveLoad {

    // Sauvegarder l'état du jeu dans un fichier
    public static void saveGame(List<Terrain> terrains, int money, int wheat, int carrot, int potatoes, int wheatSeeds, int carrotSeeds, int potatoSeeds) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("gameSave.dat"))) {
            // Créer un objet gameState avec les données actuelles du jeu
            gameState state = new gameState(terrains, money, wheat, carrot, potatoes, wheatSeeds, carrotSeeds, potatoSeeds);
            // Sauvegarder l'objet gameState dans le fichier
            oos.writeObject(state);
            System.out.println("Jeu sauvegardé avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Charger les données depuis un fichier
    public static void loadGame() throws IOException, ClassNotFoundException {
        File saveFile = new File("gameSave.dat");
        if (saveFile.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile))) {
                // Charger l'objet gameState depuis le fichier
                gameState state = (gameState) ois.readObject();

                // Appliquer les données chargées dans le jeu
                Ressource.setMoney(state.getMoney());
                Ressource.setWheat(state.getWheat());
                Ressource.setCarrot(state.getCarrot());
                Ressource.setPotatoes(state.getPotatoes());
                Production.setWheatSeed(state.getWheatSeed());
                Production.setCarrotSeed(state.getCarrotSeed());
                Production.setPotatoesSeed(state.getPotatoesSeed());

                // Mettre à jour les terrains selon l'état chargé
                // Tu peux ici réinitialiser ou ajuster l'état des terrains selon ce qui est nécessaire
                List<Terrain> terrains = state.getTerrains();

                // Mettre à jour l'affichage du jeu
                System.out.println("Jeu chargé avec succès.");
            }
        } else {
            System.out.println("Aucune sauvegarde trouvée.");
        }
    }
}
