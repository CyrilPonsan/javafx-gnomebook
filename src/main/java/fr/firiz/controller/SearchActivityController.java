package fr.firiz.controller;

import fr.firiz.gnomebook.GnomeBook;
import fr.firiz.gnomebook.SearchActivity;
import fr.firiz.modele.Gnome;
import fr.firiz.modele.MyConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchActivityController implements Initializable {

    @FXML
    TextField textField;
    @FXML
    AnchorPane anchorPane;
    @FXML
    Button goSearchButton;
    @FXML
    Label titre;
    static Gnome gnome;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Stage mainStage = GnomeBook.getMainStage();
        mainStage.setOpacity(0);
        goSearchButton.setDisable(true);
        textField.textProperty().addListener((observableValue, s, s2) ->
                goSearchButton.setDisable(textField.getText().length() == 0));
    }

    public void goSearchButtonClicked(ActionEvent actionEvent) throws Exception {
        if (MyConnection.testData(textField.getText())) {
            gnome = MyConnection.getData(textField.getText());
            Scene scene = goSearchButton.getScene();
            FXMLLoader fxmlLoader = new FXMLLoader(SearchActivity.class.getResource("gnome_found.fxml"));
            Scene newScene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) scene.getWindow();
            fxmlLoader.setController(new GnomeFoundController());
            stage.setScene(newScene);
            stage.centerOnScreen();
        } else {
            Stage stage = (Stage) goSearchButton.getScene().getWindow();
            stage.setTitle("Aucun gnome trouvé à ce nom...");
        }
    }

    public static Gnome getGnome() {
        return gnome;
    }

}
