package fr.firiz.gnomebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchActivity extends Application {

    Stage mainStage;
    Stage searchActivityStage;

    public SearchActivity(Stage newStage, Stage parentStage) throws IOException {
        this.searchActivityStage = newStage;
        this.start(searchActivityStage);
        mainStage = parentStage;
        System.out.println(mainStage.getTitle());
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SearchActivity.class.getResource("search_activity.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        searchActivityStage.setScene(scene);
        searchActivityStage.initModality(Modality.APPLICATION_MODAL);
        searchActivityStage.show();
    }
}
