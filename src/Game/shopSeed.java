package Game;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Objects;

public class shopSeed extends Application {

    @FXML
    private Button btnReturn;
    @FXML
    private Button btnBuyBle;
    @FXML
    private Button btnBuyCarotte;
    @FXML
    private Button btnBuyPatate;
    @FXML
    private ComboBox<String> comboboxNumberBuyBle;
    @FXML
    private ComboBox<String> comboboxNumberBuyCarotte;
    @FXML
    private ComboBox<String> comboboxNumberBuyPatate;
    @FXML
    private Label labelPriceBle;
    @FXML
    private Label labelPriceCarotte;
    @FXML
    private Label labelPricePatate;

    private principalGame mainGame;

    public shopSeed(principalGame mainGame) {
        this.mainGame = mainGame;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("../FXML/InterfaceShopSeed.fxml")));
        loader.setController(this);
        Parent root = loader.load();

        btnReturn.setOnMouseClicked(mouseEvent -> {
            stage.close();
        });

        btnBuyBle.setOnAction(event -> {
            int number = Integer.parseInt((String) comboboxNumberBuyBle.getValue());
            int price = 10;
            int total = number * price;
            Ressource.setMoney(Ressource.getMoney() - total);
            Production production = new Production();
            production.setWheatSeed(production.getWheatSeed() + number);
            mainGame.updateLabels();
        });

        btnBuyCarotte.setOnAction(event -> {
            int number = Integer.parseInt((String) comboboxNumberBuyCarotte.getValue());
            int price = 20;
            int total = number * price;
            Ressource.setMoney(Ressource.getMoney() - total);
            Production production = new Production();
            production.setCarrotSeed(production.getCarrotSeed() + number);
            mainGame.updateLabels();
        });

        btnBuyPatate.setOnAction(event -> {
            int number = Integer.parseInt((String) comboboxNumberBuyPatate.getValue());
            int price = 30;
            int total = number * price;
            Ressource.setMoney(Ressource.getMoney() - total);
            Production production = new Production();
            production.setPotatoesSeed(production.getPotatoesSeed() + number);
            mainGame.updateLabels();
        });

        labelPriceBle.setText("Prix: 10");
        labelPriceCarotte.setText("Prix: 20");
        labelPricePatate.setText("Prix: 30");

        for (int i = 0; i < 99; i++) {
            comboboxNumberBuyBle.getItems().add(String.valueOf(i));
            comboboxNumberBuyCarotte.getItems().add(String.valueOf(i));
            comboboxNumberBuyPatate.getItems().add(String.valueOf(i));
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}