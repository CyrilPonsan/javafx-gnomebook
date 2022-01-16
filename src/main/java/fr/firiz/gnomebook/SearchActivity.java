package fr.firiz.gnomebook;

import fr.firiz.modele.Version;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchActivity extends Application {

    static Stage mainStage;
    Stage searchActivityStage;

    public SearchActivity(Stage newStage, Stage parentStage) throws IOException {
        this.searchActivityStage = newStage;
        mainStage = parentStage;
        this.start(searchActivityStage);
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SearchActivity.class.getResource("search_activity.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(Version.getVersion());
        stage.show();
        stage.setOnCloseRequest(e -> {
            mainStage.setOpacity(1);
            stage.close();
        });
    }

    public static Stage getMainStage() {
        return mainStage;
    }

}
