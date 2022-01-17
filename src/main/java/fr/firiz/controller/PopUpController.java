package fr.firiz.controller;

import fr.firiz.gnomebook.GnomeBook;
import fr.firiz.gnomebook.InsertActivity;
import fr.firiz.gnomebook.PopUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PopUpController implements Initializable {

    @FXML
    Button retourButton;
    @FXML
    Label message;

    public void retourButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) retourButton.getScene().getWindow();
        stage.close();
        GnomeBook.getMainStage().setOpacity(1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        message.setText(PopUp.getMessage());
    }
}
