package fr.firiz.gnomebook;

import fr.firiz.modele.Version;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InsertActivity extends Application {

    static Stage mainStage;
    public InsertActivity(Stage newStage, Stage stage) throws IOException {
        mainStage = stage;
        this.start(newStage);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InsertActivity.class.getResource("insert_activity.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
        stage.setTitle(Version.getVersion());
        stage.setOnCloseRequest(e -> {
            mainStage.setOpacity(1);
            stage.close();
        });
    }

    public static Stage getMainStage() {
        return mainStage;
    }
}
