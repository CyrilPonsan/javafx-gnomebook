package fr.firiz.controller;

import fr.firiz.modele.Gnome;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GnomeFoundController implements Initializable {

    @FXML
    Label name;
    @FXML
    Label classe;
    @FXML
    Label iLevel;
    @FXML
    Button chercherBouton;
    @FXML
    ImageView avatar;
    Gnome gnome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gnome = SearchActivityController.getGnome();
        Image image = new Image(gnome.getAvatar());
        avatar.setImage(image);
        name.setText(gnome.getNom());
        classe.setText(gnome.getMetier());
        iLevel.setText("iLevel : " + gnome.getNiveau());
    }

    public void chercherBoutonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) chercherBouton.getScene().getWindow();
        stage.setTitle("Bouton clické");
    }
}
