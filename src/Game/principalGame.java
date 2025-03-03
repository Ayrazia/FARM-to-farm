package Game;
import Menu.Menu;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Objects;

public class principalGame extends Application {

    @FXML
    private Button btnBlé;
    @FXML
    private Button btnCarrot;
    @FXML
    private Button btnPotato;
    @FXML
    private Button btnTerrainLibre;
    @FXML
    private Button btnChicken;
    @FXML
    private Button btnCow;
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("../FXML/InterfaceGame.fxml")));
        loader.setController(this);
        Parent root = loader.load();

        btnExitToMenu.setOnAction(event -> {
            Platform.runLater(() -> {
                try {
                    primaryStage.close();
                    new Menu().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });

        btnExitToWindow.setOnAction(event -> {
            primaryStage.close();
        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}