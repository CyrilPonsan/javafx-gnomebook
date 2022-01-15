package fr.firiz.gnomebook;

import fr.firiz.modele.Version;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GnomeBook extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GnomeBook.class.getResource("gnomebook.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Version.setVersion();
        stage.setTitle(Version.getVersion());
        stage.setScene(scene);
        stage.setWidth(680);
        stage.setHeight(340);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
