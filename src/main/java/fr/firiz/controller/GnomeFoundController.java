package fr.firiz.controller;

import fr.firiz.gnomebook.SearchActivity;
import fr.firiz.modele.Gnome;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
    ImageView avatar;
    @FXML
    Button retourButton;
    Gnome gnome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gnome = SearchActivityController.getGnome();
        Image img = new Image(gnome.getAvatar());
        avatar.setImage(img);
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(300.0f);
        rectangle.setWidth(300.0f);
        rectangle.setArcHeight(300);
        rectangle.setArcWidth(300);
        avatar.setClip(rectangle);
        SnapshotParameters param = new SnapshotParameters();
        param.setFill(Color.TRANSPARENT);
        WritableImage image = avatar.snapshot(param, null);
        avatar.setClip(null);
        avatar.setImage(image);
        name.setText(gnome.getNom());
        classe.setText(gnome.getMetier());
        iLevel.setText("iLevel : " + gnome.getNiveau());
        System.out.println(gnome.getAvatar());
    }

    public void onBoutonRetourClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) retourButton.getScene().getWindow();
        stage.close();
        SearchActivity.getMainStage().setOpacity(1);
    }
}
