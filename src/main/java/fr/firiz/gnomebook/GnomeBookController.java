package fr.firiz.gnomebook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GnomeBookController implements Initializable {

    short i = 0;
    int x = 0;
    @FXML
    ImageView avatar;
    @FXML
    Image img;
    @FXML
    Label titre;
    @FXML
    VBox vBox;
    @FXML
    AnchorPane anchorPane;
    @FXML
    Button displayButton;

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

    public void displayButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) displayButton.getScene().getWindow();
        stage.close();
    }

    private String toString(short i) {
        return String.valueOf(i);
    }
}