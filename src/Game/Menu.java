package Game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Menu extends Application {

    @FXML
    private Button btnStartNewGame;
    @FXML
    private Button btnLoadGame;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnCredit;

    private static String[] arguments;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("../FXML/InterfaceMenu.fxml")));
        loader.setController(this);
        Parent root = loader.load();

        btnStartNewGame.setOnAction(event -> {
            Ressource.setMoney(500);
            Platform.runLater(() -> {
                try {
                    primaryStage.close();
                    new principalGame().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Ressource.setMoney(5000);
            });
        });

        btnExit.setOnAction(event -> primaryStage.close());

        btnLoadGame.setOnAction(event -> {
            loadGame();
        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadGame() {
        try {
            gameSaveLoad.loadGame();

            Platform.runLater(() -> {
                try {
                    Stage currentStage = (Stage) btnLoadGame.getScene().getWindow();
                    currentStage.close();
                    new principalGame().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        arguments = args;
        launch(args);
    }
}
