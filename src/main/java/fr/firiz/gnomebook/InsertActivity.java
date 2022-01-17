package fr.firiz.gnomebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InsertActivity extends Application {

    public InsertActivity() throws IOException {
        Stage stage = new Stage();
        this.start(stage);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InsertActivity.class.getResource("insert_activity.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
        stage.setTitle(GnomeBook.getVersion());
        stage.setOnCloseRequest(e -> {
            GnomeBook.getMainStage().setOpacity(1);
            stage.close();
        });
    }

}
