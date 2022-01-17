package fr.firiz.gnomebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchActivity extends Application {

    Stage searchActivityStage;

    public SearchActivity() throws IOException {
        this.searchActivityStage = new Stage();
        this.start(searchActivityStage);
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SearchActivity.class.getResource("search_activity.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(GnomeBook.getVersion());
        stage.show();
        stage.setOnCloseRequest(e -> {
            GnomeBook.getMainStage().setOpacity(1);
            stage.close();
        });
    }

}
