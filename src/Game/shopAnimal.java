package Game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class shopAnimal extends Application {

private principalGame mainGame;

    public shopAnimal(principalGame principalGame) {
            this.mainGame = mainGame;

    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("../FXML/InterfaceShopAnimal.fxml")));
        loader.setController(this);
        Parent root = loader.load();

        stage.setTitle("Animal Shop");
        stage.setScene(new Scene((Pane) root));
        stage.show();



    }
}
