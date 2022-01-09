package fr.firiz.gnomebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class GnomeBook extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GnomeBook.class.getResource("gnomebook.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("gnomeBook v0.01");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
