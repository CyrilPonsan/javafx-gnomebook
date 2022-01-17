package fr.firiz.controller;

import fr.firiz.gnomebook.GnomeBook;
import fr.firiz.gnomebook.InsertActivity;
import fr.firiz.gnomebook.SearchActivity;
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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GnomeBookController implements Initializable {

    @FXML
    ImageView avatar;
    @FXML
    Image img;
    @FXML
    Label titre;
    @FXML
    Button searchButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(100.0f);
        rectangle.setWidth(100.0f);
        rectangle.setArcHeight(90);
        rectangle.setArcWidth(90);
        avatar.setClip(rectangle);

        SnapshotParameters param = new SnapshotParameters();
        param.setFill(Color.TRANSPARENT);
        WritableImage image = avatar.snapshot(param, null);
        avatar.setClip(null);
        avatar.setImage(image);
    }

    public void searchButtonClicked(ActionEvent actionEvent) throws IOException {
        SearchActivity searchActivity = new SearchActivity();
    }

    public void insertButtonClicked(ActionEvent actionEvent) throws IOException {
        InsertActivity insertActivity = new InsertActivity();
    }
}