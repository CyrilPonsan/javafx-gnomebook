package fr.firiz.controller;

import fr.firiz.gnomebook.GnomeBook;
import fr.firiz.gnomebook.PopUp;
import fr.firiz.modele.Gnome;
import fr.firiz.modele.MyConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
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
        GnomeBook.getMainStage().setOpacity(0);
        submitButton.setDisable(true);
        nameTextField.textProperty().addListener((observable, s, s2) -> testButton());
        classeTextField.textProperty().addListener((observable, s, s2) -> testButton());
        niveauTextField.textProperty().addListener((observable, s, s2) -> testButton());
    }
    public boolean testDigits(String tmp) {
        for(int i = 0; i < tmp.length(); i++) {
            if((tmp.charAt(i) >= '0') && (tmp.charAt(i) <= '9')) {
                return true;
            }
        }
        return false;
    }

    public void submitButtonClicked(ActionEvent actionEvent) throws Exception {
        if (!testDigits(niveauTextField.getText())) {
            errorPopup();
            return;
        }
        if (!MyConnection.testData(nameTextField.getText())) {
            Gnome gnome = new Gnome(nameTextField.getText(), classeTextField.getText(), Integer.parseInt(niveauTextField.getText()));
            MyConnection.insertData(gnome);
            Stage newStage = new Stage();
            PopUp popUp = new PopUp("Gnome enregistré", newStage);
            Stage stage = (Stage) submitButton.getScene().getWindow();
            stage.close();
        } else {
            Stage newStage = new Stage();
            newStage.initModality(Modality.APPLICATION_MODAL);
            PopUp popUp = new PopUp("Nom déjà pris", newStage);
        }
    }

    private void errorPopup() throws Exception {
        Stage newStage = new Stage();
        newStage.initModality(Modality.APPLICATION_MODAL);
        PopUp popUp = new PopUp("N'entrez que des chiffres svp", newStage);
    }

    public boolean testField(TextField text) {
        return ((text.getText().contains(" ")) || (text.getText().isEmpty()));
    }

    public void testButton() {
        submitButton.setDisable(testField(nameTextField) || testField(classeTextField) || testField(niveauTextField));
    }

}
