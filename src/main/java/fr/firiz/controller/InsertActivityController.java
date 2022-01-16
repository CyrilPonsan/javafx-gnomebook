package fr.firiz.controller;

import fr.firiz.gnomebook.InsertActivity;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

    public void submitButtonClicked(ActionEvent actionEvent) throws SQLException, IOException {
        if (testField(nameTextField) && testField(classeTextField) && testField(niveauTextField)) {
            if (!MyConnection.testData(nameTextField.getText())) {
                Gnome gnome = new Gnome(nameTextField.getText(), classeTextField.getText(), Integer.parseInt(niveauTextField.getText()));
                MyConnection.insertData(gnome);
                FXMLLoader fxmlLoader = new FXMLLoader(InsertActivity.class.getResource("confirmation.fxml"));
                Scene newScene = new Scene(fxmlLoader.load());
                fxmlLoader.setController(new ConfirmationController());
                Stage stage = (Stage) submitButton.getScene().getWindow();
                stage.setScene(newScene);
                stage.centerOnScreen();
            } else {
                titreLabel.setText("Nom déjà pris");
            }
        }
    }

    public boolean testField(TextField text) {
        return ((!text.getText().contains(" ")) && (!text.getText().isEmpty()));
    }
}
