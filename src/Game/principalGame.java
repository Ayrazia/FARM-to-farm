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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

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
    private Button btnShopSell;
    @FXML
    private Button btnShopBuy;
    @FXML
    private Button btnSaveGame;
    @FXML
    private Button btnExitToMenu;
    @FXML
    private Button btnExitToWindow;
    @FXML
    private Label labelMoney;
    @FXML
    private Label labelRessource;

    private Ressource ressource;

    private final String[] imagesChampBle = {
            "./Image/champBle.png",
            "./Image/champBle2.png",
            "./Image/champBle3.png"
    };

    private final String[] imagesChampCarrote = {
            "./Image/champCarrote.png",
            "./Image/champCarrote2.png",
            "./Image/champCarrote3.png"
    };

    private final String[] imagesChampPotato = {
            "Image/champPotatoes.png",
            "Image/champPotatoes2.png",
            "Image/champPotatoes3.png"
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("../FXML/InterfaceGame.fxml")));
        loader.setController(this);
        Parent root = loader.load();

        ressource = new Ressource(0, 0, 0, 0, 0, 1600);

        TerrainLibre terrainLibre1 = new TerrainLibre();
        TerrainLibre terrainLibre2 = new TerrainLibre();
        TerrainLibre terrainLibre3 = new TerrainLibre();
        TerrainLibre terrainLibre4 = new TerrainLibre();
        TerrainLibre terrainLibre5 = new TerrainLibre();
        TerrainLibre terrainLibre6 = new TerrainLibre();

        imageViewTerrainLibre.setImage(new Image("./Image/champSell.png"));
        imageViewTerrainLibre1.setImage(new Image("./Image/champSell.png"));
        imageViewTerrainLibre2.setImage(new Image("./Image/champSell.png"));
        imageViewTerrainLibre3.setImage(new Image("./Image/champSell.png"));
        imageViewTerrainLibre4.setImage(new Image("./Image/champSell.png"));
        imageViewTerrainLibre5.setImage(new Image("./Image/champSell.png"));
        imageViewTerrainLibre6.setImage(new Image("./Image/champSell.png"));

        imageViewTerrainLibre.setOnMouseClicked(event -> showModalFreeLand("Terrain libre", 100, terrainLibre1, imageViewTerrainLibre));
        imageViewTerrainLibre1.setOnMouseClicked(event -> showModalFreeLand("Terrain libre", 500, terrainLibre2, imageViewTerrainLibre1));
        imageViewTerrainLibre2.setOnMouseClicked(event -> showModalFreeLand("Terrain libre", 1000, terrainLibre3, imageViewTerrainLibre2));
        imageViewTerrainLibre3.setOnMouseClicked(event -> showModalFreeLand("Terrain libre", 1500, terrainLibre4, imageViewTerrainLibre3));
        imageViewTerrainLibre4.setOnMouseClicked(event -> showModalFreeLand("Terrain libre", 2000, terrainLibre5, imageViewTerrainLibre4));
        imageViewTerrainLibre5.setOnMouseClicked(event -> showModalFreeLand("Terrain libre", 2500, terrainLibre6, imageViewTerrainLibre5));

        labelMoney.setText("Argent : " + ressource.getMoney() + "€");
        labelRessource.setText("Ressources :\n " + ressource.getWheat() + " blé\n " + ressource.getMilk() + " lait\n " + ressource.getEgg() + " oeuf\n " + ressource.getCarrot() + " carotte\n " + ressource.getPotatoes() + " patate\n");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showModalFreeLand(String title, int costLand, Terrain terrain, ImageView imageView) {
        Stage modalStage = new Stage();
        modalStage.setTitle(title);

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        Label name = new Label("Nom du terrain : " + terrain.getNameTerrain());
        Label message = new Label("Ce terrain est libre mais coûte " + costLand + "€");
        Button buy = new Button("Acheter pour " + costLand + "€");
        Button cancel = new Button("Annuler");

        final Terrain[] terrainWrapper = {terrain};

        buy.setOnAction(event -> {
            if (costLand > Ressource.getMoney()) {
                showModalRessource("Impossible d'acheter ce terrain", Ressource.getMoney(), "€  Vous n'avez pas assez d'argent");
                return;
            } else if (imageView.getParent() instanceof GridPane) {
                GridPane parent = (GridPane) imageView.getParent();
                int colIndex = GridPane.getColumnIndex(imageView);
                int rowIndex = GridPane.getRowIndex(imageView);
                parent.getChildren().remove(imageView);
                imageView.setImage(new Image("./Image/champs.png"));
                GridPane.setColumnIndex(imageView, colIndex);
                GridPane.setRowIndex(imageView, rowIndex);
                parent.getChildren().add(imageView);
                Ressource.setMoney(Ressource.getMoney() - costLand);
                terrainWrapper[0] = new TerrainUser();
                imageView.setOnMouseClicked(e -> showModalSelectTerrain("Select Terrain Activity", terrainWrapper[0].getNameTerrain(), new Terrain("Elevage Cow"), new Terrain("Elevage Chicken"), new Terrain("Farming Carrot"), new Terrain("Farming Potato"), new Terrain("Farming Wheat")));
            }

            modalStage.close();
        });

        cancel.setOnAction(event -> modalStage.close());
        root.getChildren().addAll(name, message, buy, cancel);

        Scene scene = new Scene(root, 300, 200);
        modalStage.setScene(scene);
        modalStage.showAndWait();
    }

    private void showModalSelectTerrain(String title, String landName, Terrain elevageCow, Terrain elevageChicken, Terrain farmingCarrot, Terrain farmingPotato, Terrain farmingWheat) {
        Stage modalStage = new Stage();
        modalStage.setTitle(title);
        Label name = new Label("Nom du terrain : " + landName);
        ComboBox<String> chooseTerrainActivity = new ComboBox<>();
        chooseTerrainActivity.getItems().addAll(elevageCow.getTypeTerrain(), elevageChicken.getTypeTerrain(), farmingCarrot.getTypeTerrain(), farmingPotato.getTypeTerrain(), farmingWheat.getTypeTerrain());
        chooseTerrainActivity.setOnAction(event -> {
            String selectedText = chooseTerrainActivity.getValue();
            if (selectedText != null) {
                ImageView selectedImageView = new ImageView();
                selectedImageView.setFitWidth(125);
                selectedImageView.setFitHeight(75);
                String[] imagePaths = new String[3];
                if (selectedText.equals(elevageCow.getTypeTerrain())) {
                    imagePaths = new String[]{"/Image/elevageCow1.png", "/Image/elevageCow2.png", "/Image/elevageCow3.png"};
                } else if (selectedText.equals(elevageChicken.getTypeTerrain())) {
                    imagePaths = new String[]{"/Image/elevageChicken1.png", "/Image/elevageChicken2.png", "/Image/elevageChicken3.png"};
                } else if (selectedText.equals(farmingCarrot.getTypeTerrain())) {
                    imagePaths = new String[]{"/Image/champCarrote.png", "/Image/champCarrote2.png", "/Image/champCarrote3.png"};
                } else if (selectedText.equals(farmingPotato.getTypeTerrain())) {
                    imagePaths = new String[]{"/Image/champPotatoes.png", "/Image/champPotatoes2.png", "/Image/champPotatoes3.png"};
                } else if (selectedText.equals(farmingWheat.getTypeTerrain())) {
                    imagePaths = new String[]{"/Image/champBle.png", "/Image/champBle2.png", "/Image/champBle3.png"};
                }

                if (getClass().getResource(imagePaths[0]) != null) {
                    selectedImageView.setImage(new Image(getClass().getResource(imagePaths[0]).toExternalForm()));
                    animateImages(selectedImageView, imagePaths);
                } else {
                    System.err.println("Image not found: " + imagePaths[0]);
                }

                if (imageViewTerrainLibre.getParent() instanceof GridPane) {
                    GridPane parent = (GridPane) imageViewTerrainLibre.getParent();
                    int colIndex = GridPane.getColumnIndex(imageViewTerrainLibre);
                    int rowIndex = GridPane.getRowIndex(imageViewTerrainLibre);
                    parent.getChildren().remove(imageViewTerrainLibre);
                    if (selectedImageView.getParent() != null) {
                        ((GridPane) selectedImageView.getParent()).getChildren().remove(selectedImageView);
                    }
                    GridPane.setColumnIndex(selectedImageView, colIndex);
                    GridPane.setRowIndex(selectedImageView, rowIndex);
                    parent.getChildren().add(selectedImageView);
                }
                modalStage.close();
            }
        });
        modalStage.setScene(new Scene(new VBox(name, chooseTerrainActivity), 300, 200));
        modalStage.showAndWait();
    }

    private void animateImages(ImageView imageView, String[] imagePaths) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
            String currentImage = imageView.getImage().getUrl();
            int nextImageIndex = (java.util.Arrays.asList(imagePaths).indexOf(currentImage) + 1) % imagePaths.length;
            imageView.setImage(new Image(getClass().getResource(imagePaths[nextImageIndex]).toExternalForm()));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
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
        Scene scene = new Scene(root, 350, 150);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}