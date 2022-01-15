package fr.firiz.controller;

import fr.firiz.gnomebook.GnomeFound;
import fr.firiz.modele.Gnome;
import fr.firiz.modele.MyConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SearchActivityController {

    @FXML
    TextField textField;
    @FXML
    AnchorPane anchorPane;
    @FXML
    Button goSearchButton;
    public void goSearchButtonClicked(ActionEvent actionEvent) throws Exception {
        Gnome gnome = MyConnection.getData(textField.getText());
        Scene scene = goSearchButton.getScene();
        FXMLLoader fxmlLoader = new FXMLLoader (GnomeFound.class.getResource("gnome_found.fxml"));
        Scene newScene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) scene.getWindow();
        stage.setScene(newScene);
    }
}
