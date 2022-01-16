package fr.firiz.controller;

import fr.firiz.gnomebook.InsertActivity;
import fr.firiz.gnomebook.PopUp;
import fr.firiz.modele.Gnome;
import fr.firiz.modele.MyConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InsertActivityController implements Initializable {

    @FXML
    Button submitButton;
    @FXML
    TextField nameTextField;
    @FXML
    TextField classeTextField;
    @FXML
    TextField niveauTextField;
    @FXML
    Label titreLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InsertActivity.getMainStage().setOpacity(0);
    }

    public void submitButtonClicked(ActionEvent actionEvent) throws Exception {
        if (testField(nameTextField) && testField(classeTextField) && testField(niveauTextField)) {
            if (!MyConnection.testData(nameTextField.getText())) {
                Gnome gnome = new Gnome(nameTextField.getText(), classeTextField.getText(), Integer.parseInt(niveauTextField.getText()));
                MyConnection.insertData(gnome);
                Stage newStage = new Stage();
                PopUp popUp = new PopUp("Gnome enregistré", newStage);
                Stage stage = (Stage) submitButton.getScene().getWindow();
                stage.close();
            } else {
                titreLabel.setText("Nom déjà pris");
            }
        }
    }

    public boolean testField(TextField text) {
        return ((!text.getText().contains(" ")) && (!text.getText().isEmpty()));
    }
}
