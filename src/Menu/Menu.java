package Menu;
import Game.principalGame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
            Platform.runLater(() -> {
                try {
                    primaryStage.close();
                    new principalGame().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });btnExit.setOnAction(event -> {
            primaryStage.close();
        });



        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        arguments = args;
        launch(args);
    }
}