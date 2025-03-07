package Game;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Objects;

public class shopSell extends Application {

    @FXML
    private Button btnReturn;
    @FXML
    private Button btnSellWheat;
    @FXML
    private Button btnSellCarrot;
    @FXML
    private Button btnSellPotato;
    @FXML
    private Button btnMaxWheat;
    @FXML
    private Button btnMaxCarrot;
    @FXML
    private Button btnMaxPotato;
    @FXML
    private TextField textFieldSellWheat;
    @FXML
    private TextField textFieldSellCarrot;
    @FXML
    private TextField textFieldSellPotato;
    @FXML
    private Label labelPriceWheat;
    @FXML
    private Label labelPriceCarrot;
    @FXML
    private Label labelPricePotato;

    private principalGame mainGame;

    public shopSell(principalGame mainGame) {
        this.mainGame = mainGame;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("../FXML/InterfaceShopSell.fxml")));
        loader.setController(this);
        Parent root = loader.load();

        btnReturn.setOnMouseClicked(mouseEvent -> {
            stage.close();
        });

        btnSellWheat.setOnAction(event -> {
            String input = textFieldSellWheat.getText();
            if (isNumeric(input)) {
                int number = Integer.parseInt(input);
                int price = 5;
                int total = number * price;

                if (Ressource.getWheat() >= number) {
                    Ressource.setWheat(Ressource.getWheat() - number);
                    Ressource.addWheatSale(number);
                    Ressource.setMoney(Ressource.getMoney() + total);
                    Ressource.addSale(total);
                    mainGame.updateLabels();
                } else {
                    showModalError("Pas assez de blé", "Vous n'avez pas assez de blé à vendre.");
                }
            } else {
                showModalError("Entrée invalide", "Veuillez entrer un nombre valide.");
            }
        });

        btnSellCarrot.setOnAction(event -> {
            String input = textFieldSellCarrot.getText();
            if (isNumeric(input)) {
                int number = Integer.parseInt(input);
                int price = 10;
                int total = number * price;

                if (Ressource.getCarrot() >= number) {
                    Ressource.setCarrot(Ressource.getCarrot() - number);
                    Ressource.addCarrotSale(number);
                    Ressource.setMoney(Ressource.getMoney() + total);
                    Ressource.addSale(total);
                    mainGame.updateLabels();
                } else {
                    showModalError("Pas assez de carottes", "Vous n'avez pas assez de carottes à vendre.");
                }
            } else {
                showModalError("Entrée invalide", "Veuillez entrer un nombre valide.");
            }
        });

        btnSellPotato.setOnAction(event -> {
            String input = textFieldSellPotato.getText();
            if (isNumeric(input)) {
                int number = Integer.parseInt(input);
                int price = 8;
                int total = number * price;

                if (Ressource.getPotatoes() >= number) {
                    Ressource.setPotatoes(Ressource.getPotatoes() - number);
                    Ressource.addPotatoesSale(number);
                    Ressource.setMoney(Ressource.getMoney() + total);
                    Ressource.addSale(total);
                    mainGame.updateLabels();
                } else {
                    showModalError("Pas assez de pommes de terre", "Vous n'avez pas assez de pommes de terre à vendre.");
                }
            } else {
                showModalError("Entrée invalide", "Veuillez entrer un nombre valide.");
            }
        });

        btnMaxWheat.setOnAction(event -> {
            textFieldSellWheat.setText(String.valueOf(Ressource.getWheat()));
        });

        btnMaxCarrot.setOnAction(event -> {
            textFieldSellCarrot.setText(String.valueOf(Ressource.getCarrot()));
        });

        btnMaxPotato.setOnAction(event -> {
            textFieldSellPotato.setText(String.valueOf(Ressource.getPotatoes()));
        });

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void showModalError(String title, String message) {
        VBox errorBox = new VBox(10);
        Label errorLabel = new Label(message);
        Button okButton = new Button("OK");

        okButton.setOnAction(e -> errorBox.getScene().getWindow().hide());

        errorBox.getChildren().addAll(errorLabel, okButton);
        Stage errorStage = new Stage();
        errorStage.setTitle(title);
        errorStage.setScene(new Scene(errorBox, 300, 150));
        errorStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}