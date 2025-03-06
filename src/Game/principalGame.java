package Game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;
import java.util.Random;

public class principalGame extends Application {

    @FXML
    private ImageView imageViewTerrainLibre;
    @FXML
    private ImageView imageViewTerrainLibre1;
    @FXML
    private ImageView imageViewTerrainLibre2;
    @FXML
    private ImageView imageViewTerrainLibre3;
    @FXML
    private ImageView imageViewTerrainLibre4;
    @FXML
    private ImageView imageViewTerrainLibre5;
    @FXML
    private ImageView imageViewTerrainLibre6;
    @FXML
    private ImageView imageViewShopSeed;
    @FXML
    private ImageView imageViewShopSell;
    @FXML
    private Label labelMoney;
    @FXML
    private Label labelRessource;
    @FXML
    private Label labelSeed;
    @FXML
    private Button btnExitToMenu;
    @FXML
    private Button btnSaveGame;
    @FXML
    private Button btnExitToWindow;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("../FXML/InterfaceGame.fxml")));
        loader.setController(this);
        Parent root = loader.load();

        Ressource.setMoney(5000);
        updateLabels();

        TerrainLibre[] terrainsLibres = {
                new TerrainLibre(), new TerrainLibre(), new TerrainLibre(),
                new TerrainLibre(), new TerrainLibre(), new TerrainLibre(),
                new TerrainLibre()
        };

        ImageView[] imageViews = {
                imageViewTerrainLibre, imageViewTerrainLibre1, imageViewTerrainLibre2,
                imageViewTerrainLibre3, imageViewTerrainLibre4, imageViewTerrainLibre5,
                imageViewTerrainLibre6
        };

        imageViewShopSeed.setOnMouseClicked(mouseEvent -> {
            try {
                new shopSeed(this).start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        for (ImageView imageView : imageViews) {
            imageView.setImage(new Image("./Image/champSell.png"));
        }

        int[] costs = {100, 500, 1000, 1500, 2000, 2500, 6000};

        for (int i = 0; i < imageViews.length; i++) {
            int index = i;
            imageViews[i].setOnMouseClicked(event ->
                    showModalFreeLand("Terrain libre", costs[index], terrainsLibres[index], imageViews[index])
            );
        }

        btnExitToMenu.setOnAction(event -> {
            primaryStage.close();
            try {
                new Menu.Menu().start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        btnExitToWindow.setOnAction(event -> {
            primaryStage.close();
        });

        updateLabels();

        Scene scene = (new Scene(root, 570, 370));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showModalFreeLand(String title, int costLand, Terrain terrain, ImageView imageView) {
        Stage modalStage = new Stage();
        modalStage.setTitle(title);

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Label message = new Label("Ce terrain est libre mais coûte " + costLand + "€");
        Button buy = new Button("Acheter pour " + costLand + "€");
        Button cancel = new Button("Annuler");

        buy.setOnAction(event -> {
            if (costLand > Ressource.getMoney()) {
                showModalRessource("Impossible d'acheter ce terrain", Ressource.getMoney(), "€  Vous n'avez pas assez d'argent");
            } else {
                Ressource.setMoney(Ressource.getMoney() - costLand);
                updateLabels();
                imageView.setImage(new Image("./Image/champs.png"));
                imageView.setOnMouseClicked(e -> showModalSelectTerrain("Sélectionner un terrain", terrain, imageView));
            }
            modalStage.close();
        });

        cancel.setOnAction(event -> modalStage.close());
        root.getChildren().addAll(message, buy, cancel);

        Scene scene = new Scene(root, 300, 200);
        modalStage.setScene(scene);
        modalStage.showAndWait();
    }

    private void showModalSelectTerrain(String title, Terrain terrain, ImageView imageView) {
        Stage modalStage = new Stage();
        modalStage.setTitle(title);

        Label name = new Label("Nom du terrain : " + terrain.getNameTerrain());
        ComboBox<String> chooseTerrainActivity = new ComboBox<>();
        chooseTerrainActivity.getItems().addAll("Carrote", "Pomme de terre", "Blé");

        chooseTerrainActivity.setOnAction(event -> {
            String selectedText = chooseTerrainActivity.getValue();
            String[] imagePaths = new String[3];

            switch (selectedText) {
                case "Carrote":
                    imagePaths = new String[]{"/Image/champCarrote.png", "/Image/champCarrote2.png", "/Image/champCarrote3.png"};
                    terrain.setTypeTerrain("Carrote");
                    break;
                case "Pomme de terre":
                    imagePaths = new String[]{"/Image/champPotatoes.png", "/Image/champPotatoes2.png", "/Image/champPotatoes3.png"};
                    terrain.setTypeTerrain("Pomme de terre");
                    break;
                case "Blé":
                    imagePaths = new String[]{"/Image/champBle.png", "/Image/champBle2.png", "/Image/champBle3.png"};
                    terrain.setTypeTerrain("Blé");
                    break;
            }

            if (getClass().getResource(imagePaths[0]) != null) {
                imageView.setImage(new Image(getClass().getResource(imagePaths[0]).toExternalForm()));
                animateImages(imageView, imagePaths, terrain);
            } else {
                System.err.println("Image not found: " + imagePaths[0]);
            }

            modalStage.close();
        });

        VBox root = new VBox(name, chooseTerrainActivity);
        Scene scene = new Scene(root, 300, 200);
        modalStage.setScene(scene);
        modalStage.showAndWait();
    }

    private void animateImages(ImageView imageView, String[] imagePaths, Terrain terrain) {
        final int[] index = {0};
        imageView.setOnMouseClicked(null);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
            if (index[0] < imagePaths.length - 1) {
                index[0]++;
                imageView.setImage(new Image(getClass().getResource(imagePaths[index[0]]).toExternalForm()));
            }
        }));

        timeline.setCycleCount(imagePaths.length);
        timeline.setOnFinished(e -> enableHarvest(imageView, terrain, imagePaths[0]));
        timeline.play();
    }

    private void enableHarvest(ImageView imageView, Terrain terrain, String resetImagePath) {
        imageView.setOnMouseClicked(e -> collectResource(terrain, imageView, resetImagePath));
    }

    private void collectResource(Terrain terrain, ImageView imageView, String resetImagePath) {
        String type = terrain.getTypeTerrain();
        int gain = generateRandomGain();

        switch (type) {
            case " Blé ":
                Ressource.setWheat(Ressource.getWheat() + gain);
                break;
            case " Carrote ":
                Ressource.setCarrot(Ressource.getCarrot() + gain);
                break;
            case " Pomme de terre ":
                Ressource.setPotatoes(Ressource.getPotatoes() + gain);
                break;
        }

        updateLabels();

        showModalRessource("Récolte terminée", gain, type + " récolté!");

        imageView.setImage(new Image(getClass().getResource(resetImagePath).toExternalForm()));

        imageView.setOnMouseClicked(e -> showModalSelectTerrain("Sélectionner un terrain", terrain, imageView));
    }

    private int generateRandomGain() {
        Random rand = new Random();
        return rand.nextInt(51) + 75;
    }

    private void showModalRessource(String title, int numberRessource, String ressourceName) {
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Label message = new Label("Vous avez " + numberRessource + ressourceName);
        Button ok = new Button("OK");

        ok.setOnAction(event -> {
            Stage stage = (Stage) ok.getScene().getWindow();
            stage.close();
        });

        root.getChildren().addAll(message, ok);

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 350, 150));
        stage.showAndWait();
    }

    public void updateLabels() {
        labelMoney.setText("Argent : " + Ressource.getMoney() + "€");
        labelRessource.setText("Ressources :\n" +
                " " + Ressource.getWheat() + " blé\n" +
                " " + Ressource.getCarrot() + " carotte\n" +
                " " + Ressource.getPotatoes() + " patate\n"
        );
        labelSeed.setText("Graines :\n" +
                " " + Production.getWheatSeed() + " graine de blé\n" +
                " " + Production.getCarrotSeed() + " graine de carotte\n" +
                " " + Production.getPotatoesSeed() + " graine de patate\n"
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}